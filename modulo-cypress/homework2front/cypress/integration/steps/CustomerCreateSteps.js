import LoginPage from "../pages/LoginPage";
import DashboardPage from "../pages/DashboardPage";
import CustomerCreatePage from "../pages/CustomerCreatePage";
import BasePage from "../pages/BasePage";

import { faker } from '@faker-js/faker/locale/pt_BR';
import { AnimalModule } from "@faker-js/faker";

const LOGIN_PAGE = new LoginPage;
const DASHBOARD_PAGE = new DashboardPage;
const CUSTOMER_CREATE_PAGE = new CustomerCreatePage;
const BASE_PAGE = new BasePage;

Then("verificar que estou na pagina Dashboard", () => {
        cy.url().should('eq', 'https://itera-qa.azurewebsites.net/Dashboard')
})

And("tento criar usuario com campos vazios", () => {
        DASHBOARD_PAGE.clicarBtnCreateNew();
        CUSTOMER_CREATE_PAGE.preencherCampoName(faker.name.firstName());
        CUSTOMER_CREATE_PAGE.preencherCampoCompany(faker.company.name());
        CUSTOMER_CREATE_PAGE.preencherCampoAdress(faker.address.streetAddress());
        CUSTOMER_CREATE_PAGE.clicarBtnCreateNew();
})

Then("verificar que estou na pagina Customer/Create", () => {
        cy.url().should('eq', 'https://itera-qa.azurewebsites.net/Customer/Create')
})
