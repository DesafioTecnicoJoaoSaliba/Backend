package desafiotecnicojr.desafiotecnico.repositories;

import desafiotecnicojr.desafiotecnico.dtos.produto.input.ProdutoDTO;
import desafiotecnicojr.desafiotecnico.dtos.produto.output.ProdutoOutput;
import desafiotecnicojr.desafiotecnico.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("""
            select new desafiotecnicojr.desafiotecnico.dtos.produto.output.ProdutoOutput(
            produto.id,
            produto.nome,
            produto.descricao,
            produto.valor,
            produto.dthCriacao
            )
            from Produto produto
            where produto.id = :id
            """)
    ProdutoOutput findProdutoDTOById(Long id);

    @Query("""
            select new desafiotecnicojr.desafiotecnico.dtos.produto.output.ProdutoOutput(
                produto.id,
                produto.nome,
                produto.descricao,
                produto.valor,
                produto.dthCriacao
            )
            from Produto produto
            where (:nome is null or produto.nome like %:nome%)
            and (:descricao is null or produto.descricao like %:descricao%)
            """)
    Page<ProdutoOutput> findProdutoDTO(@Param("nome") String nome, @Param("descricao") String descricao, Pageable pageable);

}
