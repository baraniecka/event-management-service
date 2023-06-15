import { EventsService } from './../service/events.service';
import { Component } from '@angular/core';
import {EventData} from '../model/event';
import {Location} from "@angular/common";

@Component({
  selector: 'app-create-event',
  templateUrl: './create-event.component.html',
  styleUrls: ['./create-event.component.scss'],
})
export class CreateEventComponent {
  constructor(private eventService: EventsService,
              private location: Location) {}

  // event: Event;

  addEvent(title: string, start: Date, end: Date, desc: string): void {
    title.trim;
    desc.trim;

    const event: EventData = {
      title: title,
      startDate: start,
      endDate: end,
      description: desc,
    };

    this.eventService.addEvent(event).subscribe();
  }

  back(): void {
    this.location.back()
  }
}
