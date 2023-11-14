package christmas.dto;

import christmas.domain.Reservation;
import christmas.domain.menu.Orders;

public record OrderInfo(Reservation reservation, Orders orders) {
}
