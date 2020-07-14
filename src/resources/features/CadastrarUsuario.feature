#language: en

@ts20 @cadastro @email
Feature: Como admin do submarino
  Eu quero validar que o usuário não pode se cadastrar com e-mail inválido

  Background:
    Given o usuário está na tela de cadastro

  Scenario Outline: Tentar cadastrar com e-mail inválido
    Given o usuário informa <email> inválido
    And o usuário preenche os demais campos corretamente
    When o usuário clicar no botão cadastrar
    Then o cadastro não é realizado
    Examples:
      | email          |
      | 'emailerrado'  |
      | '@emailerrado' |
      | 'emailerrado@' |