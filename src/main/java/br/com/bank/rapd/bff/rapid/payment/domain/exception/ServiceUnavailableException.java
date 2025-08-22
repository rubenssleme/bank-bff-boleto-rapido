package br.com.bank.rapd.bff.rapid.payment.domain.exception;

public class ServiceUnavailableException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String errorCode;
    private final String errorMsg;

    public ServiceUnavailableException(Integer errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = Integer.toString(errorCode);
        this.errorMsg = errorMsg;
    }

    public ServiceUnavailableException(String errorCode, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ServiceUnavailableException(Integer errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = Integer.toString(errorCode);
        this.errorMsg = errorMsg;
    }

    public ServiceUnavailableException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrCode() {
        return errorCode;
    }

    public String getErrMsg() {
        return errorMsg;
    }

}
