import { Component, OnInit } from '@angular/core';
import {LoginDTO} from "../../dto/LoginDTO";
import {LoginService} from "../../service/login.service";
import {Navigation, Router} from "@angular/router";
import {NgToastService} from "ng-angular-popup";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginDto=new LoginDTO();

  constructor(private loginService:LoginService,private router:Router,private toast: NgToastService) { }

  ngOnInit(): void {
  }


  login(){
    this.loginService.login(this.loginDto).subscribe(obj=>{
      if(obj){
        localStorage.setItem('isUser',"true");
        this.router.navigateByUrl("/dashboard");
      }else{
        this.toast.error({detail:'Incorrect UserName Or Password ',summary:'Please Try Again Check Your UserName And Password',duration:5000});
      }
    },error => {
      this.toast.error({detail:'Incorrect UserName Or Password ',summary:'Please Try Again Check Your UserName And Password',duration:5000});
    });
  }

}
