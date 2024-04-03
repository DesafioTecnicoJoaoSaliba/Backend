package desafiotecnicojr.desafiotecnico.controller;

import desafiotecnicojr.desafiotecnico.dtos.ProdutoDTO;
import desafiotecnicojr.desafiotecnico.service.ProdutoService;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {


    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    private ProdutoDTO createProduct(@RequestBody @Valid ProdutoDTO produtoDTO) {
        return this.produtoService.createProduct(produtoDTO);
    }

    @GetMapping("{id}")
    private ProdutoDTO getProduct(@PathVariable Long id) {
        return this.produtoService.getProduct(id);
    }

    @GetMapping()
    private Page<ProdutoDTO> findProdutoDTO(@ParameterObject Pageable pageable, @RequestParam(required = false) String nome, @RequestParam(required = false)  String descricao) {
        return this.produtoService.findProdutoDTO(pageable, nome, descricao);
    }

    @DeleteMapping("{id}")
    private void deleteProduct(@PathVariable Long id) {
         this.produtoService.deleteProduct(id);
    }

}
