package br.com.holy.bank.usuario;

import br.com.holy.bank.endereco.Endereco;
import br.com.holy.bank.endereco.EnderecoResponse;
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
public class UsuarioResponse {
	
	private String nome;
	private String cpf;
	private String password;
	private String email;
	private String telefone;
	private EnderecoResponse idEndereco;
		
	public UsuarioResponse(Usuario usuario) {
		super();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.password = usuario.getPassword();
		this.email = usuario.getEmail();
		this.telefone = usuario.getTelefone();
		this.idEndereco = new EnderecoResponse(usuario.getEndereco());	
	}
}
