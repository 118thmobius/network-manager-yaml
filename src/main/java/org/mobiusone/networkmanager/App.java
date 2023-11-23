package org.mobiusone.networkmanager;

import org.mobiusone.networkmanager.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Domain> domains = new ArrayList<>();
        domains.add(new Domain("local.example.com"));

        List<Network> networks = new ArrayList<>();
        IPv4Addr networkAddr = new IPv4Addr(192,168,1,0,24);
        System.out.println(networkAddr.isNetworkAddress() ? "NETWORK ADDR OK":"NOT NETWORK ADDR");
        Network network = new Network("local",networkAddr);
        networks.add(network);

        List<NetworkInterface> interfaces = new ArrayList<>();
        NetworkInterface networkInterface = new NetworkInterface("enp1",new MacAddr());
        networkInterface.connectIPv4(network,new IPv4Addr(192,168,1,10,24));
        interfaces.add(networkInterface);

        List<Host> hosts = new ArrayList<>();
        Host host = new Host("sun");
        host.addInterface(networkInterface);
        hosts.add(host);

        networks.stream().forEach(network1 -> {
            System.out.println("Netowork:"+ network1.getName()+"("+ network1.getAddr()+")");
            network1.getConnections().stream().forEach(
                    connection -> {
                        System.out.println("Connected NIC:"+connection.getNetworkInterface().getName());
                        connection.getNetworkInterface().getIPv4Connections().forEach(iPv4Connection -> System.out.println(iPv4Connection.getAddr()));
                        if (connection.getNetworkInterface().getHost() == null) System.out.println("Not installed.");
                        else {
                            Host h = connection.getNetworkInterface().getHost();
                            System.out.println("Host "+ h.getName());
                        }
                    }
            );
        });
    }
}
