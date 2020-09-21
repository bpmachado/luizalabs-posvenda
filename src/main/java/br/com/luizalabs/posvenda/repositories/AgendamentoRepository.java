package br.com.luizalabs.posvenda.repositories;

import br.com.luizalabs.posvenda.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

}
