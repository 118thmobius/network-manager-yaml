package org.mobiusone.networkmanager.entity;

import java.util.ArrayList;
import java.util.List;

public class Config {
    private List<Domain> domains;
    private List<Network> networks;
    private List<NetworkInterface> interfaces;
    private List<Host> hosts;

    public Config() {
        this.domains = new ArrayList<>();
        this.networks = new ArrayList<>();
        this.interfaces = new ArrayList<>();
        this.hosts = new ArrayList<>();
    }

    public Config(List<Domain> domains, List<Network> networks, List<NetworkInterface> interfaces, List<Host> hosts) {
        this.domains = domains;
        this.networks = networks;
        this.interfaces = interfaces;
        this.hosts = hosts;
    }
}
