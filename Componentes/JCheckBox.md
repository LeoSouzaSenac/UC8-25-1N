# 🧩 Aula: Utilizando o JCheckBox no NetBeans

## 🎯 Objetivo

Aprender o que é o componente **JCheckBox**, como utilizá-lo em um formulário criado pelo **GUI Builder do NetBeans**, e como **manipular seus valores** através de **métodos Java**.

---

## 📘 O que é o JCheckBox?

O **JCheckBox** é um componente gráfico usado para permitir que o usuário **selecione uma ou mais opções** de uma lista.
Cada `JCheckBox` funciona de forma **independente**, podendo estar **marcado** ou **desmarcado**.

🔹 Exemplo de uso:

* Escolher **interesses pessoais** (Música, Esportes, Filmes)
* Selecionar **opções de configuração**
* Indicar **preferências** do usuário

---

## 🧱 Criando JCheckBox pelo GUI Builder (NetBeans)

### Passo 1: Adicionando o componente

1. Abra o formulário (`.java`) no **modo Design**.
2. No painel **Paleta (Palette)** → localize o componente **Check Box (JCheckBox)**.
3. Arraste o **JCheckBox** para o seu formulário.
4. Edite o **texto** do componente (propriedade *text*), exemplo: `"Música"`.
5. Renomeie o **variable name**, exemplo: `cbMusica`.

Repita esse processo para criar mais opções, como:

* `cbEsporte`
* `cbFilme`

---

## 🧠 Lendo o valor de um JCheckBox

Para saber se o `JCheckBox` está **marcado** (selecionado) ou **não**, usamos o método:

```java
boolean selecionado = cbMusica.isSelected();
```

Se o valor for `true`, o checkbox está marcado.
Se for `false`, está desmarcado.

📍 Exemplo prático:

```java
if (cbMusica.isSelected()) {
    JOptionPane.showMessageDialog(null, "Você gosta de música!");
}
```

---

## 🪄 Exemplo com vários JCheckBoxes

Você pode combinar vários checkboxes e verificar quais estão marcados:

```java
private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {                                            
    String mensagem = "Você gosta de: \n";

    if (cbMusica.isSelected()) {
        mensagem += "- Música\n";
    }
    if (cbEsporte.isSelected()) {
        mensagem += "- Esportes\n";
    }
    if (cbFilme.isSelected()) {
        mensagem += "- Filmes\n";
    }

    JOptionPane.showMessageDialog(null, mensagem);
}
```

✅ **Resultado esperado:**
Se o usuário marcar “Música” e “Filmes”, aparecerá:

```
Você gosta de:
- Música
- Filmes
```

---

## 🔁 Limpando os JCheckBoxes

Para **desmarcar** todos os checkboxes via código:

```java
cbMusica.setSelected(false);
cbEsporte.setSelected(false);
cbFilme.setSelected(false);
```

E para **marcar** um deles:

```java
cbMusica.setSelected(true);
```

---

## 🧩 Resumo dos principais métodos

| Método                    | Descrição                                    |
| ------------------------- | -------------------------------------------- |
| `isSelected()`            | Retorna `true` se o checkbox estiver marcado |
| `setSelected(true/false)` | Marca ou desmarca o checkbox                 |
| `setText(String texto)`   | Altera o texto exibido no checkbox           |

---

## 🧰 Exemplo completo

```java
private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {                                             
    String resultado = "Você gosta de:\n";

    if (cbMusica.isSelected()) resultado += "- Música\n";
    if (cbEsporte.isSelected()) resultado += "- Esportes\n";
    if (cbFilme.isSelected()) resultado += "- Filmes\n";

    JOptionPane.showMessageDialog(null, resultado);
}
```

---

## 📋 Exercício prático

**Crie um formulário** com os seguintes componentes:

* Três `JCheckBox` com os textos:

  * Música
  * Esportes
  * Filmes
* Um `JButton` com o texto **"Mostrar Seleção"**

📍 Quando o botão for clicado:

* Mostre em uma **caixa de diálogo** as opções que o usuário marcou.

---

## 🧩 Desafio (opcional)

Adicione um botão **"Limpar"** que **desmarque todos os checkboxes** quando clicado.

Dica:

```java
cbMusica.setSelected(false);
cbEsporte.setSelected(false);
cbFilme.setSelected(false);
```

---

## ✅ Conclusão

O componente **JCheckBox** é muito útil para criar **listas de seleção múltipla** no Java Swing.
Com ele, você pode:

* Exibir várias opções ao usuário
* Ler quais opções foram selecionadas
* Marcar ou desmarcar opções via código

É um dos componentes mais simples e práticos para deixar os formulários **interativos e dinâmicos**.
