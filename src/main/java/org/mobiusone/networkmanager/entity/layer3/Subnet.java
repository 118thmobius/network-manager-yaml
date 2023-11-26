package org.mobiusone.networkmanager.entity.layer3;

import org.mobiusone.networkmanager.entity.layer2.NetworkInterface;
import org.mobiusone.networkmanager.entity.layer3.IPv4Addr;
import org.mobiusone.networkmanager.entity.layer3.L3Addr;

import java.util.ArrayList;
import java.util.List;

/**
 * Subnetを表すエンティティ。
 */
public abstract class Subnet<T extends L3Addr> {
    private String name;
    private T addr;
    private List<NetworkInterface.Connection<T>> connections;

    public Subnet(String name,T addr) {
        this.name = name;
        this.addr = addr;
        connections = new ArrayList<>();
    }

    public void addConnection(NetworkInterface.Connection<T> connection){
        connections.add(connection);
    }

    public String getName() {
        return name;
    }

    public T getAddr(){
        return addr;
    };

    public List<NetworkInterface.Connection<T>> getConnections() {
        return connections;
    }
}
