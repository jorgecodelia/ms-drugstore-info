package cl.code.ms.drugstore.info.common.util;

import cl.code.ms.drugstore.info.common.exception.DrugstoreInfoException;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validator {
    private final Pattern pattern = Pattern.compile("[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}");
    private final static String XSS_PATTERN = ".*[%<>&;'\0].*";

    public void validate(String key) throws DrugstoreInfoException {
        try {
            Matcher mather = pattern.matcher(key);
            if (key.isEmpty() || !mather.find() || key.matches(XSS_PATTERN)){
                throw new DrugstoreInfoException(Constant.VALIDATOR_ERROR);
            }
        }catch (Exception e) {
            throw new DrugstoreInfoException(Constant.VALIDATOR_ERROR);
        }
    }
}