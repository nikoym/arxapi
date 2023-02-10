package com.example.arx.model;

import java.util.List;
import java.util.Map;

public class AnonymizedDataResponse {
    private List<String[]> data;
    private String status;

    public AnonymizedDataResponse(List<String[]> data, String status) {
        this.data = data;
        this.status = status;
    }

    public List<String[]> getData() {
        return data;
    }

    public void setData(List<String[]> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
