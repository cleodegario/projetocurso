package com.cassio.cursomc.domain.enums;

public enum EnumTipoCliente {

    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private int cod;
    private String descricao;

    private EnumTipoCliente(int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EnumTipoCliente toEnum(Integer cod){

        if(cod == null){
            return null;
        }

        for(EnumTipoCliente x : EnumTipoCliente.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id Invalido:" + cod);
    }
}
