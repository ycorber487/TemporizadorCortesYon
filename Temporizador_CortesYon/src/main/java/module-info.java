module ies.montecillos.temporizador_cortesyon {
    requires javafx.controls;
    requires javafx.fxml;


    opens ies.montecillos.temporizador_cortesyon to javafx.fxml;
    exports ies.montecillos.temporizador_cortesyon;
}