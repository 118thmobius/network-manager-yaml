package org.mobiusone.networkmanager.entity;

import org.mobiusone.networkmanager.entity.layer2.NetworkInterface;
import org.mobiusone.networkmanager.entity.layer3.L3Addr;
import org.mobiusone.networkmanager.entity.layer3.Subnet;
import org.mobiusone.networkmanager.entity.layer7.Domain;

import java.util.*;
import java.util.stream.Collectors;

public class Config {
    private List<Domain> domains;
    private List<Subnet<? extends L3Addr>> subnets;
    private List<NetworkInterface> interfaces;
    private List<Host> hosts;

    public Config() {
        this.domains = new ArrayList<>();
        this.subnets = new ArrayList<>();
        this.interfaces = new ArrayList<>();
        this.hosts = new ArrayList<>();
    }

    public Config(List<Domain> domains, List<Subnet<? extends L3Addr>> subnets, List<NetworkInterface> interfaces, List<Host> hosts) {
        this.domains = domains;
        this.subnets = subnets;
        this.interfaces = interfaces;
        this.hosts = hosts;
    }

    public void addDomain(Domain domain){
        this.domains.add(domain);
    }

    public void addSubnets(Subnet<? extends L3Addr> subnet){
        this.subnets.add(subnet);
    }

    public void addNetworkInterface(NetworkInterface networkInterface){
        this.interfaces.add(networkInterface);
    }

    public void addHost(Host host){
        this.hosts.add(host);
    }

    public void print(){
        System.out.print("There are \n");

        // Subnet -> Hosts
        System.out.printf("%d subnets \n", subnets.size());
        subnets.forEach(n -> {
            System.out.printf("  - %s[%s] (%d connections)\n",n.getName(),n.getAddr().toString(),n.getConnections().size());
            Map<Boolean,List<NetworkInterface.Connection<? extends L3Addr>>> interfaces = n.getConnections().stream().collect(Collectors.partitioningBy(c -> c.getNetworkInterface().isInstalled()));
            Optional.ofNullable(interfaces.get(false)).ifPresent(notInstalled -> System.out.printf("    - *reserved* (%d connections)\n",notInstalled.size()));
            Optional.ofNullable(interfaces.get(true)).ifPresent(intalled -> intalled.stream().collect(Collectors.groupingBy(c -> c.getNetworkInterface().getHost())).forEach((host,connections) -> {
                System.out.printf("    - %s (%d connections)\n",host.getName(),connections.size());
                connections.forEach(c -> System.out.printf("      - %s[%s]\n",c.getNetworkInterface().getName(),c.getAddr()));
            }));
        });


        // Hosts
        System.out.printf("%d hosts \n",hosts.size());
        hosts.forEach(h -> System.out.printf("  - %s ( %d interfaces )\n",h.getName(),h.getInterfaces().size() ));

        Map<Boolean,Long> numOfInterfaces = interfaces.stream().collect(Collectors.partitioningBy(NetworkInterface::isInstalled,Collectors.counting()));
        System.out.printf("%d interfaces ( %d installed / %d not installed )\n",interfaces.size(),numOfInterfaces.getOrDefault(true,0L),numOfInterfaces.getOrDefault(false,0L));


    }

}
