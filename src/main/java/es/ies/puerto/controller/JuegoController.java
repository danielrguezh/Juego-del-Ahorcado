package es.ies.puerto.controller;

import java.io.IOException;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.controller.abstractas.AbstractController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author danielrguezh
 * @version 1.0.0
 */

public class JuegoController extends AbstractController {
    
    @FXML Button regresarButton;

    /**
     * va a la pantalla de inicio
     */
    @FXML
    public void juegoToInicioOnClick(){
        mostrarPantalla(regresarButton,"app-init");
    }
}
