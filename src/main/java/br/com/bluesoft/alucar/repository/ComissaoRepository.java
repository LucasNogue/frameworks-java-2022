package br.com.bluesoft.alucar.repository;

import br.com.bluesoft.alucar.model.Comissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComissaoRepository extends JpaRepository<Comissao, Long> {
}