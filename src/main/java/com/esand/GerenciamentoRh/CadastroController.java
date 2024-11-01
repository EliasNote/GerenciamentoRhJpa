package com.esand.GerenciamentoRh;

import com.esand.GerenciamentoRh.entidades.Funcionario;
import com.esand.GerenciamentoRh.repositorios.FuncionarioRepository;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CadastroController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @FXML
    private TextField nomeField;
    @FXML
    private TextField sobrenomeField;
    @FXML
    private TextField cpfField;
    @FXML
    private TextField salarioField;

    @FXML
    protected void salvar() {
        funcionarioRepository.save(new Funcionario(
                null,
                nomeField.getText(),
                sobrenomeField.getText(),
                cpfField.getText(),
                Funcionario.Departamento.PRODUCAO,
                Double.parseDouble(salarioField.getText()),
                null
        ));
    }
}