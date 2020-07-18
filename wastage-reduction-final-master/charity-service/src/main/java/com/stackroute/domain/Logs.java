package com.stackroute.domain;

import com.stackroute.rabbitmq.model.CharityStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Logs {

    @Id
    private int id;

    private String date;

    private double rating;

    private CharityStatus charityStatus;

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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public CharityStatus getCharityStatus() {
        return charityStatus;
    }

    public void setCharityStatus(CharityStatus charityStatus) {
        this.charityStatus = charityStatus;
    }
}
