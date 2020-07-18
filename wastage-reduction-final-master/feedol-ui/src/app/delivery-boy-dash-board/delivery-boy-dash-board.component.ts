import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { DomSanitizer } from '@angular/platform-browser';

import { UpdateService } from '../update.service';
import { DonationService } from '../donation.service';
import { DeliveryBoyActivity } from '../delivery-boy-activity';
@Component({
  selector: 'app-delivery-boy-dash-board',
  templateUrl: './delivery-boy-dash-board.component.html',
  styleUrls: ['./delivery-boy-dash-board.component.css']
})
export class DeliveryBoyDashBoardComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private service: DonationService,
    private sanitizer: DomSanitizer,
    private updateService : UpdateService,
  ) { }
  public deliveryBoy;
  username: string;
  deliveryRoute: any;
  deliveryBoyLogs: any;
  location;
  url = "http://maps.google.com/maps?q=";
  postfix = "&z=15&output=embed";
  cords : any[][];
  restaurants : any;
  updatedLocation : any;
  details = new DeliveryBoyActivity;
  ngOnInit() {
    this.username = sessionStorage.getItem('username');
    console.log(this.username)
    this.updateService.getDeliveryBoyProfile(this.username).subscribe(data => {
      console.log(data)
      this.deliveryBoy = data;
    })
    console.log(this.username)
    this.service.fetchDeliveryBoyLogs(this.username).subscribe(data => {
      console.log(data)
      this.deliveryBoyLogs = data;
      console.log(this.deliveryBoyLogs)
      this.deliveryBoyLogs.logs = this.deliveryBoyLogs.logs.map(e => {
        e.restaurants.map(i => {
          i.location = this.sanitizer.bypassSecurityTrustResourceUrl(this.url + i.location + this.postfix)
          return i
        })
        e.charities.map(j => {
          j.location = this.sanitizer.bypassSecurityTrustResourceUrl(this.url + j.location + this.postfix)
          return j
        })
        return e
      })
    })
    this.location = this.sanitizer.bypassSecurityTrustResourceUrl(this.url + this.cords + this.postfix)
  }
  fetchRoute() {
    console.log(this.username)
    this.service.fetchDeliveryBoyRoute(this.username).subscribe(data => {
      console.log(data)
      this.deliveryRoute = data;
    })
  }
  update() {
    console.log(this.updatedLocation)
    this.details.deliveryboyId = this.username;
    this.details.status = "available";
    this.details.location = this.updatedLocation;
    this.service.updateDeliveryBoyActivity(this.details).subscribe(data => {
      console.log(data)
    })
  }
 }