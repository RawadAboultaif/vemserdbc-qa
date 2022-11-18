const API_BASE = Cypress.env('API_BASE')
const TOKEN = Cypress.env('ACCESS_TOKEN')
import { token } from "../../support/commands"

import Ajv from "ajv"
const ajv = new Ajv({allErrors: true, verbose: true})

export default class Contrato {

  contratoRequest(contrato, endpoint, query){
    cy.request({
      method: 'GET',
      url: `${API_BASE}/${endpoint}`,
      failOnStatusCode: false,
      headers: {
        Authorization: token,
        "Content-Type": "application/json",
      },
      qs : query
    }).then((response)=>{
      //pegar o arquivo (Schema) pasta fixtures e passar com parameto
      cy.fixture(contrato).then((contrato)=>{
        // compilar esse arquivo, (jsonSchema)
        const validate = ajv.compile(contrato)

        // resnse  da api (validações)
        const responseApi = validate(response.body)

        // Validação (Error)
        if(!responseApi) cy.log(validate.errors).then(() =>{
          throw new Error('Falha do contrato')
        })
      })
    })

  }



}