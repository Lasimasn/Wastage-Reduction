import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { SignUpUser } from "../signupuser";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

public validEmail: boolean =false;
  public signUpUser;

  @Output() clickEvent = new EventEmitter<string>();

  constructor() { }

  ngOnInit() {
  }

  sendToOuter(username, password, email){
    this.signUpUser = new SignUpUser(username, password, email);
    this.clickEvent.emit(this.signUpUser);
  }
  2

 
  
}
