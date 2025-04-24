package com.test

//import com.ibm.icu.impl.ZoneMeta.getSystemTimeZone
//import java.time.DayOfWeek
import com.google.common.collect.Comparators.min
import com.google.common.collect.Comparators.max
import org.apache.poi.ss.formula.functions.Days
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalField
import java.util.*

//import java.time.Month

//import java.util.*
//import java.util.Calendar.*

fun main() {
    val currentDate = LocalDate.now()
    val year = currentDate.year

    val calendar: MutableList<DayOutput> = mutableListOf()

    for (i in 5 .. 31) {
        calendar.add(DayOutput(LocalDate.of(year, 3, i)))
    }
    val workSchedule = WorkSchedule(
        sizeWorkDays = 4,
        sizeWeekendDays = 2
    )

    println(workSchedule.startDate)

    calculateFixCalendar(calendar, workSchedule)
//    calculateSliceCalendar(calendar, workSchedule)



//    calendar.forEach {
//        println("${it.date}/${it.date.dayOfWeek}(${it.date.dayOfWeek.title()}) - ${it.dayType}")
//    }

    val firstDayInYear = LocalDate.of(year, 1, 1)
    val lastDayInYear = LocalDate.of(year, 12, 31)

    val pattern = DateTimeFormatter.ofPattern("d MMMM", Locale.forLanguageTag("ru-RU"));
    val pattern2 = DateTimeFormatter.ofPattern("d MMM", Locale.forLanguageTag("ru-RU"));
//    val pattern2 = DateTimeFormatter.ofPattern("dd MMMM uuuu")
//    val pattern3 = DateTimeFormatter.ofPattern("dd MMMM uuuu", Locale.of("ru", "RU"))

//    print(min(currentDate, firstDayInYear))
//    print(min(currentDate, lastDayInYear))
//    print(listOf(currentDate, firstDayInYear).min())
//    print(listOf(currentDate, firstDayInYear).max())

    println(firstDayInYear.format(pattern))
    println(currentDate.format(pattern2))


}

private fun print(calendar: LocalDate){
    println("Год ${calendar.year}")
    println("День недели ${calendar.dayOfWeek}")
    println("День года ${calendar.dayOfYear}")
    println("Месяц года ${calendar.month}")
    println("День месяца ${calendar.dayOfMonth}")
    println("---------------------------------")
}

private fun calculateFixCalendar(yearCalendar: List<DayOutput>, workSchedule: WorkSchedule){
    yearCalendar.filter { !it.date.isBefore(workSchedule.startDate) }
        .onEach {
            it.dayType = workSchedule.weeklyChart[it.date.dayOfWeek.value - 1]
        }
}

private fun calculateSliceCalendar(yearCalendar: List<DayOutput>, workSchedule: WorkSchedule){
    val chart = Array(workSchedule.sizeWorkDays) { DayType.WORK } + Array(workSchedule.sizeWeekendDays) { DayType.WEEKEND }
    var index = 0
    yearCalendar.filter { !it.date.isBefore(workSchedule.startDate) }
        .onEach {
            it.dayType = chart[index % chart.size]
            index++
        }
}

enum class DayType {
    WORK, // рабочий
    WEEKEND, // выходной
    DAY_OFF, // отгул
    SICK_DAY, // больничный
    VACATION, // отпуск
    ;
}

data class DayOutput(
    val date: LocalDate,
    var dayType: DayType? = null
)

class WorkSchedule(
    // Дата начала действия графика (действие по н.в., либо до даты начала следующего графика в списке)
    val startDate: LocalDate = LocalDate.MIN,
    // Тип графика (фиксированный/скользящий)
    val workType: WorkType = WorkType.FIX,
    // Еженедельный график (для фиксированного типа) - массив из 7-ми значений
    val weeklyChart: Array<DayType> = arrayOf(DayType.WORK, DayType.WORK, DayType.WORK, DayType.WORK, DayType.WORK, DayType.WEEKEND, DayType.WEEKEND),
    // Количество рабочих дней (для скользящего графика)
    val sizeWorkDays: Int = 0,
    // Количество выходных дней (для скользящего графика)
    val sizeWeekendDays: Int = 0,
    // Время начала рабочего дня
    val startTime: LocalTime = LocalTime.of(9, 0),
    // Время окончания рабочего дня
    val endTime: LocalTime = LocalTime.of(18, 0)
)

enum class WorkType {
    FIX, // фиксированный график
    SLICE, // скользящий график
    ;
}

fun DayOfWeek.title(): String {
    return when(this) {
        DayOfWeek.MONDAY -> "Понедельник"
        DayOfWeek.TUESDAY -> "Вторник"
        DayOfWeek.WEDNESDAY -> "Среда"
        DayOfWeek.THURSDAY -> "Четверг"
        DayOfWeek.FRIDAY -> "Пятница"
        DayOfWeek.SATURDAY -> "Суббота"
        DayOfWeek.SUNDAY -> "Воскресенье"
    }
}


