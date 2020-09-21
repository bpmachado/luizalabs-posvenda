package br.com.luizalabs.posvenda.resources;

import br.com.luizalabs.posvenda.domain.Agendamento;
import br.com.luizalabs.posvenda.dto.AgendamentoDTO;
import br.com.luizalabs.posvenda.services.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/agendamento")
public class AgendamentoResource {

    private final AgendamentoService agendamentoService;


    public AgendamentoResource(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;

    }


    @RequestMapping(value="{id}",method=RequestMethod.GET)
    public ResponseEntity<Agendamento> find(@PathVariable Integer id ) {

        Agendamento obj = agendamentoService.find(id);

        return ResponseEntity.ok().body(obj);

    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody AgendamentoDTO objDto){
        Agendamento obj = agendamentoService.fromDTO(objDto);
        obj = agendamentoService.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        agendamentoService.delete(id);

        return ResponseEntity.noContent().build();

    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<AgendamentoDTO>> find() {

        List<Agendamento> list = agendamentoService.findAll();
        List<AgendamentoDTO> listaDTO = list.stream().map(obj -> new  AgendamentoDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listaDTO);
    }



}
