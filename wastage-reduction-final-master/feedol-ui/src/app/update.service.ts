import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
​
@Injectable({
  providedIn: 'root'
})
export class UpdateService {
​
  constructor(private http: HttpClient) { }
​
  getRestaurantProfile(username):Observable<any>{
    console.log(username)
    return this.http.get<any>('http://localhost:8080/registration-service/api/v1/restaurant-profile?username='+username);
  }
​
  updateRestaurantProfile(restaurant):Observable<any>{
    console.log(restaurant)
    return this.http.put<any>('http://localhost:8080/registration-service/api/v1/restaurant-profile',restaurant);
  }
​
  getCharityProfile(username):Observable<any>{
    console.log(username)
    return this.http.get<any>('http://localhost:8080/registration-service/api/v1/charity-profile?username='+username);
  }
​
  updateCharityProfile(charity):Observable<any>{
    console.log(charity)
    return this.http.put<any>('http://localhost:8080/registration-service/api/v1/charity-profile',charity);
  }
​
  getDeliveryBoyProfile(username):Observable<any>{
    console.log(username)
    return this.http.get<any>('http://localhost:8080/registration-service/api/v1/deliveryBoy-profile?username='+username);
  }
​
  updateDeliveryBoyProfile(deliveryBoy):Observable<any>{
    console.log(deliveryBoy)
    return this.http.put<any>('http://localhost:8080/registration-service/api/v1/deliveryBoy-profile',deliveryBoy);
  }
}
