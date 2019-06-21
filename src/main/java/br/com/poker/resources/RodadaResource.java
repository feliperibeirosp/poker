package br.com.poker.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.poker.model.PontuacaoRodada;
import br.com.poker.model.Rodada;
import br.com.poker.service.RodadaService;

@RestController
public class RodadaResource {
	
	@Autowired
	private RodadaService rodadaService;
	
	@RequestMapping(value = "/iniciaRodada", method = RequestMethod.GET)
    public ResponseEntity<?> iniciaRodada() {
 
		Rodada rodada = rodadaService.rodadaAberta();
 
        if (rodada != null) {
            return new ResponseEntity(" Já existe uma rodada aberta! ",
                    HttpStatus.NOT_FOUND);
        }
 
        rodada = rodadaService.abrirRodada();
        return new ResponseEntity<Rodada>(rodada, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/fecharRodada", method = RequestMethod.GET)
    public ResponseEntity<?> fecharRodada() {
 
		Rodada rodada = rodadaService.rodadaAberta();
 
        if (rodada == null) {
            return new ResponseEntity(" Não existe nenhuma rodada aberta! ",
                    HttpStatus.NOT_FOUND);
        }
 
        rodada = rodadaService.fecharRodada();
        return new ResponseEntity<Rodada>(rodada, HttpStatus.OK);
    }
		
	@RequestMapping(value = "/adicionaJogadorRodada", method = RequestMethod.GET)
    public ResponseEntity<?> adicionaJogadorRodada(@RequestParam("id") Long id, @RequestParam("valor") Double valor) {
 
		Rodada rodada = rodadaService.rodadaAberta();
 
        if (rodada == null) {
            return new ResponseEntity(" Não existe nenhuma rodada aberta! ",
                    HttpStatus.NOT_FOUND);
        }
 
        rodada = rodadaService.adicionaJogadorRodada(rodada, id, valor);
        return new ResponseEntity<Rodada>(rodada, HttpStatus.OK);
    }

	@RequestMapping(value = "/rebuy", method = RequestMethod.GET)
    public ResponseEntity<?> rebuy(@RequestParam("id") Long id, @RequestParam("valor") Double valor) {
 
		Rodada rodada = rodadaService.rodadaAberta();
 
        if (rodada == null) {
            return new ResponseEntity(" Não existe nenhuma rodada aberta! ",
                    HttpStatus.NOT_FOUND);
        }
 
        PontuacaoRodada pontuacao = rodadaService.rebuy(rodada, id, valor);
        return new ResponseEntity<PontuacaoRodada>(pontuacao, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/saidaJogador", method = RequestMethod.GET)
    public ResponseEntity<?> saidaJogador(@RequestParam("id") Long id, @RequestParam("valor") Double valor) {
 
		Rodada rodada = rodadaService.rodadaAberta();
 
        if (rodada == null) {
            return new ResponseEntity(" Não existe nenhuma rodada aberta! ",
                    HttpStatus.NOT_FOUND);
        }
 
        PontuacaoRodada pontuacao = rodadaService.saidaJogador(rodada, id, valor);
        return new ResponseEntity<PontuacaoRodada>(pontuacao, HttpStatus.OK);
    }
}
