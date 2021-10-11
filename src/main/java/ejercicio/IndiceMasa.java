package ejercicio;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class IndiceMasa extends Application{

	
	private TextField operando1Text, operando2Text;
	
	
	
	private DoubleProperty operando1 = new SimpleDoubleProperty(0);
	private DoubleProperty operando2 = new SimpleDoubleProperty(0);
	private DoubleProperty resultado = new SimpleDoubleProperty(0);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	
		operando1Text = new TextField("1");
		operando1Text.setAlignment(Pos.CENTER);
		operando1Text.relocate(100, 120);
		operando1Text.setPrefWidth(100);
		
		operando2Text = new TextField("2");
		operando2Text.setAlignment(Pos.CENTER);
		operando2Text.relocate(150, 100);
		operando2Text.setPrefWidth(100);
		
		Label peso=  new Label("Peso:");
		//peso.relocate(100,10);
		
		Label Altura=  new Label("Altura:");
		//Altura.relocate(100,40);
		
		Label KG=  new Label("kg");
		//KG.relocate(100,10);
		
		Label CM=new Label("cm");
		//CM.relocate(100,10);
		
		
		HBox root= new HBox( operando1Text, operando2Text,peso,Altura);
		
		
		Scene scene = new Scene(root, 320, 200); 
		
		primaryStage.setTitle("IMC");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
