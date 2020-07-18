//package com.stackroute.restaurant.restaurantlogserver.domain;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//import java.util.Date;
//import java.util.List;
//
//@Document(collection="restaurantLogs")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class RestaurantLogs {
//    @Id
//    int restaurantlogid;
//    String username;
//    String rating;
//    private List<RestaurantLogs> restaurantLogs;
//}
//
//
package com.stackroute.domain;
import com.stackroute.rabbitmq.model.RestaurantStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Logs {
    @Id
    int id;
    String date;
    double rating;
    RestaurantStatus restaurantStatus;

    public Logs() {
    }

    public Logs(int id, String date, double rating, RestaurantStatus restaurantStatus) {
        this.id = id;
        this.date = date;
        this.rating = rating;
        this.restaurantStatus = restaurantStatus;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public RestaurantStatus getRestaurantStatus() {
        return restaurantStatus;
    }

    public void setRestaurantStatus(RestaurantStatus restaurantStatus) {
        this.restaurantStatus = restaurantStatus;
    }
}

