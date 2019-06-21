package br.com.poker.model;

public class Ranking {

	private long id;
	private int posicao;
	private Jogador jogador;
	private double pontos;
	private Rodada rodada;

	public Ranking(long id, int posicao, Jogador jogador, double pontos, Rodada rodada) {
		super();
		this.id = id;
		this.posicao = posicao;
		this.jogador = jogador;
		this.pontos = pontos;
		this.rodada = rodada;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public double getPontos() {
		return pontos;
	}

	public void setPontos(double pontos) {
		this.pontos = pontos;
	}

	public Rodada getRodada() {
		return rodada;
	}

	public void setRodada(Rodada rodada) {
		this.rodada = rodada;
	}

}
