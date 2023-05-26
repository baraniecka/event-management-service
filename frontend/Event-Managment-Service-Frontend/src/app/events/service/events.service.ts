import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, from } from 'rxjs';
import { Event } from '../model/event';

@Injectable({
  providedIn: 'root',
})
export class EventsService {
  constructor(private httpClient: HttpClient) {}

  private readonly url: string = 'http://localhost:8080/event';

  public getActualEvents(): Observable<any> {
    return this.httpClient.get<Event[]>(`${this.url}/events`);
  }

  public getSingleEvent(id: number) {
    return this.httpClient.get<Event>(`${this.url}/${id}`);
  }
}
