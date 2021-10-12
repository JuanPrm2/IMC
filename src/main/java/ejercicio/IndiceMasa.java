package ejercicio;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class IndiceMasa extends Application{

	
	private TextField pesoText, alturaText;
	private Label imcLabel,estadoLabel,resultadoLabel;
	
	
	private DoubleProperty operando1 = new SimpleDoubleProperty(0);
	private DoubleProperty operando2 = new SimpleDoubleProperty(0);
	private DoubleProperty resultado = new SimpleDoubleProperty(0);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	
		pesoText = new TextField();
		pesoText.setAlignment(Pos.CENTER);
		pesoText.setPrefWidth(100);
		
		alturaText = new TextField();
		alturaText.setAlignment(Pos.CENTER);
		alturaText.setPrefWidth(100);
		
		imcLabel = new Label("IMC: ");
		imcLabel.setAlignment(Pos.CENTER);
		
		estadoLabel=new Label("Bajo peso | Normal | Sobrepeso | Obeso");
		estadoLabel.setAlignment(Pos.CENTER);
		
		resultadoLabel=new Label();
		resultadoLabel.setPrefWidth(100);
		
		Label peso=  new Label("Peso:");
		//peso.setPrefWidth(5);
		Label Altura=  new Label("Altura:");
		//Altura.setPrefWidth(5);
		
		Label KG=  new Label("kg");
		
		Label CM=new Label("cm");
		
		
		HBox pesoVox= new HBox( peso,pesoText,KG);
		pesoVox.setAlignment(Pos.CENTER);
		HBox alturaVox=new HBox(Altura,alturaText,CM);
		alturaVox.setAlignment(Pos.CENTER);
		HBox imc =new HBox(imcLabel,resultadoLabel);
		imc.setAlignment(Pos.CENTER);
		
		VBox root=new VBox (pesoVox,alturaVox,imc,estadoLabel);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(5);
		Scene scene = new Scene(root, 320, 200); 
		
		//bindeos
		pesoText.textProperty().bindBidirectional(operando1, new NumberStringConverter());
		
		alturaText.textProperty().bindBidirectional(operando2,new NumberStringConverter());
		
		resultado.bind(operando1.divide((operando2.divide(100).multiply(operando2.divide(100)))));
		
		resultadoLabel.textProperty().bind(Bindings
											.when(operando1.lessThanOrEqualTo(0).or(operando2.lessThanOrEqualTo(0)) )
											.then("peso/(altura^2)")
											.otherwise(resultado.asString("%.2f"))
				);
		
		resultado.addListener((o,ov,nv) -> onResultadoChanged(nv.doubleValue()));
		
		
		primaryStage.setTitle("IMC");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	
		
	}

	private void onResultadoChanged(double nv) {

		
		if(operando1.doubleValue()!=0&&operando2.doubleValue()!=0) {
			if(nv<18.5) {
				estadoLabel.setText("Bajo peso");
			}else if(nv>=18.5&&nv<25) {
				estadoLabel.setText("Normal");
			}else if(nv>=25&&nv<30) {
				estadoLabel.setText("Sobrepeso");
			}else {
				estadoLabel.setText("Obeso");
				
			}	
		}
		
	}




	public static void main(String[] args) {
		launch(args);
	}
	
}
