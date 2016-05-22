package it.polito.tdp.bar.model;

public class Evento implements Comparable<Evento> {

	public enum tipoEvento {
		ARRIVO_GRUPPO_CLIENTI, AL_BAR, USCITA_GRUPPO_CLIENTI
	};

	



	private long time;
	private int numPersone;
	private long durata;
	private float tolleranza;
	private tipoEvento type;
	private int id;
	
	

	
	public Evento(long time, int numPersone, long durata, float tolleranza, tipoEvento type, int id) {
		this.time = time;
		this.numPersone = numPersone;
		this.durata = durata;
		this.tolleranza = tolleranza;
		this.type = type;
		this.id = id;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getNumPersone() {
		return numPersone;
	}

	public void setNumPersone(int numPersone) {
		this.numPersone = numPersone;
	}

	public long getDurata() {
		return durata;
	}

	public void setDurata(long durata) {
		this.durata = durata;
	}

	public float getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(float tolleranza) {
		this.tolleranza = tolleranza;
	}

	public tipoEvento getType() {
		return type;
	}

	public void setType(tipoEvento type) {
		this.type = type;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	@Override
	public String toString() {
		return "Evento [time=" + time + ", numPersone=" + numPersone + ", durata=" + durata + ", tolleranza="
				+ tolleranza + ", type=" + type + ", id=" + id + "]";
	}

		

	@Override
	public int compareTo(Evento o) {
		return Long.compare(this.time, o.time);
	}

}
