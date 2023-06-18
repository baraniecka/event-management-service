import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, from } from 'rxjs';
import {Event, EventData} from '../model/event';
import {Comment, CommentData} from '../model/comment';

@Injectable({
  providedIn: 'root',
})
export class EventsService {
  constructor(private httpClient: HttpClient) {}

  private readonly url: string = 'http://localhost:8080/api';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  public getActualEvents(): Observable<any> {
    return this.httpClient.get<Event[]>(`${this.url}/events`);
  }

  public getSingleEvent(id: number) {
    return this.httpClient.get<Event>(`${this.url}/event/${id}`);
  }

  public addEvent(event: EventData): Observable<EventData> {
    return this.httpClient.post<Event>(`${this.url}/event`, event, this.httpOptions);
  }

  public getComments(id:number):Observable<any> {
    return this.httpClient.get<Comment[]>(`${this.url}/comment/event/${id}`)
  }

  public addComment(comment:CommentData):Observable<Comment>{
return this.httpClient.post<Comment>(`${this.url}/comment/new`, comment, this.httpOptions)
  }

  public getEventsByPhrase(phrase:string):Observable<any>{
    return this.httpClient.get<Event>(`${this.url}/event/search/${phrase}`)
  }

}
