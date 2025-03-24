package com.test.Test26_TemplateEngine.Engine

import com.test.Test26_TemplateEngine.resources.OperationMode

class FlyEngine : Engine {
    private val OPEN_TRIGGER = "\${{"
    private val CLOSE_TRIGGER = "}}"



    override fun readingTemplate(template: String, params: Map<String, String>): String {
        if (template.isBlank()){
            return ""
        }

        var cursor: Int = 0
//        val templ = template.byteInputStream()

        var mode: OperationMode = OperationMode.TEXT

        while (cursor <= template.length){
            val current: Char = template[cursor]


            cursor++
        }

        return ""
    }

    override fun parsingByTemplate(text: String, template: String): Map<String, String> {
        TODO("Not yet implemented")
    }

}