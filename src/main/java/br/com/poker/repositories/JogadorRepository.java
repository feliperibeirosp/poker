package br.com.poker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.poker.model.Jogador;

public interface JogadorRepository extends CrudRepository<Jogador, Long> {

	List<Jogador> findAllByOrderByPontosDesc();

}
