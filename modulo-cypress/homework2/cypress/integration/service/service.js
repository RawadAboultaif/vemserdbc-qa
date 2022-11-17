import { token } from "../../support/commands"


const API_BASE = Cypress.env('API_BASE')

export default class UserService{

  listarPessoas(page, tamanho){
    return cy.request({
        method: "GET",
        url: `${API_BASE}pessoa`,
        headers: {
          Authorization: token,
          "Content-Type": "application/json",
        },
        qs: {
          pagina: page,
          tamanhoDasPaginas: tamanho,
        },
        failOnStatusCode: false,
    }).as('response').get('@response')
  }

  atualizarPessoa(idPessoa, pessoa){
    return cy.request({
        method: 'PUT',
        url: `${API_BASE}pessoa/${idPessoa}`,
        headers: {
            Authorization: token,
            "Content-Type": "application/json",
        },
        body: pessoa,
        failOnStatusCode: false,
    }).as('response').get('@response')
  }

  deletarPessoa(idPessoa){
    return cy.request({
        method: 'DELETE',
        url: `${API_BASE}pessoa/${idPessoa}`,
        headers: {
            Authorization: token,
            "Content-Type": "application/json",
        },
        failOnStatusCode: false,
    }).as('response').get('@response')
  }

  adicionarPessoa(pessoa){
    return cy.request({
        method: 'POST',
        url: `${API_BASE}pessoa`,
        headers: {
            Authorization: token,
            "Content-Type": "application/json",
        },
        body: pessoa,
        failOnStatusCode: false,
    }).as('response').get('@response')
  }

  buscarPessoaPorCpf(cpf){
    return cy.request({
        method: "GET",
        url: `${API_BASE}/pessoa/${cpf}/cpf`,
        headers: {
          Authorization: token,
          "Content-Type": "application/json",
        },
        failOnStatusCode: false,
    }).as('response').get('@response')
  }

  buscarRelatorioPessoa(idpessoa){
    return cy.request({
        method: "GET",
        url: `${API_BASE}pessoa/relatorio`,
        headers: {
          Authorization: token,
          "Content-Type": "application/json",
        },
        qs: {
          idPEssoa: idpessoa,
        },
        failOnStatusCode: false,
    }).as('response').get('@response')
  }

  buscarListaCompleta(idpessoa){
    return cy.request({
        method: "GET",
        url: `${API_BASE}pessoa/lista-completa`,
        headers: {
          Authorization: token,
          "Content-Type": "application/json",
        },
        qs: {
          idPEssoa: idpessoa,
        },
        failOnStatusCode: false,
    }).as('response').get('@response')
  }

  buscarListaComEndereco(idpessoa){
    return cy.request({
        method: "GET",
        url: `${API_BASE}pessoa/lista-com-enderecos`,
        headers: {
          Authorization: token,
          "Content-Type": "application/json",
        },
        qs: {
          idPEssoa: idpessoa,
        },
        failOnStatusCode: false,
    }).as('response').get('@response')
  }

  buscarListaComContatos(idpessoa){
    return cy.request({
        method: "GET",
        url: `${API_BASE}pessoa/lista-com-contatos`,
        headers: {
          Authorization: token,
          "Content-Type": "application/json",
        },
        qs: {
          idPEssoa: idpessoa,
        },
        failOnStatusCode: false,
    }).as('response').get('@response')
  }

  buscarPessoaPorNome(nomePessoa){
    return cy.request({
        method: "GET",
        url: `${API_BASE}pessoa/byname`,
        headers: {
          Authorization: token,
          "Content-Type": "application/json",
        },
        qs: {
          nome: nomePessoa,
        },
        failOnStatusCode: false,
    }).as('response').get('@response')
  }
}