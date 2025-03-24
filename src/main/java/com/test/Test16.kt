package com.test

import com.ibm.icu.impl.ICUResourceBundle
import com.ibm.icu.text.MessageFormat
import com.ibm.icu.text.PluralFormat
import com.ibm.icu.text.PluralRules
import com.ibm.icu.text.RuleBasedNumberFormat
import com.ibm.icu.util.ULocale
import java.text.FieldPosition


fun main() {

//    val locRu: ULocale = ULocale("RU")
//
//    val patRu = "одна{Собака} две{Собаки} пять{Собак}"
//
//    val plfmtRu = PluralFormat(locRu, patRu)
//    val msgfmtRu = MessageFormat("{0,number} {1}", locRu)
//
//    val numbers = arrayOf(0, 1, 2, 3, 4, 5, 6, 10, 14, 17, 34, 48, 101, 214, 348)
//
//    for (num in numbers) {
//        val msgRu = StringBuffer()
//
//        msgfmtRu.format(arrayOf<Any>(num, plfmtRu.format(num)), msgRu, FieldPosition(0))
//
//        println(String.format("%-16s%-16s%-16s\n", num, msgRu))
//
//    }

    println()


    val locRu = ULocale("RU")

    val patRu = "one{стул} few{стула} many{стульев} other{стульев}"

    val plfmtRu = PluralFormat(locRu, patRu)
    val plfmtRu2 = PluralFormat(locRu, PluralRules.PluralType.CARDINAL, patRu)

    val msgfmtRu = MessageFormat("{0,number} {1}", locRu)

    val numbers = intArrayOf(0, 1, 2, 3, 4, 5, 10, 100, 101, 102)
    System.out.printf("%-16s%-16s\n", "Number", "Русский")

    for (num in numbers) {
        val msgRu = StringBuffer()
        msgfmtRu.format(arrayOf<Any>(num, plfmtRu.format(num.toDouble())), msgRu, FieldPosition(0))

        System.out.printf("%-16s%-16s\n", num, msgRu)
    }

    println()


    val msgPatRu = "{0, plural, one{# пес} few{# пса} many{# псов} other{# псов}}"

    val altMsgfmtRu = MessageFormat(msgPatRu, locRu)
    System.out.printf("%-16s%-16s\n", "Number", "Русский")
    for (num in numbers) {
        val msgRu = StringBuffer()

        altMsgfmtRu.format(arrayOf<Any>(num), msgRu, FieldPosition(0))

        System.out.printf("%-16s%-16s\n", num, msgRu)
    }

}