import { Component } from '@angular/core';
import {Location} from "@angular/common";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  constructor( private location: Location){}

  back(): void {
    this.location.back()
  }

}
