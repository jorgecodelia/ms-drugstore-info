package cl.code.ms.drugstore.info.api.handler;

import cl.code.ms.drugstore.info.api.model.DrugstoreInfoApiResponse;
import cl.code.ms.drugstore.info.common.exception.GatewayException;
import cl.code.ms.drugstore.info.common.exception.MapperException;
import cl.code.ms.drugstore.info.common.exception.RepositoryException;
import cl.code.ms.drugstore.info.common.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.invoke.MethodHandles;

import static cl.code.ms.drugstore.info.common.util.Constant.DEFAULT_EXCEPTION_MSG;

@RestControllerAdvice
public class ExceptionHandlerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<DrugstoreInfoApiResponse> handleException(ServiceException exception) {
        return getEmptyDataResponseResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MapperException.class)
    public ResponseEntity<DrugstoreInfoApiResponse> handleException(MapperException exception) {
        return getEmptyDataResponseResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RepositoryException.class)
    public ResponseEntity<DrugstoreInfoApiResponse> handleException(RepositoryException exception) {
        return getEmptyDataResponseResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(GatewayException.class)
    public ResponseEntity<DrugstoreInfoApiResponse> handleException(GatewayException exception) {
        return getEmptyDataResponseResponseEntity(exception, HttpStatus.BAD_GATEWAY);
    }

    private ResponseEntity<DrugstoreInfoApiResponse> getEmptyDataResponseResponseEntity(Exception exception, HttpStatus httpStatus) {
        return new ResponseEntity<>(getEmptyDataResponse(exception.getLocalizedMessage()), httpStatus);
    }

    private DrugstoreInfoApiResponse getEmptyDataResponse(String message) {
        String description = DEFAULT_EXCEPTION_MSG+message;
        return  new DrugstoreInfoApiResponse(false,description);
    }

}