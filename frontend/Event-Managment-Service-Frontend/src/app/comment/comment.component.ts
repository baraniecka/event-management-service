import {Component} from '@angular/core';
import {EventsService} from "../service/events.service";
import {Location} from "@angular/common";
import {Comment, CommentData} from '../model/comment';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.scss']
})
export class CommentComponent {

  constructor(private eventService: EventsService,
              private location: Location) {}
  addComment(message: string): void {

    const comment: CommentData = {message: message};


  this.eventService.addComment(comment).subscribe();
  }
  back(): void {
    this.location.back()
  }
}
