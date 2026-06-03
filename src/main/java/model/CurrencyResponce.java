package model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class CurrencyResponce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double value;
    private double convertedValue;
    private String fromValue;
    private String toValue;
    private double rate;
    private String date;
    private String source;
    @ManyToOne
    @JoinColumn(name = "player_id")
    @JsonIgnore
    private Player player;


    public CurrencyResponce(String fromValue, String toValue, double rate, String date, String source) {

        this.fromValue = fromValue;
        this.toValue = toValue;
        this.rate = rate;
        this.date = date;
        this.source = source;
    }

    public CurrencyResponce() {

    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setToValue(String to) {
        this.toValue = to;
    }

    public void setFromValue(String from) {
        this.fromValue = from;
    }

    public void setConvertedValue(double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public double getConvertedValue() {
        return convertedValue;
    }

    public String getFromValue() {
        return fromValue;
    }

    public String getToValue() {
        return toValue;
    }

    public double getRate() {
        return rate;
    }

    public String getDate() {
        return date;
    }

    public String getSource() {
        return source;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "CurrencyResponce{" +
                "id=" + id +
                ", value=" + value +
                ", convertedValue=" + convertedValue +
//                ", fromValue='" + fromValue + '\'' +
//                ", toValue='" + toValue + '\'' +
                ", rate=" + rate +
                ", date='" + date + '\'' +
                ", source='" + source + '\'' +
                ", player=" + player +
                '}';
    }
}
