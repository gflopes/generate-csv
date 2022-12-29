package br.com.gustavo.generatecsv.repository;

import br.com.gustavo.generatecsv.entity.ServicoTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoTecnicoRepository extends JpaRepository<ServicoTecnico, Long> {
}