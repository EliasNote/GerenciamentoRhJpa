package com.esand.GerenciamentoRh;

import com.esand.GerenciamentoRh.repositorios.LoginRepository;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.esand.GerenciamentoRh.Utils.loadFXML;
import static com.esand.GerenciamentoRh.Utils.showErrorMessage;

@Component
public class LoginController  {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private Inicializar inicializar;

    @FXML
    private TextField CPF;

    @FXML
    private TextField Senha;

    @FXML
    public void logar() {
        inicializar.criarLoginFuncionarioAdmin();

        if (verificarSenha()) {
            Stage stage = (Stage) CPF.getScene().getWindow();
            loadFXML(stage, "principal.fxml", CPF);
        } else {
            showErrorMessage("CPF ou Senha incorreto");
        }
    }

    private boolean verificarSenha() {
        if (loginRepository.findByCpf(CPF.getText()).getSenha().equals(Senha.getText())) {
            System.out.println(loginRepository.findByCpf(CPF.getText()).getCpf() + "\n" +
                    loginRepository.findByCpf(CPF.getText()).getSenha());
            return true;
        };
        return false;
    }
}