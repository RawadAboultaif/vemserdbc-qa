import PessoaService from '../../service/pessoaService'

const userService = new PessoaService

const userPayload = require('../../../fixtures/pessoa/massaDados/addUser.payload.json')
const userPayloadNomeVazio = require('../../../fixtures/pessoa/massaDados/addUserNomeVazio.payload.json')

const allure = Cypress.Allure.reporter.getInterface();



allure.epic('Pessoa')
context('Pessoa', () => {

  it('PUT - Atualizar Pessoa', () => {
    userService.adicionarPessoa(userPayload)
    .then(response => {
      cy.wrap(response.body).as('pessoa')
    })
    cy.get('@pessoa').then(pessoa => {
        userService.atualizarPessoa(pessoa.idPessoa, userPayload)
      .should((response) => {
        expect(response.status).to.eq(200)
      })
    cy.get('@pessoa').then(pessoa => {
      userService.deletarPessoa(pessoa.idPessoa)
    })
    })
  })

  it('PUT - Atualizar Pessoa Com Id Negativo', () => {
    userService.atualizarPessoa(-1, userPayload)
    .should((response) => {
      expect(response.status).to.eq(400)
    })
  })

  it('GET - Listar Pessoas', () => {
    userService.listarPessoas(0, 20)
    .should((response) =>{
      expect(response.status).to.eq(200)
    })
  });

  it('GET - Listar Pessoas Tamanha lista Negativo', () => {
    userService.listarPessoas(0, -20)
    .should((response) =>{
      expect(response.status).to.eq(400)
    })
  });

  it('DELETE, Deletar Pessoa', () => {
    userService.adicionarPessoa(userPayload)
    .then(response => {
      cy.wrap(response.body).as('pessoa')
    })
    cy.get('@pessoa')
    .then(pessoa => 
      userService.deletarPessoa(pessoa.idPessoa)
      .should((response) => {
        expect(response.status).to.eq(200)
      }))
    })
  
  it('DELETE, Deletar Pessoa Id Negativo', () => {
    userService.deletarPessoa(-200)
      .should((response) => {
        expect(response.status).to.eq(200)
      })
  })


  it('POST, Adicionar Nova Pessoa', () => {
    userService.adicionarPessoa(userPayload)
    .should((response) => {
      expect(response.status).to.eq(200)
    }).then(response => {
      cy.wrap(response.body).as('pessoa')
    })
    cy.get('@pessoa').then(pessoa => 
      userService.deletarPessoa(pessoa.idPessoa))
  })

  it('POST, Adicionar Nova Pessoa Com Nome Vazio', () => {
    userService.adicionarPessoa(userPayloadNomeVazio)
    .should((response) => {
      expect(response.status).to.eq(400)
    })
  })

  it('GET, Buscar Pessoa Por CPF', () => {
    userService.adicionarPessoa(userPayload)
    .then(response => {
      cy.wrap(response.body).as('pessoa')
    })
    cy.get('@pessoa').then(pessoa => 
      userService.buscarPessoaPorCpf(pessoa.cpf)
      .should(() => {
        expect(userPayload.cpf).to.eq(pessoa.cpf)
      }))
    cy.get('@pessoa').then(pessoa => 
      userService.deletarPessoa(pessoa.idPessoa))
  })

  it('GET, Buscar Pessoa Por CPF Invalido', () => {
      userService.buscarPessoaPorCpf("123456789123")
      .should((response) => {
        expect(response.status).to.eq(400)
      })
  })

  it('GET, Buscar Relatorio Pessoa', () => {
    userService.adicionarPessoa(userPayload)
    .then(response => {
      cy.wrap(response.body).as('pessoa')
    })
    cy.get('@pessoa').then(pessoa => 
      userService.buscarRelatorioPessoa(pessoa.idPessoa)
      .should(() => {
        expect(userPayload.email).to.eq(pessoa.email)
      }))
    cy.get('@pessoa').then(pessoa => 
      userService.deletarPessoa(pessoa.idPessoa))
  })

  it('GET, Buscar Relatorio Pessoa Inexistente', () => {
      userService.buscarRelatorioPessoa(9875733)
      .should((response) => {
        expect(response.status).to.eq(404)
      })
  })

  it('GET, Lista Completa Pessoa', () => {
    userService.adicionarPessoa(userPayload)
    .then(response => {
      cy.wrap(response.body).as('pessoa')
    })
    cy.get('@pessoa').then(pessoa => 
      userService.buscarListaCompleta(pessoa.idPessoa)
      .should(() => {
        expect(userPayload.email).to.eq(pessoa.email)
      }))
    cy.get('@pessoa').then(pessoa => 
      userService.deletarPessoa(pessoa.idPessoa))
  })

  it('GET, Lista Completa Pessoa Id Passado Como String', () => {
    userService.adicionarPessoa(userPayload)
    .then(response => {
      cy.wrap(response.body).as('pessoa')
    })
    cy.get('@pessoa').then(pessoa => 
      userService.buscarListaCompleta(toString(pessoa.idPessoa))
      .should(() => {
        expect(response.status).to.eq(400)
      }))
    cy.get('@pessoa').then(pessoa => 
      userService.deletarPessoa(pessoa.idPessoa))
  })

  it('GET, Lista Com Endereco Pessoa', () => {
    userService.adicionarPessoa(userPayload)
    .then(response => {
      cy.wrap(response.body).as('pessoa')
    })
    cy.get('@pessoa').then(pessoa => 
      userService.buscarListaComEndereco(pessoa.idPessoa)
      .should(() => {
        expect(userPayload.email).to.eq(pessoa.email)
      }))
    cy.get('@pessoa').then(pessoa => 
      userService.deletarPessoa(pessoa.idPessoa))
  })

  it('GET, Lista Com Endereco Pessoa Inexistente', () => {
      userService.buscarListaComEndereco(99999999)
      .should((response) => {
        expect(response.status).to.eq(404)
      })
  })

  it('GET, Lista Com Contatos Pessoa', () => {
    userService.adicionarPessoa(userPayload)
    .then(response => {
      cy.wrap(response.body).as('pessoa')
    })
    cy.get('@pessoa').then(pessoa => 
      userService.buscarListaComContatos(pessoa.idPessoa)
      .should(() => {
        expect(userPayload.email).to.eq(pessoa.email)
      }))
    cy.get('@pessoa').then(pessoa => 
      userService.deletarPessoa(pessoa.idPessoa))
  })

  it('GET, Lista Com Contatos Pessoa Inexistente', () => {
      userService.buscarListaComContatos(99999999)
      .should((response) => {
        expect(response.status).to.eq(404)
      })
  })

  it('GET, Buscar Pessoa por Nome', () => {
    userService.adicionarPessoa(userPayload)
    .then(response => {
      cy.wrap(response.body).as('pessoa')
    })
    cy.get('@pessoa').then(pessoa => 
      userService.buscarPessoaPorNome(pessoa.nome)
      .should(() => {
        expect(userPayload.email).to.eq(pessoa.email)
      }))
    cy.get('@pessoa').then(pessoa => 
      userService.deletarPessoa(pessoa.idPessoa))
  })

  it('GET, Buscar Pessoa por Nome Vazio', () => {
      userService.buscarPessoaPorNome("")
      .should((response) => {
        expect(response.status).to.eq(400)
      })
  })
});