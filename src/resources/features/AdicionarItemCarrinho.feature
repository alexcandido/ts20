#language: en

@ts20 @carrinho @adicionarItem
Feature: Como usuário do submarino
  Eu quero adicionar um item no carrinho

  Scenario: Adicionar um item ao carrinho
    Given o usuário encontra um produto desejado
    When o usuário clicar no botão comprar
    Then o produto é adicionado ao carrinho
    And a quantidade é atualizada para 1