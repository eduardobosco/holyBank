package br.com.holy.bank.usuario;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<UsuarioResponse> inserir (@RequestBody UsuarioRequest usuarioRequest){
		Usuario usuario = usuarioRequest.converter(usuarioRepository, enderecoRepository);
		usuarioRepository.save(usuario);
		
		final UsuarioResponse response = new UsuarioResponse(usuario);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioResponse> atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioRequest usuarioRequest ){
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if(optional.isPresent()) {
			Usuario usuario = usuarioRequest.atualizar(id, usuarioRepository);
		
		return ResponseEntity.ok(new UsuarioResponse(usuario));
		}
		return ResponseEntity.notFound().build(); 
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if(optional.isPresent()) {
			usuarioRepository.deleteById(id);
		return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build(); 
	}
	
	

}
