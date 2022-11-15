///<reference types="cypress" />

const id = 2

context('Books', () => {
    it('Buscar livros por id', () => {
        cy.request({
            method: 'GET',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Books',
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body).to.not.be.empty;
        })
    })

    it('Postar novos livros', () => {
        cy.request({
            method: 'POST',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Books',
            failOnStatusCode: false,
            body: {
                "id": 0,
                "title": "JavaScript",
                "description": "Muito Facil",
                "pageCount": 0,
                "excerpt": "E Muito Chato",
                "publishDate": "2022-11-15T19:35:04.735Z"
            }
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.description).to.eq('E Muito Chato')
        })
    })

    it('Buscar livros por id', () => {
        cy.request({
            method: 'GET',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Books/' + id,
            failOnStatusCode: false
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.title).to.eq('Book 2')
        })
    })

    it('Atualizar livros por id', () => {
        cy.request({
            method: 'PUT',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Books/' + id,
            failOnStatusCode: false,
            body: {
                "id": 0,
                "title": "Prefiro JAVA",
                "description": "Muito Melhor",
                "pageCount": 0,
                "excerpt": "string",
                "publishDate": "2022-11-15T19:39:32.799Z"
            }
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
            expect(response.body.title).to.eq('Prefiro JAVA')
        })
    })

    it('Deletar livros por id', () => {
        cy.request({
            method: 'DELETE',
            url: 'https://fakerestapi.azurewebsites.net/api/v1/Books/' + id,
            failOnStatusCode: false,
        }).as('response').get('@response').should((response) => {
            expect(response.status).to.eq(200);
        })
    })
})