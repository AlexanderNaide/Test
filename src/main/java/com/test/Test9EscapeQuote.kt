package com.test

import com.mysql.cj.x.protobuf.MysqlxExpr
import java.util.regex.Pattern

class Test9EscapeQuote {

    companion object {
        val escapeChars = "\\\\.?![]{}()<>*+-=^\$|\'"

        val SPECIAL_REGEX_CHARS = Pattern.compile("[{}()\\[\\].'+*?^$\\\\|]")
//        val SPECIAL_REGEX_CHARS = Pattern.compile("\\\\.?![]{}()<>*+-=^\$|\'")

        fun escapeQuotes (string: String) : String {
            return if (string.isNotEmpty()){
                string.replace("[\\W]", "\\\\$0")
            } else {
                ""
            }
        }
    }

}
fun main(){

    var matched = "(Hello'friend)"
    val regexExpGroup = Test9EscapeQuote.escapeQuotes(matched)

    println(regexExpGroup)

    matched = matched.replace("\'", "\\\'")

    println(escapeSpecialRegexChars(matched))



}

fun escapeSpecialRegexChars(str: String) : String {
    return Test9EscapeQuote.SPECIAL_REGEX_CHARS.matcher(str).replaceAll("\\\\$0")
}