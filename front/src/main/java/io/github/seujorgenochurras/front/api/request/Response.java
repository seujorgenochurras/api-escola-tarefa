package io.github.seujorgenochurras.front.api.request;

import java.net.http.HttpResponse;

public class Response {
    private int statusCode;
    private String body;

    public Response(){

    }
    public Response(HttpResponse<String> httpResponse){
        this.body = httpResponse.body();
        this.statusCode = httpResponse.statusCode();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Response setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Response setBody(String body) {
        this.body = body;
        return this;
    }
}
