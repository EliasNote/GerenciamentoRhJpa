package com.esand.GerenciamentoRh.repositorios;

import com.esand.GerenciamentoRh.entidades.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
