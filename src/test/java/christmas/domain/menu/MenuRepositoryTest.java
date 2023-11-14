package christmas.domain.menu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuRepositoryTest {
    @DisplayName("메뉴 이름으로 메뉴를 찾는 테스트")
    @Test
    void 메뉴_이름으로_메뉴_찾기() {
        String existingMenuName = "양송이수프";
        Menu existingMenu = MenuRepository.from(existingMenuName);

        assertThat(existingMenu.getName()).isEqualTo(existingMenuName);
    }
    @DisplayName("없는메뉴 이름으로 메뉴를 찾을시 에러 테스트")
    @Test
    void 없는_메뉴_이름으로_메뉴_찾기() {
        String nonExistingMenuName = "멍멍이밥";
        assertThatThrownBy(() -> MenuRepository.from(nonExistingMenuName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("모든 메뉴 조회 테스트")
    @Test
    void 모든_메뉴_조회() {
        int expectedMenuCount = 12;
        int actualMenuCount = MenuRepository.menus().size();
        assertThat(expectedMenuCount).isEqualTo(actualMenuCount);
    }

}