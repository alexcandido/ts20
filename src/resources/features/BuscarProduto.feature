#language: en

@ts20 @busca
Feature: Como usuário do submarino
  Eu quero buscar por produtos pelo nome do produto
  Para que eu possa encontrar os itens com facilidade

  Scenario: Buscar por produtos pelo nome usando a busca principal do portal
    Given o usuário está na home page
    When o usuário busca o produto "console play station 4" através da barra de busca
    Then o portal irá listar produtos relacionados com o termo buscado "console play station 4"
