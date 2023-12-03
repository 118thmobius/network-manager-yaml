package org.mobiusone.networkmanager.core.entity.layer2;

import org.mobiusone.networkmanager.core.entity.Host;
import org.mobiusone.networkmanager.core.entity.layer3.NetworkAddr;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NetworkInterface<D extends DataLinkAddr> {
    private String name;
    private D addr;
    private List<Connection<D,? extends NetworkAddr>> connections;
    private Host host;

    public NetworkInterface(String name, D addr) {
        this.name = name;
        this.addr = addr;
        connections = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public D getL2Addr() {
        return addr;
    }

    public <N extends NetworkAddr> List<Connection<D,N>> getConnectionsByType(Class<N> clazz){
        return connections.stream().filter(c -> clazz.isInstance(c.getNetworkInterface().addr)).map(c -> (Connection<D,N>) c).collect(Collectors.toList());
    }

    public Host getHost() {
        return host;
    }

    public boolean isInstalled(){
        return host != null;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    <N extends NetworkAddr> void connect(Connection<D,N> connection){
        connections.add(connection);
    }
}
