import { Component, OnInit } from '@angular/core';
import * as CanvasJS from '../../assets/js/canvasjs.min';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { UpdateService } from '../update.service';
import { DonationService } from '../donation.service';

import { Rating } from '../rating';

@Component({
  selector: 'app-charity-dash-board',
  templateUrl: './charity-dash-board.component.html',
  styleUrls: ['./charity-dash-board.component.css']
})
export class CharityDashBoardComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private updateService : UpdateService,
    private donateService : DonationService) { }

    charity : any;
    username : string;
    foodStatus : any;
    charityLogs : any[];
    abcd : any;
    locationstring:string;
    rating = new Rating;
    public rate;

  ngOnInit() {

    this.username = sessionStorage.getItem('username');

    console.log(this.username)
    this.updateService.getCharityProfile(this.username).subscribe(data=>{
        console.log(data);
        this.charity=data;
        console.log(this.charity); 
         });
         
    this.donateService.fetchCharityLogs(this.username).subscribe(data=>{
      console.log(data)
      this.charityLogs=data; 
      console.log(this.charity)});
  }

  fetchStatus(){
    this.donateService.fetchCharityFoodStatus(this.username).subscribe(data=>{
      console.log(data)
      this.foodStatus=data;})
  }

  onRate(rate,logId){
    console.log(rate,logId)
    this.rating.username = this.username;
    this.rating.logId = logId;
    this.rating.rating = rate;
    this.donateService.onRate(this.rating).subscribe(data=>{
      console.log(data)})
      this.ngOnInit()
  }

}
