#language: en

@ts20 @carrinho @esvaziar
Feature: Como usuário do submarino
  Eu quero esvaziar o carrinho

  Scenario: Esvaziar carrinho
    Given o usuário possui um item no carrinho
    When o usuário clicar no botão remover
    Then o carrinho fica vazio após remover o produto