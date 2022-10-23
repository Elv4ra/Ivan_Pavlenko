package responceValidators;

public interface ResponseValidator {
    boolean validateCode(int code);
    boolean validateField(String field, String value);
}
