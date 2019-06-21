package br.com.poker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.poker.model.Jogador;
import br.com.poker.model.PontuacaoRodada;
import br.com.poker.model.Rodada;

public interface PontuacaoRepository extends CrudRepository<PontuacaoRodada, Long> {

	PontuacaoRodada findByJogadorAndRodada(Jogador jogador, Rodada rodada);

	List<PontuacaoRodada> findAllByRodada(Rodada rodada);

}
