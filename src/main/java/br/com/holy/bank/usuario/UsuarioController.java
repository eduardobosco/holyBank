package br.com.holy.bank.usuario;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.holy.bank.endereco.EnderecoRepository;

@Controller
@RequestMapping("v1/usuario")
public class UsuarioController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	@ResponseBody
	public List<Usuario> listar (){
		return usuarioRepository.findAll();
	}
	
	@PostMapping
	@Transactional
	public void inserir (@RequestBody UsuarioRequest usuarioRequest){
		Usuario usuario = usuarioRequest.converter(usuarioRepository, enderecoRepository);
		usuarioRepository.save(usuario);
	}
	

}
