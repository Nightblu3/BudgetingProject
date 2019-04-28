package com.example.lib2;

/**
 * Class for coding the budgeting app.
 */

public class Budget {

    /**
     * Months in a year.
     */
    public static final int MONTHS = 12;

    /**
     * Weeks per Month.
     */
    public static final int WEEKS = 4;

    /**
     * Days per month.
     */
    public static final int DAYS = 30;

    /**
     * Hours per day.
     */
    public static final int HOURS = 24;

    /**
     * Minutes/Seconds per xyz.
     */
    public static final int MINS = 60;
    /**
     * Gets monthly salary.
     * @param yearlySalary money/year.
     * @return months.
     */
    public int getMonths(final int yearlySalary) {
        return yearlySalary / MONTHS;
    }
    /**
     * Gives Weeks.
     * @param yearlySalary Money/year
     * @return weeks
     */
    public int getWeeks(final int yearlySalary) {
        return getMonths(yearlySalary) / WEEKS;
    }
    /**
     * Gives Days.
     * @param yearlySalary Money/year
     * @return days
     */
    public int getDays(final int yearlySalary) {
        return getWeeks(yearlySalary) / DAYS;
    }
    /**
     * Gives Hours.
     * @param yearlySalary Money/year
     * @return Hours
     */
    public int getHours(final int yearlySalary) {
        return getDays(yearlySalary) / HOURS;
    }
    /**
     * Gives Mins/Seconds.
     * @param yearlySalary Money/year
     * @return mins/seconds
     */
    public int getMins(final int yearlySalary) {
        return getHours(yearlySalary) / MINS;
    }


}
