#language: en

@ts20 @busca @favorito
Feature: Como usuário do submarino
  Eu quero adicionar produtos na lista de favoritos
  Para que eu possa encontrar os itens depois com facilidade

  Background:
    Given o usuário está logado no portal

  Scenario: Adicionar produto na lista de favoritos
    Given o usuário está na home page do submarino
    And o usuário digita o produto "console play station 4"
    And o usuário pressiona enter
    And o portal irá listar produtos relacionados com o termo buscado "console play station 4"
    And o usuário seleciona um dos produtos listados
    When o usuário adiciona o item a lista de favoritos
    And o usuário vai para a lista de favoritos
    Then o portal lista o item adicionado "console play station 4"

  Scenario: Esvaziar lista de favoritos
    Given o usuário está na home page do submarino
    And o usuário vai para a lista de favoritos
    When o usuário remove os itens da lista de favoritos
    Then o portal irá informar que a lista está vazia