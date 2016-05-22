package it.polito.tdp.bar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Core {

	private Queue<Evento> listaEventi;
	private Map<Integer, Cliente> clienti;
	private List<Tavolo> tavoli;

	private static int numClientiSoddisfatti;

	private static int numClientiInsoddisfatti;

	public Core() {

		listaEventi = new PriorityQueue<Evento>();
		clienti = new HashMap<Integer, Cliente>();
		tavoli = new ArrayList<Tavolo>();

		numClientiSoddisfatti = 0;
		numClientiInsoddisfatti = 0;

		Tavolo t11 = new Tavolo(4);
		tavoli.add(t11);
		Tavolo t12 = new Tavolo(4);
		tavoli.add(t12);
		Tavolo t13 = new Tavolo(4);
		tavoli.add(t13);
		Tavolo t14 = new Tavolo(4);
		tavoli.add(t14);
		Tavolo t15 = new Tavolo(4);
		tavoli.add(t15);

		Tavolo t7 = new Tavolo(6);
		tavoli.add(t7);
		Tavolo t8 = new Tavolo(6);
		tavoli.add(t8);
		Tavolo t9 = new Tavolo(6);
		tavoli.add(t9);
		Tavolo t10 = new Tavolo(6);
		tavoli.add(t10);

		Tavolo t3 = new Tavolo(8);
		tavoli.add(t3);
		Tavolo t4 = new Tavolo(8);
		tavoli.add(t4);
		Tavolo t5 = new Tavolo(8);
		tavoli.add(t5);
		Tavolo t6 = new Tavolo(8);
		tavoli.add(t6);

		Tavolo t1 = new Tavolo(10);
		tavoli.add(t1);
		Tavolo t2 = new Tavolo(10);
		tavoli.add(t2);

	}

	public void aggiungiEvento(Evento e) {
		listaEventi.add(e);
	}

	public void aggiungiCliente(Cliente c) {
		clienti.put(c.getId(), c);
	}

	public void passo() {
		Evento e = listaEventi.remove();

		// nuovo cliente
		Cliente c = clienti.get(e.getId());

		int numClienti = e.getNumPersone();
		boolean seduto = false;

		switch (e.getType()) {

		case ARRIVO_GRUPPO_CLIENTI:

			for (Tavolo t : tavoli) {
				if (!t.isOccupato()) {
					int numPosti = t.getNumPosti();
					if (numPosti >= numClienti) {

						// se clienti occupano almeno 50% posti tavolo
						if (numClienti >= numPosti / 2) {

							// tavolo occupato e cliente soddisfatto
							t.setOccupato(true);
							t.setCliente(e.getId());
							seduto = true;

							numClientiSoddisfatti += numClienti;

							// passa stato uscita a tempo entrata+durata
							this.aggiungiEvento(new Evento(e.getTime() + e.getDurata(), numClienti, e.getDurata(),
									e.getTolleranza(), Evento.tipoEvento.USCITA_GRUPPO_CLIENTI, e.getId()));

							break;
						}

						// se clienti occupano meno 50% posti tavolo
						else {
							// provo indirizzarli al bancone in base tolleranza
							float tolleranza = e.getTolleranza();
							float caso = (float) this.randInt(0, 9) / 10;
							if (caso <= tolleranza) {
								// si siedono al bancone
								c.setStato(Cliente.statoCliente.SODDISFATTO);
								numClientiSoddisfatti += numClienti;
								seduto = true;

							} else {
								// li faccio sedere al tavolo
								t.setOccupato(true);
								t.setCliente(e.getId());
								seduto = true;

								numClientiSoddisfatti += numClienti;

								// passa stato uscita a tempo entrata+durata
								this.aggiungiEvento(new Evento(e.getTime() + e.getDurata(), numClienti, e.getDurata(),
										e.getTolleranza(), Evento.tipoEvento.USCITA_GRUPPO_CLIENTI, e.getId()));

							}
							break;

						}

					}

				}

			}

			// se non c'e' nessun tavolo libero
			if (seduto == false) {
				// o va al bancone o e' insoddisfatto (tolleranza)
				float tolleranza = e.getTolleranza();
				float caso = (float) this.randInt(0, 9) / 10;
				if (caso > tolleranza) {
					c.setStato(Cliente.statoCliente.INSODDISFATTO);
					numClientiInsoddisfatti += numClienti;

				} else {
					// si siede al bancone
					c.setStato(Cliente.statoCliente.SODDISFATTO);
					numClientiSoddisfatti += numClienti;
				}

			}

			break;

		case USCITA_GRUPPO_CLIENTI:
			// tavolo si libera
			for (Tavolo v : tavoli) {
				if (v.getCliente() == c.getId()) {
					v.setOccupato(false);
					clienti.remove(e.getId());
					break;

				}

			}

			break;
		default:
			return;

		}

	}

	public void simula() {
		numClientiSoddisfatti = 0;
		numClientiInsoddisfatti = 0;
		while (!listaEventi.isEmpty()) {
			passo();
		}
	}

	public static int getNumClientiSoddisfatti() {
		return numClientiSoddisfatti;
	}

	public static void setNumClientiSoddisfatti(int numClientiSoddisfatti) {
		Core.numClientiSoddisfatti = numClientiSoddisfatti;
	}

	public static int getNumClientiInsoddisfatti() {
		return numClientiInsoddisfatti;
	}

	public static void setNumClientiInsoddisfatti(int numClientiInsoddisfatti) {
		Core.numClientiInsoddisfatti = numClientiInsoddisfatti;
	}

	public int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public Queue<Evento> getListaEventi() {
		return listaEventi;
	}

	public Map<Integer, Cliente> getClienti() {
		return clienti;
	}

	public List<Tavolo> getTavoli() {
		return tavoli;
	}

}
