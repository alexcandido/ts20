#language: en

@ts20 @carrinho @adicionarItem
Feature: Como usuário do submarino
  Eu quero adicionar um item no carrinho

  Background:
    Given o usuário está na home page

  Scenario: Adicionar um item ao carrinho
    Given o usuário busca o produto "Cartão psn" através da barra de busca
    And o usuário seleciona o produto "Gift Card Digital Playstation Store R$ 100"
    When o usuário clicar no botão comprar
    Then o produto "Gift Card Digital Playstation Store R$ 100" é adicionado ao carrinho
    And a quantidade é atualizada para 1