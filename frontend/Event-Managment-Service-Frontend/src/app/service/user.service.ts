import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {User, UserData} from "../model/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  private readonly url: string = 'http://localhost:8080/api/user';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  public addUser(user: UserData): Observable<UserData>{
    return this.httpClient.post<User>(`${this.url}/add`,user, this.httpOptions)
  }
}
