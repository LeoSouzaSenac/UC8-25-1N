## Introdução ao RPG e Livros-Jogos

O **RPG (Role-Playing Game)**, ou jogo de interpretação de papéis, é um tipo de jogo em que os participantes assumem os papéis de personagens fictícios e vivem aventuras em mundos imaginários. Diferente de jogos tradicionais, o RPG foca na **narrativa, na tomada de decisões e na interação entre personagens**, permitindo que os jogadores moldem a história de acordo com suas escolhas.

Um dos formatos mais clássicos de RPG são os **Livros-Jogos**, também conhecidos como **gamebooks**, que combinam leitura com mecânicas de jogo. Nessas obras, o leitor assume o papel do protagonista e faz escolhas ao longo da narrativa, determinando caminhos, desafios e finais diferentes. Para decidir os resultados de ações ou combates, muitas vezes é necessário usar **rolagens de dados**, adicionando um elemento de sorte e estratégia.

Entre os autores mais renomados de Livros-Jogos, destacam-se **Ian Livingstone** e **Steve Jackson**, criadores da famosa série **Fighting Fantasy**. Suas histórias combinam aventura, exploração de mundos fantásticos e decisões estratégicas que impactam diretamente o desenrolar da narrativa. Obras como *As Cavernas da Feiticeira da Neve* e *A Nave Espacial Traveller* são ótimos exemplos para se inspirar ao criar suas próprias aventuras.

Neste exercício, vamos usar o conceito dos Livros-Jogos para desenvolver um **mini-RPG em Java**. O jogador assumirá o papel de um personagem aventureiro, fará escolhas que impactarão a história, enfrentará inimigos e utilizará habilidades específicas, tudo isso implementado em uma interface gráfica usando **Java Swing**. Essa abordagem permite combinar **programação orientada a objetos** com **narrativa interativa**, oferecendo uma experiência prática e divertida de aprendizado.

---

# Trabalho: Jogo de Aventuras em Java (Java Swing)

## Objetivo

Desenvolver um mini-jogo de aventuras em Java utilizando **orientação a objetos**, **herança**, **interfaces** e **Java Swing**. O jogador assumirá o papel de um aventureiro em um mundo de fantasia, tomará decisões estratégicas, enfrentará inimigos e utilizará habilidades específicas de sua classe.

O projeto deve permitir **interatividade via GUI**, utilizando componentes do **Java Swing** para menus, diálogos e ações.

---

## Estrutura e Arquivos Obrigatórios

Os alunos devem criar os seguintes arquivos (cada um em seu próprio `.java`):

1. **Personagem.java** – classe base que define os atributos e métodos comuns a todos os personagens (jogadores e inimigos):

   * `nome` (String)
   * `vida` (int)
   * `mana` (int)
   * `forca` (int)
   * `agilidade` (int)

   Métodos obrigatórios:

   * `atacar(Personagem inimigo)`

   * `usarHabilidade(Personagem inimigo)`

   * `usarItem()`

   * `fugir()`

   * `rolarDados(int quantidade, int lados)`

   * `calcularChanceDeAcerto(Personagem inimigo)`

   > Essa será a **classe pai** de todas as classes de personagem jogável (Bárbaro, Mago, Arqueiro e Ladino) e também poderá ser estendida por **Inimigo**.

2. **Bárbaro.java**, **Mago.java**, **Arqueiro.java**, **Ladino.java** – classes concretas que herdam de `Personagem` e implementam regras de negócio específicas (ver seção de RN por classe).

3. **Inimigo.java** – classe que representa inimigos do jogo, herdando também de `Personagem`.

4. **Dados.java** – classe responsável por gerar rolagens de dados para determinar atributos e resultados de ações.

5. **Jogo.java** – classe principal que inicializa a interface Swing, gerencia menus, história e controla o fluxo do jogo.

---

## Regras de Negócio (RN)

### RN Gerais do Personagem

* **RN01:** Nenhum objeto pode ser instanciado diretamente do tipo `Personagem`.
  Deve-se criar objetos apenas das classes derivadas (Bárbaro, Mago, Arqueiro, Ladino, Inimigo).

* **RN02:** A vida inicial deve ser definida via rolagem de dados (exemplo: `3d6` = rolar 3 dados de 6 lados e somar).

* **RN03:** O jogador deve rolar os dados para definir seus atributos antes de iniciar o jogo.

* **RN04:** Cada classe de personagem possui **atributos e habilidades especiais**:

  * **Bárbaro**: força alta, vida alta, mana baixa; habilidade *Fúria* (ataque extra).
  * **Mago**: força baixa, vida média, mana alta; habilidade *Magia* (ataque mágico).
  * **Arqueiro**: força média, vida média, agilidade alta; habilidade *Tiro Preciso* (maior chance de acerto).
  * **Ladino**: força média, vida média, agilidade muito alta; habilidade *Evasão* (chance de escapar ou contra-atacar).

* **RN05 (Chance de Acerto):**
  Ao atacar, o personagem deve realizar um **teste de acerto**.

  * A chance de acerto é calculada pela seguinte fórmula:

    ```
    chance = 50 + (agilidade - inimigo.agilidade) * 5
    ```
  * Um número aleatório de 0 a 100 é gerado.
  * Se o número for menor ou igual à chance, o ataque acerta. Caso contrário, erra.
  * A chance mínima é 10% e a máxima é 95%.

* **RN06 (Dano):**
  O dano causado é calculado como:

  ```
  dano = forca + rolagem de dado (1d6)
  ```

  No caso de habilidades especiais, o cálculo do dano pode variar conforme as regras de cada classe.

---

### RN de Combate

* **RN07:** O combate ocorre sempre que o jogador encontra um inimigo.
* **RN08:** Durante o combate, o jogador pode escolher entre:

  1. **Atacar** (dano físico baseado na força + rolagem de dados)
  2. **Usar Habilidade** (varia conforme a classe, consome mana)
  3. **Usar Item** (poções de cura ou mana)
  4. **Fugir** (chance baseada na agilidade)
* **RN09:** O inimigo sempre contra-ataca no turno seguinte, caso ainda esteja vivo.
* **RN10:** A batalha termina quando a vida de um dos personagens chega a 0.

---

### RN de História e Escolhas

* **RN11:** Cada cenário deve apresentar pelo menos **duas opções** de escolha para o jogador, levando a caminhos diferentes.
* **RN12:** Algumas decisões podem alterar atributos (ganhar vida, mana, ouro, etc.) ou gerar combates.
* **RN13:** O jogo deve permitir reiniciar uma nova partida sem encerrar a aplicação.

---

## Regras de Negócio Específicas por Classe

### Bárbaro

* **RN14:** Recebe +2 de força ao ser criado.
* **RN15:** Habilidade *Fúria* aumenta o dano físico em 50% por um turno (custa 1 de mana).

### Mago

* **RN16:** Recebe +3 de mana ao ser criado.
* **RN17:** Habilidade *Magia* causa dano mágico equivalente a `(forca * 2) + rolagem de dado`, consome 2 de mana.

### Arqueiro

* **RN18:** Recebe +3 de agilidade ao ser criado.
* **RN19:** Habilidade *Tiro Preciso* aumenta a **chance de acerto em 50%** no próximo ataque.

### Ladino

* **RN20:** Recebe +4 de agilidade ao ser criado.
* **RN21:** Habilidade *Evasão* concede 70% de chance de escapar de um combate ou 30% de chance de contra-atacar.

---

## Sugestões de Componentes Java Swing

* **JFrame** – janela principal do jogo.
* **JPanel** – organização da tela (história, combate, atributos).
* **JButton** – botões de ações (Atacar, Fugir, Usar Habilidade, etc.).
* **JLabel** – exibição de textos e status do personagem.
* **JOptionPane** – janelas de diálogo para escolhas e mensagens.
* **JTextArea** – para exibir a narrativa do jogo.
* **JProgressBar** – barras de vida e mana.

---

## Funcionalidades Obrigatórias

1. Tela inicial pedindo o **nome do personagem** e **classe**.
2. Botão para **rolar dados** e definir atributos.
3. Exibir os **atributos** do personagem na tela.
4. Sistema de **combate interativo** com botões de ação.
5. História com **decisões múltiplas** e caminhos alternativos.
6. Exibição de mensagens de vitória, derrota e eventos narrativos via **JOptionPane**.
7. Código organizado, comentado e respeitando a **orientação a objetos**.

---

## Entrega

* Projeto Java completo, com todas as classes separadas em arquivos `.java`.
* Classe principal `Jogo.java` com o método `main()`.
* Código legível e comentado, explicando a implementação das regras de negócio.

---

**Boa sorte, aventureiro! Que os dados estejam a seu favor. 🎲⚔️**
