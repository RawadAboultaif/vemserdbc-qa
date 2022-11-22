import LoginPage from "../pages/LoginPage";
import DashboardPage from "../pages/DashboardPage";
import CustomerCreatePage from "../pages/CustomerCreatePage";
import BasePage from "../pages/BasePage";

import { faker } from '@faker-js/faker/locale/pt_BR';

const LOGIN_PAGE = new LoginPage;
const DASHBOARD_PAGE = new DashboardPage;
const CUSTOMER_CREATE_PAGE = new CustomerCreatePage;
const BASE_PAGE = new BasePage;


context('CustomerCreatePage', () => {

    it('Validar criação de novo usuario com todos os dados validos', () => {

        LOGIN_PAGE.loginNoSistem();
        DASHBOARD_PAGE.clicarBtnCreateNew();
        CUSTOMER_CREATE_PAGE.preencherCampoName(faker.name.firstName());
        CUSTOMER_CREATE_PAGE.preencherCampoCompany(faker.company.name());
        CUSTOMER_CREATE_PAGE.preencherCampoAdress(faker.address.streetAddress());
        CUSTOMER_CREATE_PAGE.preencherCampoCity(faker.address.cityName());
        CUSTOMER_CREATE_PAGE.preencherCampoPhone(faker.phone.number());
        CUSTOMER_CREATE_PAGE.preencherCampoEmail(faker.internet.email());
        CUSTOMER_CREATE_PAGE.clicarBtnCreateNew();

        cy.url().should('eq', 'https://itera-qa.azurewebsites.net/Dashboard')
    })

    it('Validar Mensagem de erro ao criar usuario com campos vazios', () => {

        LOGIN_PAGE.loginNoSistem();
        DASHBOARD_PAGE.clicarBtnCreateNew();
        CUSTOMER_CREATE_PAGE.preencherCampoName(faker.name.firstName());
        CUSTOMER_CREATE_PAGE.preencherCampoCompany(faker.company.name());
        CUSTOMER_CREATE_PAGE.preencherCampoAdress(faker.address.streetAddress());
        CUSTOMER_CREATE_PAGE.clicarBtnCreateNew();


        cy.url().should('eq', 'https://itera-qa.azurewebsites.net/Customer/Create')
    })

})
