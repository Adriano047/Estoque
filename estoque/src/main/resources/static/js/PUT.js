const texto = document.querySelector(".submit");
const Titulo = document.querySelector(".title");

texto.innerText = "Alterar";
Titulo.innerText = "Alterar Produto";

function enviarFormulario(event) {
    event.preventDefault();
    const id = window.location.pathname.split('/')[2];
    const nome = document.getElementById('Nome').value.trim().replaceAll(/\s+/g, " ");
    const quantidade = document.getElementById('Quantidade').value;
    const preco = document.getElementById('Preco').value;
    if (quantidade >= 1 && preco >= 0.05 && nome != '') {

        const produto = {
            nome: nome,
            qtd: quantidade,
            preco: preco.replace(',', '.')  // Substituindo vírgula por ponto, caso necessário
        };
        fetch(`/almo-sys/produtos/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(produto),
        })
        .then(response => response.text())
        .then(data => {
            console.log({ "message": "Produto Alterado" }, data);
        })
        .catch(error => {
            console.error('Erro:', error);
        });
        window.location.href = "/";
    }
}