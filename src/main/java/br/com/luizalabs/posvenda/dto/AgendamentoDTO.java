package br.com.luizalabs.posvenda.dto;

import br.com.luizalabs.posvenda.domain.Agendamento;
import br.com.luizalabs.posvenda.domain.enums.TipoEnvio;
import br.com.luizalabs.posvenda.validation.AgendamentoInsert;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@AgendamentoInsert
public class AgendamentoDTO implements Serializable {
        private static final long serialVersionUID = 1L;

        private Integer id;

        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="America/Sao_Paulo")
        private Date dataEnvio;

        private static String STATUS_REGISTRO = "Novo";

        @NotEmpty(message="Preenchimento obrigatório.")
        private String destinatario;

        @NotEmpty(message="Preenchimento obrigatório.")
        private String mensagem;

        private Integer tipoEnvio;

        private String status;

        AgendamentoDTO(){
        }

        public AgendamentoDTO(Agendamento obj){
                id = obj.getId();
                dataEnvio = obj.getDataEnvio();
                destinatario = obj.getDestinatario();
                mensagem = obj.getMensagem();
                tipoEnvio = obj.getTipoEnvio().getCod();
                status = obj.getStatus();
        }



        public Integer getId() {
                return id;
        }

        public Date getDataEnvio() {
                return dataEnvio;
        }

        public String getDestinatario() {
                return destinatario;
        }

        public String getMensagem() {
                return mensagem;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public void setDataEnvio(Date dataEnvio) {
                this.dataEnvio = dataEnvio;
        }

        public void setDestinatario(String destinatario) {
                this.destinatario = destinatario;
        }

        public void setMensagem(String mensagem) {
                this.mensagem = mensagem;
        }

        public TipoEnvio getTipoEnvio() {
                return TipoEnvio.toEnum(tipoEnvio);

        }

        public void setTipoEnvio(Integer tipoEnvio) {
                this.tipoEnvio = tipoEnvio;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }
}
