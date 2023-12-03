package org.mobiusone.networkmanager.entity.layer2;

import org.mobiusone.networkmanager.entity.layer3.NetworkAddr;
import org.mobiusone.networkmanager.entity.layer3.Subnet;

public abstract class Connection<D extends DataLinkAddr,N extends NetworkAddr>{
    private NetworkInterface<D> networkInterface;
    private Subnet<N> subnet;
    private N addr;

    protected Connection(NetworkInterface<D> networkInterface, Subnet<N> subnet, N addr) {
        this.networkInterface = networkInterface;
        this.subnet = subnet;
        this.addr = addr;
        networkInterface.connect(this);
        subnet.connect(this);
    }

    public NetworkInterface<D> getNetworkInterface() {
        return networkInterface;
    }

    public Subnet<N> getSubnet() {
        return subnet;
    }

    public N getAddr() {
        return addr;
    }
}
