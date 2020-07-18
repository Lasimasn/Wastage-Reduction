import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Rating } from './rating';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class DonationService {

  constructor(private http: HttpClient) { }

 saveRestaurant(restaurant){
   var saveRestaurantUrl= "http://localhost:8080/registration-service/api/v1/restaurant-profile/";
   console.log("Saving Restaurant", restaurant);
   return this.http.post<any>(saveRestaurantUrl,restaurant);
 }

 saveCharity(charity){
  var saveCharityUrl= "http://localhost:8080/registration-service/api/v1/charity-profile/";
  console.log("Saving Charity", charity);
  return this.http.post<any>(saveCharityUrl,charity);
}

saveDeliveryBoy(deliveryBoy){
  var saveDeliveryBoyUrl= "http://localhost:8080/registration-service/api/v1/deliveryBoy-profile/";
  console.log("Saving DeliveryBoy", deliveryBoy);
  return this.http.post<any>(saveDeliveryBoyUrl,deliveryBoy);
 }
 
 updateRestaurantActivity(details){
  var url= "http://localhost:8080/routing-service/updateRestaurantDetails";
  console.log("Updating Restaurant Details With Username : ", details.restaurantId , " And Food Availability : " , details.foodAvailability);
  return this.http.put<any>(url,details);
 }

 updateDeliveryBoyActivity(details){
  var url= "http://localhost:8080/routing-service/updateDeliveryBoyDetails";
  console.log("Updating Delivery Boy Details With Username : ", details.deliveryBoyId , " And Location : " , details.location);
  return this.http.put<any>(url,details);
 }
 
 fetchRestaurantLogs(username){
   var url= `http://localhost:8080/restaurant-service/api/v1/restaurant-logs/?username=${username}`;
   console.log("Fetching Restaurant's Logs With Username : ", username);
   return this.http.get<any>(url);
  }
 
  fetchRestaurantFoodStatus(username){
   var url= `http://localhost:8080/restaurant-service/api/v1/restaurant-status/?username=${username}`;
   console.log("Fetching Restaurant's Food Status With Username : ", username);
   return this.http.get<any>(url);
  }
 
 fetchCharityLogs(username){
   var url= `http://localhost:8080/charity-service/api/v1/charity-logs/?username=${username}`;
   console.log("Fetching Charity's Logs With Username : ", username);
   return this.http.get<any>(url);
  }
 
 fetchCharityFoodStatus(username){
  var url= `http://localhost:8080/charity-service/api/v1/charity-status/?username=${username}`;
  console.log("Fetching Charity's Food Status With Username : ", username);
  return this.http.get<any>(url);
 }
 
 fetchDeliveryBoyLogs(username){
   var url= `http://localhost:8080/deliveryboy-service/api/v1/deliveryBoy-logs/?username=${username}`;
   console.log("Fetching Delivery Boy's Route Status With Username : ", username);
   return this.http.get<any>(url);
  }
 
 fetchDeliveryBoyRoute(username){
   var url= `http://localhost:8080/deliveryboy-service/api/v1/deliveryBoy-status/?username=${username}`;
   console.log("Fetching Delivery Boy's Route Status With Username : ", username);
   return this.http.get<any>(url);
  }

  saveRestaurantLogOnPicked(username):Observable<any>{
    var url= `http://localhost:8080/restaurant-service/api/v1/restaurant-logs`;
    console.log("Saving Restaurant Log With Username : ", username);
    // var some = 
    // console.log(some)
    console.log("auiua")
    return this.http.post<any>(url,username) ;
   }

  saveCharityLogOnDelivered(username){
    var url= `http://localhost:8080/charity-service/api/v1/charity-logs/`;
    console.log("Saving Charity Log With Username : ", username);
    return this.http.post<any>(url,username);
   }
  
  onRate(rating : Rating){
    var url= `http://localhost:8080/charity-service/api/v1/charity-rating/`;
    console.log("Saving Charity Log With Username : ", rating);
    return this.http.post<any>(url,rating);
   }

}
