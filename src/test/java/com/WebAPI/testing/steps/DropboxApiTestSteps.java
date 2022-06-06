package com.WebAPI.testing.steps;

import requestBuilders.RequestBuilder;
import requestBuilders.impl.DeleteFileRequest;
import requestBuilders.impl.GetMetadataRequest;
import requestBuilders.impl.UploadFileRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import responceValidators.impl.ResponseDeleteValidator;
import responceValidators.impl.ResponseMetadataValidator;
import responceValidators.ResponseValidator;

import java.io.*;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.*;


public class DropboxApiTestSteps {
    private static final String ACCESS_TOKEN = "sl.BJBNAIBPyTd9wFTnkeYssMitrLkXQFhcYoR83YAyVkrQagLL7-gGoTOMjLm3oqNaGgNZuP1W0y9cD4yKk8TQtL3dVaILYC4zbwkaLfu8HqGqERttSFwwgtAnmx2JCCc0JnxOPf4";
    private static RequestBuilder builder;
    private static RequestSpecification request;
    private static ResponseValidator validator;

    @Given("^User has file \"([^\"]*)\" placed at root directory of the app$")
    public void userHasFileNamePlacedAtRootDirectoryOfTheApp(String name) throws IOException, URISyntaxException {
        new File(name).createNewFile();
        builder = new UploadFileRequest(ACCESS_TOKEN, "/" + name);
        request = given().spec(builder.build());
    }

    @When("^User uploads file to the Dropbox using API$")
    public void userUploadsFileToTheDropboxUsingAPI() {
        validator = new ResponseMetadataValidator(request.when().post());
    }

    @Then("^API responses with file \"([^\"]*)\" metadata$")
    public void apiResponsesWithMetadata(String name) {
        Assert.assertTrue(validator.validateCode(200));
        Assert.assertTrue(validator.validateField("name", name));
    }




    @Given("^User has already uploaded file \"([^\"]*)\" to the Dropbox$")
    public void userHasAlreadyUploadedFileToTheDropbox(String name) throws IOException, URISyntaxException {
        if (request == null) {
            new File(name).createNewFile();
            builder = new UploadFileRequest(ACCESS_TOKEN, "/" + name);
            given().spec(builder.build()).post();
        }
        builder = new GetMetadataRequest(ACCESS_TOKEN, "/" + name);
        request = given().spec(builder.build());
    }

    @When("^User gets file metadata using Dropbox API$")
    public void userGetFileMetadataUsingDropboxAPI() {
        validator = new ResponseMetadataValidator(request.when().post());
    }



    @Given("^User has file \"([^\"]*)\" in the Dropbox storage$")
    public void userHasFileInTheDropboxStorage(String name) throws IOException, URISyntaxException {
        if (request == null) {
            new File(name).createNewFile();
            builder = new UploadFileRequest(ACCESS_TOKEN, "/" + name);
            given().spec(builder.build()).post();
        }
        builder = new DeleteFileRequest(ACCESS_TOKEN, "/" + name);
        request = given().spec(builder.build());
    }

    @When("User deletes file from Dropbox using API")
    public void userDeletesFileFromDropboxUsingAPI(){
        validator = new ResponseDeleteValidator(request.when().post());
    }

    @Then("^API responses with deleted file \"([^\"]*)\" metadata$")
    public void fileIsDeleted(String name) {
        Assert.assertTrue(validator.validateCode(200));
        Assert.assertTrue(validator.validateField("name", name));
    }
}
