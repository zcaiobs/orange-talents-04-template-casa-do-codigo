package br.com.zupacademy.caio.casadocodigo;

import br.com.zupacademy.caio.casadocodigo.repository.AutorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CasaDoCodigoApplicationTests {

	@Autowired
	AutorRepository autorRepository;

	@Test
	void existsAutorByEmailTest() {
		Assertions.assertThat(autorRepository.existsAutorByEmail("java@email.com")).isTrue();
	}

}
