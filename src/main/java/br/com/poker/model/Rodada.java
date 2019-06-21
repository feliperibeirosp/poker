package br.com.poker.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rodada {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private LocalDate data;
	private int quantJogadores;
	private boolean aberta;

	public Rodada() {
		
	}

	public Rodada(long id, LocalDate data, int quantJogadores, boolean aberta) {
		super();
		this.id = id;
		this.data = data;
		this.quantJogadores = quantJogadores;
		this.aberta = aberta;
	}

	public Rodada(LocalDate now, boolean b) {
		this.data = now;
		this.aberta = b;
	}
	
	public void adicionaJogador() {
		quantJogadores++;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getQuantJogadores() {
		return quantJogadores;
	}

	public void setQuantJogadores(int quantJogadores) {
		this.quantJogadores = quantJogadores;
	}

	public boolean isAberta() {
		return aberta;
	}

	public void setAberta(boolean aberta) {
		this.aberta = aberta;
	}

}
