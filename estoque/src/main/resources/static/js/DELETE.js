const botao = document.querySelector(".submit");
const Titulo = document.querySelector(".title");
Titulo.innerText = "Deletar Produto";
botao.innerText = "Deletar";
document.querySelectorAll(".input").forEach(function(input) {
    input.disabled = true;
});

function enviarFormulario(event) {
    event.preventDefault();
    const id = window.location.pathname.split('/')[2];
    const nome = document.getElementById('Nome')
    const quantidade = document.getElementById('Quantidade').value;
    const preco = document.getElementById('Preco').value;
    const produto = {
        nome: nome,
        qtd: quantidade,
        preco: preco.replace(',', '.')  // Substituindo vírgula por ponto, caso necessário
    };
    fetch(`/almo-sys/produtos/${id}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(produto),
    })
    .then(response => response.text())
    .then(data => {
        console.log({ "message": "Produto Deletado" }, data);
    })
    .catch(error => {
        console.error('Erro:', error);
    });
    window.location.href = "/home";
    
}