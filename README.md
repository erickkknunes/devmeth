# devmeth
É um repositório designado para armazenar projetos da disciplina de métodos de desenvolvimento.

Este projeto é um sistema de gerenciamento de itens e pedidos construído usando Spring Boot, um framework do ecossistema Spring Framework para desenvolvimento de aplicações Java. Ele segue uma arquitetura MVC (Model-View-Controller), onde:

Model: O modelo de dados é representado pelas classes Item, OrderedItem, e OrderForm. Elas definem a estrutura dos itens, itens ordenados e formulários de pedidos, com métodos de acesso e modificação de atributos.

View: As páginas HTML (como index.html, createOrder.html e orderDetails.html) usando Thymeleaf, uma engine de templates que permite a integração de dados dinâmicos (fornecidos pelo controlador) com a camada de visualização.

Controller: A classe ItemController gerencia as requisições HTTP para diferentes endpoints (/, /addItem, /createOrder, /placeOrder). Ela coordena o fluxo de dados entre a visualização (páginas HTML) e o modelo de dados (classes Item, OrderedItem, OrderForm).

Aqui está uma explicação detalhada dos componentes:

Classes Java:

Item: Representa um item com atributos como ID, descrição, quantidade e valor. Possui métodos getters e setters para acessar e modificar esses atributos.

OrderedItem: Modela um item que foi incluído em um pedido, contendo descrição, quantidade, valor e subtotal. Também possui métodos getters e setters.

OrderForm: Representa um formulário que será preenchido para fazer um pedido. Este formulário contém o nome do cliente e um mapa de quantidades de itens selecionados.

ItemController: É um controlador Spring que gerencia as requisições HTTP. Ele responde aos endpoints especificados pelos métodos anotados (@GetMapping, @PostMapping) para mostrar a lista de itens, adicionar um novo item, criar um pedido e finalizar um pedido.

ManageApplication: Classe principal com o método main, responsável por inicializar a aplicação Spring Boot.

Páginas HTML:

index.html: Exibe a lista de itens existentes e permite a adição de novos itens através de um formulário.

createOrder.html: Permite ao usuário criar um pedido selecionando os itens disponíveis e suas quantidades.

orderDetails.html: Mostra os detalhes do pedido, incluindo o nome do cliente, itens selecionados com quantidades e subtotais, e o valor total do pedido.

