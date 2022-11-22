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



context('Dashboard Page', () => {

    it('Validar Pesquisar Usuario Pelo Campo Search', () => {
        
        let hashFaker = CUSTOMER_CREATE_PAGE.criarNovoUsuarioReturnDados()
        DASHBOARD_PAGE.preencherCampoSearch(hashFaker.email)
        DASHBOARD_PAGE.clicarBtnSearch()

        DASHBOARD_PAGE.validarEmail(hashFaker.email)

    })


    it('Validar Deletar Usuario', () => {
        
        let hashFaker = CUSTOMER_CREATE_PAGE.criarNovoUsuarioReturnDados()

        DASHBOARD_PAGE.preencherCampoSearch(hashFaker.email)
        DASHBOARD_PAGE.clicarBtnSearch()
        DASHBOARD_PAGE.clicarBtnDelete()
        CUSTOMER_DELETE_PAGE.clicarBtnDelete();

        DASHBOARD_PAGE.preencherCampoSearch(hashFaker.email)
        DASHBOARD_PAGE.clicarBtnSearch()
        DASHBOARD_PAGE.validarMensagemErroAoBuscarUsuario("No Match")

    })

    it('Validar Botao listar informaões do usuario', () => {

        let hashFaker = CUSTOMER_CREATE_PAGE.criarNovoUsuarioReturnDados()
        DASHBOARD_PAGE.preencherCampoSearch(hashFaker.email)
        DASHBOARD_PAGE.clicarBtnSearch()
        DASHBOARD_PAGE.clicarBtnDetalhesUsusario()

        CUSTOMER_DETAILS_PAGE.validarCampoNome(hashFaker.nome)
        CUSTOMER_DETAILS_PAGE.validarCampoAddress(hashFaker.address)
        CUSTOMER_DETAILS_PAGE.validarCampoCity(hashFaker.city)
        CUSTOMER_DETAILS_PAGE.validarCampoCompany(hashFaker.company)
        CUSTOMER_DETAILS_PAGE.validarCampoPhone(hashFaker.phone)
        CUSTOMER_DETAILS_PAGE.validarCampoEmail(hashFaker.email)
    })

})