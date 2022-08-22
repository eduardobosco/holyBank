package br.com.holy.bank.endereco;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class EnderecoResponse {
	
	private String rua;
	private Integer numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	
	
	public EnderecoResponse(Endereco endereco) {
		super();
		this.rua = endereco.getRua();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.pais = endereco.getPais();
	}
	
	

}
