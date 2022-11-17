import UserService from '../service/service'

const userService = new UserService

const userPayload = require('../../fixtures/addUser.payload.json')
const produtoPayload = require('../../fixtures/addProduct.payload.json')



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

  it('GET - Listar Pessoas', () => {
    userService.listarPessoas(0, 20)
    .should((response) =>{
      expect(response.status).to.eq(200)
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


});