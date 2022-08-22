package br.com.holy.bank.endereco;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class EnderecoRequest {
	
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	

	public Endereco convert(EnderecoRepository enderecoRepository) {
		return new Endereco(rua, numero, bairro, cidade, estado, pais);
	}
	
	

}
