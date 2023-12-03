package org.mobiusone.networkmanager.tcpip.entity.layer2;

import org.mobiusone.networkmanager.core.entity.annotation.Entity;
import org.mobiusone.networkmanager.core.entity.layer2.DataLinkAddr;

@Entity(layer = 2)
public class MacAddr implements DataLinkAddr {
    private long addr;

    public MacAddr(long addr) {
        this.addr = addr;
    }

    public long getAddr() {
        return addr;
    }

    @Override
    public String toString() {
        long first = (addr>>40) & 255;
        long second = (addr>>32) & 255;
        long third = (addr>>24) & 255;
        long fourth = (addr>>16) & 255;
        long fifth = (addr>>8) & 255;
        long sixth = addr & 255;
        return String.format("%x:%x:%x:%x:%x:%x",first,second,third,fourth,fifth,sixth);
    }

    @Override
    protected Object clone() {
        return new MacAddr(addr);
    }
}
