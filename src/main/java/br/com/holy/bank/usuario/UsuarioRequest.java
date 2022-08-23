package br.com.holy.bank.usuario;

import br.com.holy.bank.endereco.EnderecoRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {
	
	private String nome;
	private String cpf;
	private String password;
	private String email;
	private String telefone;

	public Usuario converter(UsuarioRepository usuarioRepository, EnderecoRepository enderecoRepository) {
		return new Usuario(nome, cpf, password, email, telefone);
	}

	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getOne(id);
		usuario.setNome(nome);
		usuario.setCpf(cpf);
		usuario.setPassword(password);
		usuario.setEmail(email);
		usuario.setTelefone(telefone);
		return usuario;
	}
}
