package almoxarifado.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import almoxarifado.estoque.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
