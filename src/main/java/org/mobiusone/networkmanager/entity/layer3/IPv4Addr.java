package org.mobiusone.networkmanager.entity.layer3;

public class IPv4Addr implements L3Addr {
    private int addr;
    private int prefixLength;

    private static final String ERR_INVALID_OCTET = "Invalid IP Address: The %s octet value '%d' is not valid. Each octet must be a value between 0 and 255.";
    public IPv4Addr(int first,int second,int third,int fourth, int prefixLength) {
        if (first < 0 || 255 < first) throw new IllegalArgumentException(String.format(ERR_INVALID_OCTET,"first",first));
        if (second < 0 || 255 < second) throw new IllegalArgumentException(String.format(ERR_INVALID_OCTET,"second",second));
        if (third < 0 || 255 < third) throw new IllegalArgumentException(String.format(ERR_INVALID_OCTET,"third",third));
        if (fourth < 0 || 255 < fourth) throw new IllegalArgumentException(String.format(ERR_INVALID_OCTET,"fourth",fourth));
        this.addr = (first<<24)|(second<<16)|(third<<8)|(fourth);
        this.prefixLength = prefixLength;
    }

    @Override
    public Type getType() {
        return Type.IPv4;
    }

    public String getAddressString(){
        int first = (addr>>24) & 255;
        int second = (addr>>16) & 255;
        int third = (addr>>8) & 255;
        int fourth = addr & 255;
        return String.format("%d.%d.%d.%d",first,second,third,fourth);
    }

    public boolean isNetworkAddress(){
        return (addr<<prefixLength)==0;
    }

    @Override
    public String toString() {
        return String.format("%s/%d",getAddressString(),prefixLength);
    }

    public static class Range{

    }

    public static class Util{

    }
}