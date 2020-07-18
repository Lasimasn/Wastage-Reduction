import { Component, OnInit } from '@angular/core';
import { DonationService } from '../donation.service';

@Component({
  selector: 'app-route-map',
  templateUrl: './route-map.component.html',
  styleUrls: ['./route-map.component.css']
})
export class RouteMapComponent implements OnInit {

  username : string
  deliveryRoute : any
  public show:boolean = true;
  public charityLogs = null;

  constructor(private service : DonationService) { }
  
  ngOnInit() {
    this.username = sessionStorage.getItem('username');
    console.log(this.username)
    this.service.fetchDeliveryBoyRoute(this.username).subscribe(data=>{
      console.log(data)
      this.deliveryRoute=data;
      this.service.fetchCharityLogs(this.deliveryRoute.logs.charities[0].username).subscribe(data => {
        console.log(data)
        this.charityLogs = data;
      })
    })

      
  }
  
  toggle() {
    this.show = !this.show;
  }

  onDelivered(charityUsername: string) {
    this.service.saveCharityLogOnDelivered(charityUsername).subscribe(data => {
      console.log(data)
      this.toggle();
    })
  }
  
  
 }
 