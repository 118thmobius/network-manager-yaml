package org.mobiusone.networkmanager.core.entity;

import org.mobiusone.networkmanager.core.entity.layer2.NetworkInterface;

import java.util.ArrayList;
import java.util.List;

public class Host {
    private String name;
    private List<NetworkInterface> interfaces;

    public Host(String name) {
        this.name = name;
        this.interfaces = new ArrayList<>();
    }

    public void addInterface(NetworkInterface networkInterface){
        networkInterface.setHost(this);
        interfaces.add(networkInterface);
    }

    public String getName() {
        return name;
    }

    public List<NetworkInterface> getInterfaces() {
        return interfaces;
    }
}
