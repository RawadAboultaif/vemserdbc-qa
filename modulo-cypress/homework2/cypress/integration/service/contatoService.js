import { token } from "../../support/commands"


const API_BASE = Cypress.env('API_BASE')


export default class ContatoService {

    listarContato(endpoint, query){
        return cy.request({
            method: "GET",
            url: `${API_BASE}contato/${endpoint}`,
            headers: {
              Authorization: token,
              "Content-Type": "application/json",
            },
            failOnStatusCode: false,
            qs: query
        }).as('response').get('@response')
    }

    adicionarContato(endpoint, massaDados, query){
        return cy.request({
            method: "POST",
            url: `${API_BASE}contato/${endpoint}`,
            headers: {
              Authorization: token,
              "Content-Type": "application/json",
            },
            body: massaDados,
            qs: query,
            failOnStatusCode: false,
        }).as('response').get('@response')
    }

    atualizarContato(endpoint, massaDados){
        return cy.request({
            method: "PUT",
            url: `${API_BASE}contato/${endpoint}`,
            headers: {
              Authorization: token,
              "Content-Type": "application/json",
            },
            body: massaDados,
            failOnStatusCode: false,
        }).as('response').get('@response')
    }

    deletarContato(endpoint){
        return cy.request({
            method: "DELETE",
            url: `${API_BASE}contato/${endpoint}`,
            headers: {
              Authorization: token,
              "Content-Type": "application/json",
            },
            failOnStatusCode: false,
        }).as('response').get('@response')
    }
}