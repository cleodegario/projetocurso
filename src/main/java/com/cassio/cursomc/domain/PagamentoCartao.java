package com.cassio.cursomc.domain;

import com.cassio.cursomc.domain.enums.EnumEstadoPagamento;

import javax.persistence.Entity;

@Entity
public class PagamentoCartao extends  Pagamento {

    private static final long serialVersionUID = 1L;

    private Integer numeroParcelas;

    public PagamentoCartao(){}

    public PagamentoCartao(Integer id, EnumEstadoPagamento estado, Pedido pedido, Integer numeroParcelas) {
        super(id, estado, pedido);
        this.numeroParcelas = numeroParcelas;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }
}
