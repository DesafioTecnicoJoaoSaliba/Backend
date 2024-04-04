package desafiotecnicojr.desafiotecnico.dtos.produto.output;

import desafiotecnicojr.desafiotecnico.dtos.produto.input.ProdutoDTO;
import desafiotecnicojr.desafiotecnico.entity.Produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoOutput extends ProdutoDTO {
    private LocalDateTime dthCriacao;

    public ProdutoOutput(LocalDateTime dthCriacao) {
        this.dthCriacao = dthCriacao;
    }

    public ProdutoOutput(Long id, String nome, String descricao, BigDecimal valor, LocalDateTime dthCriacao) {
        super(id, nome, descricao, valor);
        this.dthCriacao = dthCriacao;
    }

    public  static ProdutoOutput fromEntity(Produto produto){
        return new ProdutoOutput(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getValor(), produto.getDthCriacao());

    }

    public LocalDateTime getDthCriacao() {
        return dthCriacao;
    }

    public void setDthCriacao(LocalDateTime dthCriacao) {
        this.dthCriacao = dthCriacao;
    }
}
