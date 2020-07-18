import { Component, OnInit,Output,EventEmitter } from '@angular/core';
import { Restaurant } from '../restaurant';
import { Charity } from '../charity';
import { SignupService } from '../signup.service';
import { Router } from '@angular/router'

@Component({
  selector: 'app-signup-outer',
  templateUrl: './signup-outer.component.html',
  styleUrls: ['./signup-outer.component.css']
})
export class SignupOuterComponent implements OnInit {

  public restaurant;
  public charity;
  public user;
  public role;

  constructor(private service:SignupService, private route:Router) { }

  ngOnInit() {
  }

  signup($event){
    this.user = $event;
    console.log(this.user);
    console.log(this.user.username, this.user.password, this.user.email);
    if(this.role == "restaurant"){
      this.restaurant = new Restaurant(this.user.username, this.user.password, this.user.email, this.role,"", "", "", "", "","");
      this.service.signupRestaurant(this.restaurant).subscribe(data =>{
      console.log(data);
      this.route.navigateByUrl("/Login");
      });
    }
    else if(this.role == "charity"){
      this.charity = new Charity(this.user.username, this.user.password, this.user.email, this.role,"", "", "", "", "", "","");
      this.service.signupCharity(this.charity).subscribe(data =>{
      console.log(data)
      this.route.navigateByUrl("/Login");
      });
    }
    
  }

}
