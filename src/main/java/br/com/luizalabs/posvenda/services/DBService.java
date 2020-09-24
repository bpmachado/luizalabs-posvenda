package br.com.luizalabs.posvenda.services;

import br.com.luizalabs.posvenda.domain.Agendamento;
import br.com.luizalabs.posvenda.domain.enums.TipoEnvio;
import br.com.luizalabs.posvenda.repositories.AgendamentoRepository;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class DBService {

    private final AgendamentoRepository agendamentoRepository;

    public DBService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    public void instantiateTestDataBase() throws ParseException {
        Agendamento agendamento = new Agendamento();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        agendamento.setDataEnvio(sdf.parse( "21/09/2020"));
        agendamento.setDestinatario("bpmachado@gmail.com");
        agendamento.setMensagem("Novo cliente luizalabs");
        agendamento.setTipoEnvio(TipoEnvio.EMAIL);
        agendamento.setStatus("Enviado");

        agendamentoRepository.save(agendamento);
    }

}
