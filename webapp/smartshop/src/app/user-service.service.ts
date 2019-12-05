import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { User } from './User';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

 
  userRole:string;
  userId:string;
  
  constructor(private router:Router,private httpClient:HttpClient) { }

  addUser(user:User) {
    return this.httpClient.post<User>('http://localhost:8082/users',user); 
  }
  // getUser(userId:string){
  //   // let user = this.userList.filter((user)=>(user.userId==userId));
  //   return user[0];
  // }
}
