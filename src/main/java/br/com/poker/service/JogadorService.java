package br.com.poker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.poker.model.Jogador;
import br.com.poker.repositories.JogadorRepository;

@Service
public class JogadorService {

	@Autowired
	private JogadorRepository jogadorRepo;

	public Jogador adicionaJogador(String nome) {

		Jogador jogador = new Jogador(nome);
		
		jogadorRepo.save(jogador);

		return jogador;

	}
	
	public List<Jogador> jogadores(){
		
		return (List<Jogador>) jogadorRepo.findAll();
	}
}
