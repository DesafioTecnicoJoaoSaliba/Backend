package desafiotecnicojr.desafiotecnico.controller;

import desafiotecnicojr.desafiotecnico.dtos.produto.input.ProdutoDTO;
import desafiotecnicojr.desafiotecnico.dtos.produto.output.ProdutoOutput;
import desafiotecnicojr.desafiotecnico.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
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

    @Operation(summary = "Cria um novo produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping
    public ProdutoOutput createProduct(@RequestBody @Valid ProdutoDTO produtoDTO) {
        return this.produtoService.createProduct(produtoDTO);
    }

    @Operation(summary = "Retorna um produto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto retornado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @GetMapping("{id}")
    public ProdutoDTO getProduct(@PathVariable Long id) {
        return this.produtoService.getProduct(id);
    }

    @Operation(summary = "Retorna todos os produtos ou filtra por nome e/ou descrição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de produtos ou produtos filtrados"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping()
    public Page<ProdutoOutput> findProdutoDTO(@ParameterObject Pageable pageable, @RequestParam(required = false) String nome, @RequestParam(required = false) String descricao) {
        return this.produtoService.findProdutoDTO(pageable, nome, descricao);
    }

    @Operation(summary = "Exclui um produto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Produto excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.produtoService.deleteProduct(id);
    }
}
