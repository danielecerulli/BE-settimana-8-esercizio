package it.dipendenti.pojo;

import java.util.Objects;

public class Dipendente {
	
	private int matricola;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	
	public int getMatricola() {
		return matricola;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	@Override
	public int hashCode() {
		return Objects.hash(matricola);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dipendente other = (Dipendente) obj;
		return matricola == other.matricola;
	}
	
	
}
