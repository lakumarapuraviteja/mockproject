import { Injectable } from '@angular/core';
import { UserServiceService } from './user-service.service';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { User } from './User';
import { ProductServiceService } from './services/product-service.service';
//import { MovieListService } from '../movie/movie-list.service';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  loggedInUser={loggedOut:true};
  validCredentials:boolean = true;
  accessToken: string; 
  redirectUrl = '/';
  loggedIn:boolean = false;
  private token: string;
  private id:number;
  type: string;
  isAdmin:boolean = false;
  userrole: string;
  isUser:boolean =false;
  userID:string;

  constructor(private  httpClient:HttpClient, private userService:UserServiceService,public router: Router) { }

  authenticate(userId: string, password: string): Observable<any>{
   let credentials=btoa(userId + ':' + password);
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Basic ' + credentials);
    return this.httpClient.get('http://localhost:8087/authentication-service/authenticate', {headers});
  }

  public setToken(token: string) {
   //this.setToken(token);
    this.token = token;
   }
  public getToken() {
    return this.token;
  }
  public setId(id: number) {
    this.id = id;
  }
  public getId() {
    return this.id;
  }

  authenticateUser(user) {
    this.authenticate(user.userId,user.password).subscribe(
      (data)=>{
        this.loggedInUser = user;
        this.validCredentials = true;
        this.userrole =data.role;
        this.userService.userId =data.username;
        this.userID = data.username;
        this.loggedIn = true;
        this.token=data.token;
        if(this.userrole=='superuser'){
          console.log("in if");
          this.router.navigate(['superuser'])
        }
        else if(this.userrole == 'admin'){
          this.isAdmin = true;
          this.router.navigate(['search-box']);
         }
       else {
         this.isUser=true;
         this.router.navigate(['search-box']);
       }
  
        //    if(this.id!=null){
        //     this.movieListService.addToFavorites(this.userService.userId,this.id).subscribe(
        //      data =>{console.log("first added");} );
        //   }
        
        
        //this.setToken(data.token);
       // this.productService.isLoggedIn = true;
        //this.router.navigate(['search-box']);
      },
      (error)=>{
        this.validCredentials = false;
  })
  }
  logout() {
    this.loggedInUser = {loggedOut:true};
    //this.movieListService.isAdmin = false;
    this.loggedIn = false;
    this.isAdmin=false;
    this.isUser=false;
    //this.movieListService.isLoggedIn = false;
    //this.movieListService.clickedOnAdd = false;
    //this.movieListService.addedToFav = false;
    this.router.navigate(['login']);
  }
  addUser(user : User){
    //let user:User = {userId:this.signUpForm.value["userId"],firstname:this.signUpForm.value["firstname"],lastname:this.signUpForm.value["lastname"],
    //password:this.signUpForm.value["password"],confirmPassword:this.signUpForm.value["confirmPassword"]}
    //console.log(users);
    if(this.type=="user"){
      return this.httpClient.post<User>('http://localhost:8087/authentication-service/users/U',user);
    }
    else{
      return this.httpClient.post<User>('http://localhost:8087/authentication-service/users/A',user);
    }
      }
    adminInfo():Observable<User[]>{
      let headers=new HttpHeaders();
      headers=headers.set('Authorization','Bearer '+this.getToken());
      return this.httpClient.get<User[]>('http://localhost:8087/authentication-service/users/admin',{headers});
    }

      response(user:User):Observable<User>{
        let headers=new HttpHeaders();
        headers=headers.set('Authorization','Bearer '+this.getToken());
        return this.httpClient.put<User>('http://localhost:8087/authentication-service/users',user,{headers});
}
}
