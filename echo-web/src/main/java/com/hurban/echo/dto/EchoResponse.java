package com.hurban.echo.dto;

import java.util.Map;

public class EchoResponse {

    private Map<String, String> headers;
    private Map<String, String> params;
    private Map<String, String> body;

    public EchoResponse() {
    }

    public EchoResponse(Map<String, String> headers, Map<String, String> params, Map<String, String> body) {
        this.headers = headers;
        this.params = params;
        this.body = body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
    public Map<String, String> getParams() {
        return params;
    }
    public Map<String, String> getBody() {
        return body;
    }
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
    public void setParams(Map<String, String> params) {
        this.params = params;
    }
    public void setBody(Map<String, String> body) {
        this.body = body;
    }
    public EchoResponse withHeaders(Map<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public EchoResponse withParams(Map<String, String> params) {
        this.params = params;
        return this;
    }

    public EchoResponse withBody(Map<String, String> body) {
        this.body = body;
        return this;
    }

    public static EchoResponse build() {
        return new EchoResponse();
    }

    @Override
    public String toString() {
        return "EchoResponse{" +
                "headers=" + headers +
                ", params=" + params +
                ", body=" + body +
                '}';
    }
}
