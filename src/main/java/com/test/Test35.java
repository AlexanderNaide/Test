package com.test;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test35 {
    public static void main(String[] args) {
        List<DeliveryOrderJ> orders = List.of(
                new DeliveryOrderJ(1L, "112 Mammoth Street, Colorado Springs, CO 80911", LocalDate.of(2021, 9, 3)),
                new DeliveryOrderJ(2L, "369 Woodside Court, Troy, NY 12180", LocalDate.of(2021, 9, 5)),
                new DeliveryOrderJ(3L, "837 Bowman Street, Helena, MT 59601", LocalDate.of(2021, 9, 2)),
                new DeliveryOrderJ(4L, "112 Mammoth Street, Colorado Springs, CO 80911", LocalDate.of(2021, 9, 3)),
                new DeliveryOrderJ(5L, "112 Mammoth Street, Colorado Springs, CO 80911", LocalDate.of(2021, 10, 3)),
                new DeliveryOrderJ(6L, "112 Mammoth Street, Colorado Springs, CO 80911", LocalDate.of(2021, 8, 3))
        );

        System.out.println(findFirstOrder(orders));
        printAddressesToDeliver(orders).forEach(System.out::println);
    }


    // Метод find First Order принимает список заказов и должен возвращать первый / самый ранний заказ в списке в соответствии
    // со значением поля DeliveryDate. Если список пуст, метод должен возвращать порядок, созданный его конструктором по умолчанию ("пустой порядок").
    public static DeliveryOrderJ findFirstOrder(List<DeliveryOrderJ> orders) {
        DeliveryOrderJ result;
        if (orders.isEmpty()) {
            result = new DeliveryOrderJ();
        } else {
            result = sortDeliveryByDate(orders).get(0);
        }
        return result;
    }

    // Метод печати адресов для доставки также использует список заказов и должен печатать адреса, отсортированные по
    // дате доставки (от самой ранней до самой поздней), без дубликатов. Каждый адрес должен быть напечатан с новой строки.
    // Если список содержит дубликаты, следует распечатать только первый заказ, чтобы избежать повторного посещения одного и того же адреса.
    // Вернуть отсортированную коллекцию
    public static Collection<DeliveryOrderJ> printAddressesToDeliver(Collection<DeliveryOrderJ> orders) {
        return (Collection<DeliveryOrderJ>) sortDeliveryByDate(new ArrayList(orders)).stream().map(order -> ((DeliveryOrderJ) order).address).collect(Collectors.toSet());
    }

    public static List<DeliveryOrderJ> sortDeliveryByDate(List<DeliveryOrderJ> orders) {
        return orders.stream()
                .sorted(Comparator.comparing(DeliveryOrderJ::getDate, Comparator.nullsFirst(LocalDate::compareTo)))
                .toList();
    }
}

class DeliveryOrderJ {
    @Getter
    Long id;
    String address;
    @Getter
    LocalDate date;

    public DeliveryOrderJ() {
    }

    public DeliveryOrderJ(Long id, String address, LocalDate date) {
        this.id = id;
        this.address = address;
        this.date = date;
    }

}