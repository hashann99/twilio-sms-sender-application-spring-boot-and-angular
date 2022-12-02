import { Injectable } from '@angular/core';
import {LoginDTO} from "../dto/LoginDTO";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  login(login: LoginDTO) :Observable<boolean>{
      return this.http.post<boolean>('http://localhost:8082/api/login',login);
  }
}
