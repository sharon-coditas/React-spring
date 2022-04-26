package com.example.ReviewApp.userlogin;

public class ApiResponse {
    private Object data;
    private Object error;

    public ApiResponse(Object data, Object error) {
        this.data = data;
        this.error = error;
    }

    public ApiResponse(Object error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    @Override
    public String
    toString() {
        return "ApiResponse{" +
                "data=" + data +
                ", error=" + error +
                '}';
    }
}
