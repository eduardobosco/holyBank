package br.com.holy.bank.usuario;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.holy.bank.endereco.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cpf;
	private String password;
	private String email;
	private String telefone;
	
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDateTime criadoEm = LocalDateTime.now();
	
	@ManyToOne
	private Endereco endereco;

	public Usuario(String nome, String cpf, String password, String email, String telefone, Endereco endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.password = password;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}
}
