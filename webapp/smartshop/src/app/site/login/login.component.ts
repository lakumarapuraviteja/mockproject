import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/auth-service.service';
import { User } from 'src/app/User';
//import { MovieListService } from 'src/app/movie/movie-list.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  loginForm:FormGroup
  

  constructor(private formBuild:FormBuilder,private authService:AuthServiceService,private router:Router) { }

  ngOnInit() {
    this.loginForm = this.formBuild.group({
      userId: ['',[
        Validators.required
      ]],
      password: ['',[
        Validators.required
      ]]
    })
  }
  get userId(){
    return this.loginForm.get('userId');
  }
  get password(){
    return this.loginForm.get('password');
  }
  toSignupUser() {
    this.router.navigate(['/signup','user'])
  }
  toSignupAdmin() {
    this.router.navigate(['/signup','admin'])
  }

  }

