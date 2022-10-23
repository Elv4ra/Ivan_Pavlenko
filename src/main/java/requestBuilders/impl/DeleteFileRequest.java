package requestBuilders.impl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import requestBuilders.RequestBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public class DeleteFileRequest implements RequestBuilder {
    private final RequestSpecBuilder builder = new RequestSpecBuilder();

    public DeleteFileRequest(String accessToken, String path) throws URISyntaxException {
        this.setUrl()
                .setAuthorizationHeader(accessToken)
                .setData(path)
                .setContentType();
    }

    @Override
    public RequestSpecification build() {
        return this.builder.build();
    }

    private DeleteFileRequest setUrl() throws URISyntaxException {
        this.builder.setBaseUri(new URI("https://api.dropboxapi.com/2/files/delete_v2"));
        return this;
    }

    private DeleteFileRequest setAuthorizationHeader(String authorizationHeader) {
        this.builder.addHeader("Authorization", "Bearer " + authorizationHeader);
        return this;
    }

    private DeleteFileRequest setData(String path) {
        this.builder.setBody(createArgJson(path).toString());
        return this;
    }

    private void setContentType() {
        this.builder.setContentType(ContentType.JSON);
    }

    private JSONObject createArgJson(String path) {
        JSONObject dataJson = new JSONObject();
        dataJson.put("path", path);
        return dataJson;
    }
}
