package com.example.modelotcp_ip_app;

import java.util.LinkedList;

public class Layer {
    private String title;
    private String description;
    private String protocols;
    private String method;
    private LinkedList<Device> devices = new LinkedList<>();

    public Layer(String title, String description, String protocols, String method, LinkedList<Device> devices) {
        this.title = title;
        this.description = description;
        this.protocols = protocols;
        this.method = method;
        this.devices = devices;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProtocols() {
        return protocols;
    }

    public void setProtocols(String protocols) {
        this.protocols = protocols;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public LinkedList<Device> getDevices() {
        return devices;
    }

    public void setDevices(LinkedList<Device> devices) {
        this.devices = devices;
    }
}
