package br.com.poker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.poker.model.Jogador;
import br.com.poker.service.JogadorService;

@RestController
public class JogadorResource {

	@Autowired
	private JogadorService jogadorService;
	
	@RequestMapping(value = "/jogadores", method = RequestMethod.GET)
	public ResponseEntity<List<Jogador>> listar() {

		List<Jogador> jogadores = jogadorService.jogadores();

		return new ResponseEntity<List<Jogador>>(jogadores, HttpStatus.OK);
	}

	@RequestMapping(value = "/adicionaJogador", method = RequestMethod.GET)
	public ResponseEntity<Jogador> adicionaJogador(@RequestParam("nome") String nome) {

		Jogador jogador = jogadorService.adicionaJogador(nome);

		return new ResponseEntity<Jogador>(jogador, HttpStatus.OK);
	}
}
