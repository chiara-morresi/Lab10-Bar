package it.polito.tdp.bar;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.bar.model.Statistiche;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class BarController {
	
	private Statistiche model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtRisultato;
    
    public void setModel(Statistiche model) {
    	this.model=model;
    }
    
    int conta = 1;

    @FXML
    void doSimula(ActionEvent event) {
    	
    	
    	//model.initialize();
    	
    	model.generaRandom();
		
		int array[] = model.getStatistiche();
		
		txtRisultato.appendText("SIMULAZIONE " +conta+"\n");
		
		txtRisultato.appendText("Numeri clienti totali: " +array[0]+ "\n");
		txtRisultato.appendText("Numeri clienti soddisfatti: " +array[1] +"\n");
		txtRisultato.appendText("Numeri clienti insoddisfatti: " +array[2] +"\n\n");	
		
		conta++;
		
    }

    @FXML
    void initialize() {
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Bar.fxml'.";

    }
}
