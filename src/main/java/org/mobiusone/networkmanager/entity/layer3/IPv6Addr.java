package org.mobiusone.networkmanager.entity.layer3;

public class IPv6Addr implements L3Addr {
    @Override
    public Type getType() {
        return Type.IPv6;
    }
}
