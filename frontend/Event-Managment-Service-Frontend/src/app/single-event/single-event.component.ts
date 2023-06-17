import {ActivatedRoute, Router} from '@angular/router';
import {EventsService} from '../service/events.service';
import {Component, OnInit} from '@angular/core';
import {Event} from '../model/event';
import {Comment} from '../model/comment';

@Component({
  selector: 'app-single-event',
  templateUrl: './single-event.component.html',
  styleUrls: ['./single-event.component.scss'],
})
export class SingleEventComponent implements OnInit {
  event: Event;
  comments: Comment[];

  constructor(
    private eventsService: EventsService,
    private route: ActivatedRoute,
  ) {
  }

  getEvent(): void {
    const id: number = Number(this.route.snapshot.paramMap.get('id'));

    this.eventsService
      .getSingleEvent(id)
      .subscribe((event) => (this.event = event));
  }

  getComment(): void {
    const id: number = Number(this.route.snapshot.paramMap.get('id'));

    this.eventsService
      .getComments(id)
      .subscribe((comments) => (this.comments = comments));
  }

  public ngOnInit(): void {
    this.getEvent();
    this.getComment();
  }
}
