import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { DataService } from '../data.service'

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public ifLogged;

  constructor(private route:Router, private data: DataService) { }

  ngOnInit() { 
    this.data.currentMessage.subscribe(message => {
      this.ifLogged = message
      this.ngOnInit
    })

    if(sessionStorage.getItem('username')){
      console.log("logged in");
      this.ifLogged = "true";
    }
    else{
      console.log("logged out")
      this.ifLogged = "false";
    }

    console.log(this.route.url);

  }

  logout(){
    sessionStorage.clear();
    this.ngOnInit();
    this.route.navigateByUrl("/");
  }

  login(){
    this.route.navigateByUrl("/Login");
  }

}