package com.esand.GerenciamentoRh.repositorios;

import com.esand.GerenciamentoRh.entidades.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByCpf(String text);
}
