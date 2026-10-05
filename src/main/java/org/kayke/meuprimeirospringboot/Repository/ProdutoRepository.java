package org.kayke.meuprimeirospringboot.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.kayke.meuprimeirospringboot.Model.Produto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends  JpaRepository<Produto, Long> {
}
