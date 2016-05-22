package it.polito.tdp.bar.model;

public class Tavolo {
	
	
	private int numPosti;
	private boolean occupato;
	private int cliente;
	
	public Tavolo(int numPosti) {
		this.numPosti = numPosti;
		cliente = -1;
		occupato = false;
	}

	public int getNumPosti() {
		return numPosti;
	}

	public void setNumPosti(int numPosti) {
		this.numPosti = numPosti;
	}

	public boolean isOccupato() {
		return occupato;
	}

	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}


	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Tavolo [numPosti=" + numPosti + ", occupato=" + occupato + ", cliente=" + cliente + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
