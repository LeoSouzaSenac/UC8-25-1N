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

1. **Personagem.java** – interface que define métodos obrigatórios para todos os personagens, como:

   * `atacar()`
   * `usarHabilidade()`
   * `usarItem()`
   * `fugir()`

2. **Aventureiro.java** – classe abstrata que implementa `Personagem` e contém atributos comuns a todas as classes de aventureiro:

   * `nome` (String)
   * `vida` (int)
   * `mana` (int)
   * `forca` (int)
   * `agilidade` (int)

3. **Bárbaro.java**, **Mago.java**, **Arqueiro.java**, **Ladino.java** – classes concretas que herdam de `Aventureiro` e implementam regras de negócio específicas (RN).

4. **Inimigo.java** – classe que representa inimigos do jogo, com atributos como:

   * `nome` (String)
   * `vida` (int)
   * `forca` (int)
   * `agilidade` (int)

5. **Dados.java** – classe responsável por gerar rolagens de dados para determinar atributos e resultados de ações.

6. **Jogo.java** – classe principal que inicializa a interface Swing, gerencia menus e controla o fluxo do jogo.

---

## Regras de Negócio

### RN Gerais do Personagem

* RN01: Nenhum objeto pode ser do tipo `Aventureiro` diretamente. Deve-se instanciar uma das classes derivadas (Bárbaro, Mago, Arqueiro, Ladino).
* RN02: A vida inicial deve ser definida via rolagem de dados (1 dado para cada ponto base definido pela classe).
* RN03: O jogador deve escolher rolar dados para cada atributo antes de iniciar o jogo.
* RN04: Cada classe possui atributos e habilidades especiais:

  * **Bárbaro**: força alta, vida alta, mana baixa; habilidade especial: *Fúria* (ataque extra).
  * **Mago**: força baixa, vida média, mana alta; habilidade especial: *Magia* (ataque mágico).
  * **Arqueiro**: força média, vida média, agilidade alta; habilidade especial: *Tiro Preciso* (aumenta chance de acerto).
  * **Ladino**: força média, vida média, agilidade muito alta; habilidade especial: *Evasão* (chance de fugir ou contra-atacar).

### RN de Combate

* RN05: O combate ocorre sempre quando o personagem encontra um inimigo.
* RN06: Durante o combate, o jogador pode escolher entre:

  1. Atacar (dano baseado na força + rolagem de dados)
  2. Usar Habilidade (varia por classe, consome mana se aplicável)
  3. Usar Item (como poções de vida ou mana)
  4. Fugir (chance de sucesso baseada na agilidade)
* RN07: O inimigo sempre atacará no seu turno, com dano baseado em sua força + rolagem de dados.

### RN de História e Escolhas

* RN08: Cada cenário deve apresentar no mínimo **duas opções**, levando a caminhos diferentes.
* RN09: Algumas escolhas podem impactar atributos, como ganhar vida, mana ou enfrentar inimigos mais fortes.
* RN10: O jogo deve permitir múltiplas partidas sem reiniciar a aplicação, reiniciando atributos e história.

---

## Regras de Negócio Específicas por Classe

### Bárbaro

* RN11: Recebe +2 de força adicional na criação do personagem.
* RN12: Habilidade *Fúria* aumenta dano físico em 50% por um turno, custo de 1 mana.

### Mago

* RN13: Recebe +3 de mana inicial.
* RN14: Habilidade *Magia* causa dano mágico equivalente a 2 vezes a força + rolagem de dados, consome 2 de mana.

### Arqueiro

* RN15: Recebe +3 de agilidade.
* RN16: Habilidade *Tiro Preciso* aumenta a chance de acerto em 50% por um turno.

### Ladino

* RN17: Recebe +4 de agilidade.
* RN18: Habilidade *Evasão* permite tentar fugir com 70% de chance ou contra-atacar com 30% de chance.

---

## Sugestões de Componentes Java Swing

* **JFrame**: janela principal do jogo.
* **JPanel**: divisões da interface, como painel de combate, painel de história e painel de atributos.
* **JButton**: ações do jogador (atacar, usar habilidade, rolar dados).
* **JLabel**: exibir texto da história, atributos e status do combate.
* **JOptionPane**: diálogos de confirmação, escolha de caminhos ou nomes.
* **JTextArea**: narrativa longa do jogo.
* **JProgressBar** (opcional): mostrar vida do jogador e inimigos.

---

## Funcionalidades Obrigatórias

1. Tela inicial pedindo o **nome do personagem** e escolha da **classe**.
2. Botão para **rolar dados** e definir atributos do personagem.
3. Exibir atributos do personagem em tempo real (JLabels ou JTable).
4. Menu de combate interativo via botões (Atacar, Usar Habilidade, Usar Item, Fugir).
5. Sistema de **história interativa** com decisões que afetam atributos ou enredo.
6. Mensagens de vitória, derrota ou fuga com JOptionPane.
7. Código organizado por classes e arquivos, respeitando herança e interface.

---

## Entrega

* Projeto Java completo pronto para execução.
* Cada classe em seu próprio arquivo `.java`.
* O jogo deve ser executável via `Jogo.java`, que terá a classe main.
* Comentários no código explicando o funcionamento de cada método e regras implementadas.

---

**Boa sorte e boa aventura!**
