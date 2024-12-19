package almoxarifado.estoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import almoxarifado.estoque.models.Produto;
import almoxarifado.estoque.service.ProdutoService;

@Controller
@RequestMapping("")
public class WebController {

    @Autowired
    public ProdutoService produtoService;

    @GetMapping
    public String homePage(Model model) {
        List<Produto> produtos = produtoService.findAll();
        model.addAttribute("produto", produtos);
        return "index";
    }

    @GetMapping(path = "/novoProduto")
    public String formularioPOST(Model model) {
        model.addAttribute("produto", new Produto());
        return "formulario";
    }

    @GetMapping(path = "/AlterarProduto/{id}")
    public String formularioPUT(@PathVariable("id") String id, Model model) {
        Integer idNum = Integer.parseInt(id);
        Produto produtoExistente = produtoService.findById(idNum);
        model.addAttribute("produto", produtoExistente);
        return "formulario";
    }

    @GetMapping(path = "/DeletarProduto/{id}")
    public String formularioDELET(@PathVariable("id") String id, Model model) {
        Integer idNum = Integer.parseInt(id);
        Produto produtoExistente = produtoService.findById(idNum);
        model.addAttribute("produto", produtoExistente);
        return "formulario";

    }

    @ExceptionHandler(org.springframework.web.servlet.NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundError() {
        return "formulario";
    }
}
