package christmas.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Reservation {
    private LocalDate reservationDate;

    public Reservation(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDate getDate() {
        return reservationDate;
    }

    public boolean hasInChristmasPeriods() {
        int month = reservationDate.getMonthValue();
        int day = reservationDate.getDayOfMonth();
        return month == 12 && day >= 1 && day <= 25;
    }

    public boolean hasInWeekDayPeriods() {
        int month = reservationDate.getMonthValue();
        DayOfWeek dayOfWeek = reservationDate.getDayOfWeek();
        return month == 12 && (dayOfWeek != DayOfWeek.FRIDAY && dayOfWeek != DayOfWeek.SATURDAY);
    }

    public boolean hasInWeekEndPeriods() {
        int month = reservationDate.getMonthValue();
        DayOfWeek dayOfWeek = reservationDate.getDayOfWeek();
        return month == 12 && (dayOfWeek != DayOfWeek.FRIDAY || dayOfWeek != DayOfWeek.SATURDAY);
    }

    public boolean hasInSpecialPeriods() {
        int month = reservationDate.getMonthValue();
        DayOfWeek dayOfWeek = reservationDate.getDayOfWeek();
        return month == 12 && (dayOfWeek == DayOfWeek.SUNDAY || reservationDate.getDayOfMonth() == 25);
    }
}
