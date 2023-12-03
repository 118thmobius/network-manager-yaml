package org.mobiusone.networkmanager.entity.layer2;

import org.mobiusone.networkmanager.entity.layer3.NetworkAddr;
import org.mobiusone.networkmanager.entity.layer3.Subnet;

public abstract class ConnectionManager<D extends DataLinkAddr,N extends NetworkAddr> {
    public abstract Connection<D,N> connect(NetworkInterface<D> networkInterface, Subnet<N> subnet, N addr);
}
