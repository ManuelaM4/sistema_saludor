package com.saludor.sistema;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Prototipo "Sistema Saludador".
 * Tiene tres pantallas: inicio, formulario y saludo.
 */
public class SistemaSaludadorApp extends Application {

    private static final String ESTILO_BOTON =
            "-fx-background-color: #2e7d6b; -fx-text-fill: white; "
            + "-fx-font-size: 15px; -fx-padding: 10 24; -fx-background-radius: 8;";

    private Stage ventana;

    @Override
    public void start(Stage stage) {
        this.ventana = stage;
        stage.setTitle("Sistema Saludador");
        stage.setScene(new Scene(crearInicio(), 520, 440));
        stage.show();
    }

    // Pantalla 1: inicio con el botón "Solicitar saludo"
    private VBox crearInicio() {
        Label titulo = new Label("Sistema Saludador");
        titulo.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: #1f3d36;");

        Label subtitulo = new Label("Pulsa el botón para recibir tu saludo.");
        subtitulo.setStyle("-fx-font-size: 14px; -fx-text-fill: #555;");

        Button solicitar = new Button("Solicitar saludo");
        solicitar.setStyle(ESTILO_BOTON);
        solicitar.setOnAction(e -> ventana.getScene().setRoot(crearFormulario()));

        return contenedor(titulo, subtitulo, solicitar);
    }

    // Pantalla 2: formulario con nombre, edad y hora (AM/PM)
    private VBox crearFormulario() {
        Label titulo = new Label("Ingresa tus datos");
        titulo.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #1f3d36;");

        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Nombre");
        campoNombre.setMaxWidth(280);

        TextField campoEdad = new TextField();
        campoEdad.setPromptText("Edad");
        campoEdad.setMaxWidth(280);

        ComboBox<String> comboHora = new ComboBox<>();
        comboHora.getItems().addAll("AM", "PM");
        comboHora.setPromptText("Hora (AM/PM)");
        comboHora.setPrefWidth(280);

        Label error = new Label();
        error.setStyle("-fx-text-fill: #c62828; -fx-font-size: 13px;");
        error.setWrapText(true);
        error.setMaxWidth(280);

        Button aceptar = new Button("Aceptar");
        aceptar.setStyle(ESTILO_BOTON);
        aceptar.setOnAction(e -> {
            String nombre = campoNombre.getText().trim();
            String textoEdad = campoEdad.getText().trim();
            String hora = comboHora.getValue();

            if (nombre.isEmpty()) {
                error.setText("El nombre no puede estar vacío.");
                return;
            }
            int edad;
            try {
                edad = Integer.parseInt(textoEdad);
            } catch (NumberFormatException ex) {
                error.setText("La edad debe ser un número entero.");
                return;
            }
            if (edad < 1 || edad > 120) {
                error.setText("La edad debe estar entre 1 y 120.");
                return;
            }
            if (hora == null) {
                error.setText("Selecciona AM o PM.");
                return;
            }
            ventana.getScene().setRoot(crearSaludo(nombre, edad, hora));
        });

        return contenedor(titulo, campoNombre, campoEdad, comboHora, error, aceptar);
    }

    // Pantalla 3: saludo con el nombre y la edad
    private VBox crearSaludo(String nombre, int edad, String hora) {
        String saludo = hora.equals("AM") ? "Buenos días" : "Buenas tardes";
        String textoEdad = (edad == 1) ? "1 año" : edad + " años";

        Label mensaje = new Label(saludo + ", " + nombre + ". Tienes " + textoEdad + ".");
        mensaje.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #1f3d36;");
        mensaje.setWrapText(true);
        mensaje.setMaxWidth(420);

        Button volver = new Button("Volver al inicio");
        volver.setStyle(ESTILO_BOTON);
        volver.setOnAction(e -> ventana.getScene().setRoot(crearInicio()));

        return contenedor(mensaje, volver);
    }

    // Contenedor común para que las tres pantallas se vean igual
    private VBox contenedor(javafx.scene.Node... hijos) {
        VBox caja = new VBox(16, hijos);
        caja.setAlignment(Pos.CENTER);
        caja.setPadding(new Insets(30));
        caja.setStyle("-fx-background-color: #eef5f2;");
        return caja;
    }

    public static void main(String[] args) {
        launch(args);
    }
}