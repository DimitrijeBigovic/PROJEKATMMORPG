package model;


import java.sql.Date;
import java.util.Objects;

public class TimeResponce {
    public int year;
    public int month;
    public int day;
    public int hour;
    public int minute;
    public int seconds;
    public int milliseconds;
    public String dateTime;
    public String date;
    public String time;
    public String timeZone;
    public String dayOfWeek;
    public boolean dstActive;


    public TimeResponce() {
    }

    public TimeResponce(int year, int month, int day, int hour, int minute, int seconds, int milliseconds, String dateTime, String date, String time, String timeZone, String dayOfWeek, boolean dstActive) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.seconds = seconds;
        this.milliseconds = milliseconds;
        this.dateTime = dateTime;
        this.date = date;
        this.time = time;
        this.timeZone = timeZone;
        this.dayOfWeek = dayOfWeek;
        this.dstActive = dstActive;
    }

    public boolean isDstActive() {
        return dstActive;
    }

    public void setDstActive(boolean dstActive) {
        this.dstActive = dstActive;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TimeResponce that)) {
            return false;
        }
        return day == that.day && month == that.month && year == that.year && dstActive == that.dstActive
                && milliseconds == that.milliseconds && hour == that.hour && minute == that.minute && seconds == that.seconds && dateTime == that.dateTime
                && date == that.date && time == that.time && timeZone == that.timeZone && dayOfWeek == that.dayOfWeek;


    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year, dstActive, milliseconds, hour, minute, dateTime, date, time, timeZone, dayOfWeek);
    }

    @Override
    public String toString() {
        return "TimeApi{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                ", second=" + seconds +
                ", millisecond=" + milliseconds +
                ", dateTime='" + dateTime + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                ", timeZone='" + timeZone + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                ", dstActive=" + dstActive +
                '}';
    }
}
