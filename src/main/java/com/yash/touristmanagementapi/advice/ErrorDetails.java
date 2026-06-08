package com.yash.touristmanagementapi.advice;

import java.time.LocalDateTime;

public class ErrorDetails {
    private String type;
    private String message;
    private LocalDateTime ldt;

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "type='" + type + '\'' +
                ", message='" + message + '\'' +
                ", ldt=" + ldt +
                '}';
    }

    public ErrorDetails() {
    }

    public ErrorDetails(String type, String message, LocalDateTime ldt) {
        this.type = type;
        this.message = message;
        this.ldt = ldt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLdt() {
        return ldt;
    }

    public void setLdt(LocalDateTime ldt) {
        this.ldt = ldt;
    }
}
