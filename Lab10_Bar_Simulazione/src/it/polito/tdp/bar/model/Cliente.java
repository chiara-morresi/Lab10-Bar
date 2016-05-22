package it.polito.tdp.bar.model;

public class Cliente {
	
	public enum statoCliente { SODDISFATTO, INSODDISFATTO }
	
	private int id;
	private statoCliente stato;
	
	//aggiungere booleano per tenere traccia del balcone
	
	public Cliente(int id, statoCliente stato) {
		this.id = id;
		this.stato = stato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public statoCliente getStato() {
		return stato;
	}

	public void setStato(statoCliente stato) {
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", stato=" + stato + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	

}
