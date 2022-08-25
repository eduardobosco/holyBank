package br.com.holy.bank.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
public class UsuarioDetalhadoResponse {
	
	private String nome;
	private String documento;
	private String password;
	private String email;
	private String telefone;
	private List<EnderecoResponse> enderecos;

		
	public UsuarioDetalhadoResponse(Usuario usuario) {
		super();
		this.nome = usuario.getNome();
		this.documento = usuario.getDocumento();
		this.password = usuario.getPassword();
		this.email = usuario.getEmail();
		this.telefone = usuario.getTelefone();
		this.enderecos = new ArrayList<>();
		this.enderecos.addAll(usuario.getEndereco().stream().map(EnderecoResponse::new).collect(Collectors.toList()));
	}
}
