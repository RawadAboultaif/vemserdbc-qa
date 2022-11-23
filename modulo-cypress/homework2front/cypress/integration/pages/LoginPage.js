

import BasePage from "./BasePage";
import DashboardPage from "./DashboardPage";

const BASE_PAGE = new BasePage();
const createnew = new DashboardPage()

let username = "#Username";
let password = "#Password";
let loginBtn = "body > div > div:nth-child(4) > form > table > tbody > tr:nth-child(7) > td:nth-child(2) > input.btn.btn-primary"
let msgLogin = ".alert-danger";


export default class LoginPage {

    preencherUsername(text) {
        BASE_PAGE.preencherInput(username, text)
    }
    
    preencherPassword(text) {
        BASE_PAGE.preencherInput(password, text)
    }

    clicarBtnLogin() {
        BASE_PAGE.click(loginBtn)
    }

    buscarMsgErrorLogin() {
        BASE_PAGE.validarText(msgLogin, "Wrong username or password")
    }
}