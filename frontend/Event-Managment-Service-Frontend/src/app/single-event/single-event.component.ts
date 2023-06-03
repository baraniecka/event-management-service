import { ActivatedRoute, Router } from '@angular/router';
import { EventsService } from '../service/events.service';
import { Component, OnInit } from '@angular/core';
import { Event } from '../model/event';

@Component({
  selector: 'app-single-event',
  templateUrl: './single-event.component.html',
  styleUrls: ['./single-event.component.scss'],
})
export class SingleEventComponent implements OnInit {
  event: Event;

  constructor(
    private eventsService: EventsService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  getEvent(): void {
    const id: number = Number(this.route.snapshot.paramMap.get('id'));

    this.eventsService
      .getSingleEvent(id)
      .subscribe((event) => (this.event = event));
  }

  public ngOnInit(): void {
    this.getEvent();
  }
}
