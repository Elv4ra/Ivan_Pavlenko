package requestBuilders.impl;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import requestBuilders.RequestBuilder;

import java.net.URI;
import java.net.URISyntaxException;

import static io.restassured.config.EncoderConfig.encoderConfig;


public class UploadFileRequest implements RequestBuilder {
    private final RequestSpecBuilder builder = new RequestSpecBuilder();

    public UploadFileRequest(String accessToken, String dropboxApiArg) throws URISyntaxException {
        this.setUrl()
                .setAuthorizationHeader(accessToken)
                .setDropboxApiArgHeader(dropboxApiArg)
                .setContentType();
    }

    @Override
    public RequestSpecification build() {
        return this.builder.build();
    }

    private UploadFileRequest setUrl() throws URISyntaxException {
        this.builder.setBaseUri(new URI("https://content.dropboxapi.com/2/files/upload"));
        return this;
    }

    private UploadFileRequest setAuthorizationHeader(String authorizationHeader) {
        this.builder.addHeader("Authorization", "Bearer " + authorizationHeader);
        return this;
    }

    private UploadFileRequest setDropboxApiArgHeader(String path) {
        this.builder.addHeader("Dropbox-API-Arg", createArgJson(path).toString());
        return this;
    }

    private void setContentType() {
        this.builder.setConfig(RestAssured.config()
                .encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .setContentType(ContentType.BINARY);
    }

    private JSONObject createArgJson(String path) {
        JSONObject dropboxApiArgJson = new JSONObject();
        dropboxApiArgJson.put("path", path);
        return dropboxApiArgJson;
    }
}
