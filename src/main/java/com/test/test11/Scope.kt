package com.test.test11

enum class Scope (val scope: String) {
    TASK("task"),
    TASK_ACTIVITY("task_activity"),
    CONTACT("contact"),
    EMPLOYEE("employee"),
    PLANNER("planner"),
    PLANNER_FILTER("planner_filter"),
    CONTACT_GROUP("contact_group"),
    CUSTOM_FIELD("custom_field"),
    EMPLOYEE_GROUP("employee_group"),
    PROJECT("project"),
    WORKSPACE("workspace"),
    // тип для телеметрии, не связанной с работой в crm
    COMMONS("commons");

    companion object {
        fun fromValue(v: String): Scope {
            return values().first { item -> item.scope == v }
        }
    }

    override fun toString(): String {
        return scope
    }
}