# 🧩 Troca de Cenas no Jogo

**Para trocar as cenas no nosso jogo, primeiro precisamos de uma classe que representa cada cena.**
Ela tem: uma imagem para a cena, uma imagem que contém o texto, o texto dos dois botões, e os índices das próximas cenas (para a escolha esquerda e direita).

---

## 1) Classe `Cena` — o molde de cada cena

```java
public class Cena {
    private String caminhoImagem;   // imagem principal
    private String caminhoTexto;    // imagem que contém o texto/narração
    private String escolhaEsq;      // rótulo do botão esquerdo
    private String escolhaDir;      // rótulo do botão direito
    private int proximaCenaEsq;     // índice (ID) da cena destino da esquerda
    private int proximaCenaDir;     // índice (ID) da cena destino da direita

    public Cena(String caminhoImagem, String caminhoTexto,
                String escolhaEsq, String escolhaDir,
                int proximaCenaEsq, int proximaCenaDir) {
        this.caminhoImagem = caminhoImagem;
        this.caminhoTexto = caminhoTexto;
        this.escolhaEsq = escolhaEsq;
        this.escolhaDir = escolhaDir;
        this.proximaCenaEsq = proximaCenaEsq;
        this.proximaCenaDir = proximaCenaDir;
    }

    // Getters (úteis para usar em mostrarCena)
    public String getCaminhoImagem() { return caminhoImagem; }
    public String getCaminhoTexto() { return caminhoTexto; }
    public String getEscolhaEsq() { return escolhaEsq; }
    public String getEscolhaDir() { return escolhaDir; }
    public int getProximaCenaEsq() { return proximaCenaEsq; }
    public int getProximaCenaDir() { return proximaCenaDir; }
}
```

**Resumo:** cada `Cena` é um pacote com tudo que aparece na tela e para onde cada botão leva.

---

## 2) Variáveis centrais na `TelaJogo` (parte relevante)

Você precisa de duas variáveis principais para controlar as cenas:

```java
// lista com todas as cenas do jogo (cada cena tem um índice)
private ArrayList<Cena> cenas = new ArrayList<>();

// índice da cena que está sendo exibida agora
private int cenaAtual = 0;
```

* `cenas` guarda todas as `Cena` criadas (0, 1, 2, ...).
* `cenaAtual` indica qual cena está visível no momento.

---

## 3) Onde criar as cenas — `inicializarCenas()`

Crie um método que popula o `ArrayList` com todas as cenas do jogo:

```java
private void inicializarCenas() {
    cenas.add(new Cena("/cidade-inicial.jpg", "/textorpg1.jpg",
            "Floresta", "Montanha",
            1, 2));

    cenas.add(new Cena("/floresta.jpg", "/textorpg2.jpg",
            "Enfrentar", "Escapar",
            3, 0));

    // ... adicione quantas cenas precisar
}
```

**Importante:** os caminhos (`"/cidade-inicial.jpg"`) devem ser recursos no classpath (coloque em `resources`) para funcionarem com `getResource()`.

---

## 4) Função que realmente troca a cena — `mostrarCena(int indice)`

Este método faz o trabalho visual: pega a `Cena` pelo índice e atualiza os componentes (imagens e botões).

```java
private void mostrarCena(int indice) {
    // 1) valida o índice
    if (indice < 0 || indice >= cenas.size()) {
        return; // evita erro se pedir cena inexistente
    }

    // 2) obtém a cena
    Cena c = cenas.get(indice);

    // 3) atualiza os ícones (imagens) usando getResource()
    campoImagem.setIcon(new javax.swing.ImageIcon(
        getClass().getResource(c.getCaminhoImagem())
    ));

    texto.setIcon(new javax.swing.ImageIcon(
        getClass().getResource(c.getCaminhoTexto())
    ));

    // 4) atualiza textos dos botões
    btnEscolhaEsq.setText(c.getEscolhaEsq());
    btnEscolhaDir.setText(c.getEscolhaDir());

    // 5) atualiza qual cena está ativa
    cenaAtual = indice;
}
```

**Por que validar o índice?** Evita erro se alguém chamar uma cena inválida.

---

## 5) Ligar os botões às mudanças de cena (ações)

No `actionPerformed` dos botões você pega o índice da cena atual e chama `mostrarCena()` com o destino correto:

Botão esquerdo:

```java
private void btnEscolhaEsqActionPerformed(java.awt.event.ActionEvent evt) {
    int proxima = cenas.get(cenaAtual).getProximaCenaEsq();
    mostrarCena(proxima);
}
```

Botão direito:

```java
private void btnEscolhaDirActionPerformed(java.awt.event.ActionEvent evt) {
    int proxima = cenas.get(cenaAtual).getProximaCenaDir();
    mostrarCena(proxima);
}
```

---

## 6) Chamar os métodos no construtor — essencial!

No construtor da `TelaJogo` **você deve inicializar a GUI e depois inicializar as cenas e mostrar a cena inicial**. A ordem importa:

```java
public TelaJogo() {
    initComponents();         // 1) NetBeans GUI Builder inicializa componentes visuais
    inicializarCenas();       // 2) popula o ArrayList com todas as cenas
    mostrarCena(cenaAtual);   // 3) exibe a cena inicial (cenaAtual começa em 0)
}
```

Se você esquecer de chamar `inicializarCenas()` antes de `mostrarCena()`, `cenas` estará vazia e `mostrarCena()` não encontrará nada.

**Dica prática:** sempre deixe `cenaAtual = 0;` antes de `mostrarCena()` se a cena inicial for a de índice 0.

---

## 7) Recursos/imagens — como organizar para não quebrar em outro PC

* Coloque todas as imagens dentro da pasta `resources`.
* Use caminhos começando com `/` ao criar a `Cena` (ex: `"/cidade-inicial.jpg"`).
* Carregue imagens com `getClass().getResource(path)` — assim o Java consegue encontrá-las.

Exemplo de estrutura:

```
src/
  cidade-inicial.jpg
  textorpg1.jpg
  floresta.jpg
  ...
```

---


## 8) Erros comuns e como evitar

* **Imagens com caminho absoluto (ex: `C:\...`)** → quebram em outros PCs. Use `getResource`.
* **Esquecer de chamar `inicializarCenas()` antes de `mostrarCena()`** → `cenas` vazio.
* **Não validar `indice` em `mostrarCena()`** → `IndexOutOfBoundsException`.

---

