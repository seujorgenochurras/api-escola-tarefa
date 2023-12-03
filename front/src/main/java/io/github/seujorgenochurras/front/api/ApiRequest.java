package io.github.seujorgenochurras.front.api;

import io.github.seujorgenochurras.front.request.PostRequest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;
public class ApiRequest  {
    private static final HttpClient client = HttpClient.newHttpClient();

    private ApiRequest() {
    }

    private static final Logger logger = Logger.getLogger(ApiRequest.class.getName());

    public static  PostRequest postRequest(String mapping){
        return new PostRequest(mapping);
    }
    public static  PostRequest postRequest(DefaultMappings mapping){
        return new PostRequest(mapping.getMapping());
    }

}
