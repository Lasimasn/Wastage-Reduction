import { Component, OnInit } from '@angular/core';
import { User } from '../user'
import { LoginService } from '../login.service';
import { Router } from '@angular/router'
import { DataService } from '../data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user: User;

  constructor(private service: LoginService, private route: Router, private data: DataService) { }

  ngOnInit() {
  }
  login(username, password) {
    console.log(username, password);
    this.user = new User(username, password);
    console.log(this.user)
    this.service.login(this.user).subscribe(data => {
      console.log(data);
      sessionStorage.setItem('token', data.token);
      sessionStorage.setItem('username', data.userDetails.username);
      sessionStorage.setItem('role', data.userDetails.role);
      // this.data.changeMessage(true);
      this.route.navigateByUrl("/DashboardComponent");
    });
  }
}
