#language: en

@ts20 @frete @prazo
Feature: Como usuário do submarino
  Eu quero verificar o frete e o prazo convencional

  Background:
    Given o usuário está na home page

  Scenario: Validar o frete e o prazo convencional
    Given o usuário busca o produto "game of thrones" através da barra de busca
    And o usuário seleciona um dos produtos listados
    When o usuário informar o CEP "52011040"
    Then o portal lista a tabela do tipo, preço e prazo do frete
