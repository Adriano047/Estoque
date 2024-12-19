function enviarFormulario(event) {
    event.preventDefault();
    const nome = document.getElementById('Nome').value.trim().replaceAll(/\s+/g, " ");
    const quantidade = document.getElementById('Quantidade').value;
    const preco = document.getElementById('Preco').value;

    if (quantidade >= 1 && preco >= 0.05 && nome != '') {
        const produto = {
            nome: nome,
            qtd: quantidade,
            preco: preco.replace(',', '.')  // Substituindo vírgula por ponto, caso necessário
        };
    
        fetch('/almo-sys/produtos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(produto),
        })
        .then(response => response.text())
        .then(data => {
            console.log({ "message": "Produto cadastrado" }, data);
        })
        .catch(error => {
            console.error('Erro:', error);
        });
        window.location.href = "/home";
    }
}