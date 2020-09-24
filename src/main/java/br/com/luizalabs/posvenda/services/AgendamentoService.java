package br.com.luizalabs.posvenda.services;

import br.com.luizalabs.posvenda.domain.Agendamento;
import br.com.luizalabs.posvenda.domain.enums.TipoEnvio;
import br.com.luizalabs.posvenda.dto.AgendamentoDTO;
import br.com.luizalabs.posvenda.repositories.AgendamentoRepository;
import br.com.luizalabs.posvenda.services.exception.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;


    public Agendamento find(Integer id){
        Optional<Agendamento> obj = agendamentoRepository.findById(id);

        if(!obj.isPresent()){
            throw new DataIntegrityException("Registro não encontrado");
        }

        return obj.orElse(null);
    }

    public Agendamento insert(Agendamento obj){
        Agendamento agendamentoIncluido = agendamentoRepository.save(obj);
        return agendamentoIncluido;
    }

    public Agendamento fromDTO(AgendamentoDTO objDTO){

        return new Agendamento(objDTO.getId(), objDTO.getDataEnvio(), objDTO.getDestinatario(), objDTO.getMensagem(), TipoEnvio.toEnum(objDTO.getTipoEnvio().getCod()), objDTO.getStatus());
    }

    public void delete(Integer id) {
        find(id);
        try {
            agendamentoRepository.deleteById(id);
        }catch(DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é Possivel excluir uma agendamento");
        }
    }

    public List<Agendamento> findAll() {

        List<Agendamento> obj = agendamentoRepository.findAll();

        if(obj.size()==0){
            throw new DataIntegrityException("Registro não encontrado");
        }

        return obj;
    }


}
