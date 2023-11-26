package org.mobiusone.networkmanager;

import org.mobiusone.networkmanager.entity.*;
import org.mobiusone.networkmanager.entity.layer2.MacAddr;
import org.mobiusone.networkmanager.entity.layer2.NetworkInterface;
import org.mobiusone.networkmanager.entity.layer3.IPv4Addr;
import org.mobiusone.networkmanager.entity.layer3.IPv4Subnet;
import org.mobiusone.networkmanager.entity.layer3.IPv6Addr;
import org.mobiusone.networkmanager.entity.layer3.Subnet;
import org.mobiusone.networkmanager.entity.layer7.Domain;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Config config = new Config();

        config.addDomain(new Domain("local.example.com"));

        IPv4Addr networkAddr = new IPv4Addr(192,168,1,0,24);
        IPv4Subnet subnet = new IPv4Subnet("local",networkAddr);
        config.addSubnets(subnet);

        NetworkInterface networkInterface = new NetworkInterface("enp1",new MacAddr());
        networkInterface.connectIPv4(subnet,new IPv4Addr(192,168,1,10,24));
        config.addNetworkInterface(networkInterface);

        Host host = new Host("sun");
        host.addInterface(networkInterface);
        config.addHost(host);

        config.print();
    }
}
