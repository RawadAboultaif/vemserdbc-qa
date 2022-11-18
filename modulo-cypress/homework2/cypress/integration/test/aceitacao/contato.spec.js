import ContatoService from "../../service/contatoService";


const contatoService = new ContatoService
let contatoPayload = require('../../../fixtures/contato/massaDados/contato.payload.json')

const qsIdPessoa = 
{
    idPessoa: 4091
}

const qsTamanhoPagesInvalido = 
{
    pagina: 0,
    tamanhoDasPaginas: -20,
}


context('Contato', () => {

    it('POST - Adicionar Novo Contato', () => {
        contatoService.adicionarContato(4091, contatoPayload, qsIdPessoa)
        .should((response) => {
            expect(response.status).to.eq(200)
        }).then(response => {
            cy.wrap(response.body).as('contato')
          })
          cy.get('@contato').then(contato => 
            contatoService.deletarContato(contato.idContato))
    })

    it('POST - Adicionar Novo Contato em Pessoa Inexistente', () => {
        contatoService.adicionarContato(34235235, contatoPayload, qsIdPessoa)
        .should((response) => {
            expect(response.status).to.eq(404)
        })
    })


    it('DELETE - Deletar Contato Existente', () => {
        contatoService.adicionarContato(4091, contatoPayload, qsIdPessoa)
        .should((response) => {
            expect(response.status).to.eq(200)
        }).then(response => {
            cy.wrap(response.body).as('contato')
          })
          cy.get('@contato').then(contato => 
            contatoService.deletarContato(contato.idContato))
    })

    it('DELETE - Deletar Contato Inexistente', () => {
        contatoService.deletarContato(34235235)
        .should((response) => {
            expect(response.status).to.eq(404)
        })
    })

    it('GET - Listar Contatos Por idContato', () => {
        contatoService.adicionarContato(4091, contatoPayload, qsIdPessoa)
        .should((response) => {
            expect(response.status).to.eq(200)
        }).then(response => {
            cy.wrap(response.body).as('contato')
          })
          cy.get('@contato').then(contato => 
            contatoService.listarContato(contato.idPessoa, ''))
            .should((response) => {
                expect(response.status).to.eq(200)})
          cy.get('@contato').then(contato => 
            contatoService.deletarContato(contato.idContato))
    })

    it('GET - Listar Contatos Por idContato Inexistente', () => {
            contatoService.listarContato(34235235, '')
            .should((response) => {
                expect(response.status).to.eq(404)})
    })

    it('PUT - Atualizar Contato', () => {
        contatoService.adicionarContato(4091, contatoPayload, qsIdPessoa)
        .should((response) => {
            expect(response.status).to.eq(200)
        }).then(response => {
            cy.wrap(response.body).as('contato')
          })
          cy.get('@contato').then(contato => {
            contatoPayload.tipoContato = "COMERCIAL"
            contatoService.atualizarContato(contato.idContato, contatoPayload)
            .should((response) => {
                expect(response.body.tipoContato).to.eq("COMERCIAL")
            })
        })
          cy.get('@contato').then(contato => 
            contatoService.deletarContato(contato.idContato))
    })

    it('PUT - Atualizar Contato Inexistente', () => {
        contatoService.atualizarContato(34235235, contatoPayload)
        .should((response) => {
            expect(response.status).to.eq(404)
        })
    })

    it('GET - Listar Todos Os Contatos', () => {
        contatoService.listarContato("", "")
        .should((response) => {
            expect(response.status).to.eq(200)
        })
    })

    it('GET - Listar Todos Os Contatos Tamanho Pagina Invalido', () => {
        contatoService.listarContato("", qsTamanhoPagesInvalido)
        .should((response) => {
            expect(response.status).to.eq(400)
        })
    })

})