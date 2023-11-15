package christmas.domain.menu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuTest {
    @DisplayName("메뉴가 같으면 같은 객체인지 테스트")
    @Test
    void 두_메뉴가_같은지_검증() {
        Menu getMenu = MenuRepository.from("양송이수프");
        Menu realMenu = new Menu("양송이수프", 6_000, Category.APPETIZER);

        assertThat(getMenu).isEqualTo(realMenu);
    }
    @DisplayName("메뉴 속성이 다르면 다른 객체인지 테스트")
    @Test
    void 두_메뉴가_같지않은지_검증() {
        Menu getMenu = MenuRepository.from("양송이수프");
        Menu realMenu = new Menu("양송이수프", 15_000, Category.APPETIZER);

        assertThat(getMenu).isNotEqualTo(realMenu);
    }
}
