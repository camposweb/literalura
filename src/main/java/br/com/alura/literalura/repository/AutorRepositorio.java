package br.com.alura.literalura.repository;

import br.com.alura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepositorio  extends JpaRepository<Autor, Long>{

    List<Autor> findByAnoFalecimentoLessThanEqual(Integer anoFalecimento);

}
