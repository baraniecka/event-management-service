import { EventsService } from './service/events.service';
import { Component, OnInit } from '@angular/core';
import { Event } from './model/event';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.scss'],
})
export class EventsComponent implements OnInit {
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
