package br.com.zupacademy.caio.casadocodigo.repository;

import br.com.zupacademy.caio.casadocodigo.domain.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Long> {
    Pais findByNome(String nome);
}
