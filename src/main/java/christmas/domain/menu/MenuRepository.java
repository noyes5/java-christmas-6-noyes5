package christmas.domain.menu;

import christmas.domain.exception.MenuException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuRepository {
    private static final List<Menu> menus = new ArrayList<>();

    static {
        menus.add(new Menu("양송이수프", 6_000, Category.APPETIZER));
        menus.add(new Menu("타파스", 5_500, Category.APPETIZER));
        menus.add(new Menu("시저샐러드", 8_000, Category.APPETIZER));
        menus.add(new Menu("티본스테이크", 55_000, Category.MAIN));
        menus.add(new Menu("바비큐립", 54_000, Category.MAIN));
        menus.add(new Menu("해산물파스타", 35_000, Category.MAIN));
        menus.add(new Menu("크리스마스파스타", 25_000, Category.MAIN));
        menus.add(new Menu("초코케이크", 15_000, Category.DESSERT));
        menus.add(new Menu("아이스크림", 5_000, Category.DESSERT));
        menus.add(new Menu("제로콜라", 3_000, Category.BEVERAGE));
        menus.add(new Menu("레드와인", 60_000, Category.BEVERAGE));
        menus.add(new Menu("샴페인", 25_000, Category.BEVERAGE));
    }

    public static List<Menu> menus() {
        return Collections.unmodifiableList(menus);
    }

    public static Menu from(String name) {
        return menus.stream()
                .filter(menu -> menu.hasName(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(MenuException.INVALID_MENU_INPUT.getMessage()));
    }
}
