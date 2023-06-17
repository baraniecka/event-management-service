import { Component } from '@angular/core';
import { EventsService } from '../service/events.service';
import { Event } from '../model/event';
@Component({
  selector: 'app-view-for-logged-user',
  templateUrl: './view-for-logged-user.component.html',
  styleUrls: ['./view-for-logged-user.component.scss']
})
export class ViewForLoggedUserComponent {
  events: Event[];
  singleEvent: Event;

  constructor(private eventService: EventsService) {}

  findActualEvents(): void {
    this.eventService
      .getActualEvents()
      .subscribe((events) => (this.events = events));
  }

  ngOnInit(): void {
    this.findActualEvents();
  }
}
