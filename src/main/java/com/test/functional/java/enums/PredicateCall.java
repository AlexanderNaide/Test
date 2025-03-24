package com.test.functional.java.enums;

import com.test.functional.java.model.Predicate;
import com.test.functional.java.model.IncomingCall;

public enum PredicateCall {
    // Через анонимный класс
    CREATE_CONTACT(new Predicate(){
        @Override
        public void process(IncomingCall call){
            System.out.printf("Создан новый контакт %s %s\n", call.name, call.lastname);
        }
    }),
    // Через лямбда выражение
    CREATE_SMS(call -> {
        System.out.printf("Отправлено смс на номер %s\n", call.phone);
    }),
    ADDED_TO_BLACK_LIST(call -> {
        System.out.printf("Номер добавлен в блэк-лист: %s\n", call.phone);
    }),
    MAKE_AS_SPAM(call -> {
        System.out.println("Спам звонок");
    });

    public final Predicate predicate;

    PredicateCall(Predicate predicate) {
        this.predicate = predicate;
    }
}
