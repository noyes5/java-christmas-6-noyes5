package christmas.domain.dto;

import christmas.domain.menu.Menu;

public record MenuItem(Menu menu, int quantity) {
}
