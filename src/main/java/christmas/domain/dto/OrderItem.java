package christmas.domain.dto;

import christmas.domain.menu.Menu;

public record OrderItem(Menu menu, int quantity) {
}
