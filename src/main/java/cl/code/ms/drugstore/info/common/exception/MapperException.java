package cl.code.ms.drugstore.info.common.exception;

public class MapperException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MapperException()
    {
        super();
    }

    public MapperException(String message)
    {
        super(message);
    }

    public MapperException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
