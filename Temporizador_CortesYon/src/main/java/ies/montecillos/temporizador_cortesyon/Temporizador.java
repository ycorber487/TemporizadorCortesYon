package ies.montecillos.temporizador_cortesyon;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * Clase Temporizador que extiende Label y proporciona una cuenta regresiva visual.
 */
public class Temporizador extends Label {

    /** Tiempo restante en segundos. */
    private int tiempo;

    /** Timeline para manejar la cuenta regresiva. */
    private Timeline timeline;

    /** Evento que se ejecuta cuando la cuenta regresiva finaliza. */
    private EventHandler<ActionEvent> onFinCuentaAtras;

    /**
     * Constructor de la clase Temporizador.
     *
     * @param tiempoInicial El tiempo inicial en segundos.
     */
    public Temporizador(int tiempoInicial) {
        this.tiempo = tiempoInicial;
        setText(String.valueOf(tiempo));

        // Configura el Timeline para que actualice el tiempo cada segundo
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), e -> decrementarTiempo());
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(tiempo);

        // Inicializa el evento de finalización
        onFinCuentaAtras = event -> {};
    }

    /**
     * Método privado que reduce el tiempo en un segundo y actualiza la etiqueta.
     * Detiene el temporizador y ejecuta el evento cuando llega a cero.
     */
    private void decrementarTiempo() {
        tiempo--;
        setText(String.valueOf(tiempo));

        if (tiempo <= 0) {
            timeline.stop();
            onFinCuentaAtras.handle(null);
        }
    }

    /**
     * Inicia el temporizador desde el principio.
     */
    public void iniciar() {
        timeline.playFromStart();
    }

    /**
     * Establece un manejador de eventos para la finalización de la cuenta regresiva.
     *
     * @param eventHandler Manejador de eventos a ejecutar cuando el temporizador finalice.
     */
    public void setOnFinCuentaAtras(EventHandler<ActionEvent> eventHandler) {
        this.onFinCuentaAtras = eventHandler;
    }

    /**
     * Obtiene el tiempo restante en segundos.
     *
     * @return El tiempo restante en segundos.
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * Establece un nuevo tiempo y actualiza la etiqueta.
     *
     * @param tiempo Nuevo tiempo en segundos.
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
        setText(String.valueOf(tiempo));
    }
}
