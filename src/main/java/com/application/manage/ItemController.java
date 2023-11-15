package com.application.manage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@Controller
class ItemController {

    private final Map<Integer, Item> items = new HashMap<>();
    private int itemIdSequence = 1;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("items", items.values());
        model.addAttribute("newItem", new Item());
        return "index";
    }

    @PostMapping("/addItem")
    public String addItem(@ModelAttribute("newItem") Item newItem) {
        newItem.setId(itemIdSequence++);
        items.put(newItem.getId(), newItem);
        return "redirect:/";
    }

    @GetMapping("/createOrder")
    public String createOrder(Model model) {
        model.addAttribute("orderForm", new OrderForm());
        model.addAttribute("items", items.values());
        return "createOrder";
    }

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