Esse repositório armazena o projeto final da disciplina de Testes de Sistemas do curso de pós graduação em Testes Ágeis
da CESAR School. Criamos testes automatizados utilizando selenium e cucumber para o site: https://www.submarino.com.br/

## Turma: 2019.2

#### **Alunos:**

- Alan Garcia da Silva Santos
- Alex Antônio Candido Silva
- Rodrigo Emmanuel Campelo Souza

## **Instruções:**
O projeto tem a opção de rodar no Windows, Mac e Linux, para configurar de acordo com o seu Sistema Operacional, siga
os passos abaixo:

1. Acesse a classe de configuração do driver em: /src/test/java/manager/DriverFactory.java
2. No método "getDriver", tire as barras de comentário ("//") da linha referente ao seu Sistema Operacional e mantenha
as linhas dos outros sistemas comentadas
3. Agora é só executar a classe CucumberRunner para que todos os testes sejam executados

Nota: Caso tenha algum problema com o Chromedriver, provavelmente a versão do seu Chrome não é compatível com a do
driver fornecido, nesse caso, precisa fazer o download do driver equivalente a sua versão do browser em
https://chromedriver.chromium.org/downloads