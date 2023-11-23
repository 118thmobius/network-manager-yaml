package org.mobiusone.networkmanager.entity;

import java.util.List;

public class Domain {
    private String name;
    private List<Record> records;
    public Domain(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public List<Record> getRecords() {
        return records;
    }
    public void addRecord(Record record){
        records.add(record);
    }

    public static class Record{
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
    }

    public static class ARecord extends Record{
        private IPv4Addr addr;

        public ARecord(Domain domain, String name, IPv4Addr addr) {
            super(domain, name);
            this.addr = addr;
        }
        public IPv4Addr getAddr() {
            return addr;
        }
    }
}
