package com.test

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.time.Period

fun main() {
    val firstDate = LocalDate.of(2024, 12, 30)
    val secondDate = LocalDate.of(2025, 1, 9)

    val schedule = WorkSchedule(
        startDate = firstDate,
        workType = WorkType.SLICE,
        workChart = arrayOf(
            DayDefinition(dayType = DayType.WORK),
            DayDefinition(dayType = DayType.WORK),
            DayDefinition(dayType = DayType.WEEKEND),
            DayDefinition(dayType = DayType.WEEKEND),
        ))

    val yearCalendar = listOf(
        CalendarDay(date = LocalDate.of(2025, 1, 1)),
        CalendarDay(date = LocalDate.of(2025, 1, 2)),
        CalendarDay(date = LocalDate.of(2025, 1, 3)),
        CalendarDay(date = LocalDate.of(2025, 1, 4)),
        CalendarDay(date = LocalDate.of(2025, 1, 5)),
        CalendarDay(date = LocalDate.of(2025, 1, 6)),
        CalendarDay(date = LocalDate.of(2025, 1, 7)),
        CalendarDay(date = LocalDate.of(2025, 1, 8)),
        CalendarDay(date = LocalDate.of(2025, 1, 9)),
        CalendarDay(date = LocalDate.of(2025, 1, 10)),
    )

    fillingCalendarBySliceWorkType(yearCalendar, schedule)

    yearCalendar.forEach { day ->
        println("${day.date} - ${day.dayType}")
    }


}

private fun fillingCalendarBySliceWorkType(yearCalendar: List<CalendarDay>, workSchedule: WorkSchedule){
    val chart = workSchedule.workChart
    var index = if (workSchedule.startDate.isBefore(yearCalendar.first().date)) Period.between(workSchedule.startDate, yearCalendar.first().date).days else 0
    println("--- $index")
    yearCalendar
        .filter { !it.date.isBefore(workSchedule.startDate) }
        .filter { it.dayType == null }
        .forEach {
            it.dayType = chart[index % chart.size].dayType
            index++
        }
}

data class CalendarDay(
    val date: LocalDate,
    val source: Source = Source.BY_SCHEDULE,
    var dayType: DayType? = null,
    val beginWorkTime: LocalTime? = null,
    val endWorkTime: LocalTime? = null,
)

enum class Source {
    BY_SCHEDULE, // из графика
    OVERRIDE, // установленный индивидуально
    ;
}

enum class DayType {
    WORK, // рабочий
    WEEKEND, // выходной
    DAY_OFF, // отгул
    SICK_DAY, // больничный
    VACATION, // отпуск
    ;
}

class WorkSchedule(
    // Дата начала действия графика (действие по н.в., либо до даты начала следующего графика в списке)
    val startDate: LocalDate = LocalDate.now(),
    // Тип графика (фиксированный/скользящий)
    val workType: WorkType = WorkType.FIX,
    // Схема работы. Рабочие и выходные дни в одном массиве
    val workChart: Array<DayDefinition> = emptyArray(),
)

enum class WorkType {
    FIX, // фиксированный график
    SLICE, // скользящий график
    ;
}

data class DayDefinition(
    // День недели
    val dayOfWeek: DayOfWeek? = null,
    // Тип дгя
    val dayType: DayType? = null,
    // Начала рабочего времени
    val beginWorkTime: LocalTime? = null,
    // Окончания рабочего времени
    val endWorkTime: LocalTime? = null
)

data class CalendarRecordOutput(
    var eventId: Int? = null,
    var label: String = "",
    var dayOfWeek: DayOfWeek? = null,
    var dateFrom: LocalDate? = null,
    var dateTo: LocalDate? = null,
    var source: Source = Source.BY_SCHEDULE,
    var dayType: DayType = DayType.WORK,
    var beginWorkTime: LocalTime? = null,
    var endWorkTime: LocalTime? = null,
    var description: String? = null
)