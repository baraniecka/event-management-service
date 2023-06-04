import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, from } from 'rxjs';
import {Event, EventData} from '../model/event';

@Injectable({
  providedIn: 'root',
})
export class EventsService {
  constructor(private httpClient: HttpClient) {}

  private readonly url: string = 'http://localhost:8080/api/event';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  public getActualEvents(): Observable<any> {
    return this.httpClient.get<Event[]>(`${this.url}/events`);
  }

  public getSingleEvent(id: number) {
    return this.httpClient.get<Event>(`${this.url}/${id}`);
  }

  public addEvent(event: EventData): Observable<EventData> {
    return this.httpClient.post<Event>(this.url, event, this.httpOptions);
  }
}
