package application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Macchinetta extends Application {
	
	TextField t1;
	TextField t2;
	TextField t3;
	TextField t4;
	Button b2;
	Button BtnC;
	Button BtnT;
	Button BtnA;
	Label message;
	
	MacchinettaBib b1 = new MacchinettaBib();
	
	
	@Override
	public void start(Stage s1) throws Exception {
		
		b1.addChiavetta(new chiavetta("1234", 10));
		GridPane p1 = new GridPane();
		
		// creiamo dei widget per la pagina
		 t1 = new TextField();
		 
		
		 
		 b2 = new Button("Entra");
		 BtnC = new Button("Caffè");
		 BtnT = new Button("The");
		 BtnA = new Button("Acqua");
		 message = new Label();
		 
		 
		
		b2.setOnAction(e -> entra());
		BtnC.setOnAction(e -> erogaC());
		
		
		
		BtnC.setVisible(false);
		BtnT.setVisible(false);
		BtnA.setVisible(false);
		
		// aggiungiamo i widget al gridpane
		
		p1.add(t1, 0, 0);
		p1.add(b2, 1, 0);
		p1.add(BtnC, 0, 1);
		p1.add(BtnT, 0, 2);
		p1.add(BtnA, 0, 3);
		p1.add(message, 0, 4);
		
		
		
		
		
		
		
		
		// Scena
        Scene scena = new Scene(p1, 500, 200);
        s1.setTitle("App Messaggio");
        s1.setScene(scena);
        s1.show();
		
		
		
		
	}
	
	
	
	
	
	
	
public void entra() {
		
		String codice  = t1.getText();
		
		
		if (b1.getAccesso(codice)) {
			
			t1.setVisible(false);
			BtnC.setVisible(true);
			BtnT.setVisible(true);
			BtnA.setVisible(true);
			message.setText("Login riuscito");
			
			
		}
		else {
			
			 Alert alert = new Alert(AlertType.INFORMATION);
		        alert.setTitle("Messaggio");
		      
		        // recuperto il testo del textField con il metodo getText() e lo assegno ad una variabile stringa
		        String text = codice;
		        // setto il contenuto dell'alert con il valore ottenuto da input
		        alert.setContentText(text + " non ricosciuto");
		        alert.showAndWait();
		        t1.setVisible(true);
				BtnC.setVisible(false);
				BtnT.setVisible(false);
				BtnA.setVisible(false);
		        
				message.setText("Login fallito");
		}
		
	}

public void erogaC() {
	
	String codice  = t1.getText();
	
	
	if (b1.erogaC(codice)) {
		
		
		
		message.setText("Caffè in erogazione \n" + " credito residuo " + b1.getCredito(codice));
		
		
	}
	else {
		
		 Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Messaggio");
	      
	        // recuperto il testo del textField con il metodo getText() e lo assegno ad una variabile stringa
	        String text = codice;
	        // setto il contenuto dell'alert con il valore ottenuto da input
	        alert.setContentText(text + " credito non sufficiente");
	        alert.showAndWait();
	        t1.setVisible(true);
			BtnC.setVisible(false);
			BtnT.setVisible(false);
			BtnA.setVisible(false);
	        
			message.setText("Login fallito");
	}
	
}







	public static void main(String[] args) {
	        launch(args);
	    }



}
