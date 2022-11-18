import Activities from '../../service/fakeRestApi.service'
const activities  = new Activities 


context('Contrato Contato', () => {

    it('Contrato - Buscar Contato por Id Pessoa', () => {
        activities.contratoRequest("contato/schema/contatoPessoa.contrato", "contato/892", "")
    })

    it('Contrato - Buscar Lista Completa de Contatos', () => {
        activities.contratoRequest("contato/schema/contatoPessoa.contrato", "contato", "")
    })

})