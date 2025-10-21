# 🧩 Aula: Utilizando o JCheckBox e ButtonGroup no NetBeans

## 🎯 Objetivo

Aprender o que são os componentes **JCheckBox** e **ButtonGroup**, como utilizá-los no **GUI Builder do NetBeans**, e como **obter e manipular** seus valores através de **métodos Java**.

---

## 📘 O que é o JCheckBox?

O **JCheckBox** é um componente gráfico usado para **selecionar uma ou mais opções** de um conjunto.
Cada `JCheckBox` possui **duas opções possíveis**: marcado (`true`) ou desmarcado (`false`).

🔹 Exemplos de uso:

* Selecionar **interesses**: Música 🎵, Esportes ⚽, Filmes 🎬
* Escolher **opções adicionais** em um formulário
* Definir **preferências** do usuário

---

## 🧱 Criando JCheckBox pelo GUI Builder (NetBeans)

### Passo 1: Adicionando o componente

1. Abra o formulário (`.java`) no **modo Design**.
2. No painel **Paleta (Palette)** → localize o componente **Check Box (JCheckBox)**.
3. Arraste o **JCheckBox** para o seu formulário.
4. Altere o **texto** do botão (propriedade *text*), exemplo: `"Música"`.
5. Renomeie o **variable name** (exemplo: `cbMusica`).

Repita o processo para criar quantos checkboxes quiser (exemplo: `cbEsporte`, `cbFilme`).

---

## 🧠 Lendo o valor de um JCheckBox

Para saber se o `JCheckBox` está **marcado** ou **não**, utilizamos o método:

```java
boolean selecionado = cbMusica.isSelected();
```

Se quiser **mostrar o resultado** em uma mensagem:

```java
if (cbMusica.isSelected()) {
    JOptionPane.showMessageDialog(null, "Você gosta de música!");
}
```

---

## 🪄 Exemplo com vários JCheckBoxes

```java
private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {                                            
    String mensagem = "Você gosta de: \n";

    if (cbMusica.isSelected()) {
        mensagem += "- Música\n";
    }
    if (cbEsporte.isSelected()) {
        mensagem += "- Esporte\n";
    }
    if (cbFilme.isSelected()) {
        mensagem += "- Filmes\n";
    }

    JOptionPane.showMessageDialog(null, mensagem);
}
```

✅ **Resultado:**
Se o aluno marcar "Música" e "Filmes", aparecerá:

```
Você gosta de:
- Música
- Filmes
```

---

## 🔁 Limpando os JCheckBoxes

Para **desmarcar todos** os checkboxes via código:

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

## 💡 Dica

Um `JCheckBox` **permite múltiplas seleções**.
Mas e se você quiser **apenas uma opção possível** (por exemplo, Masculino/Feminino)?
➡️ Nesse caso, usamos o **ButtonGroup**, que agrupa **JRadioButtons**, não JCheckBoxes.

---

# 🎚️ ButtonGroup e JRadioButton

## 📘 O que é o JRadioButton?

O **JRadioButton** é semelhante ao `JCheckBox`, mas ele é usado quando queremos **apenas uma opção selecionada por vez**.

Por exemplo:

* Sexo: Masculino / Feminino
* Tipo de conta: Gratuita / Premium

Para garantir que **apenas um botão** possa ser selecionado, usamos o **ButtonGroup**.

---

## 🧱 Criando RadioButtons e ButtonGroup no GUI Builder

### Passo 1: Adicionando os componentes

1. No modo **Design**, vá na **Paleta → Button → Radio Button (JRadioButton)**.
2. Arraste **dois ou mais** `JRadioButton` para o formulário.
3. Altere o texto de cada um, por exemplo:

   * `rbMasculino` → texto: “Masculino”
   * `rbFeminino` → texto: “Feminino”

### Passo 2: Criando o ButtonGroup

1. Ainda na **Paleta**, arraste o componente **Button Group** para o formulário.
   (Ele aparecerá apenas na parte inferior, como um “objeto invisível”.)
2. Renomeie o grupo (exemplo: `grupoSexo`).
3. Selecione cada `JRadioButton`, vá em **Propriedades → buttonGroup**, e escolha `grupoSexo`.

Agora, o NetBeans faz automaticamente com que **apenas um RadioButton** do grupo possa ser selecionado.

---

## 🧠 Lendo o valor selecionado do ButtonGroup

Como cada `JRadioButton` é um componente separado, verificamos **qual está selecionado**:

```java
private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {                                          
    String mensagem = "";

    if (rbMasculino.isSelected()) {
        mensagem = "Sexo selecionado: Masculino";
    } else if (rbFeminino.isSelected()) {
        mensagem = "Sexo selecionado: Feminino";
    } else {
        mensagem = "Nenhum sexo selecionado.";
    }

    JOptionPane.showMessageDialog(null, mensagem);
}
```

---

## 🔄 Alterando a seleção via código

```java
rbMasculino.setSelected(true);  // Marca Masculino
rbFeminino.setSelected(false);  // Desmarca Feminino
```

Para **limpar o grupo todo**, é possível usar:

```java
grupoSexo.clearSelection();
```

---

## 🧩 Resumo dos principais métodos

| Método                    | Descrição                           |
| ------------------------- | ----------------------------------- |
| `isSelected()`            | Retorna `true` se estiver marcado   |
| `setSelected(true/false)` | Marca ou desmarca o botão           |
| `clearSelection()`        | Limpa a seleção de um `ButtonGroup` |

---

## 🧰 Exemplo completo

```java
private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {                                             
    String resultado = "Você gosta de:\n";

    if (cbMusica.isSelected()) resultado += "- Música\n";
    if (cbEsporte.isSelected()) resultado += "- Esporte\n";
    if (cbFilme.isSelected()) resultado += "- Filmes\n";

    if (rbMasculino.isSelected()) {
        resultado += "\nSexo: Masculino";
    } else if (rbFeminino.isSelected()) {
        resultado += "\nSexo: Feminino";
    }

    JOptionPane.showMessageDialog(null, resultado);
}
```

---

## 📋 Exercício prático

**Crie um formulário** com os seguintes componentes:

* Três `JCheckBox` (Música, Esportes, Filmes)
* Dois `JRadioButton` (Masculino, Feminino) dentro de um `ButtonGroup`
* Um `JButton` chamado **"Mostrar Seleção"**

📍 Quando o botão for clicado:

* Mostre os **hobbies** selecionados
* Mostre o **sexo** escolhido

---

## 🧩 Desafio (opcional)

Crie um botão **“Limpar”** que:

* Desmarque todos os `JCheckBox`
* Limpe a seleção do `ButtonGroup`

Dica:

```java
cbMusica.setSelected(false);
cbEsporte.setSelected(false);
cbFilme.setSelected(false);
grupoSexo.clearSelection();
```

---

## ✅ Conclusão

Os componentes **JCheckBox** e **JRadioButton + ButtonGroup** permitem criar formulários **interativos e intuitivos**, ideais para capturar preferências e opções do usuário.

Com eles, o aluno aprende a:

* Criar seleções simples ou múltiplas
* Ler e manipular estados dos botões
* Organizar grupos exclusivos com o `ButtonGroup`
