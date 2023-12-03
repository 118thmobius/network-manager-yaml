package org.mobiusone.networkmanager.entity.layer3;

import org.mobiusone.networkmanager.entity.annotation.Entity;

@Entity(layer = 3)
public class IPv4Subnet extends Subnet<IPv4Addr>{

    public IPv4Subnet(String name, IPv4Addr addr) {
        super(name,addr);
    }
}
