Feature: Login

 Scenario: Validar login com sucesso
    Given que preencho o username valido
    And que preencho a senha valida
    When clico em login
    #Então devo visualizar uma mensagem de boas vindas

Scenario: Validar mensagem erro ao tentar logar com senha invalida
    Given que preencho o username valido
    And que preencho a senha invalida
    When clico em login
    Then devo visualizar uma mensagem de erro
