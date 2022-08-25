package br.com.holy.bank.endereco;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	
	@NotBlank
	@Size(max = 64)
	private String rua;
	
	@NotNull
	private Integer numero;
	
	@NotBlank
	@Size(max = 64)
	private String bairro;
	
	@NotBlank
	@Size(max = 64)
	private String cidade;
	
	@NotBlank
	@Size(max = 64)
	private String estado;
	
	@NotBlank
	@Size(max = 64)
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
