package it.polito.tdp.bar.model;

import java.util.Random;

public class Statistiche {

	private Core simulatore = new Core();

	private final static int MAX = 2000;

	private static int numClienti = 0;

	public int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public void generaRandom() {

		long time = 0;
		numClienti = 0;

		for (int i = 1; i <= MAX; i++) {

			int numPersone = this.randInt(1, 10);
			long durata = this.randInt(60, 120);
			float tolleranza = (float) this.randInt(0, 9) / 10;

			Cliente c = new Cliente(i, Cliente.statoCliente.SODDISFATTO);
			simulatore.aggiungiCliente(c);
			Evento e = new Evento(time, numPersone, durata, tolleranza, Evento.tipoEvento.ARRIVO_GRUPPO_CLIENTI, i);
			simulatore.aggiungiEvento(e);

			time += this.randInt(1, 10);
			numClienti += numPersone;

		}
	}

	public int[] getStatistiche() {
		int[] array = new int[3];
		array[0] = numClienti;

		simulatore.simula();

		array[1] = Core.getNumClientiSoddisfatti();
		array[2] = Core.getNumClientiInsoddisfatti();

		return array;
	}

	public Core getSimulatore() {
		return simulatore;
	}

	public static int getNumClienti() {
		return numClienti;
	}

}
