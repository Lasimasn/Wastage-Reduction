import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  login(user):Observable<any>{ 
    console.log(user)
    return this.http.post<any>('http://localhost:8080/authentication-service/authentication/authenticate',user);
  } 
  check(token):Observable<any>{ 
    console.log(token)
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Authorization': 'Bearer '+token
      })
    };
    return this.http.get<any>('http://localhost:8080/authentication-service/authentication/checkUser',httpOptions);
  }  
}
