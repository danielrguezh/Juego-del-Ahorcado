package es.ies.puerto.controller.abstractas;

import java.lang.reflect.Method;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.config.ConfigManager;
import es.ies.puerto.model.entities.UsuarioEntitySqlite;
import es.ies.puerto.model.services.NivelServiceSqlite;
import es.ies.puerto.model.services.PalabraServiceSqlite;
import es.ies.puerto.model.services.UsuarioServiceSqlite;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author danielrguezh
 * @version 1.0.0
 */

public abstract class AbstractController {

    static final String PATH_DB = "src/main/resources/usuarios.db";
    private UsuarioServiceSqlite usuarioServiceSqlite;
    private PalabraServiceSqlite palabraServiceSqlite;
    private NivelServiceSqlite nivelServiceSqlite;
    
    /**
     * Constructor por defecto
     */
    public AbstractController() {
        try {
            usuarioServiceSqlite = new UsuarioServiceSqlite(PATH_DB);
            palabraServiceSqlite = new PalabraServiceSqlite(PATH_DB);
            nivelServiceSqlite = new NivelServiceSqlite(PATH_DB);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Getters and Setters
     */
    public UsuarioServiceSqlite getUsuarioServiceSqlite() {
        return usuarioServiceSqlite;
    }

    public PalabraServiceSqlite getPalabraServiceSqlite() {
        return palabraServiceSqlite;
    }

    public NivelServiceSqlite getNivelServiceSqlite() {
        return nivelServiceSqlite;
    }

    @FXML
    public Text textUsuario;

    @FXML
    public Text textUsuarioEmail;

    @FXML
    public Text textContrasenia;

    @FXML 
    private Text textEmail;

    @FXML
    private TextField textFieldUsuario;

    @FXML
    private TextField textFieldUsuarioEmail;
    
    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private Button openAceptarButton;

    @FXML
    private Button openRegistrarButton;

    @FXML
    private Button openListarUsuariosButton;

    @FXML
    private Button buttonRecuperarContrasenia;

    @FXML
    private Text textRegistroTitulo;

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private TextField textFieldEmailRepit;

    @FXML
    private PasswordField textFieldPasswordRepit;

    @FXML
    private Button buttonVolverAtras;

    @FXML
    private Text textListaUsuario;

    @FXML
    private Button buscarUsuariosButton;

    /**
     * Método para cambiar el idioma
     */
    @FXML
    protected void cambiarIdioma() {
        if (textUsuario != null) {
            textUsuario.setText(ConfigManager.ConfigProperties.getProperty("textUsuario"));
        }

        if (textUsuarioEmail != null) {
            textUsuarioEmail.setText(ConfigManager.ConfigProperties.getProperty("textUsuarioEmail"));
        }

        if (textContrasenia != null) {
            textContrasenia.setText(ConfigManager.ConfigProperties.getProperty("textContrasenia"));
        }

        if (textEmail != null) {
            textEmail.setText(ConfigManager.ConfigProperties.getProperty("textEmail"));
        }

        if (textFieldUsuario != null) {
            textFieldUsuario.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldUsuario"));
        }

        if (textFieldUsuarioEmail != null) {
            textFieldUsuarioEmail.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldUsuarioEmail"));
        }

        if (textFieldPassword != null) {
            textFieldPassword.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldPassword"));
        }

        if (openAceptarButton != null) {
            openAceptarButton.setText(ConfigManager.ConfigProperties.getProperty("openAceptarButton"));
        }

        if (openRegistrarButton != null) {
            openRegistrarButton.setText(ConfigManager.ConfigProperties.getProperty("openRegistrarButton"));
        }

        if (openListarUsuariosButton != null) {
            openListarUsuariosButton.setText(ConfigManager.ConfigProperties.getProperty("openListarUsuariosButton"));
        }

        if (buttonRecuperarContrasenia != null) {
            buttonRecuperarContrasenia.setText(ConfigManager.ConfigProperties.getProperty("buttonRecuperarContrasenia"));
        }

        if (textRegistroTitulo != null) {
            textRegistroTitulo.setText(ConfigManager.ConfigProperties.getProperty("textRegistroTitulo"));
        }

        if (textFieldNombre != null) {
            textFieldNombre.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldNombre"));
        }

        if (textFieldEmail != null) {
            textFieldEmail.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldEmail"));
        }

        if (textFieldEmailRepit != null) {
            textFieldEmailRepit.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldEmailRepit"));
        }

        if (textFieldPasswordRepit != null) {
            textFieldPasswordRepit.setPromptText(ConfigManager.ConfigProperties.getProperty("textFieldPasswordRepit"));
        }

        if (buttonVolverAtras != null) {
            buttonVolverAtras.setText(ConfigManager.ConfigProperties.getProperty("buttonVolverAtras"));
        }

        if (textListaUsuario != null) {
            textListaUsuario.setText(ConfigManager.ConfigProperties.getProperty("textListaUsuario"));
        }

        if (buscarUsuariosButton != null) {
            buscarUsuariosButton.setText(ConfigManager.ConfigProperties.getProperty("buscarUsuariosButton"));
        }
    }

    /**
     * Metodo que muestra una pantalla alterna en la aplicacion
     * @param button
     * @param fxml 
     */
    public void mostrarPantalla(Button button, String fxml) {
        if (button == null || fxml == null || fxml.isEmpty()) {
            return;
        }
        try {
            Stage stage = (Stage) button.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(getClass().getResource("/es/ies/puerto/css/style.css").toExternalForm());
            Image icon = new Image(getClass().getResource("/es/ies/puerto/img/ahorcado.png").toExternalForm());
            stage.getIcons().add(icon);
            stage.setTitle("Juego del ahorcado");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que muestra una pantalla alterna en la aplicacion
     * @param button
     * @param fxml
     * @param usuario datos almacenados en la nueva pantalla
     */
    public void mostrarPantalla(Node node, String fxml, UsuarioEntitySqlite usuario) {
        if (node == null || fxml == null || fxml.isEmpty() || usuario == null) {
            return;
        }
        try {
            Stage stage = (Stage) node.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource(fxml));
            Scene scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(getClass().getResource("/es/ies/puerto/css/style.css").toExternalForm());
            Object controller = fxmlLoader.getController();
            Method method = controller.getClass().getMethod("cargarDatosUsuario", UsuarioEntitySqlite.class);
            method.invoke(controller, usuario); 
            Image icon = new Image(getClass().getResource("/es/ies/puerto/img/ahorcado.png").toExternalForm());
            stage.getIcons().add(icon);
            stage.setTitle("Juego del Ahorcado");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}