package com.test.functional.java;

import com.test.functional.java.enums.PredicateCall;
import com.test.functional.java.model.IncomingCall;

public class Main {
    public static void main(String[] args) {
        CallGenerateProcessor callGenerateProcessor = new CallGenerateProcessor();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                IncomingCall incomingCall = callGenerateProcessor.getCall(i);
                PredicateCall currentCall = PredicateCall.values()[(int) (Math.random() * 4)];
                currentCall.predicate.process(incomingCall);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
