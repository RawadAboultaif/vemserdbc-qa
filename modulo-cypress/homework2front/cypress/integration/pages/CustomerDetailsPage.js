import BasePage from "./BasePage";

const BASE_PAGE = new BasePage();

let campoNome = 'body > div > div > dl > dd:nth-child(2)'
let campoCompany = 'body > div > div > dl > dd:nth-child(4)'
let campoAddress = 'body > div > div > dl > dd:nth-child(6)'
let campoCity = 'body > div > div > dl > dd:nth-child(8)'
let campoPhone = 'body > div > div > dl > dd:nth-child(10)'
let campoEmail = 'body > div > div > dl > dd:nth-child(12)'

export default class CustomerDetailsPage {

    validarCampoNome(text) {
        BASE_PAGE.validarText(campoNome, text)
    }

    validarCampoCompany(text) {
        BASE_PAGE.validarText(campoCompany, text)
    }

    validarCampoAddress(text) {
        BASE_PAGE.validarText(campoAddress, text)
    }

    validarCampoCity(text) {
        BASE_PAGE.validarText(campoCity, text)
    }

    validarCampoPhone(text) {
        BASE_PAGE.validarText(campoPhone, text)
    }

    validarCampoEmail(text) {
        BASE_PAGE.validarText(campoEmail, text)
    }

}