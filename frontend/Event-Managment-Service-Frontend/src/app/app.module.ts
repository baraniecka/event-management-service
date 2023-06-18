import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EventsComponent } from './events/events.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SingleEventComponent } from './single-event/single-event.component';
import { CreateEventComponent } from './create-event/create-event.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { CommentComponent } from './comment/comment.component';
import { ViewForLoggedUserComponent } from './view-for-logged-user/view-for-logged-user.component';
import { EventSearchComponent } from './event-search/event-search.component';

// import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    EventsComponent,
    SingleEventComponent,
    CreateEventComponent,
    LoginComponent,
    RegisterComponent,
    CommentComponent,
    ViewForLoggedUserComponent,
    EventSearchComponent,

    // LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    CommonModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
