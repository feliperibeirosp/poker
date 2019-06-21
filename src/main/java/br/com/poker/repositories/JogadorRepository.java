package br.com.poker.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.poker.model.Jogador;

public interface JogadorRepository extends CrudRepository<Jogador, Long> {

}
