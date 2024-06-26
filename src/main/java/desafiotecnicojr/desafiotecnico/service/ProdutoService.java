package desafiotecnicojr.desafiotecnico.service;

import desafiotecnicojr.desafiotecnico.dtos.produto.input.ProdutoDTO;
import desafiotecnicojr.desafiotecnico.dtos.produto.output.ProdutoOutput;
import desafiotecnicojr.desafiotecnico.entity.Produto;
import desafiotecnicojr.desafiotecnico.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public ProdutoOutput createProduct(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());

        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setValor(produtoDTO.getValor());
        produto.setDthCriacao(LocalDateTime.now());
        produto = this.produtoRepository.save(produto);

        return ProdutoOutput.fromEntity(produto);
    }


    public ProdutoDTO getProduct(Long id) {
        return produtoRepository.findProdutoDTOById(id);
    }

    public Page<ProdutoOutput> findProdutoDTO(Pageable pageable, String nome, String descricao) {
        return produtoRepository.findProdutoDTO(nome, descricao, pageable);
    }

    public void deleteProduct(Long id) {
        produtoRepository.deleteById(id);
    }
}
