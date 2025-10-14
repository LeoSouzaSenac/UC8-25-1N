# 🛒 Sistema de Compras em Java com `Scanner` e `ArrayList`

## 🎯 Objetivo do Exercício

Criar um **sistema simples de compras** em **Java**, utilizando:

* Classes e herança;
* Entrada de dados com `Scanner`;
* Estrutura de repetição com `while`;
* Estrutura de decisão com `switch`;
* Manipulação de listas com `ArrayList`.

O sistema deve permitir:

1. Adicionar produtos ao carrinho;
2. Remover produtos do carrinho;
3. Ver os itens do carrinho;
4. Fazer o pagamento;
5. Sair do programa.

---

## 🧱 Estrutura do Projeto

O projeto possui **4 classes** principais:

* `Produto` → Classe base (pai);
* `Eletronico` → Subclasse de `Produto`;
* `Roupa` → Subclasse de `Produto`;
* `Alimento` → Subclasse de `Produto`;
* `App` → Classe principal com o menu e a lógica do programa.

---

## 📦 Classe `Produto`

```java
package arrayList;

public class Produto {
    protected String nome;
    protected double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String toString() {
        return nome + " - R$ " + preco;
    }
}
```

### 🧩 Explicação

* `Produto` é a **classe base** de todos os produtos da loja.
* Contém os **atributos comuns** (`nome` e `preco`).
* O método `toString()` serve para **exibir o produto formatado** no console.

---

## ⚡ Classe `Eletronico`

```java
package arrayList;

public class Eletronico extends Produto {
    
    private String marca;

    public Eletronico(String nome, double preco, String marca) {
        super(nome, preco);
        this.marca = marca;
    }

    public String toString() {
        return "[Eletrônico] " + nome + " (" + marca + ") - R$ " + preco;
    }
}
```

### 🧩 Explicação

* A classe **herda** de `Produto` com `extends Produto`.
* Adiciona o atributo `marca`.
* Sobrescreve o método `toString()` para mostrar o tipo de produto.

---

## 👕 Classe `Roupa`

```java
package arrayList;

public class Roupa extends Produto {
    
    private String tamanho;

    public Roupa(String nome, double preco, String tamanho) {
        super(nome, preco);
        this.tamanho = tamanho;
    }

    public String toString() {
        return "[Roupa] " + nome + " (Tam: " + tamanho + ") - R$ " + preco;
    }
}
```

### 🧩 Explicação

* Também herda de `Produto`;
* Tem o atributo `tamanho`;
* Personaliza a forma como o produto é exibido.

---

## 🍕 Classe `Alimento`

```java
package arrayList;

public class Alimento extends Produto {
    
    private String validade;

    public Alimento(String nome, double preco, String validade) {
        super(nome, preco);
        this.validade = validade;
    }

    public String toString() {
        return "[Alimento] " + nome + " (Val: " + validade + ") - R$ " + preco;
    }
}
```

### 🧩 Explicação

* Herda de `Produto`;
* Adiciona a informação da **data de validade**;
* Usa `toString()` para exibir o produto formatado.

---

## 🧠 Classe Principal `App`

```java
package arrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static Produto celular = new Eletronico("Celular", 1500.00, "Samsung");
    static Produto camiseta = new Roupa("Camiseta", 80.00, "GG");
    static Alimento pizza = new Alimento("Pizza", 45.00, "20/10/2025");

    static ArrayList<Produto> carrinho = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
```

### 🧩 Explicação

* Cria **produtos fixos** disponíveis para compra;
* O **`ArrayList`** `carrinho` armazena os produtos escolhidos pelo usuário;
* O **`Scanner`** lê as opções digitadas pelo usuário.

---

## 🧭 Função `mostrarMenu()`

```java
static void mostrarMenu() {
    System.out.println("\n===== MENU DE COMPRAS =====");
    System.out.println("1 - Adicionar produto ao carrinho");
    System.out.println("2 - Remover produto do carrinho");
    System.out.println("3 - Ver carrinho");
    System.out.println("4 - Fazer pagamento");
    System.out.println("0 - Sair");
    System.out.print("Escolha uma opção: ");
}
```

📘 Exibe o menu principal para o usuário escolher uma ação.

---

## 🛒 Função `adicionarProduto()`

```java
static void adicionarProduto() {
    System.out.println("\n=== Produtos disponíveis ===");
    System.out.println("1 - " + celular);
    System.out.println("2 - " + camiseta);
    System.out.println("3 - " + pizza);
    System.out.print("Escolha o produto para adicionar: ");
    int escolha = sc.nextInt();

    switch (escolha) {
        case 1: carrinho.add(celular); System.out.println("Celular adicionado!"); break;
        case 2: carrinho.add(camiseta); System.out.println("Camiseta adicionada!"); break;
        case 3: carrinho.add(pizza); System.out.println("Pizza adicionada!"); break;
        default: System.out.println("Opção inválida.");
    }
}
```

🧩 Explicação:

* Mostra os produtos disponíveis;
* O usuário escolhe o número correspondente;
* O produto é adicionado ao **ArrayList `carrinho`**.

---

## ❌ Função `removerProduto()`

```java
static void removerProduto() {
    if (carrinho.isEmpty()) {
        System.out.println("Carrinho vazio.");
        return;
    }

    System.out.println("\nItens no carrinho:");
    for (int i = 0; i < carrinho.size(); i++) {
        System.out.println((i + 1) + " - " + carrinho.get(i));
    }

    System.out.print("Digite o número do item para remover: ");
    int remover = sc.nextInt();

    if (remover > 0 && remover <= carrinho.size()) {
        System.out.println(carrinho.get(remover - 1).getNome() + " removido!");
        carrinho.remove(remover - 1);
    } else {
        System.out.println("Número inválido.");
    }
}
```

🧩 Explicação:

* Mostra os itens do carrinho;
* Permite ao usuário remover um produto pelo número;
* Garante que o índice informado seja válido.

---

## 👀 Função `verCarrinho()`

```java
static void verCarrinho() {
    if (carrinho.isEmpty()) {
        System.out.println("Carrinho vazio.");
    } else {
        System.out.println("\n=== Itens no carrinho ===");
        double total = 0;
        for (Produto p : carrinho) {
            System.out.println(p);
            total += p.getPreco();
        }
        System.out.println("Total até agora: R$ " + total);
    }
}
```

🧩 Explicação:

* Usa o **for-each** para percorrer os produtos;
* Mostra o nome e o preço de cada item;
* Calcula e mostra o total parcial da compra.

---

## 💳 Função `fazerPagamento()`

```java
static void fazerPagamento() {
    if (carrinho.isEmpty()) {
        System.out.println("Carrinho vazio, não é possível pagar.");
        return;
    }

    double total = 0;
    for (Produto p : carrinho) {
        total += p.getPreco();
    }

    System.out.println("\nValor total da compra: R$ " + total);
    System.out.println("Pagamento realizado com sucesso! Obrigado por comprar conosco!");

    carrinho.clear();
}
```

🧩 Explicação:

* Calcula o valor total da compra;
* Exibe a mensagem de sucesso;
* Limpa o carrinho após o pagamento.

---

## 🌀 Função `main()`

```java
public static void main(String[] args) {
    int opcao = 1;

    while (opcao != 0) {
        mostrarMenu();
        opcao = sc.nextInt();

        switch (opcao) {
            case 1: adicionarProduto(); break;
            case 2: removerProduto(); break;
            case 3: verCarrinho(); break;
            case 4: fazerPagamento(); break;
            case 0: System.out.println("Saindo do sistema..."); break;
            default: System.out.println("Opção inválida."); break;
        }
    }
}
```

🧩 Explicação:

* O `while` mantém o menu ativo até o usuário escolher `0` (sair);
* Cada opção chama a função correspondente;
* Usa `switch` para controlar as escolhas.

---

## ✅ Resultado Esperado (Exemplo de Execução)

```
===== MENU DE COMPRAS =====
1 - Adicionar produto ao carrinho
2 - Remover produto do carrinho
3 - Ver carrinho
4 - Fazer pagamento
0 - Sair
Escolha uma opção: 1

=== Produtos disponíveis ===
1 - [Eletrônico] Celular (Samsung) - R$ 1500.0
2 - [Roupa] Camiseta (Tam: GG) - R$ 80.0
3 - [Alimento] Pizza (Val: 20/10/2025) - R$ 45.0
Escolha o produto para adicionar: 3
Pizza adicionada!

===== MENU DE COMPRAS =====
Escolha uma opção: 3
=== Itens no carrinho ===
[Alimento] Pizza (Val: 20/10/2025) - R$ 45.0
Total até agora: R$ 45.0
```

---

## 🧾 Conceitos Envolvidos

| Conceito            | Descrição                                                                     |
| ------------------- | ----------------------------------------------------------------------------- |
| **Classe e Objeto** | Cada tipo de produto é uma classe derivada de `Produto`.                      |
| **Herança**         | Permite reaproveitar atributos e métodos da classe `Produto`.                 |
| **Polimorfismo**    | O `ArrayList<Produto>` pode armazenar qualquer objeto que herde de `Produto`. |
| **ArrayList**       | Estrutura dinâmica usada para armazenar o carrinho.                           |
| **Scanner**         | Lê as entradas do usuário.                                                    |
| **Switch**          | Escolhe a ação a ser executada conforme o menu.                               |
| **Loop `while`**    | Mantém o sistema rodando até o usuário encerrar.                              |

---

## 🧠 Aprendizados do Exercício

* Como **organizar um programa orientado a objetos**;
* Como **criar menus interativos** no console;
* Como **manipular listas dinâmicas (`ArrayList`)**;
* Como **usar o `for-each`** para percorrer objetos;
* Como **usar herança e polimorfismo** na prática.

---
