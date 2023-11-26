package org.mobiusone.networkmanager.entity.layer2;

import org.mobiusone.networkmanager.entity.Host;
import org.mobiusone.networkmanager.entity.layer3.Subnet;
import org.mobiusone.networkmanager.entity.layer3.L3Addr;
import org.mobiusone.networkmanager.entity.layer3.IPv4Addr;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NetworkInterface {
    private String name;
    private MacAddr addr;
    private List<Connection<? extends L3Addr>> connections;
    private Host host;

    public NetworkInterface(String name, MacAddr addr) {
        this.name = name;
        this.addr = addr;
        connections = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public MacAddr getAddr() {
        return addr;
    }

    public List<? extends Connection<? extends L3Addr>> getConnectionsByType(L3Addr.Type type){
        return connections.stream().filter(c -> c.getType() == type).collect(Collectors.toList());
    }

    public List<IPv4Connection> getIPv4Connections() {
        return getConnectionsByType(L3Addr.Type.IPv4).stream().map(connection -> (IPv4Connection)connection).collect(Collectors.toList());
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

    public IPv4Connection connectIPv4(Subnet<IPv4Addr> subnet, IPv4Addr addr){
        IPv4Connection connection = new IPv4Connection(this, subnet,addr);
        subnet.addConnection(connection);
        connections.add(connection);
        return connection;
    }

    public static abstract class Connection<T extends L3Addr>{
        private NetworkInterface networkInterface;
        private Subnet<T> subnet;

        public abstract L3Addr.Type getType();

        public Connection(NetworkInterface networkInterface, Subnet<T> subnet) {
            this.networkInterface = networkInterface;
            this.subnet = subnet;
        }

        public NetworkInterface getNetworkInterface() {
            return networkInterface;
        }
        public Subnet<T> getNetwork() {
            return subnet;
        }

        public abstract T getAddr();
    }

    public static class IPv4Connection extends Connection<IPv4Addr>{
        private IPv4Addr addr;

        @Override
        public L3Addr.Type getType() {
            return L3Addr.Type.IPv4;
        }

        private IPv4Connection(NetworkInterface networkInterface, Subnet<IPv4Addr> subnet, IPv4Addr addr) {
            super(networkInterface, subnet);
            this.addr = addr;
        }

        public IPv4Addr getAddr() {
            return addr;
        }
    }
}
