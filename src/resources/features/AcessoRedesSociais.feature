#language: en

@ts20 @redeSocial
Feature: Como usuário do submarino
  Eu quero acessar as redes sociais a partir da página principal

  Scenario Outline: Acessar as redes sociais por meio da página principal
    Given o usuário está na home page do submarino
    When o usuário encontrar o icone da <rede social>
    And o usuário clilcar no ícone
    Then a <página> da rede social selecionada irá abrir
    Examples:
      | rede social  | página                               |
      | youtube      | https://www.youtube.com/c/submarino  |
      | facebook     | https://www.facebook.com/submarino/  |
      | instagram    | https://www.instagram.com/submarino/ |
      | twitter      | https://twitter.com/submarino/       |