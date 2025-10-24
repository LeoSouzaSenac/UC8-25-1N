# Exercício Java Swing – Gerenciador de Pokémons

## Descrição

Desenvolva uma aplicação de **desktop** em **Java Swing** que simule um **Gerenciador de Pokémons**.
O treinador poderá organizar sua **mochila com até 6 Pokémons**, adicionando e removendo criaturas do “computador” (lista de Pokémons disponíveis).

O exercício tem como objetivo praticar **Programação Orientada a Objetos**, **manipulação de listas**, e **criação de interfaces gráficas com Java Swing**.

---

## Objetivo do Sistema

O programa deve permitir que o treinador:

1. Visualize dois conjuntos de Pokémons:

   * **Computador:** lista de Pokémons disponíveis.
   * **Mochila:** lista de Pokémons que o treinador está carregando.

2. **Adicione Pokémons** do computador para a mochila, respeitando o limite máximo de 6.

3. **Remova Pokémons** da mochila, retornando-os para o computador.

4. Exiba todas as informações em uma **única tela**, utilizando **duas tabelas (JTables)** e **botões de ação**.

---

## Estrutura do Projeto

O projeto deve conter duas classes principais:

1. **Classe Pokémon**

   * Representa um Pokémon com os atributos:

     * Nome
     * Tipo
     * Nível

2. **Classe GerenciadorPokemons**

   * Contém toda a interface gráfica e lógica do sistema.
   * Exibe duas tabelas: uma com os Pokémons disponíveis e outra com os Pokémons na mochila.
   * Possui botões para **adicionar** e **remover** Pokémons.

---

## Requisitos Funcionais

1. O sistema deve iniciar com uma lista de Pokémons disponíveis no computador.
2. Ao selecionar um Pokémon e clicar em “Adicionar”, ele deve ser movido para a mochila.
3. Se a mochila já estiver cheia (6 Pokémons), uma mensagem deve informar o limite atingido.
4. Ao selecionar um Pokémon na mochila e clicar em “Remover”, ele deve voltar para o computador.
5. As tabelas devem ser atualizadas automaticamente a cada ação.

---

## Requisitos Não Funcionais

1. A interface deve ser desenvolvida utilizando **Java Swing**.
2. Os dados devem ser armazenados em **listas (ArrayList)**.
3. O layout deve ser simples e intuitivo, permitindo o uso em uma única janela.
4. As tabelas devem exibir as colunas:

   * Nome
   * Tipo
   * Nível

---

## Fluxo de Uso Esperado

1. Ao iniciar o programa, o usuário visualiza:

   * Tabela de Pokémons disponíveis (computador).
   * Tabela de Pokémons na mochila (inicialmente vazia).

2. O usuário seleciona um Pokémon do computador e clica em **“Adicionar”**.

   * O Pokémon é movido para a mochila.

3. O usuário pode selecionar um Pokémon da mochila e clicar em **“Remover”**.

   * O Pokémon retorna à lista do computador.

4. O sistema impede que mais de 6 Pokémons sejam adicionados à mochila e exibe uma mensagem de alerta quando isso ocorre.

---

## Critérios de Avaliação

1. **Correção funcional:** o programa realiza todas as operações corretamente.
2. **Organização do código:** uso adequado de classes, métodos e atributos.
3. **Interface gráfica:** clareza, simplicidade e boa disposição dos elementos.
4. **Tratamento de erros:** exibição de mensagens ao usuário em casos de ações inválidas.
5. **Cumprimento dos requisitos:** todas as funcionalidades obrigatórias foram implementadas.

---

## Desafios Extras (opcionais)

1. Adicionar um botão para **limpar toda a mochila**.
2. Exibir o **número total de Pokémons** na mochila em tempo real.
3. Permitir **ordenar** as listas por nome ou nível.
4. Implementar um **menu superior** com as opções “Adicionar”, “Remover” e “Sair”.

---

Deseja que eu transforme esse enunciado em um **modelo de entrega para os alunos** (com campos para preencher nome, turma, data etc.)?
