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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping
    public ResponseEntity<ProdutoOutput> createProduct(@RequestBody @Valid ProdutoDTO produtoDTO) {
        ProdutoOutput produtoOutput = this.produtoService.createProduct(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoOutput);
    }

    @Operation(summary = "Retorna um produto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto retornado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProduct(@PathVariable Long id) {
        ProdutoDTO produtoDTO = this.produtoService.getProduct(id);
        return ResponseEntity.ok().body(produtoDTO);
    }

    @Operation(summary = "Retorna todos os produtos ou filtra por nome e descrição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de produtos ou produtos filtrados"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping()
    public ResponseEntity<Page<ProdutoOutput>> findProdutoDTO(@ParameterObject Pageable pageable, @RequestParam(required = false) String nome, @RequestParam(required = false) String descricao) {
        Page<ProdutoOutput> produtos = this.produtoService.findProdutoDTO(pageable, nome, descricao);
        return ResponseEntity.ok().body(produtos);
    }

    @Operation(summary = "Exclui um produto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Produto excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        this.produtoService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
