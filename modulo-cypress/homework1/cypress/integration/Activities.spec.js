///<reference types="cypress" />

const id = 2

// Suite
context('Activities', () => {

    // Cenario
    it('Buscar todoas as Atividades', () => {
  
      cy.request({
        method: 'GET',
        url: 'https://fakerestapi.azurewebsites.net/api/v1/Activities',
        failOnStatusCode: false
      }).as('response').get('@response').should((response) => {
        expect(response.status).to.eq(200);
        expect(response.body).to.not.be.empty;
      })
  
    });
  
    it('Postar Nova Atividade', () => {
  
      cy.request({
        method: 'POST',
        url: 'https://fakerestapi.azurewebsites.net/api/v1/Activities',
        failOnStatusCode: false, 
        body: {
          "id": 10,
          "title": "Teste",
          "dueDate": "2022-11-15T16:17:10.775Z",
          "completed": true
        }
      }).as('response').get('@response').should((response) => {
        expect(response.status).to.eq(200);
        expect(response.body.id).to.eq(10);
        expect(response.body.title).to.eq("Teste");
  
      })
  
    });

    it("Buscar Atividades por id", () => {
      cy.request({
        method: 'GET',
        url: 'https://fakerestapi.azurewebsites.net/api/v1/Activities/' + id,
        failOnStatusCode: false
      }).as('response').get('@response').should((response) =>{
        expect(response.status).to.eq(200);
        expect(response.body.id).to.eq(2);
      })
    });

    it('Atualizar Usuario Existente', () => {
      cy.request({
        method: 'PUT',
        url: 'https://fakerestapi.azurewebsites.net/api/v1/Activities/' + id,
        failOnStatusCode: false,
        body: {
          "id": 2,
          "title": "Teste",
          "dueDate": "2022-11-15T18:54:49.649Z",
          "completed": true
        }
      }).as('response').get('@response').should((response) => {
        expect(response.status).to.eq(200);
        expect(response.body.title).to.eq("Teste")
      })
    })

    it('Deletar Ususario Existente',  () => {
      cy.request({
        method: 'DELETE',
        url: 'https://fakerestapi.azurewebsites.net/api/v1/Activities/' + id,
        failOnStatusCode: false
      }).as('response').get('@response').should((response) => {
        expect(response.status).to.eq(200);
      })
    })

  });