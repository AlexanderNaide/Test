package com.test.Test26_TemplateEngine.Engine

interface Engine {
    fun readingTemplate(template: String, params: Map<String, String>): String
    fun parsingByTemplate(text: String, template: String): Map<String, String>
}