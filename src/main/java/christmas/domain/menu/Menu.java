package christmas.domain.menu;

import java.util.Objects;

public class Menu {
    private final int price;
    private final String name;
    private final Category category;

    public Menu(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public boolean hasName(String inputName) {
        return name.equals(inputName);
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        return price == menu.price && Objects.equals(name, menu.name) && category == menu.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name, category);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}
