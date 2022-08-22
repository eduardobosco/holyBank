package br.com.holy.bank.endereco;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("v1/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<EnderecoResponse> inserir(@RequestBody EnderecoRequest enderecoRequest) {
		Endereco endereco = enderecoRequest.convert(enderecoRepository);
		enderecoRepository.save(endereco);

		final EnderecoResponse response = new EnderecoResponse(endereco);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
