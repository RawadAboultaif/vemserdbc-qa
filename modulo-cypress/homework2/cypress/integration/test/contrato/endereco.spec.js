import Activities from '../../service/fakeRestApi.service'
const activities  = new Activities 

const qsIdPessoa =
 {
    idPessoa: 956
 }

 const qsPais = 
 {
    País: 'Eritrea'
 }

context('Contrato Endereco', () => {

    it('Contrato - Buscar Endereco por Id Endereco', () => {
        activities.contratoRequest("endereco/schema/enderecoPorIdEndereco.contrato", "endereco/173", "")
    })

    it('Contrato - Lista Endereco Completa', () => {
        activities.contratoRequest("endereco/schema/listaEnderecoCompleta.contrato", "endereco", "")
    })

    it('Contrato - Lista Endereco Por Pais', () => {
        activities.contratoRequest("endereco/schema/listaArrayEndereco.contrato", "endereco/retorna-por-pais", qsPais)
    })

    it('Contrato - Lista Endereco Por Id Pessoa', () => {
        activities.contratoRequest("endereco/schema/listaArrayEndereco.contrato", "endereco/retorna-por-id-pessoa", qsIdPessoa)
    })

})