package es.ies.puerto.controller;

import es.ies.puerto.controller.abstractas.AbstractController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * @author danielrguezh
 * @version 1.0.0
 */

public class InicioController extends AbstractController{
    
    @FXML private Button editarButton;
    @FXML private Button jugarButton;
    @FXML private Button regresarButton;

    /**
     * Metodo de inicializacion de la interfaz
     */
    @FXML
    public void initialize() {
        cambiarIdioma();
    }

    /**
     * Metodo que redirige a la pantalla registrar
     */
    @FXML
    public void inicioToRegistrarOnClick(){
        mostrarPantalla(editarButton, "registro");
    }

    /**
     * Metodo que redirige a la pantalla de partida
     */
    @FXML
    public void inicioToPartidaOnClick(){
        mostrarPantalla(jugarButton, "juego");
    }

    /**
     * Metodo que redirige a la pantalla de login
     */
    @FXML
    public void inicioToLoginOnClick(){
        mostrarPantalla(regresarButton,"app-init");
    }
}
