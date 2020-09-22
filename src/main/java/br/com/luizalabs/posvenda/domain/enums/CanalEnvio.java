package br.com.luizalabs.posvenda.domain.enums;

public enum CanalEnvio {
    EMAIL(1, "Email"),
    SMS(2, "Sms"),
    PUSH(3, "Push"),
    WHASTAPP(4, "WhastApp");

    private int cod;
    private String descricao;

    private CanalEnvio(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static CanalEnvio toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(CanalEnvio x : CanalEnvio.values()) {
            if(cod.equals(x.getCod())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválida:" +cod);
    }

}
