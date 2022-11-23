import BasePage from "../pages/BasePage";
import CustomerCreatePage from "../pages/CustomerCreatePage";
import DashboardPage from "../pages/DashboardPage";
import CustomerDeletePage from  "../pages/CustomerDeletePage";
import CustomerDetailsPage from "../pages/CustomerDetailsPage";


const BASE_PAGE = new BasePage;
const CUSTOMER_CREATE_PAGE = new CustomerCreatePage;
const DASHBOARD_PAGE = new DashboardPage;
const CUSTOMER_DELETE_PAGE = new CustomerDeletePage;
const CUSTOMER_DETAILS_PAGE = new CustomerDetailsPage;


let hashFaker;

   And("que crio um novo usuario", ()=>{
    hashFaker = CUSTOMER_CREATE_PAGE.criarNovoUsuarioReturnDados()
   });

  
   And("que preencho o campo de pesquisar usuario", ()=>{
    DASHBOARD_PAGE.preencherCampoSearch(hashFaker.email)
   });

   And('que clico no botao de deletar do dashboard', () => {
    DASHBOARD_PAGE.clicarBtnDelete()
   })

   When('clico no botao deletar na pagina do ususario', () => {
    CUSTOMER_DELETE_PAGE.clicarBtnDelete();
   })
   
   When("clico em search", ()=>{
    DASHBOARD_PAGE.clicarBtnSearch()
   });

   Then("devo visualizar o usuario na lista", () => {
    DASHBOARD_PAGE.validarEmail(hashFaker.email)
   })

   Then("devo visualizar que o usuario nao se encontrar mais na lista", () => {
    DASHBOARD_PAGE.preencherCampoSearch(hashFaker.email)
    DASHBOARD_PAGE.clicarBtnSearch()
    DASHBOARD_PAGE.validarMensagemErroAoBuscarUsuario("No Match")
   })

   When('que clico no botao Details', () => {
        DASHBOARD_PAGE.clicarBtnDetalhesUsusario()
   })

   Then('devo vizualizar todas as informações do usuario', () => {
        CUSTOMER_DETAILS_PAGE.validarCampoNome(hashFaker.nome)
        CUSTOMER_DETAILS_PAGE.validarCampoAddress(hashFaker.address)
        CUSTOMER_DETAILS_PAGE.validarCampoCity(hashFaker.city)
        CUSTOMER_DETAILS_PAGE.validarCampoCompany(hashFaker.company)
        CUSTOMER_DETAILS_PAGE.validarCampoPhone(hashFaker.phone)
        CUSTOMER_DETAILS_PAGE.validarCampoEmail(hashFaker.email)
   })