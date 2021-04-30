package br.com.zupacademy.caio.casadocodigo.repository;

import br.com.zupacademy.caio.casadocodigo.domain.Estado;
import br.com.zupacademy.caio.casadocodigo.domain.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Optional<Estado> findByIdAndPais(Long id, Pais pais);
    List<Estado> findAllByPais(Pais pais);
}
