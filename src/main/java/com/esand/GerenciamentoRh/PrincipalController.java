package com.esand.GerenciamentoRh;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import static com.esand.GerenciamentoRh.Utils.loadChildrenFXML;

public class PrincipalController {
    @FXML
    private Pane contentPane;

    @FXML
    public void showCadastrar() {
        loadChildrenFXML(contentPane,"cadastro.fxml");
    }

    @FXML
    public void showVisualizar() {
        loadChildrenFXML(contentPane,"visualizar.fxml");
    }
}
