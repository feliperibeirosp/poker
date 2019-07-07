package br.com.poker.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.poker.model.Jogador;
import br.com.poker.model.PontuacaoRodada;
import br.com.poker.model.Rodada;
import br.com.poker.repositories.JogadorRepository;
import br.com.poker.repositories.PontuacaoRepository;
import br.com.poker.repositories.RodadaRepository;

@Service
public class RodadaService {

	@Autowired
	private RodadaRepository rodadaRepo;

	@Autowired
	private JogadorRepository jogadorRepo;

	@Autowired
	private PontuacaoRepository pontuacaoRepo;

	public Rodada rodadaAberta() {
		return rodadaRepo.findByAberta(true);
	}

	public Rodada abrirRodada() {
		Rodada rodada = new Rodada(LocalDate.now(), true);

		rodadaRepo.save(rodada);

		return rodada;

	}

	public Rodada fecharRodada() {
		Rodada rodadaAberta = this.rodadaAberta();
		rodadaAberta.setAberta(false);
		rodadaRepo.save(rodadaAberta);
		fecharPontuacao(rodadaAberta);
		return rodadaAberta;
	}

	private void fecharPontuacao(Rodada rodada) {

		List<PontuacaoRodada> lista = pontuacaoRepo.findAllByRodada(rodada);

		Map<Long, Integer> mapaPosicao = getMapaPosicao(lista);

		for (PontuacaoRodada pontuacaoRodada : lista) {

			Double pontuacao = calcularPontuacao(rodada, pontuacaoRodada, mapaPosicao.get(pontuacaoRodada.getJogador().getId()));

			pontuacaoRodada.setPontos(pontuacao);
			Jogador jogador = pontuacaoRodada.getJogador();
			jogador.addPontos(pontuacao);
			jogadorRepo.save(jogador);
		}

		pontuacaoRepo.saveAll(lista);
	}

	private Map<Long, Integer> getMapaPosicao(List<PontuacaoRodada> lista) {

		Map<Long, Integer> mapa = new HashMap<>();

		for (PontuacaoRodada pontuacao : lista) {

			int posicao = 1;
			Double saldo = pontuacao.getSaldo();
			for (PontuacaoRodada pontuacao2 : lista) {
				
				Double saldo2 = pontuacao2.getSaldo();
				if(saldo < saldo2)
					posicao++;
				
			}
			mapa.put(pontuacao.getJogador().getId(), Integer.valueOf(posicao));

		}
		return mapa;
	}

	private Double calcularPontuacao(Rodada rodada, PontuacaoRodada pontuacaoRodada, int posicao) {

		int quantidadeJogadores = rodada.getQuantJogadores();

		return ((quantidadeJogadores * 2) - posicao) + (pontuacaoRodada.getSaldo()/4);
	}

	public Rodada adicionaJogadorRodada(Rodada rodada, Long id, Double valor) {

		Optional<Jogador> jogador = jogadorRepo.findById(id);

		PontuacaoRodada pontuacao = new PontuacaoRodada(rodada, jogador.get(), valor);

		rodada.adicionaJogador();

		pontuacaoRepo.save(pontuacao);
		rodadaRepo.save(rodada);

		return rodada;
	}

	public PontuacaoRodada rebuy(Rodada rodada, Long id, Double valor) {

		Optional<Jogador> jogador = jogadorRepo.findById(id);

		PontuacaoRodada pontuacao = pontuacaoRepo.findByJogadorAndRodada(jogador.get(), rodada);

		pontuacao.addValor(valor);

		pontuacaoRepo.save(pontuacao);

		return pontuacao;
	}

	public PontuacaoRodada saidaJogador(Rodada rodada, Long id, Double valor) {

		Optional<Jogador> jogador = jogadorRepo.findById(id);

		PontuacaoRodada pontuacao = pontuacaoRepo.findByJogadorAndRodada(jogador.get(), rodada);

		pontuacao.setValorFinal(valor);
		pontuacao.setSaldo();

		pontuacaoRepo.save(pontuacao);

		return pontuacao;
	}

}
