package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.model.Cliente;
import br.com.bluesoft.alucar.model.ContaCorrente;
import br.com.bluesoft.alucar.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {
    @Query("SELECT c FROM  ContaCorrente c WHERE c.vendedor.id = :id")
    Optional<ContaCorrente> encontraContaCorrenteDoVendedor(@Param("id") Long id);
}