# 🧩 Aula: Utilizando o JComboBox no NetBeans

## 🎯 Objetivo
Aprender o que é o componente **JComboBox**, como utilizá-lo em um formulário criado pelo **GUI Builder do NetBeans**, e como manipular seus valores através de **métodos Java**.

---

## 📘 O que é o JComboBox?

O **JComboBox** é um componente gráfico (da biblioteca Swing) usado para **exibir uma lista suspensa de opções**.  
O usuário pode clicar na seta e **selecionar um item** da lista.

🔹 Exemplo de uso:
- Selecionar o **estado** (SP, RJ, MG...)  
- Escolher o **sexo** (Masculino, Feminino)  
- Definir o **tipo de pagamento** (Crédito, Débito, Dinheiro)

---

## 🧱 Criando o JComboBox pelo GUI Builder (NetBeans)

### Passo 1: Adicionando o componente
1. Abra o formulário (`.java`) no **modo Design**.
2. No painel **Paleta (Palette)** → localize o componente **Combo Box (JComboBox)**.
3. Arraste o **JComboBox** para o seu formulário.
4. Renomeie-o na **Janela de Propriedades** → campo **variable name** (exemplo: `cbEstados`).

---

## 🧩 Adicionando Itens ao JComboBox

### ✅ Opção 1: Diretamente no GUI Builder
1. Selecione o `JComboBox`.
2. Vá até **Propriedades → model**.
3. Clique no botão **[…]**.
4. Digite os itens da lista (um por linha).  
   Exemplo:
```

SP
RJ
MG
ES

````
5. Clique em **OK**.

### ✅ Opção 2: Pelo código Java
Você também pode **adicionar ou remover itens** pelo código.  
Para isso, vá na aba **Source** e adicione o código dentro de algum método (por exemplo, no construtor do formulário):

```java
cbEstados.addItem("PR");
cbEstados.addItem("SC");
cbEstados.addItem("RS");
````

Ou para limpar os itens:

```java
cbEstados.removeAllItems();
```

---

## 🎛️ Obtendo o valor selecionado

Quando o usuário escolhe uma opção, podemos **pegar o item selecionado** usando o método:

```java
String estadoSelecionado = cbEstados.getSelectedItem().toString();
```

📍 Exemplo prático dentro de um botão:

```java
private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {                                            
    String estado = cbEstados.getSelectedItem().toString();
    JOptionPane.showMessageDialog(null, "Estado selecionado: " + estado);
}
```

---

## 🪄 Alterando a seleção via código

Você pode selecionar um item do JComboBox através do código, usando:

```java
cbEstados.setSelectedItem("RJ");
```

Ou pelo **índice** (lembrando que o índice começa em 0):

```java
cbEstados.setSelectedIndex(2); // Seleciona o terceiro item
```

---

## 🔁 Limpando e atualizando a lista

Se quiser **limpar** e **recarregar** a lista com novos valores:

```java
cbEstados.removeAllItems();
cbEstados.addItem("Amazonas");
cbEstados.addItem("Bahia");
cbEstados.addItem("Ceará");
```

---

## 💡 Dica: JComboBox com Tipos Diferentes

O `JComboBox` também pode armazenar **objetos** (não só texto).
Por exemplo, você pode criar uma lista de **cidades com código e nome**.
Mas para iniciantes, é melhor usar **Strings simples**.

---

## 🧠 Resumo dos principais métodos

| Método                         | Descrição                     |
| ------------------------------ | ----------------------------- |
| `addItem(Object item)`         | Adiciona um novo item à lista |
| `removeItem(Object item)`      | Remove um item específico     |
| `removeAllItems()`             | Remove todos os itens         |
| `getSelectedItem()`            | Retorna o item selecionado    |
| `setSelectedItem(Object item)` | Define o item selecionado     |
| `setSelectedIndex(int index)`  | Seleciona o item pelo índice  |

---

## 🧰 Exemplo completo

```java
private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {                                             
    String estado = cbEstados.getSelectedItem().toString();
    JOptionPane.showMessageDialog(null, "Você escolheu o estado: " + estado);
}
```

---

## 📋 Exercício prático

**Crie um formulário** com os seguintes componentes:

* Um `JLabel` com o texto: "Selecione o estado"
* Um `JComboBox` com os estados brasileiros
* Um `JButton` com o texto "Mostrar Seleção"

Quando o botão for clicado, mostre em uma **caixa de diálogo** o estado selecionado.

---

## 🧩 Desafio (opcional)

Faça o mesmo exercício, mas agora adicione **os itens pelo código**, e ao clicar no botão:

* Mostre o nome do estado
* Mostre também o **índice** do item selecionado (usando `getSelectedIndex()`)

---

## ✅ Conclusão

O `JComboBox` é um componente muito útil para criar **listas de seleção** no Java Swing.
Com ele, podemos facilmente:

* Apresentar opções fixas ao usuário
* Capturar a opção escolhida
* Alterar ou atualizar a lista conforme necessário

```
