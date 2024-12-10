package ies.montecillos.temporizador_cortesyon;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class Controller {

    @FXML
    private VBox vbox; // Contenedor donde se añadirá el Temporizador

    private Temporizador temporizador;

    public void initialize() {
        // Crea un Temporizador con un tiempo inicial de 10 segundos
        temporizador = new Temporizador(10);

        // Establece el evento que se lanza al finalizar la cuenta atrás
        temporizador.setOnFinCuentaAtras(event -> {
            System.out.println("¡La cuenta atrás ha finalizado!");

        });


        vbox.getChildren().add(temporizador);

        // Inicia el temporizador
        temporizador.iniciar();
    }
}