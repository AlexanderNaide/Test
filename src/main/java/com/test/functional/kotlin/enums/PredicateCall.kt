package com.test.functional.kotlin.enums

import com.test.functional.kotlin.model.IncomingCall
import com.test.functional.kotlin.model.Predicate

enum class PredicateCall(val predicate: Predicate) {
    // Через анонимный класс
    CREATE_CONTACT(
        fun(call: IncomingCall) {
            println("Создан новый контакт ${call.name} ${call.lastname}")
        }
    ),

    // Через анонимный класс
    CREATE_SMS(
        fun(call: IncomingCall) {
            println("Отправлено смс на номер ${call.phone}")
        }
    ),

    // Через лямбда выражение
    ADDED_TO_BLACK_LIST({ call ->
        println("Номер добавлен в блэк-лист: ${call.phone}")
    }),

    // Через лямбда выражение
    MAKE_AS_SPAM({
        println("Спам звонок отклонен")
    })
}