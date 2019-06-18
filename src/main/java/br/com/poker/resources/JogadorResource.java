package br.com.poker.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.poker.model.Jogador;

@RestController
public class JogadorResource {

	 
	  public JogadorResource() {

	  }
	 
	  @RequestMapping(value = "/jogadores", method = RequestMethod.GET)
	  public ResponseEntity<List<Jogador>> listar() {
		  
		  Jogador felipe = new Jogador(10, "Felipe");
		  
		  List<Jogador> jogadores = new ArrayList<Jogador>();
		  jogadores.add(felipe);
		  
	    return new ResponseEntity<List<Jogador>>(jogadores, HttpStatus.OK);
	  }
}
