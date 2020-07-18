import { Component, OnInit,Output,EventEmitter } from '@angular/core';
import { Restaurant } from '../restaurant';
import { Charity } from '../charity';
import { SignupService } from '../signup.service';
import { Router } from '@angular/router';
import { SignUpUser } from "../signupuser";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public role;
  public user ;
  public restaurant;
  public charity;
  constructor(private service:SignupService,private route:Router) { }

  ngOnInit() {
  }
  restaurantSetRole(){
    this.role='restaurant';
  }
  charitySetRole(){
    this.role='charity';
  }

 
  signup($event){
    this.user = $event;
    console.log(this.user);
    console.log(this.user.username, this.user.password, this.user.email);
    if(this.role == "restaurant"){
      this.restaurant = new Restaurant(this.user.username, this.user.password, this.user.email, this.role,"", "", "", "", "","");
      this.service.signupRestaurant(this.restaurant).subscribe(data =>{
      console.log(data);
      // $("#myModal").modal("hide");
      document.getElementById('signUp').style.display='none'
      // this.route.navigateByUrl("/Login");
      });
    }
    else if(this.role == "charity"){
      this.charity = new Charity(this.user.username, this.user.password, this.user.email, this.role,"", "", "", "", "", "","");
      this.service.signupCharity(this.charity).subscribe(data =>{
      console.log(data);
      document.getElementById('signUp').style.display='none'
      // this.route.navigateByUrl("/Login");
      });
    }
    
  }
}
