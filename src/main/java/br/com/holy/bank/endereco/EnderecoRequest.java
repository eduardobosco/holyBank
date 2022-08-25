package br.com.holy.bank.endereco;

import br.com.holy.bank.usuario.Usuario;
import br.com.holy.bank.usuario.UsuarioRepository;
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
	private Long usuario_id;
	

	public Endereco convert(EnderecoRepository enderecoRepository,UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getOne(usuario_id);
		return new Endereco(rua, numero, bairro, cidade, estado, pais, usuario);
	}


	public Endereco atualizar(Long id, EnderecoRepository enderecoRepository) {
		Endereco endereco = enderecoRepository.getOne(id);
		endereco.setRua(rua);
		endereco.setNumero(numero);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		endereco.setPais(pais);
		return endereco;
	}
	
	

}
