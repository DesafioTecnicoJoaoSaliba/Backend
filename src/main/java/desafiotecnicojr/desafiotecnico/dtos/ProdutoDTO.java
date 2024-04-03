package desafiotecnicojr.desafiotecnico.dtos;

import desafiotecnicojr.desafiotecnico.model.Produto;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProdutoDTO{
    private Long id;
    private @NotBlank @NotNull String nome;
    private @NotBlank @NotNull String descricao;
    private @NotNull BigDecimal valor;
    private LocalDateTime dthCriacao;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Long id, String nome, String descricao, BigDecimal valor, LocalDateTime dthCriacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.dthCriacao = dthCriacao;
    }

    public  static ProdutoDTO fromEntity(Produto produto){
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getValor(), produto.getDthCriacao());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDthCriacao() {
        return dthCriacao;
    }

    public void setDthCriacao(LocalDateTime dthCriacao) {
        this.dthCriacao = dthCriacao;
    }
}
