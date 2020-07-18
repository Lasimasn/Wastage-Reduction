import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { DragScrollComponent } from 'ngx-drag-scroll';
@Component({
 selector: 'app-charity-slider',
 templateUrl: './charity-slider.component.html',
 styleUrls: ['./charity-slider.component.css']
})
export class CharitySliderComponent implements OnInit {
 @ViewChild('nav', {read: DragScrollComponent}) ds: DragScrollComponent;
 public getAllCharity;
 public charityArray = []
 public charityThumb;
 public charityName;
 public charityAddress;
 public charityPhonenumber;
 constructor(private http: HttpClient) { }
 ngOnInit() {
   console.log("charity")
   this.getAllCharities().subscribe((data : any) => {
     console.log(data)
     data.forEach(element => {
       this.charityArray.push(element)
     });
     console.log(this.charityArray)
   });
 }
 moveLeft() {
   this.ds.moveLeft();
 }
 moveRight() {
   this.ds.moveRight();
 }
 openView(charity) {
   console.log(charity)
   this.charityThumb = charity.img_url;
   this.charityName = charity.charity_name;
   this.charityAddress = charity.address;
   this.charityPhonenumber = charity.phonenumber;
 }
 getAllCharities() {
   return this.http.get('http://localhost:8080/charity-service/api/v1/charity-slider')
 }
}
