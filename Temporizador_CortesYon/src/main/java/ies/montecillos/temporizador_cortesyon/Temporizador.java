package ies.montecillos.temporizador_cortesyon;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Temporizador extends Label {
    private int tiempo;
    private Timeline timeline;
    private EventHandler<ActionEvent> onFinCuentaAtras;

    public Temporizador(int tiempoInicial) {
        this.tiempo = tiempoInicial;
        setText(String.valueOf(tiempo));

        // Configura el Timeline para que actualice el tiempo cada segundo
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), e -> decrementarTiempo());
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(tiempo); //

        // Inicializa el evento de finalización
        onFinCuentaAtras = event -> {};
    }

    private void decrementarTiempo() {
        tiempo--;
        setText(String.valueOf(tiempo));

        if (tiempo <= 0) {
            timeline.stop();
            onFinCuentaAtras.handle(null);
        }
    }


    public void iniciar() {
        timeline.playFromStart();
    }


    public void setOnFinCuentaAtras(EventHandler<ActionEvent> eventHandler) {
        this.onFinCuentaAtras = eventHandler;
    }


    public int getTiempo() {
        return tiempo;
    }


    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
        setText(String.valueOf(tiempo)); // Actualizar la etiqueta
    }
}