package almoxarifado.estoque.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "ERRO: Nome do produto não informada")
    private String nome;

    @NotNull(message = "ERRO: Quantidade do produto não informada")
    @Min(value = 1, message = "A quantidade minima suportada é 1")
    private Integer qtd;
    @NotNull(message = "ERRO: Valor do produto não informada")
    @DecimalMin(value = "0.05", inclusive = true, message = "O preço deve ser no mínimo 0.05")
    private Double preco;

}
