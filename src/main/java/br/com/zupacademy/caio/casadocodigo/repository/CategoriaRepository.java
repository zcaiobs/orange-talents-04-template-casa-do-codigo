package br.com.zupacademy.caio.casadocodigo.repository;

import br.com.zupacademy.caio.casadocodigo.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
