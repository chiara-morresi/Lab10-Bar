package it.polito.tdp.bar.model;

public class TestModel {

	public static void main(String[] args) {
		
		Statistiche st = new Statistiche();
		
		
		st.generaRandom();;
		
		int array[] = st.getStatistiche();
		

		System.out.println(array[0] +" "
		+ array[1] +" "
		+ array[2]);

	}

}
