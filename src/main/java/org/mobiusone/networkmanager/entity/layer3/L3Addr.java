package org.mobiusone.networkmanager.entity.layer3;

public interface L3Addr {
    enum Type{
        IPv4,IPv6
    }

    Type getType();
}
