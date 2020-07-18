import { Component, OnInit, Input } from '@angular/core';
import { DonationService } from '../donation.service';

@Component({
  selector: 'app-restaurant-card',
  templateUrl: './restaurant-card.component.html',
  styleUrls: ['./restaurant-card.component.css']
})
export class RestaurantCardComponent implements OnInit {

  @Input() restaurant;
  @Input() i;
  public restaurantLogs = null;

  public show:boolean = true;


  constructor(private service : DonationService) { }

  ngOnInit() {
    console.log(this.restaurant.username)
    this.service.fetchRestaurantLogs(this.restaurant.username).subscribe(data => {
      console.log(data)
      this.restaurantLogs = data;
    })
  }

  toggle() {
    this.show = !this.show;
  }
  
  onPicked(restaurantUsername: string) {
    console.log(restaurantUsername)
    this.service.saveRestaurantLogOnPicked(restaurantUsername).subscribe(data => {
      console.log(data)
      this.toggle();
    })
  }
}
