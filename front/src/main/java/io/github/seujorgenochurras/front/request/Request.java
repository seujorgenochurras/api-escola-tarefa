package io.github.seujorgenochurras.front.request;

public abstract class Request {
    private String header;
    private String url;

    public String getUrl() {
        return url;
    }

    public Request setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getHeader() {
        return header;
    }

    public Request setHeader(String header) {
        this.header = header;
        return this;
    }
}

