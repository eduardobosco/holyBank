package br.com.holy.bank.endereco;

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
public class UsuarioDto {
	
	private String nome;
	private String cpf;
	private String password;
	private String email;
	private String telefone;

}
