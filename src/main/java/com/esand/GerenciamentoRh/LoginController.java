package com.esand.GerenciamentoRh;

import com.esand.GerenciamentoRh.entidades.Funcionario;
import com.esand.GerenciamentoRh.repositorios.FuncionarioRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @FXML
    private TextField CPF;

    @FXML
    private TextField Senha;

    @FXML
    public void logar() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Elias");
        funcionario.setSobrenome("Sand");
        funcionario.setCpf("10527127973");
        funcionario.setSalario(8000.00);
        funcionario.setDepartamento(Funcionario.Departamento.RH);
        funcionario.setBeneficios(null);

        System.out.println(funcionarioRepository.save(funcionario));
    }

    private void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERRO");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}