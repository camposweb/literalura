package br.com.alura.literalura.repository;

import br.com.alura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepositorio  extends JpaRepository<Autor, Long>{

    @Query("SELECT a FROM Autor a WHERE :ano <= a.anoFalecimento")
    List<Autor> findByAnoFalecimentoLessThanEqual(Integer ano);

    List<Autor> findByNomeContainingIgnoreCase(String nome);
}
