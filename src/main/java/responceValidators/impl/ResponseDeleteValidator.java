package responceValidators.impl;

import io.restassured.response.Response;
import org.json.JSONObject;
import responceValidators.ResponseValidator;

public class ResponseDeleteValidator implements ResponseValidator {
    private final Response response;

    public ResponseDeleteValidator(Response response) {
        this.response = response;
    }
    @Override
    public boolean validateCode(int code) {
        return this.response.getStatusCode() == code;
    }

    @Override
    public boolean validateField(String field, String value) {
        return new JSONObject(response.getBody().asPrettyString()).getJSONObject("metadata").getString(field).equals(value);
    }
}
