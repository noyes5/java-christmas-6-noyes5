package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Reservation;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ReservationTest {
    @DisplayName("기간 확인 테스트 - 크리스마스 기간")
    @ParameterizedTest
    @ValueSource(ints = {1, 25})
    void 크리스마스_기간_확인(int day) {
        LocalDate christmas = LocalDate.of(2023, 12, day);
        Reservation reservation = new Reservation(christmas);
        assertThat(reservation.hasInChristmasPeriods()).isTrue();
    }

    @DisplayName("기간 확인 테스트 - 비크리스마스 기간")
    @ParameterizedTest
    @ValueSource(ints = {26, 31})
    void 비크리스마스_기간_확인(int day) {
        LocalDate nonChristmas = LocalDate.of(2023, 12, day);
        Reservation reservation = new Reservation(nonChristmas);
        assertThat(reservation.hasInChristmasPeriods()).isFalse();
    }

    @DisplayName("기간 확인 테스트 - 평일")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 31})
    void 평일_확인(int day) {
        LocalDate weekday = LocalDate.of(2023, 12, day);
        Reservation reservation = new Reservation(weekday);
        assertThat(reservation.hasInWeekDayPeriods()).isTrue();
    }

    @DisplayName("기간 확인 테스트 - 비평일")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void 비평일_확인(int day) {
        LocalDate weekday = LocalDate.of(2023, 12, day);
        Reservation reservation = new Reservation(weekday);
        assertThat(reservation.hasInWeekDayPeriods()).isFalse();
    }

    @DisplayName("기간 확인 테스트 - 주말")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void 주말_확인(int day) {
        LocalDate weekend = LocalDate.of(2023, 12, day);
        Reservation reservation = new Reservation(weekend);
        assertThat(reservation.hasInWeekEndPeriods()).isTrue();
    }

    @DisplayName("기간 확인 테스트 - 비주말")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 31})
    void 비주말_확인(int day) {
        LocalDate weekend = LocalDate.of(2023, 12, day);
        Reservation reservation = new Reservation(weekend);
        assertThat(reservation.hasInWeekEndPeriods()).isTrue();
    }

    @DisplayName("기간 확인 테스트 - 비특별 할인 기간")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 26, 27, 28})
    void 비특별_기간_확인(int day) {
        LocalDate date = LocalDate.of(2023, 12, day);
        Reservation reservation = new Reservation(date);
        assertThat(reservation.hasInSpecialPeriods()).isFalse();
    }

}
