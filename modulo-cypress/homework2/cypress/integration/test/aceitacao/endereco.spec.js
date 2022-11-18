import EnderecoService from "../../service/enderecoService";


const enderecoService = new EnderecoService
let enderecoPayload = require('../../../fixtures/endereco/massaDados/endereco.payload.json')
const qsIdPessoa = 
{
    idPessoa: 4091
}
const qsPais =
{
    País: enderecoPayload.pais
}

const qsTamanhoPagesInvalido = 
{
    pagina: 0,
    tamanhoDasPaginas: -20,
}

const qsIdPessoaInexistente = 
{
    idPessoa: 432423423
}
const qsPaisInexistente =
{
    País: "Nao Exite"
}

context('Endereco', () => {

    it('POST - Adicionar Novo Endereco', () => {
        enderecoService.adicionarEndereco(4091, enderecoPayload, qsIdPessoa)
        .should((response) => {
            expect(response.status).to.eq(200)
        }).then(response => {
            cy.wrap(response.body).as('endereco')
          })
          cy.get('@endereco').then(endereco => 
            enderecoService.deletarEndereco(endereco.idEndereco))
    })

    it('POST - Adicionar Novo Endereco em Pessoa Inexistente', () => {
        enderecoService.adicionarEndereco(999922, enderecoPayload, qsIdPessoa)
        .should((response) => {
            expect(response.status).to.eq(404)
        }).then(response => {
            cy.wrap(response.body).as('endereco')
          })
          cy.get('@endereco').then(endereco => 
            enderecoService.deletarEndereco(endereco.idEndereco))
    })


    it('DELETE - Deletar Endereco', () => {
        enderecoService.adicionarEndereco(4091, enderecoPayload, qsIdPessoa)
        .should((response) => {
            expect(response.status).to.eq(200)
        }).then(response => {
            cy.wrap(response.body).as('endereco')
          })
          cy.get('@endereco').then(endereco => 
            enderecoService.deletarEndereco(endereco.idEndereco))
    })

    it('DELETE - Deletar Endereco Inexistente', () => {
        enderecoService.adicionarEndereco(4091, enderecoPayload, qsIdPessoa)
        .should((response) => {
            expect(response.status).to.eq(200)
        }).then(response => {
            cy.wrap(response.body).as('endereco')
          })
          cy.get('@endereco').then(() => 
            enderecoService.deletarEndereco(99927273))
            .should((response) => {
                expect(response.status).to.eq(404)
            })
          cy.get('@endereco').then(endereco => 
            enderecoService.deletarEndereco(endereco.idEndereco))
    })

    it('GET - Listar Enderecos', () => {
        enderecoService.listarEndereco("")
        .should((response) => {
            expect(response.status).to.eq(200)
        })
    })

    it('GET - Listar Enderecos com Tamanho de Paginas Invalido', () => {
        enderecoService.listarEndereco(qsTamanhoPagesInvalido)
        .should((response) => {
            expect(response.status).to.eq(400)
        })
    })

    it('PUT - Atualizar Endereco Existente', () => {
        enderecoService.adicionarEndereco(4091, enderecoPayload, qsIdPessoa)
        .then(response => {
            cy.wrap(response.body).as('endereco')
        })
        cy.get('@endereco').then(endereco => {
            enderecoPayload.cidade = "teste"
            enderecoService.atualizarEndereco(endereco.idEndereco, enderecoPayload)
            .should((response) => {
                expect(response.body.cidade).to.eq("teste")
            })
        })
        cy.get('@endereco').then(endereco => {
            enderecoService.deletarEndereco(endereco.idEndereco)
        })
    })

    it('PUT - Atualizar Endereco Inexistente', () => {
            enderecoService.atualizarEndereco(986687, enderecoPayload)
            .should((response) => {
                expect(response.status).to.eq(404)
            })
    })

    it('GET - Listar Endereco Por idEndereco', () => {
        enderecoService.adicionarEndereco(4091, enderecoPayload, qsIdPessoa)
        .then(response => {
            cy.wrap(response.body).as('endereco')
          })
          cy.get('@endereco').then(endereco => 
            enderecoService.listarEndereco(endereco.idEndereco, ''))
            .should((response) => {
                expect(response.status).to.eq(200)
            })
          cy.get('@endereco').then(endereco => 
            enderecoService.deletarEndereco(endereco.idEndereco))
    })

    it('GET - Listar Endereco Por idEndereco Inexisnte', () => {
            enderecoService.listarEndereco(987967, '')
            .should((response) => {
                expect(response.status).to.eq(404)
            })
    })


    it('GET - Listar Endereco Por Pais', () => {
        enderecoService.adicionarEndereco(4091, enderecoPayload, qsIdPessoa)
        .then(response => {
            cy.wrap(response.body).as('endereco')
          })
          cy.get('@endereco').then(() => 
            enderecoService.listarEndereco("retorna-por-pais", qsPais))
            .should((response) => {
                expect(response.status).to.eq(200)
            })
          cy.get('@endereco').then(endereco => 
            enderecoService.deletarEndereco(endereco.idEndereco))
    })

    it('GET - Listar Endereco Por Pais Inexistente', () => {
            enderecoService.listarEndereco("retorna-por-pais", qsPaisInexistente)
            .should((response) => {
                expect(response.body).to.be.empty
            })
    })

    it('GET - Listar Endereco Por Id Pessoa', () => {
        enderecoService.adicionarEndereco(4091, enderecoPayload, qsIdPessoa)
        .then(response => {
            cy.wrap(response.body).as('endereco')
          })
          cy.get('@endereco').then(endereco => 
            enderecoService.listarEndereco("retorna-por-id-pessoa", qsIdPessoa))
            .should((response) => {
                expect(response.status).to.eq(200)
            })
          cy.get('@endereco').then(endereco => 
            enderecoService.deletarEndereco(endereco.idEndereco))
    })

    it('GET - Listar Endereco Por Id Pessoa Inexistente', () => {
            enderecoService.listarEndereco("retorna-por-id-pessoa", qsIdPessoaInexistente)
            .should((response) => {
                expect(response.body).to.be.empty
            })
    })
})