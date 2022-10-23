package responceValidators.impl;

import io.restassured.response.Response;
import org.json.JSONObject;
import responceValidators.ResponseValidator;

public class ResponseMetadataValidator implements ResponseValidator {
    private final Response response;

    public ResponseMetadataValidator(Response response) {
        this.response = response;
    }

    @Override
    public boolean validateField(String field, String value) {
        return new JSONObject(this.response.getBody().asPrettyString()).getString(field).equals(value);
    }

    @Override
    public boolean validateCode(int code) {
        return this.response.getStatusCode() == code;
    }
}
