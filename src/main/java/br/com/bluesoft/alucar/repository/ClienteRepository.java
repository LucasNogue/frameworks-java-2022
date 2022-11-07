package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.model.Carro;
import br.com.bluesoft.alucar.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.ref.Cleaner;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}