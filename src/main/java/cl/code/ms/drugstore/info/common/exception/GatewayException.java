package cl.code.ms.drugstore.info.common.exception;

public class GatewayException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public GatewayException() { super(); }

    public GatewayException(String message, Throwable cause)
    {
        super(message, cause);
    }
}