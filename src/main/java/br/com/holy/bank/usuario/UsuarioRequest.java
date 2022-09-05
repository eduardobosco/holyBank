package br.com.holy.bank.usuario;

import java.security.NoSuchAlgorithmException;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.com.holy.bank.compartilhado.CpfOuCnpj;
import br.com.holy.bank.compartilhado.UniqueValue;
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
	
	@NotBlank
	@Length(min = 5)
	private String nome;
	
	@NotBlank	
	@CpfOuCnpj
	@UniqueValue(domainClass = Usuario.class, fieldName = "documento")
	private String documento;
	
	@NotBlank
	private String password;
	
	@NotBlank
	@Email
	@UniqueValue(domainClass=Usuario.class, fieldName="email", message="Esta email ja esta cadastrado")
	private String email;
	
	@NotBlank @Size(max = 15)
	private String telefone;

	public Usuario converter(UsuarioRepository usuarioRepository, EnderecoRepository enderecoRepository) throws NoSuchAlgorithmException {
		return new Usuario(nome, documento, ConverterSenha.converterSenha(password), email, telefone);
	}

	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) throws NoSuchAlgorithmException {
		Usuario usuario = usuarioRepository.getOne(id);
		usuario.setNome(nome);
		usuario.setDocumento(documento);
		usuario.setPassword(ConverterSenha.converterSenha(password));
		usuario.setEmail(email);
		usuario.setTelefone(telefone);
		return usuario;
	}

	public Usuario atualizarCamposIndividuais(Long id, UsuarioRepository usuarioRepository) throws NoSuchAlgorithmException {
		Usuario usuario = usuarioRepository.getOne(id);
		if(nome != null)usuario.setNome(nome);
		if(documento != null)usuario.setDocumento(documento);
		if(password != null)usuario.setPassword(ConverterSenha.converterSenha(password));
		if(email != null)usuario.setEmail(email);
		if(telefone != null)usuario.setTelefone(telefone);
		return usuario;
	}
}
