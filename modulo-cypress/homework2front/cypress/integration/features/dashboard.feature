Feature: DashBoard

Scenario: Validar Pesquisar Usuario Pelo Campo Search
    Given que estou logado no sistema
    And que crio um novo usuario
    And que preencho o campo de pesquisar usuario
    When clico em search
    Then devo visualizar o usuario na lista

Scenario: Validar Deletar Usuario
    Given que estou logado no sistema
    And que crio um novo usuario
    And que preencho o campo de pesquisar usuario
    And clico em search
    And devo visualizar o usuario na lista
    And que clico no botao de deletar do dashboard
    When clico no botao deletar na pagina do ususario
    Then devo visualizar que o usuario nao se encontrar mais na lista

Scenario: Validar Botao listar informaões do usuario
    Given que estou logado no sistema
    And que crio um novo usuario
    And que preencho o campo de pesquisar usuario
    And clico em search
    When que clico no botao Details
    Then devo vizualizar todas as informações do usuario

Scenario: Validar criação de novo usuario com todos os dados validos
    Given que estou logado no sistema
    And que crio um novo usuario
    Then verificar que estou na pagina Dashboard

Scenario: Validar Mensagem de error ao criar usuario com campos vazios
    Given que estou logado no sistema
    And tento criar usuario com campos vazios
    Then verificar que estou na pagina Customer/Create