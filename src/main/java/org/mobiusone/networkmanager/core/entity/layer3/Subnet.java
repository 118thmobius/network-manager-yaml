package org.mobiusone.networkmanager.core.entity.layer3;

import org.mobiusone.networkmanager.core.entity.layer2.Connection;
import org.mobiusone.networkmanager.core.entity.layer2.DataLinkAddr;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Subnet<N extends NetworkAddr> {
    private String name;
    private N addr;
    private List<Connection<? extends DataLinkAddr,N>> connections;

    public Subnet(String name, N addr) {
        this.name = name;
        this.addr = addr;
        connections = new ArrayList<>();
    }

    public void connect(Connection<? extends DataLinkAddr,N> connection){
        connections.add(connection);
    }

    public String getName() {
        return name;
    }

    public N getAddr(){
        return addr;
    };

    public List<Connection<? extends DataLinkAddr,N>> getConnections() {
        return connections;
    }

    public <D extends DataLinkAddr> List<Connection<D,N>> getConnectionsByL2Type(Class<D> clazz) {
        return connections.stream().filter(c -> clazz.isInstance(c.getNetworkInterface().getL2Addr())).map(c -> (Connection<D,N>) c).collect(Collectors.toList());
    }
}
