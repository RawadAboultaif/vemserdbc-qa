import Activities from '../../service/fakeRestApi.service'
const activities  = new Activities 

const qsRelatorio = 
  {
    idPessoa: 4
  }

const qsPessoa = 
{
    nome: "Gabriel Luppi"
}


context('Contrato Pessoa', () => {

  it('Contrato - Validar contrato listarPessoa', () => {
    activities.contratoRequest("pessoa/schema/listarPessoa.contrato", "pessoa", "")
  });

  it('Contrato - Validar contrato atualizarPessoa', () => {
    activities.contratoRequest("pessoa/schema/pessoaCpf.contrato", "pessoa/741258/cpf", "")
  })

  it('Contrato - Validar contrato relatorioPorId', () => {
    activities.contratoRequest("pessoa/schema/relatorioIdPessoa.contrato", "pessoa/relatorio", qsRelatorio)
  })

  it('Contrato - Validar contrato lista-completa', () => {
    activities.contratoRequest("pessoa/schema/listaCompleta.contrato", "pessoa/lista-completa", qsRelatorio)
  })

  it('Contrato - Validar contrato lista-com-enderecos', () => {
    activities.contratoRequest("pessoa/schema/listaComEndereco.contrato", "pessoa/lista-com-enderecos", qsRelatorio)
  })

  it('Contrato - Validar contrato lista-com-contatos', () => {
    activities.contratoRequest("pessoa/schema/listaComContatos.contrato", "pessoa/lista-com-enderecos", qsRelatorio)
  })

  it('Contrato - Validar contrato buscarPorNome', () => {
    activities.contratoRequest("pessoa/schema/pessoa.contrato", "pessoa/byname", qsPessoa)
  })

})