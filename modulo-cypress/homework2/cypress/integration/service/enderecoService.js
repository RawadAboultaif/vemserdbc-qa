import { token } from "../../support/commands"


const API_BASE = Cypress.env('API_BASE')


export default class EnderecoService {

    listarEndereco(endpoint, query){
        return cy.request({
            method: "GET",
            url: `${API_BASE}endereco/${endpoint}`,
            headers: {
              Authorization: token,
              "Content-Type": "application/json",
            },
            failOnStatusCode: false,
            qs: query
        }).as('response').get('@response')
    }

    adicionarEndereco(endpoint, massaDados, query){
        return cy.request({
            method: "POST",
            url: `${API_BASE}endereco/${endpoint}`,
            headers: {
              Authorization: token,
              "Content-Type": "application/json",
            },
            body: massaDados,
            qs: query,
            failOnStatusCode: false,
        }).as('response').get('@response')
    }

    atualizarEndereco(endpoint, massaDados){
        return cy.request({
            method: "PUT",
            url: `${API_BASE}endereco/${endpoint}`,
            headers: {
              Authorization: token,
              "Content-Type": "application/json",
            },
            body: massaDados,
            failOnStatusCode: false,
        }).as('response').get('@response')
    }

    deletarEndereco(endpoint){
        return cy.request({
            method: "DELETE",
            url: `${API_BASE}endereco/${endpoint}`,
            headers: {
              Authorization: token,
              "Content-Type": "application/json",
            },
            failOnStatusCode: false,
        }).as('response').get('@response')
    }
}