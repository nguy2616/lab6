package model;

import javax.persistence.*;

@Entity
@Table(name="time")
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String date;
    @Column
    private String time;



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Time() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
