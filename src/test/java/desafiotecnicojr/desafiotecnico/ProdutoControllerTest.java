package desafiotecnicojr.desafiotecnico;

import desafiotecnicojr.desafiotecnico.controller.ProdutoController;
import desafiotecnicojr.desafiotecnico.dtos.produto.input.ProdutoDTO;
import desafiotecnicojr.desafiotecnico.dtos.produto.output.ProdutoOutput;
import desafiotecnicojr.desafiotecnico.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoControllerTest {

    @Mock
    private ProdutoService produtoService;

    @InjectMocks
    private ProdutoController produtoController;

    @Test
    void createProduct() {
        ProdutoDTO produtoDTO = new ProdutoDTO(1L, "Produto Teste", "Descrição do Produto Teste", BigDecimal.TEN);
        ProdutoOutput produtoOutput = new ProdutoOutput(1L, "Produto Teste", "Descrição do Produto Teste", BigDecimal.TEN, LocalDateTime.now());
        when(produtoService.createProduct(produtoDTO)).thenReturn(produtoOutput);

        ProdutoDTO responseEntity = produtoController.createProduct(produtoDTO);

        assertEquals(produtoDTO, responseEntity);
    }

    @Test
    void getProduct() {
        Long productId = 1L;
        ProdutoDTO produtoDTO = new ProdutoDTO(1L, "Produto Teste", "Descrição do Produto Teste", BigDecimal.TEN);
        ProdutoOutput produtoOutput = new ProdutoOutput(1L, "Produto Teste", "Descrição do Produto Teste", BigDecimal.TEN, LocalDateTime.now());
        when(produtoService.createProduct(produtoDTO)).thenReturn(produtoOutput);

        ProdutoDTO responseEntity = produtoController.getProduct(productId);

        assertEquals(produtoDTO, responseEntity);
    }

    @Test
    void findProdutoDTO() {
        Pageable pageable = Pageable.unpaged();
        ProdutoOutput produtoDTO = new ProdutoOutput(1L, "Produto Teste", "Descrição do Produto Teste", BigDecimal.TEN,LocalDateTime.now());
        Page<ProdutoOutput> produtoPage = new PageImpl<>(Collections.singletonList(produtoDTO));
        when(produtoService.findProdutoDTO(pageable, null, null)).thenReturn(produtoPage);

        Page<ProdutoOutput> responseEntity =  produtoController.findProdutoDTO(pageable, null, null);

        assertEquals(produtoPage, responseEntity);
    }

    @Test
    void deleteProduct() {
        Long productId = 1L;

        produtoController.deleteProduct(productId);

        verify(produtoService, times(1)).deleteProduct(productId);
    }
}
