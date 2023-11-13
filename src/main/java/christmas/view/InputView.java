package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.StringUtils;
import christmas.util.validator.MenuValidator;
import christmas.util.validator.ReservationValidator;
import java.util.HashMap;
import java.util.Map;

public class InputView {
    private enum Messsage {
        INPUT_RESERVATION("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
        INPUT_ORDER_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

        private final String message;

        Messsage(String message) {
            this.message = message;
        }
    }

    public int readReservation() {
        System.out.println(Messsage.INPUT_RESERVATION.message);
        String input = StringUtils.removeSpace(Console.readLine());
        new ReservationValidator().validate(input);
        return Integer.parseInt(input);
    }

    public String readOrderMenus() {
        System.out.println(Messsage.INPUT_ORDER_MENU.message);
        Map<String, Integer> orderMenus = new HashMap<>();
        String input = StringUtils.removeSpace(Console.readLine());
        new MenuValidator().validate(input);
        return null;
    }
}
