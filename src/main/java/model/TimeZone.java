package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Name;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import java.util.Date;

@Entity
@NamedQuery(name= TimeZone.GetALLtimeZONES, query = "SELECT t from TimeZone t")
public class TimeZone {
    public static final String GetALLtimeZONES="GetAllTimeZones";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String timeZone;
    private String currentTime;
    private int seconds;
    private String date;
    private String dayOfWeek;
    private boolean dstActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="player_id")
    @JsonIgnore
    private Player player;

    public TimeZone(Long id, String timeZone, String currentTime,int seconds, String date, String dayOfWeek, boolean dstActive, Player player) {
        this.id = id;
        this.timeZone = timeZone;
        this.currentTime = currentTime;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.dstActive = dstActive;
        this.player = player;
        this.seconds = seconds;
    }

    public TimeZone() {


    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public boolean isDstActive() {
        return dstActive;
    }

    public void setDstActive(boolean dstActive) {
        this.dstActive = dstActive;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
