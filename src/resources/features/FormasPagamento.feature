#language: en

@ts20 @pagamento
Feature: Como usuário do submarino
  Eu quero verificar as opções de pagamento disponíveis

  Background:
    Given o usuário está na home page

  Scenario: Validar as opções de pagamento disponíveis
    Given o usuário busca o produto "a arte da guerra" através da barra de busca
    And o usuário seleciona um dos produtos listados
    When o usuário abre as opções de pagamento
    Then o portal lista as formas de pagamento disponíveis
