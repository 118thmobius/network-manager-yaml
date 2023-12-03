package org.mobiusone.networkmanager.tcpip.entity.layer3;

import org.mobiusone.networkmanager.core.entity.layer3.Subnet;

public class IPv6Subnet extends Subnet<IPv6Addr> {
    public IPv6Subnet(String name, IPv6Addr addr) {
        super(name, addr);
    }
}
