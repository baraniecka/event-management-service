import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EventsComponent } from './events/events.component';
import { SingleEventComponent } from './single-event/single-event.component';
import { CreateEventComponent } from './create-event/create-event.component';
import {RegisterComponent} from "./register/register.component";
import {LoginComponent} from "./login/login.component";
import {CommentComponent} from "./comment/comment.component";

const routes: Routes = [
  { path: 'events', component: EventsComponent },
  { path: '', redirectTo: '/events', pathMatch: 'full' },
  { path: 'event/show/:id', component: SingleEventComponent },
  { path: 'event/add', component: CreateEventComponent },
  {path: 'register', component: RegisterComponent},
  {path: 'login', component: LoginComponent},
  {path: 'comment/add/:id', component: CommentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
