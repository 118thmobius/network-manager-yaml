package org.mobiusone.networkmanager.tcpip.entity.layer3;

import org.mobiusone.networkmanager.core.entity.annotation.Entity;
import org.mobiusone.networkmanager.core.entity.layer3.Subnet;

@Entity(layer = 3)
public class IPv4Subnet extends Subnet<IPv4Addr> {

    public IPv4Subnet(String name, IPv4Addr addr) {
        super(name,addr);
    }
}
