#language: en

@ts20 @listaOfertas
Feature: Como usuário do submarino
  Eu quero me cadastrar na lista de ofertas da home
  Para que eu possa receber ofertas por e-mail

  Scenario: Cadastrar o e-mail na lista de ofertas da home
    Given o usuário está na home page do submarino
    When o usuário digitar seu e-mail na lista de ofertas
    And o usuário selecionar o botão cadastrar
    Then o sistema irá cadastrar o usuário na lista de ofertas
    And o sistema irá retornar uma mensgem de sucesso