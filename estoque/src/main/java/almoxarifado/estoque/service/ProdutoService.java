package almoxarifado.estoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import almoxarifado.estoque.models.Produto;
import almoxarifado.estoque.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto findById(Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) {
        produtoRepository.deleteById(id);
    }

}
