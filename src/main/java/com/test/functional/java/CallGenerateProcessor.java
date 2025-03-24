package com.test.functional.java;

import com.test.functional.java.enums.PredicateCall;
import com.test.functional.java.model.IncomingCall;

public class CallGenerateProcessor {

    public IncomingCall getCall(int number){
        IncomingCall call = new IncomingCall();
        call.name = "name" + number;
        call.lastname = "lastname" + number;
        call.phone = "8908121683" + number;
        return call;
    }
}
