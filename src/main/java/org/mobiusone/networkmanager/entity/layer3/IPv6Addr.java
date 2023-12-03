package org.mobiusone.networkmanager.entity.layer3;

public class IPv6Addr implements NetworkAddr {
    private long network;
    private long host;
    
    private IPv6Addr(long network, long host) {
        this.network = network;
        this.host = host;
    }

    @Override
    public String toAddrBodyString() {
        return "IPv6 Addr not implemented yet";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new IPv6Addr(this.network,this.host);
    }
}
