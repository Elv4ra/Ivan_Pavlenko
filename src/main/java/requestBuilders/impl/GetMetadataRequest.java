package requestBuilders.impl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import requestBuilders.RequestBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public class GetMetadataRequest implements RequestBuilder {
    private final RequestSpecBuilder builder = new RequestSpecBuilder();

    public GetMetadataRequest(String accessToken, String path) throws URISyntaxException {
        this.setUrl()
                .setAuthorizationHeader(accessToken)
                .setData(path)
                .setContentType();
    }

    @Override
    public RequestSpecification build() {
        return this.builder.build();
    }

    private GetMetadataRequest setUrl() throws URISyntaxException {
        this.builder.setBaseUri(new URI("https://api.dropboxapi.com/2/files/get_metadata"));
        return this;
    }

    private GetMetadataRequest setAuthorizationHeader(String authorizationHeader) {
        this.builder.addHeader("Authorization", "Bearer " + authorizationHeader);
        return this;
    }

    private GetMetadataRequest setData(String path) {
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
