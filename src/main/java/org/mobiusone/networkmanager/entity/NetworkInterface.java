package org.mobiusone.networkmanager.entity;

import java.util.ArrayList;
import java.util.List;

public class NetworkInterface {
    private String name;
    private MacAddr addr;
    private List<IPv4Connection> iPv4Connections;
    private Host host;

    public NetworkInterface(String name, MacAddr addr) {
        this.name = name;
        this.addr = addr;
        iPv4Connections = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public MacAddr getAddr() {
        return addr;
    }

    public List<IPv4Connection> getIPv4Connections() {
        return iPv4Connections;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public IPv4Connection connectIPv4(Network network, IPv4Addr addr){
        IPv4Connection connection = new IPv4Connection(this,network,addr);
        network.addConnection(connection);
        this.iPv4Connections.add(connection);
        return connection;
    }

    public static class Connection{
        private NetworkInterface networkInterface;
        private Network network;

        public Connection(NetworkInterface networkInterface, Network network) {
            this.networkInterface = networkInterface;
            this.network = network;
        }

        public NetworkInterface getNetworkInterface() {
            return networkInterface;
        }
        public Network getNetwork() {
            return network;
        }
    }

    public static class IPv4Connection extends Connection{
        private IPv4Addr addr;

        private IPv4Connection(NetworkInterface networkInterface, Network network, IPv4Addr addr) {
            super(networkInterface, network);
            this.addr = addr;
        }

        public IPv4Addr getAddr() {
            return addr;
        }
    }
}
