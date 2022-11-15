///<reference types="cypress" />

const id = 2


context('Authors', () => {

    it('Buscar Todos os Authors', () => {
        cy.request({
            method: 'GET',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Authors',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).to.not.be.empty;
        })
    })

    it('Postar novo Author', () => {
        cy.request({
            method: 'POST', 
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Authors',
            failOnStatusCode: false,
            body: {
                "id": 1000,
                "idBook": 1000,
                "firstName": "Teste",
                "lastName": "Js CHATO"
            }
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.lastName).to.eq("Js CHATO")
        })
    })

    it('Buscar livro do Author', () => {
        cy.request({
            method: 'GET',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Authors/authors/books/' + id,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body[0].lastName).to.eq('Last Name 4')
        })
    })

    it('Buscar Author por id', () => {
        cy.request({
            method: 'GET',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Authors/' + id,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.id).to.eq(2)
        })
    })

    it('Atualizar Author por id', () => {
        cy.request({
            method: 'PUT',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Authors/' + id,
            failOnStatusCode: false,
            body: {
                "id": 0,
                "idBook": 0,
                "firstName": "JavaScript",
                "lastName": "Bugado"
            }
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.lastName).to.eq("Bugado")
        })
    })

    it('Deletar Author existente', () => {
        cy.request({
            method: 'DELETE',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Authors/' + id,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
        })
    })
})