package cl.code.ms.drugstore.info.common.exception;

public class RepositoryException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RepositoryException()
    {
        super();
    }

    public RepositoryException(String message)
    {
        super(message);
    }

    public RepositoryException(String message, Throwable cause)
    {
        super(message, cause);
    }
}