#language: en

@ts20 @carrinho @adicionarItem
Feature: Como usuário do submarino
  Eu quero adicionar um item no carrinho

  Background:
    Given o usuário está na home page

  Scenario: Adicionar um item ao carrinho
    Given o usuário busca o produto "Cartão psn" através da barra de busca
    And o usuário seleciona o cartão da psn de R$100
    When o usuário clicar no botão comprar
    Then o produto é adicionado ao carrinho
    And a quantidade é atualizada para 1