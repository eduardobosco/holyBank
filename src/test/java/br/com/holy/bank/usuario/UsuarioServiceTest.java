package br.com.holy.bank.usuario;




import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class UsuarioServiceTest {
	
	private UsuarioService usuarioService;
	
	@Mock
	private UsuarioRepository usuarioRepository;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		usuarioService = new UsuarioService(usuarioRepository);
		
	}

	@Test
	void whenNameIsNullShouldBeThrowException() {
		//given
		Usuario usuario = UsuarioServiceMass.getUsuarioValido();
		//when
		when(usuarioService.inserir(any())).thenReturn();
		//then
	}

}
