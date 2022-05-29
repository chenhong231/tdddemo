package com.refactoring.tdddemo;

public class KafkaSender implements Sender {
    private KafkaProducer producer;

    public KafkaSender() {
    }

    @Override
    public void send(int parameter) {
        producer.send(new ProducerRecord("record", parameter));
    }
}