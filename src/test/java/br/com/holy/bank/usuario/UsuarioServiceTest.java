package br.com.holy.bank.usuario;

import static org.hamcrest.CoreMatchers.any;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UsuarioServiceTest {
	
	private UsuarioService usuarioService;
	
	@Mock
	private UsuarioRepository usuarioRepository;
	
	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);
		usuarioService = new UsuarioService(usuarioRepository);
		
	}

	@Test
	void whenNameIsNullShouldBeThrowException() {
		//given
		Usuario usuario = UsuarioServiceMass.getUsuarioValido();
		//when
		when(usuarioRepository.inserir(any())).thenReturn();
		//then
	}

}
