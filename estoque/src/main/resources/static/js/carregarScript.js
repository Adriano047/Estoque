function carregarScript(scriptName) {
    const script = document.createElement('script');
    script.src = scriptName;
    document.head.appendChild(script);
}

if (window.location.pathname === '/novoProduto') {
    carregarScript('js/POST.js');
} else if (window.location.pathname.startsWith('/AlterarProduto/')) {
    carregarScript('/js/PUT.js');
} else if (window.location.pathname.startsWith('/DeletarProduto/')) {
    carregarScript('/js/DELETE.js');
}