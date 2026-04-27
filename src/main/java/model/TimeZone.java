package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import java.util.Date;

@Entity
public class TimeZone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String timeZone;
    private String currentTime;
    private String date;
    private String dayOfWeek;
    private boolean dstActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="player_id")
    @JsonIgnore
    private Player player;

    public TimeZone(Long id, String timeZone, String currentTime, String date, String dayOfWeek, boolean dstActive, Player player) {
        this.id = id;
        this.timeZone = timeZone;
        this.currentTime = currentTime;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.dstActive = dstActive;
        this.player = player;
    }

    public TimeZone() {


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
