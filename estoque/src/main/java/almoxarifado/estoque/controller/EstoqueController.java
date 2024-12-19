package almoxarifado.estoque.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import almoxarifado.estoque.models.Produto;
import almoxarifado.estoque.service.ProdutoService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/almo-sys/produtos")
@RestControllerAdvice
public class EstoqueController {
    @Autowired
    public ProdutoService produtoService;

    @PutMapping
    public ResponseEntity<String> naoInformadoUpdate() {

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(
                "Método não permitido. Por favor, informe o índice do produto na URL, como em /almo-sys/produtos/{id}");
    }

    @DeleteMapping
    public ResponseEntity<String> naoInformadoDelete() {

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(
                "Método não permitido. Por favor, informe o índice do produto na URL, como em /almo-sys/produtos/{id}");
    }

    @PostMapping
    public ResponseEntity<String> cadastrarProduto(@Valid @RequestBody Produto produto) {
        produtoService.save(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body("Produto cadastrado com sucesso.");
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> requicaoPOSTErro() {

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body("ERRO: Não é permitido informar o indice. Por favor utilize: /almo-sys/produtos");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarProduto(@PathVariable String id, @RequestBody Produto produto) {
        int idInt;
        try {
            idInt = Integer.parseInt(id);
            if (idInt < 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID inválido.");
            }

        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID deve ser um número inteiro.");
        }
        Produto produtoExistente = produtoService.findById(idInt);
        if (produtoExistente != null) {
            produto.setId(idInt);
            produtoService.save(produto);
            return ResponseEntity.status(HttpStatus.OK).body("Produto atualizado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
    }

    @GetMapping
    public Iterable<Produto> listarProdutos() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> pegarUnicoProduto(@PathVariable String id) {
        int idInt;
        try {
            idInt = Integer.parseInt(id);
            if (idInt < 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID inválido.");
            }

        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID deve ser um número inteiro.");
        }
        Produto produtoExistente = produtoService.findById(idInt);
        if (produtoExistente != null) {
            return ResponseEntity.ok(produtoExistente);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable String id) {
        int idInt;
        try {
            idInt = Integer.parseInt(id);
            if (idInt < 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID inválido.");
            }

        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID deve ser um número inteiro.");
        }
        Produto produtoExistente = produtoService.findById(idInt);
        if (produtoExistente != null) {
            produtoService.deleteById(idInt);
            return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Extrai apenas as mensagens de erro
        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getDefaultMessage()) // Pega a mensagem personalizada
                .findFirst() // Opcional: pega só a primeira mensagem
                .orElse("Erro de validação");

        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleTypeMismatch(HttpMessageNotReadableException ex) {
        // Mensagem de erro para quando o tipo de dado não pode ser convertido
        String errorMessage = "Tipo de dado inválido fornecido na requisição. Verifique os valores enviados.";

        return ResponseEntity.badRequest().body(errorMessage);
    }
}
