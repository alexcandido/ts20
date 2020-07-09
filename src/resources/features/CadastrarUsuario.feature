#language: en

@ts20 @cadastro @email
Feature: Como admin do submarino
  Eu quero validar que o usuário não pode se cadastrar com e-mail inválido

  Background:
    Given o usuário está na tela de cadastro

  Scenario Outline: Tentar cadastrar com e-mail inválido
    Given o usuário está na tela de cadastro
    And o usuário informa <e-mail> inválido
    And o usuário preenche os demais campos corretamente
    When o usuário clicar no botão cadastrar
    Then o cadastro não é realizado
    And o sistema retorna <mensagem> que o e-mail é obrigatório
    Examples:
      | e-mail       | mensagem          |
      |              | Campo obrigatório |
      | emailerrado  | Campo obrigatório |
      | @emailerrado | Campo obrigatório |
