package br.com.luizalabs.posvenda.dto;

import br.com.luizalabs.posvenda.domain.Agendamento;
import br.com.luizalabs.posvenda.domain.enums.CanalEnvio;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;
import javax.validation.constraints.NotEmpty;

public class AgendamentoDTO implements Serializable {
        private static final long serialVersionUID = 1L;

        private Integer id;

        private Date dataEnvio;

        private static String STATUS_REGISTRO = "Novo";

        @NotEmpty(message="Preenchimento obrigatório.")
        private String destinatario;

        @NotEmpty(message="Preenchimento obrigatório.")
        private String mensagem;

        private Integer canalEnvio;

        private String status;

        AgendamentoDTO(){
        }

        public AgendamentoDTO(Agendamento obj){
                id = obj.getId();
                dataEnvio = obj.getDataEnvio();
                destinatario = obj.getDestinatario();
                mensagem = obj.getMensagem();
                canalEnvio = obj.getCanalEnvio().getCod();
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

        public CanalEnvio getCanalEnvio() {
                return CanalEnvio.toEnum(canalEnvio);

        }

        public void setCanalEnvio(Integer canalEnvio) {
                this.canalEnvio = canalEnvio;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }
}
