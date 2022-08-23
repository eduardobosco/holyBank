package br.com.holy.bank.usuario;

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

		
	public UsuarioResponse(Usuario usuario) {
		super();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.password = usuario.getPassword();
		this.email = usuario.getEmail();
		this.telefone = usuario.getTelefone();	
	}
}
