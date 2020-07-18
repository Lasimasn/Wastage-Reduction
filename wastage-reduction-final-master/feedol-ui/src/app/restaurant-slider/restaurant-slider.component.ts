import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { DragScrollComponent } from 'ngx-drag-scroll';

@Component({
  selector: 'app-restaurant-slider',
  templateUrl: './restaurant-slider.component.html',
  styleUrls: ['./restaurant-slider.component.css']
})
export class RestaurantSliderComponent implements OnInit {

  @ViewChild('nav', {read: DragScrollComponent}) ds: DragScrollComponent;

  constructor(private http: HttpClient) { }

  public thumb;
  public menu_url;
  public name;
  public address;
  public cuisines;
  public timings;
  public allRestaurants: any;
  public restaurantArray = []

  ngOnInit() {

    var count = 0;

    for(var i=0; i<200 && count <= 12;i++){
      this.getAllRestaurants(i+1,i+20).subscribe((data : any) => {

        this.allRestaurants = data.restaurants;

        this.allRestaurants.forEach(element =>{
          if(element.restaurant.average_cost_for_two > 300 && element.restaurant.thumb != "")
          {
            this.restaurantArray.push(element.restaurant)
            count++;
          }
        });
        
        console.log("printing")
        this.restaurantArray.forEach(element => {
          console.log(element)
        })

      });
      i = i+20;
    }

  }

  moveLeft() {
    this.ds.moveLeft();
  }
 
  moveRight() {
    this.ds.moveRight();
  }

  openView(restaurant) {
    this.thumb = restaurant.thumb;
    this.menu_url = restaurant.menu_url;
    this.name = restaurant.name;
    this.address = restaurant.location.address;
    this.cuisines = restaurant.cuisines;
    this.timings = restaurant.timings;

  }

  closeView() {
    document.getElementById("viewRestaurant").style.display = "none";
  }

  getAllRestaurants(start, count) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'user-key': '30576d9b42f4f655ac73d7f1dcffdca9'
      })
    };
    return this.http.get('https://developers.zomato.com/api/v2.1/search?start='+start+'&count='+count, httpOptions);
    
  }

}