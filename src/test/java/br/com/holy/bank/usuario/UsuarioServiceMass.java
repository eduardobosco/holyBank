package br.com.holy.bank.usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.holy.bank.endereco.Endereco;

public class UsuarioServiceMass {
	
	public static Usuario getUsuarioValido() {
		
		List<Endereco> endereco = new ArrayList<>();
		
		endereco.add(Endereco.builder()
		.id(new UUID(0, 0))
		.rua("rua")
		.numero(10)
		.bairro("bairro")
		.cidade("cidade")
		.estado("estado")
		.pais("pais")
		.build());
		
		return Usuario.builder()
				.id(new UUID(0, 0))
				.nome("nome")
				.cpf("cpf")
				.email("email")
				.telefone("telefone")
				.criadoEm(LocalDateTime.now())
				.endereco(endereco).build();
	}

}
