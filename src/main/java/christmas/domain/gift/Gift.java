package christmas.domain.gift;

import static christmas.domain.gift.GiftList.DECEMBER_GIFT;

import christmas.domain.Money;
import christmas.dto.MenuItem;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuRepository;
import java.util.ArrayList;
import java.util.List;

public class Gift {
    private List<MenuItem> gifts;

    public Gift(Money totalMoney) {
        this.gifts = createGifts(totalMoney);
    }

    private List<MenuItem> createGifts(Money totalMoney) {
        List<MenuItem> gifts = new ArrayList<>();
        if (totalMoney.exceedsGiftPrice()) {
            Menu giftMenu = MenuRepository.from(DECEMBER_GIFT.getMenuName());
            int quantity = DECEMBER_GIFT.getAmount();
            MenuItem giftMenuItem = new MenuItem(giftMenu, quantity);
            gifts.add(giftMenuItem);
        }
        return gifts;
    }

    public List<MenuItem> getGifts() {
        return gifts;
    }
}
