package com.WebAPI.testing.steps;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.Metadata;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.*;


public class GetPostSteps {
    private static final String ACCESS_TOKEN = "sl.BI6X8D6pbnQ-XO0lvYQSgiLSOJgsdIMPLKtZwnitryzsG5Q74cX4KU1R9kQno0jNOHkoMk18h1P-z3xpMhtP-loBulFMbJhSilGByx_Hs8zDd2wxNg8Ea25raxjB3i_xZ7QiIa4";
    private static DbxClientV2 client;
    private static Metadata metadataFromResponse;
    private static Metadata metadataFromRequest;

    @Given("^User has file \"([^\"]*)\" placed at root directory of the app$")
    public void userHasFileNamePlacedAtRootDirectoryOfTheApp(String name) throws IOException {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/WebAPITesting").build();
        client = new DbxClientV2(config, ACCESS_TOKEN);
        File file = new File(name);
        file.createNewFile();
    }

    @When("^User uploads file \"([^\"]*)\" to the Dropbox using API$")
    public void userUploadsFileToTheDropboxUsingAPI(String name) throws IOException, DbxException {
        InputStream in = new FileInputStream(name);
        metadataFromResponse = client.files().uploadBuilder("/" + name).uploadAndFinish(in);
    }

    @Then("API responses with metadata")
    public void apiResponsesWithMetadata() {
        Assert.assertNotNull(metadataFromResponse);
    }




    @Given("^User has already uploaded file \"([^\"]*)\" to the Dropbox$")
    public void userHasAlreadyUploadedFileToTheDropbox(String name) throws IOException, DbxException {
        if (metadataFromResponse == null) {
            DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/WebAPITesting").build();
            client = new DbxClientV2(config, ACCESS_TOKEN);
            new File(name).createNewFile();
            InputStream in = new FileInputStream(name);
            metadataFromResponse = client.files().uploadBuilder("/" + name).uploadAndFinish(in);
        }
    }

    @When("^User gets file \"([^\"]*)\" metadata using Dropbox API$")
    public void userGetFileMetadataUsingDropboxAPI(String name) throws DbxException {
        metadataFromRequest = client.files().getMetadata("/" + name);
    }

    @Then("metadata must be same as response from upload operation")
    public void metadataMustBeSameAsResponseFromUploadOperation() {
        Assert.assertEquals(metadataFromRequest, metadataFromResponse);
    }





    @When("^User deletes file \"([^\"]*)\" from Dropbox using API$")
    public void userDeletesFileFromDropboxUsingAPI(String name) throws DbxException {
        client.files().deleteV2("/" + name);
    }

    @Then("file is deleted")
    public void fileIsDeleted() throws DbxException {
        Assert.assertTrue(client.files().listFolder("").getEntries().isEmpty());
    }
}
