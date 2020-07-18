import { Component, OnInit } from '@angular/core';
import { DonationService } from '../donation.service';
import { RestaurantActivity } from '../restaurant-activity';
import { UpdateService } from '../update.service';

@Component({
  selector: 'app-restaurant-dashboard',
  templateUrl: './restaurant-dashboard.component.html',
  styleUrls: ['./restaurant-dashboard.component.css']
})
export class RestaurantDashboardComponent implements OnInit {

  constructor(private service: DonationService,private updateService : UpdateService) { }

  username: string;
  restaurant: any;
  restaurantLogs: any;
  foodStatus: any;
  a: any;
  latitude: string;
  longitude: string;
  veg : any;
  nonveg : any;
  details = new RestaurantActivity;

  ngOnInit() {
    this.username = sessionStorage.getItem('username');
    console.log(this.username)
    this.updateService.getRestaurantProfile(this.username).subscribe(data => {
      console.log(data)
      this.restaurant = data;
      console.log(this.restaurant);
    })

    this.service.fetchRestaurantLogs(this.username).subscribe(data => {
      console.log(data)
      this.restaurantLogs = data;
    })
  }
}
