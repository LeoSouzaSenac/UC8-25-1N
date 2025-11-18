# ⚔️ Sistema de Batalha — Classe `Batalha` Explicada Passo a Passo

Para controlar um combate no nosso jogo, precisamos de uma classe que coordene tudo: quem ataca, quem apanha, quem morre e quando a batalha acaba.

Essa classe é a **Batalha**.

Ela recebe **um jogador** e **um inimigo**, e controla toda a lógica dos turnos.

---

## 1) Classe `Batalha` — o coração do sistema de combate

```java
public class Batalha {

    private Personagem jogador;
    private Personagem inimigo;

    public Batalha(Personagem jogador, Personagem inimigo) {
        this.jogador = jogador;
        this.inimigo = inimigo;
    }

    public Personagem getJogador() { return jogador; }
    public Personagem getInimigo() { return inimigo; }
}
```

### ✔ O que isso significa?

* Cada batalha envolve **dois personagens**.
* O construtor recebe quem está lutando.
* Os getters permitem que a interface acesse vida, nome, força, etc.

---

## 2) Método de ataque do jogador — `jogadorAtaca()`

Esse é o ataque normal.
Ele usa o método `atacar()` da classe `Personagem`.

```java
public String jogadorAtaca(int dados, int lados) {
    // jogador ataca o inimigo
    String resultado = jogador.atacar(inimigo, dados, lados);

    // adiciona vida atual do inimigo
    resultado += " " + inimigo.getNome() + " tem " + inimigo.getVida() + " de vida";

    // se morreu
    if (inimigo.getVida() <= 0) {
        resultado += ". " + inimigo.getNome() + " foi derrotado!";
    }

    return resultado;
}
```

### ✔ Explicação

1. O jogador realiza um ataque com dados “X de Y”.
2. A mensagem do ataque é retornada e completada com a vida restante do inimigo.
3. Se o inimigo ficar com 0 ou menos de vida → mensagem de derrota.

---

## 3) Jogador usa habilidade — `jogadorUsaHabilidade()`

```java
public String jogadorUsaHabilidade() {
    jogador.usarHabilidade(inimigo);

    String msg = "Habilidade usada! " 
                + inimigo.getNome() + " tem " + inimigo.getVida() + " de vida";

    if (inimigo.getVida() <= 0) {
        msg += ". " + inimigo.getNome() + " foi derrotado!";
    }

    return msg;
}
```

### ✔ Explicação

* A habilidade é executada direto do jogador.
* Depois você monta a mensagem da nova vida do inimigo.

---

## 4) Jogador usa item — `jogadorUsaItem()`

```java
public String jogadorUsaItem(Item item) {
    jogador.usarItem(item);
    return jogador.getNome() + " usou item!";
}
```

Simples: aplica o efeito e retorna uma mensagem.

---

## 5) Jogador tenta fugir — `jogadorFoge()`

```java
public boolean jogadorFoge() {
    return jogador.fugir();
}
```

Retorna **true** se a fuga funcionar.

---

## 6) Turno do inimigo — `turnoInimigo()`

Depois que o jogador age (via botão), o jogo espera alguns milissegundos e o inimigo ataca:

```java
public String turnoInimigo() {
    if (inimigo.getVida() <= 0) {
        return ""; // morto não ataca
    }

    String resultado = inimigo.atacar(jogador, 2, 6);

    resultado += " " + jogador.getNome() + " tem " + jogador.getVida() + " de vida";

    if (jogador.getVida() <= 0) {
        resultado += ". " + jogador.getNome() + " foi derrotado!";
    }

    return resultado;
}
```

### ✔ Explicação

1. Verifica se o inimigo ainda está vivo.
2. Inimigo ataca o jogador.
3. Mostra vida restante.
4. Se o jogador morreu → mensagem de derrota.

---

## 7) Verificação de fim de batalha — `batalhaAcabou()`

```java
public boolean batalhaAcabou() {
    return jogador.getVida() <= 0 || inimigo.getVida() <= 0;
}
```

### ✔ Quando acaba?

* Se o jogador morrer
* Se o inimigo morrer
  → A batalha terminou.

A interface usa esse método para saber se deve chamar `fimBatalha()`.

---



