package com.test

import java.time.LocalDate

fun main() {
    val orders = listOf(
        DeliveryOrder(1L, "112 Mammoth Street, Colorado Springs, CO 80911", LocalDate.of(2021, 9, 3)),
        DeliveryOrder(2L, "369 Woodside Court, Troy, NY 12180", LocalDate.of(2021, 9, 5)),
        DeliveryOrder(3L, "837 Bowman Street, Helena, MT 59601", LocalDate.of(2021, 9, 2)),
        DeliveryOrder(4L, "112 Mammoth Street, Colorado Springs, CO 80911", LocalDate.of(2021, 9, 3)),
        DeliveryOrder(5L, "112 Mammoth Street, Colorado Springs, CO 80911", LocalDate.of(2021, 10, 3)),
        DeliveryOrder(6L, "112 Mammoth Street, Colorado Springs, CO 80911", LocalDate.of(2021, 8, 3))
    )

    println(findFirstOrder(orders))
    println("----------------")
    printAddressesToDeliver(orders).forEach { println(it) }
}

// Метод find First Order принимает список заказов и должен возвращать первый / самый ранний заказ в списке в соответствии
// со значением поля DeliveryDate. Если список пуст, метод должен возвращать порядок, созданный его конструктором по умолчанию ("пустой порядок").
fun findFirstOrder(orders: List<DeliveryOrder?>): DeliveryOrder {
    return if (orders.isEmpty()) {
        DeliveryOrder()
    } else {
        sortDeliveryByDate(orders).first()
    }
}

// Метод печати адресов для доставки также использует список заказов и должен печатать адреса, отсортированные по
// дате доставки (от самой ранней до самой поздней), без дубликатов. Каждый адрес должен быть напечатан с новой строки.
// Если список содержит дубликаты, следует распечатать только первый заказ, чтобы избежать повторного посещения одного и того же адреса.
// Вернуть отсортированную коллекцию
fun printAddressesToDeliver(orders: Collection<DeliveryOrder?>) =
    sortDeliveryByDate(orders).distinctBy { it.address }


fun sortDeliveryByDate(orders: Collection<DeliveryOrder?>) =
    orders.filterNotNull().sortedByDescending { it.date }.reversed()

class DeliveryOrder(
    val id: Long = 0,
    val address: String = "",
    val date: LocalDate = LocalDate.now()
) {
    override fun toString(): String {
        return address
    }
}