package org.mobiusone.networkmanager.entity.layer7;

import org.mobiusone.networkmanager.entity.annotation.Entity;
import org.mobiusone.networkmanager.entity.layer3.IPv4Addr;

import java.util.List;

@Entity(layer = 7)
public class Domain {
    private String name;
    private List<Record<?>> records;
    public Domain(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public List<Record<?>> getRecords() {
        return records;
    }
    public void addRecord(Record<?> record){
        records.add(record);
    }

    public static abstract class Record<T>{
        private Domain domain;
        private String name;

        public Record(Domain domain, String name) {
            this.domain = domain;
            this.name = name;
        }

        public Domain getDomain() {
            return domain;
        }

        public String getName() {
            return name;
        }

        public abstract T getValue();
        public abstract String getValueString();
    }

    public static class ARecord extends Record<IPv4Addr>{
        private IPv4Addr addr;

        public ARecord(Domain domain, String name, IPv4Addr addr) {
            super(domain, name);
            this.addr = addr;
        }

        @Override
        public IPv4Addr getValue() {
            return addr;
        }

        @Override
        public String getValueString() {
            return addr.toString();
        }
    }
}
