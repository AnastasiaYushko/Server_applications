package org.example.network_operations;

public class ResponseEntity<T> {
    private T responseData;
    private int responseStatus;

    public ResponseEntity(T responseData, int responseStatus) {
        this.responseData = responseData;
        this.responseStatus = responseStatus;
    }

    public T getResponseData() {
        return responseData;
    }

    public void setResponseData(T responseData) {
        this.responseData = responseData;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public void setStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }
}

