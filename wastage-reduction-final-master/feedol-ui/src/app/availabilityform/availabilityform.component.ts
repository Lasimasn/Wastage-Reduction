import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RestaurantActivity } from '../restaurant-activity';
import { DonationService } from '../donation.service';

@Component({
  selector: 'app-availabilityform',
  templateUrl: './availabilityform.component.html',
  styleUrls: ['./availabilityform.component.css']
})
export class AvailabilityformComponent implements OnInit {

  constructor(private service: DonationService) { }

  username: string;
  veg : any;
  nonveg : any;
  details = new RestaurantActivity;
  foodStatus :any;
  
  ngOnInit() {
    this.username = sessionStorage.getItem('username');
  }

  updateRestaurantActivity(){
    this.details.restaurantId = this.username;
    this.details.foodAvailability = this.veg+this.nonveg;
    console.log(this.details);
    this.service.updateRestaurantActivity(this.details).subscribe(data=>{
      console.log(data)})
    alert("Successfully updated");
  }

  fetchStatus() {
    this.service.fetchRestaurantFoodStatus(this.username).subscribe(data => {
      console.log(data)
      this.foodStatus = data;
    })
  }
}
