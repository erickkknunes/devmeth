package com.application.manage;

/*Essas são as importações necessárias para o código. 
Ele importa classes relacionadas a anotações de controle, manipulação de modelos, 
e manipulação de solicitações HTTP.*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/*Essa anotação @Controller indica que essa classe é um controlador Spring.*/
@Controller
class ItemController {

    private final Map<Integer, Item> items = new HashMap<>();
    private int itemIdSequence = 1;

    /*
     * Esse método é chamado quando a aplicação recebe uma requisição GET para a
     * raiz ("/").
     * Ele adiciona atributos ao modelo (items e newItem) e retorna o nome da visão
     * ("index").
     */
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("items", items.values());
        model.addAttribute("newItem", new Item());
        return "index";
    }

    /*
     * Esse método é chamado quando a aplicação recebe uma requisição POST para
     * "/addItem".
     * Ele adiciona um novo item ao mapa de itens e redireciona para a página
     * inicial ("/").
     */
    @PostMapping("/addItem")
    public String addItem(@ModelAttribute("newItem") Item newItem) {
        newItem.setId(itemIdSequence++);
        items.put(newItem.getId(), newItem);
        return "redirect:/";
    }

    /*
     * Esse método é chamado quando a aplicação recebe uma requisição GET para
     * "/createOrder".
     * Ele adiciona um objeto OrderForm vazio e a lista de itens ao modelo e retorna
     * o nome da visão ("createOrder").
     */
    @GetMapping("/createOrder")
    public String createOrder(Model model) {
        model.addAttribute("orderForm", new OrderForm());
        model.addAttribute("items", items.values());
        return "createOrder";
    }

    /*
     * Esse método é chamado quando a aplicação recebe uma requisição POST para
     * "/placeOrder".
     * Ele processa o pedido, calcula o total e adiciona informações relevantes ao
     * modelo, em seguida,
     * retorna o nome da visão ("orderDetails").
     */
    @PostMapping("/placeOrder")
    public String placeOrder(@ModelAttribute("orderForm") OrderForm orderForm, Model model) {
        List<OrderedItem> orderedItems = new ArrayList<>();
        double totalAmount = 0;

        for (Map.Entry<Integer, Integer> entry : orderForm.getItemQuantities().entrySet()) {
            int itemId = entry.getKey();
            int quantity = entry.getValue();

            Item item = items.get(itemId);
            if (item != null && quantity > 0) {
                double subtotal = item.getValue() * quantity;
                totalAmount += subtotal;
                orderedItems.add(new OrderedItem(item.getDescription(), quantity, item.getValue(), subtotal));
            }
        }

        model.addAttribute("clientName", orderForm.getClientName());
        model.addAttribute("orderedItems", orderedItems);
        model.addAttribute("totalAmount", totalAmount);

        return "orderDetails";
    }
}