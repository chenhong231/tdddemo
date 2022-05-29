package com.refactoring.tdddemo;

public class OrderService {

    private final KafkaSender kafkaSender = new KafkaSender();

    public void placeOrder(final int parameter) {
        kafkaSender.send(parameter);
    }

}
