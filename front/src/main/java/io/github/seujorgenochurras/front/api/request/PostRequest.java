package io.github.seujorgenochurras.front.api.request;

import io.github.seujorgenochurras.front.api.util.RequestUtils;

import java.net.http.HttpRequest;

public class PostRequest extends Request {
    private String body;

    public PostRequest(String mapping) {
        this.setUrl(mapping);
    }

    public String getBody() {
        return body;
    }

    public PostRequest body(String body) {
        this.body = body;
        return this;
    }

    public Response request() {
        return new Response(RequestUtils.makePostRequestTo(getUrl(), HttpRequest.BodyPublishers.ofString(body)));
    }
}
