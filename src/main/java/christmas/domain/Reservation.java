package christmas.domain;

import static christmas.domain.Constants.CHRISTMAS_DATE;
import static christmas.domain.Constants.DECEMBER;
import static christmas.domain.Constants.DECEMBER_START_DATE;
import static christmas.domain.Constants.THIS_YEAR;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Reservation {
    private LocalDate reservationDate;

    private Reservation(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public static Reservation of(int inputDate) {
        LocalDate date = LocalDate.of(THIS_YEAR, DECEMBER, inputDate);
        return new Reservation(date);
    }

    public LocalDate getDate() {
        return reservationDate;
    }

    public boolean hasInChristmasPeriods() {
        int month = reservationDate.getMonthValue();
        int day = reservationDate.getDayOfMonth();
        return month == DECEMBER && day >= DECEMBER_START_DATE && day <= CHRISTMAS_DATE;
    }

    public boolean hasInWeekDayPeriods() {
        int month = reservationDate.getMonthValue();
        DayOfWeek dayOfWeek = reservationDate.getDayOfWeek();
        return month == DECEMBER && (dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY);
    }

    public boolean hasInWeekEndPeriods() {
        int month = reservationDate.getMonthValue();
        DayOfWeek dayOfWeek = reservationDate.getDayOfWeek();
        return month == DECEMBER && (dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY);
    }

    public boolean hasInSpecialPeriods() {
        int month = reservationDate.getMonthValue();
        DayOfWeek dayOfWeek = reservationDate.getDayOfWeek();
        return month == DECEMBER && (dayOfWeek == DayOfWeek.SUNDAY
                || reservationDate.getDayOfMonth() == CHRISTMAS_DATE);
    }

    public boolean hasInPeriods() {
        return reservationDate.getMonthValue() == DECEMBER;
    }
}
