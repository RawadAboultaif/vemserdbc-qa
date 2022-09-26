let bar = document.querySelector('input#senha')
let ger = document.querySelector('input#botao')
let snh = document.querySelector('div#senha1')
let alf = "abcdfghijklmnopqrstuvwxyzABCDFGHIJKLMNOPQRSTUVWXY1234567890!@#$%&"
let qnt = document.querySelector('span.qnt')
let cop = document.querySelector('div#copiar')
qnt.innerHTML = bar.value
bar.oninput = function() {
    qnt.innerHTML = this.value
    novasenha = ""
}
function gerar() {
    let pass = ""
    for ( i = 0, n = alf.length; i < bar.value; ++i) {
        pass += alf.charAt(Math.floor(Math.random() * n))
    }
    snh.innerHTML = pass
    snh.classList.remove('hide')
    cop.classList.remove('hide')
    novasenha = pass
}
snh.addEventListener('click', function copy(){
navigator.clipboard.writeText(novasenha)
} )