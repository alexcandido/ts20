#language: en

@ts20 @busca @favorito
Feature: Como usuário do submarino
  Eu quero adicionar produtos na lista de favoritos
  Para que eu possa encontrar os itens depois com facilidade

  Background:
    Given o usuário está logado no portal

  Scenario: Adicionar produto na lista de favoritos
    Given o usuário está na home page
    And o usuário busca o produto "console playstation 4" através da barra de busca
    And o usuário seleciona um dos produtos listados
    When o usuário adiciona o item a lista de favoritos
    And o usuário vai para a lista de favoritos
    Then o portal lista o item adicionado "console playstation 4"

  Scenario: Esvaziar lista de favoritos
    Given o usuário está na home page
    And o usuário vai para a lista de favoritos
    When o usuário remove os itens da lista de favoritos
    Then o portal irá informar que a lista está vazia