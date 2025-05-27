package com.test

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.time.Period
import kotlin.compareTo

fun main() {
    val calendarRecords: List<CalendarRecordOutput> = listOf(
        CalendarRecordOutput(
            dateFrom = LocalDate.of(2025, 1, 9),
            dateTo = LocalDate.of(2025, 1, 12)
        ),
        CalendarRecordOutput(
            dateFrom = LocalDate.of(2025, 1, 14),
            dateTo = LocalDate.of(2025, 1, 18)
        )
    )

    println("входит " + checkExistDateInCalendarRecords(LocalDate.of(2025, 1, 12), calendarRecords))
    println("не входит " + checkExistDateInCalendarRecords(LocalDate.of(2025, 1, 13), calendarRecords))
    println("входит " + checkExistDateInCalendarRecords(LocalDate.of(2025, 1, 14), calendarRecords))


    println("входит " + checkExistPeriodInCalendarRecords(LocalDate.of(2025, 1, 10), LocalDate.of(2025, 1, 12), calendarRecords))
    println("не входит " + checkExistPeriodInCalendarRecords(LocalDate.of(2025, 1, 11), LocalDate.of(2025, 1, 14), calendarRecords))
    println("не входит " + checkExistPeriodInCalendarRecords(LocalDate.of(2025, 1, 13), LocalDate.of(2025, 1, 15), calendarRecords))



}

private fun checkExistDateInCalendarRecords(
    date: LocalDate,
    calendarRecords: List<CalendarRecordOutput>
): Boolean {
    return checkExistPeriodInCalendarRecords(date, date, calendarRecords)
}

private fun checkExistPeriodInCalendarRecords(
    from: LocalDate,
    to: LocalDate,
    calendarRecords: List<CalendarRecordOutput>
): Boolean {
    return calendarRecords
        .filter {it.dateFrom != null && it.dateTo != null}
        .map { getAllDatesFromPeriod(it.dateFrom!!, it.dateTo!!) }
        .flatten()
        .containsAll(
            getAllDatesFromPeriod(from, to)
        )
}

/**
 * Возвращает список дат на запрошенный период
 */
private fun getAllDatesFromPeriod(start: LocalDate, end: LocalDate): List<LocalDate> {
    return start.datesUntil(end.plusDays(1)).toList()
}

private fun getAllDaysFromPeriod(start: LocalDate, end: LocalDate): List<CalendarDay> {
    return start.datesUntil(end.plusDays(1)).map {
        CalendarDay(it)
    }.toList()
}

//data class CalendarDay(
//    val date: LocalDate,
//    val source: Source = Source.BY_SCHEDULE,
//    var dayType: DayType? = null,
//    val beginWorkTime: LocalTime? = null,
//    val endWorkTime: LocalTime? = null,
//)

//enum class Source {
//    BY_SCHEDULE, // из графика
//    OVERRIDE, // установленный индивидуально
//    ;
//}

//enum class DayType {
//    WORK, // рабочий
//    WEEKEND, // выходной
//    DAY_OFF, // отгул
//    SICK_DAY, // больничный
//    VACATION, // отпуск
//    ;
//}

//class WorkSchedule(
//    // Дата начала действия графика (действие по н.в., либо до даты начала следующего графика в списке)
//    val startDate: LocalDate = LocalDate.now(),
//    // Тип графика (фиксированный/скользящий)
//    val workType: WorkType = WorkType.FIX,
//    // Схема работы. Рабочие и выходные дни в одном массиве
//    val workChart: Array<DayDefinition> = emptyArray(),
//)

//enum class WorkType {
//    FIX, // фиксированный график
//    SLICE, // скользящий график
//    ;
//}

//data class DayDefinition(
//    // День недели
//    val dayOfWeek: DayOfWeek? = null,
//    // Тип дгя
//    val dayType: DayType? = null,
//    // Начала рабочего времени
//    val beginWorkTime: LocalTime? = null,
//    // Окончания рабочего времени
//    val endWorkTime: LocalTime? = null
//)

//data class CalendarRecordOutput(
//    var eventId: Int? = null,
//    var label: String = "",
//    var dayOfWeek: DayOfWeek? = null,
//    var dateFrom: LocalDate? = null,
//    var dateTo: LocalDate? = null,
//    var source: Source = Source.BY_SCHEDULE,
//    var dayType: DayType = DayType.WORK,
//    var beginWorkTime: LocalTime? = null,
//    var endWorkTime: LocalTime? = null,
//    var description: String? = null
//)