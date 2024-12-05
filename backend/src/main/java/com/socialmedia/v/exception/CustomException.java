package com.socialmedia.v.exception;

public class CustomException extends RuntimeException{

    private String code;
    private String status;
    private String details;

    public CustomException(String code, String status , String details) {
        this.code = code;
        this.status = status;
        this.details = details;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "CustomException{" +
                "code=" + code +
                ", status='" + status + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
