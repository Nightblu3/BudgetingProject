package com.example.lib2;

/**
 * Class for coding the budgeting app.
 */

public class Budget {

    /**
     * Months in a year.
     */
    public static final float MONTHS = 12;

    /**
     * Weeks per Month.
     */
    public static final float WEEKS = 4;

    /**
     * Days per month.
     */
    public static final float DAYS = 365;

    /**
     * Hours per day.
     */
    public static final float HOURS = 24;

    /**
     * Minutes/Seconds per xyz.
     */
    public static final float MINS = 60;
    /**
     * Cuts off decimal.
     */
    public static final float CUT_OFF = .2f;

    /**
     * Gets monthly salary.
     *
     * @param yearlySalary money/year.
     * @return months.
     */
    public static float getMonths(final float yearlySalary) {
        return (yearlySalary / MONTHS);
    }

    /**
     * Gives Weeks.
     *
     * @param yearlySalary Money/year
     * @return weeks
     */
    public static float getWeeks(final float yearlySalary) {
        return (getMonths(yearlySalary) / WEEKS);
    }

    /**
     * Gives Days.
     *
     * @param yearlySalary Money/year
     * @return days
     */
    public static float getDays(final float yearlySalary) {
        return (yearlySalary / DAYS);
    }

    /**
     * Gives Hours.
     * @param yearlySalary Money/year
     * @return Hours
     */
    public static float getHours(final float yearlySalary) {
        return (getDays(yearlySalary) / HOURS);
    }

    /**
     * Gives Mins/Seconds.
     *
     * @param yearlySalary Money/year
     * @return mins/seconds
     */
    public static float getMins(final float yearlySalary) {
        return (getHours(yearlySalary) / MINS);
    }

    /**
     * Approx. calculates how long it will take to pay off a student loan/
     * @param rate % interest.
     * @param principal Starting amount.
     * @param payOff How much you pay per year.
     * @return time in years (approx)
     */
    public static int loanCalc(final double rate, final double principal, final double payOff) {
        double total = principal * (1 + rate) - payOff;
        int years = 0;
        if (total <= 0) {
            return 0;
        }
        if (total > 0) {
            years = 1;
        }
        return years + loanCalc(rate, total, payOff);
    }
}
