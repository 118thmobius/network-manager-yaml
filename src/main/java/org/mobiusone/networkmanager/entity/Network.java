package org.mobiusone.networkmanager.entity;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private String name;
    private IPv4Addr addr;
    private List<NetworkInterface.Connection> connections;

    public Network(String name, IPv4Addr addr) {
        this.name = name;
        this.addr = addr;
        connections = new ArrayList<>();
    }

    public void addConnection(NetworkInterface.Connection connection){
        connections.add(connection);
    }

    public String getName() {
        return name;
    }

    public IPv4Addr getAddr() {
        return addr;
    }

    public List<NetworkInterface.Connection> getConnections() {
        return connections;
    }
}
