import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'
import { DataService } from '../data.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  public role;

  constructor(private route:Router, private data: DataService) { }

  ngOnInit() {

    this.data.changeMessage("true");

    if(sessionStorage.getItem('role') == 'restaurant'){
      this.role = 'restaurant';
    }
    else if(sessionStorage.getItem('role') == 'charity'){
      this.role = 'charity';
    }
    else if(sessionStorage.getItem('role') == 'deliveryBoy'){
      this.role = 'deliveryBoy';
    }
  }

}
