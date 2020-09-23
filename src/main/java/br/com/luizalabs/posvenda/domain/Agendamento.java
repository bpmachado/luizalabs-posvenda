package br.com.luizalabs.posvenda.domain;

import br.com.luizalabs.posvenda.domain.enums.TipoEnvio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;


@Entity
public class Agendamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private static String STATUS_REGISTRO = "Novo";

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Date dataEnvio;
    private String destinatario;
    private String mensagem;
    private Integer tipoEnvio;
    private String status;

    public Agendamento(){}

    public Agendamento(Integer id, Date dataEnvio, String destinatario, String mensagem, TipoEnvio tipoEnvio, String status) {
        super();
        this.id = id;
        this.dataEnvio = dataEnvio;
        this.destinatario = destinatario;
        this.mensagem = mensagem;
        this.tipoEnvio = tipoEnvio.getCod();
        this.status = Optional.ofNullable(STATUS_REGISTRO).orElse(status);
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

    public void setTipoEnvio(TipoEnvio tipoEnvio) {
        this.tipoEnvio = tipoEnvio.getCod();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento that = (Agendamento) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dataEnvio, that.dataEnvio) &&
                Objects.equals(destinatario, that.destinatario) &&
                Objects.equals(mensagem, that.mensagem) &&
                Objects.equals(tipoEnvio, that.tipoEnvio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataEnvio, destinatario, mensagem, tipoEnvio);
    }
}
