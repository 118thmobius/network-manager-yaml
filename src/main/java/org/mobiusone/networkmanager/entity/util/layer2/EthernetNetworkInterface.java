package org.mobiusone.networkmanager.entity.util.layer2;

import org.mobiusone.networkmanager.entity.layer2.Connection;
import org.mobiusone.networkmanager.entity.layer2.ConnectionManager;
import org.mobiusone.networkmanager.entity.layer2.NetworkInterface;
import org.mobiusone.networkmanager.entity.layer3.IPv4Addr;
import org.mobiusone.networkmanager.entity.layer3.IPv6Addr;
import org.mobiusone.networkmanager.entity.layer3.NetworkAddr;
import org.mobiusone.networkmanager.entity.layer3.Subnet;

public class EthernetNetworkInterface extends NetworkInterface<MacAddr> {

    public static ConnectionManager<MacAddr,IPv4Addr> iPv4ConnectionManager = new IPv4ConnectionManager();
    public static ConnectionManager<MacAddr,IPv6Addr> iPv6ConnectionManager = new IPv6ConnectionManager();

    public EthernetNetworkInterface(String name, MacAddr addr) {
        super(name, addr);
    }

    public static abstract class EthernetConnection<N extends NetworkAddr> extends Connection<MacAddr,N> {
        public EthernetConnection(NetworkInterface<MacAddr> networkInterface, Subnet<N> subnet, N addr) {
            super(networkInterface, subnet, addr);
        }
    }

    private static class IPv4ConnectionManager extends ConnectionManager<MacAddr,IPv4Addr>{
        private IPv4ConnectionManager(){}
        @Override
        public Connection<MacAddr, IPv4Addr> connect(NetworkInterface<MacAddr> networkInterface, Subnet<IPv4Addr> subnet, IPv4Addr addr) {
            return new IPv4Connection(networkInterface,subnet,addr);
        }
    }

    private static class IPv6ConnectionManager extends ConnectionManager<MacAddr,IPv6Addr>{
        private IPv6ConnectionManager(){}
        @Override
        public Connection<MacAddr, IPv6Addr> connect(NetworkInterface<MacAddr> networkInterface, Subnet<IPv6Addr> subnet, IPv6Addr addr) {
            return new IPv6Connection(networkInterface,subnet,addr);
        }
    }

    public static class IPv4Connection extends EthernetConnection<IPv4Addr>{
        private IPv4Connection(NetworkInterface<MacAddr> networkInterface, Subnet<IPv4Addr> subnet, IPv4Addr addr) {
            super(networkInterface, subnet, addr);
        }
    }

    public static class IPv6Connection extends EthernetConnection<IPv6Addr>{
        public IPv6Connection(NetworkInterface<MacAddr> networkInterface, Subnet<IPv6Addr> subnet, IPv6Addr addr) {
            super(networkInterface, subnet, addr);
        }
    }
}
