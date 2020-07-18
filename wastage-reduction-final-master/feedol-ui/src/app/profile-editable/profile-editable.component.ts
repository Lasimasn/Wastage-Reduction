import { Component, OnInit } from '@angular/core';
import { UpdateService } from '../update.service';
import { RestaurantProfile } from '../restaurant-profile';
import { CharityProfile } from '../charity-profile';
import { DeliveryBoyProfile } from '../deliveryBoy-profile';
​
@Component({
  selector: 'app-profile-editable',
  templateUrl: './profile-editable.component.html',
  styleUrls: ['./profile-editable.component.css']
})
export class ProfileEditableComponent implements OnInit {
​
  public username; 
  public role;
  public editable;
  public actor;
  public restaurantProfile;
  public charityProfile;
  public deliveryBoyProfile;
  public selectedFile: File;
​
  constructor(private service:UpdateService) { }
​
  ngOnInit() {
​
    this.editable="false";
​
    this.username = sessionStorage.getItem('username');
    this.role = sessionStorage.getItem('role');
​
    if(this.role == 'restaurant'){
      this.service.getRestaurantProfile(this.username).subscribe(data =>{
        this.actor = data;
        console.log(this.actor);
        });
    }
    else if(this.role == 'charity'){
      this.service.getCharityProfile(this.username).subscribe(data =>{
        this.actor = data;
        console.log(this.actor);
        });
    }
    else if(this.role == 'deliveryBoy'){
      this.service.getDeliveryBoyProfile(this.username).subscribe(data =>{
        this.actor = data;
        console.log(this.actor);
        });
    }
​
    
​
  }
  public edit(){
    if(this.editable=='false')
      this.editable="true";
    else
      this.editable="false";
​
  }
​
​
​
  
  public update(){
​
    console.log(this.actor)
    // console.log(restaurant)
​
    if(this.actor.role == 'restaurant'){
      this.restaurantProfile = new RestaurantProfile(this.actor.username, this.actor.email, this.actor.role, this.actor.name, this.actor.mobile,this.actor.address,this.actor.location,this.actor.certificateNo,this.actor.certificateName);
      console.log(this.restaurantProfile);
      this.service.updateRestaurantProfile(this.restaurantProfile).subscribe(data =>{
        console.log(data);
        sessionStorage.setItem('username',data.username);
        sessionStorage.setItem('role',data.role);
        this.ngOnInit();
        });
    }
    else if(this.actor.role == 'charity'){
      this.charityProfile = new CharityProfile(this.actor.username, this.actor.email, this.actor.role, this.actor.name, this.actor.mobile,this.actor.address, this.actor.location,this.actor.foodRequirement, this.actor.certificateNo,this.actor.certificateName);
      console.log(this.charityProfile);
      this.service.updateCharityProfile(this.charityProfile).subscribe(data =>{
        console.log(data);
        sessionStorage.setItem('username',data.username);
        sessionStorage.setItem('role',data.role);
        this.ngOnInit();
        });
    }
    else if(this.actor.role == 'deliveryBoy'){
      this.deliveryBoyProfile = new DeliveryBoyProfile(this.actor.username, this.actor.email, this.actor.role, this.actor.name, this.actor.mobile,this.actor.address, this.actor.licenseNo,this.actor.licenseName);
      console.log(this.deliveryBoyProfile);
      this.service.updateDeliveryBoyProfile(this.deliveryBoyProfile).subscribe(data =>{
        console.log(data);
        sessionStorage.setItem('username',data.username);
        sessionStorage.setItem('role',data.role);
        this.ngOnInit();
        });
    }
    if(this.editable=='false')
      this.editable="true";
    else
      this.editable="false";
    
    
  }
​
}