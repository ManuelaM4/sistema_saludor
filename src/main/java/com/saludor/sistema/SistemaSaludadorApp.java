package com.saludor.sistema;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SistemaSaludadorApp extends Application {

    @Override
    public void start(Stage escenarioPrincipal) {
        Button botonSolicitarSaludo = new Button("Solicitar saludo");

        StackPane raiz = new StackPane(botonSolicitarSaludo);
        raiz.setAlignment(Pos.CENTER);
        raiz.setPadding(new Insets(24));

        Scene escena = new Scene(raiz, 480, 320);

        escenarioPrincipal.setTitle("Sistema Saludador");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
