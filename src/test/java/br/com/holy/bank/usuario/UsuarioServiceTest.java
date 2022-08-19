package br.com.holy.bank.usuario;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UsuarioServiceTest {

	private UsuarioService usuarioService;

	@Mock
	private UsuarioRepository usuarioRepository;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		usuarioService = new UsuarioService(usuarioRepository);

	}

	@Test
	public void whenNameIsNullShouldBeThrowException() {
		// given
		Usuario usuario = UsuarioServiceMass.getUsuarioValido();
		// when
		when(usuarioRepository.save(any())).thenReturn(usuario);
		//then
		usuarioService.inserir(usuario);
		assertEquals("nome", usuario.getNome());

	}

}
