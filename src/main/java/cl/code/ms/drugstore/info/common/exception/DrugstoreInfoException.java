package cl.code.ms.drugstore.info.common.exception;

public class DrugstoreInfoException extends RuntimeException {
    public DrugstoreInfoException(String message, Throwable cause) { super(message, cause); }
    public DrugstoreInfoException(String message) { super(message); }
    public DrugstoreInfoException() { super(); }
}
