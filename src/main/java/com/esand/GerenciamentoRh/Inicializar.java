package com.esand.GerenciamentoRh;

import com.esand.GerenciamentoRh.entidades.Funcionario;
import com.esand.GerenciamentoRh.entidades.Login;
import com.esand.GerenciamentoRh.repositorios.FuncionarioRepository;
import com.esand.GerenciamentoRh.repositorios.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Inicializar {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void criarLoginFuncionarioAdmin() {
        Funcionario funcionario = new Funcionario(
                1L,
                "Elias",
                "Sand",
                "admin",
                Funcionario.Departamento.GERENCIA,
                8000.00,
                null
        );
        funcionarioRepository.save(funcionario);

        Login login = new Login(
                1L,
                funcionario.getCpf(),
                "admin"
        );
        loginRepository.save(login);
    }
}
