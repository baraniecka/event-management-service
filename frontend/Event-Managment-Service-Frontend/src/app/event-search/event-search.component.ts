import {Component, OnInit} from '@angular/core';
import {EventsService} from "../service/events.service";
import {Event} from "../model/event";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-event-search',
  templateUrl: './event-search.component.html',
  styleUrls: ['./event-search.component.scss']
})
export class EventSearchComponent implements OnInit{
  events: Event[];

  constructor(
    private eventService: EventsService,
    private route: ActivatedRoute) {}
  searchResult(): void {

  }

  ngOnInit(): void {
    this.searchResult();
  }
}
