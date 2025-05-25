package br.com.bank.leme.bff.rapid.payment.adapter.exception.handler.response;

/**
 * Especifico para validacao de API
 */
public class SubErroNegocio implements ApiSubErroResponse {
    private final String codigo;
    private final String mensagem;


    SubErroNegocio(String codigo, String mensagem) {
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
