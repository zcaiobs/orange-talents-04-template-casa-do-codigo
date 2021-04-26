package br.com.zupacademy.caio.casadocodigo;

import br.com.zupacademy.caio.casadocodigo.domain.Categoria;
import br.com.zupacademy.caio.casadocodigo.repository.AutorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
class CasaDoCodigoApplicationTests {

	@Autowired
	EntityManager em;

	@Test
	@DisplayName("Deve retornar uma lista de categorias")
	void existsCategoriaByNomeTest() {
		String value = "Java";
		String field = "nome";
		List<?> result = em.createQuery("select c from Categoria c where "+ field +" = :value", Categoria.class)
				.setParameter("value", value)
				.getResultList();
		Assertions.assertThat(result.size()).isLessThan(1);
	}
}
