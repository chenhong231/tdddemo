package com.refactoring.tdddemo;

public class ProducerRecord {
    private String record;
    private int parameter;

    public ProducerRecord(String record, int paramter) {
        this.record = record;
        this.parameter = paramter;
    }
}
