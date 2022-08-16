package br.com.holy.bank.usuario;

import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		usuarioRepository=this.usuarioRepository;
	}
	
	

}
