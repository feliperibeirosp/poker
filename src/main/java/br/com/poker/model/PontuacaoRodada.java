package br.com.poker.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={
	   @UniqueConstraint(columnNames = {"rodada_id", "jogador_id"})
	}) 
public class PontuacaoRodada {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rodada_id", nullable = false)
	private Rodada rodada;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "jogador_id", nullable = false)
	private Jogador jogador;
	
	private Double valorInicial;
	private Double valorFinal;
	private Double pontos;
	private Double saldo;
	
	public PontuacaoRodada() {
		
	}
	
	public PontuacaoRodada(Rodada rodada, Jogador jogador, Double valorInicial, Double valorFinal,
			Double pontos) {
		super();
		this.rodada = rodada;
		this.jogador = jogador;
		this.valorInicial = valorInicial;
		this.valorFinal = valorFinal;
		this.pontos = pontos;
	}
	public PontuacaoRodada(Rodada rodada, Jogador jogador, Double valor) {
		super();
		this.rodada = rodada;
		this.jogador = jogador;
		this.valorInicial = valor;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Rodada getRodada() {
		return rodada;
	}
	public void setRodada(Rodada rodada) {
		this.rodada = rodada;
	}
	public Jogador getJogador() {
		return jogador;
	}
	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	public Double getValorInicial() {
		return valorInicial;
	}
	public void setValorInicial(Double valorInicial) {
		this.valorInicial = valorInicial;
	}
	public Double getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}
	public Double getPontos() {
		return pontos;
	}
	public void setPontos(Double pontos) {
		this.pontos = pontos;
	}

	public void addValor(Double valor) {
		this.valorInicial+=valor;
		
	}

	public void calcularPontos() {
		this.pontos = Math.random() * 10;
		
	}

	public void setSaldo() {
		this.saldo = valorFinal - valorInicial; 
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
}
