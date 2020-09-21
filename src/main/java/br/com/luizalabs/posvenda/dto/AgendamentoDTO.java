package br.com.luizalabs.posvenda.dto;

import br.com.luizalabs.posvenda.domain.Agendamento;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;

public class AgendamentoDTO implements Serializable {
        private static final long serialVersionUID = 1L;

        private Integer id;

        private Date dataEnvio;

        @NotEmpty(message="Preenchimento obrigatório.")
        private String destinatario;

        @NotEmpty(message="Preenchimento obrigatório.")
        private String mensagem;

        AgendamentoDTO(){
        }

        public AgendamentoDTO(Agendamento obj){
                id = obj.getId();
                dataEnvio = obj.getDataEnvio();
                destinatario = obj.getDestinatario();
                mensagem = obj.getMensagem();
        }

        public AgendamentoDTO(Integer id, Date dataEnvio, String destinatario, String mensagem) {
                this.id = id;
                this.dataEnvio = dataEnvio;
                this.destinatario = destinatario;
                this.mensagem = mensagem;
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
}
