package br.com.holy.bank.usuario;

import br.com.holy.bank.endereco.Endereco;
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
	private Long idEndereco;
	

	public Usuario converter(UsuarioRepository usuarioRepository, EnderecoRepository enderecoRepository) {
		Endereco endereco = enderecoRepository.getOne(idEndereco);
		return new Usuario(nome, cpf, password, email, telefone, endereco);

	}
	
	
	
	
	

}
