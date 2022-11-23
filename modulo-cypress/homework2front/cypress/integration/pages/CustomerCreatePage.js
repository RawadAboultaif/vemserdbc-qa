import BasePage from "./BasePage";
import LoginPage from "./LoginPage";
import DashboardPage from "./DashboardPage";

import { faker } from '@faker-js/faker/locale/pt_BR';



const BASE_PAGE = new BasePage();
const LOGIN_PAGE = new LoginPage();
const DASHBOARD_PAGE = new DashboardPage();

let inputName = "#Name"
let inputCompany = "#Company"
let inputAdress = "#Address"
let inputCity = "#City"
let inputPhone = "#Phone"
let inputEmail = "#Email"
let btnCreate = "body > div > form > div > div:nth-child(9) > div > input"
let btnBackToList = "body > div > div > a"

export default class CustomerCreatePage {

        preencherCampoName(text) {
            BASE_PAGE.preencherInput(inputName, text)
        }

        preencherCampoCompany(text) {
            BASE_PAGE.preencherInput(inputCompany, text)
        }

        preencherCampoAdress(text) {
            BASE_PAGE.preencherInput(inputAdress, text)
        }

        preencherCampoCity(text) {
            BASE_PAGE.preencherInput(inputCity, text)
        }

        preencherCampoPhone(text) {
            BASE_PAGE.preencherInput(inputPhone, text)
        }

        preencherCampoEmail(text) {
            BASE_PAGE.preencherInput(inputEmail, text)
        }

        clicarBtnCreateNew() {
            BASE_PAGE.click(btnCreate)
        }

        clicarBtnBackToList() {
            BASE_PAGE.click(btnBackToList)
        }

        criarNovoUsuarioReturnDados() {
            
            let hashFaker = new Map();

            DASHBOARD_PAGE.clicarBtnCreateNew();

            hashFaker.nome = (faker.name.firstName());
            hashFaker.company = (faker.company.name());
            hashFaker.address =(faker.address.streetAddress());
            hashFaker.city =(faker.address.cityName());
            hashFaker.phone =(faker.phone.number());
            hashFaker.email =(faker.internet.email());

            this.preencherCampoName(hashFaker.nome)
            this.preencherCampoCompany(hashFaker.company)
            this.preencherCampoAdress(hashFaker.address)
            this.preencherCampoCity(hashFaker.city)
            this.preencherCampoPhone(hashFaker.phone)
            this.preencherCampoEmail(hashFaker.email)
            this.clicarBtnCreateNew();

            return hashFaker
        }

}