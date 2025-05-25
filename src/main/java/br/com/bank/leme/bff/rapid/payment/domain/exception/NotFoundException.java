package br.com.bank.capd.bff.rapid.payment.domain.exception;

public class NotFoundException extends BusinessException {

    private static final long serialVersionUID = 1L;


    public NotFoundException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, errorMsg, cause);
    }

    public NotFoundException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }
}
