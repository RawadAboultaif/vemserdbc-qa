/// <reference types="cypress" />

import LoginPage from "../pages/LoginPage";

const LOGIN_PAGE = new LoginPage;


   Given("que preencho o username valido", ()=>{
    LOGIN_PAGE.preencherUsername("teste123");
   });

   Given("que estou logado no sistema", () => {
      LOGIN_PAGE.preencherUsername("teste123");
      LOGIN_PAGE.preencherPassword("12345");
      LOGIN_PAGE.clicarBtnLogin();
   })

   And("que preencho a senha valida", ()=>{
    LOGIN_PAGE.preencherPassword("12345");
   });

   And("que preencho a senha invalida", ()=> {
    LOGIN_PAGE.preencherPassword("senha_errada");
   });
   
   When("clico em login", ()=>{
    LOGIN_PAGE.clicarBtnLogin();
   });

   Then("devo visualizar uma mensagem de erro", () => {
    LOGIN_PAGE.buscarMsgErrorLogin()
   })