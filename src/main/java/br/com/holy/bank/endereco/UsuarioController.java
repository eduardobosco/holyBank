package br.com.holy.bank.endereco;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.holy.bank.usuario.Usuario;
import br.com.holy.bank.usuario.UsuarioService;

@Controller
@RequestMapping("v1/usuario")
public class UsuarioController {
	
	private UsuarioService usuarioService;
	
	@GetMapping
	@ResponseBody
	public List<Usuario> listar (){
		return usuarioService.listar();
	}
	
	@PostMapping
	@Transactional
	public void inserir (@RequestBody Usuario usuario){
		usuarioService.inserir(usuario);
	}
	

}
