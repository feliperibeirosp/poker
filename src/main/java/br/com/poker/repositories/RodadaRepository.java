package br.com.poker.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.poker.model.Rodada;

public interface RodadaRepository extends CrudRepository<Rodada, Long> {

	Rodada findByAberta(boolean aberta);
}
