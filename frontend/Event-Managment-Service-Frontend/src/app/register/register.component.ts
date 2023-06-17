import {Component} from '@angular/core';
import {Location} from "@angular/common";
import {UserService} from "../service/user.service";
import {UserData} from "../model/user";
import {NgForm} from "@angular/forms";


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  newUser: UserData = {} as UserData;
  submitted = false;
  message: string;

  constructor(private location: Location,
              private service: UserService) {
  }

  back(): void {
    this.location.back()
  }

  onClickSubmit(form: NgForm) {

    if (form.valid) {

      this.service.addUser(this.newUser)
        .subscribe();
      this.submitted = true;

    } else {
      this.message = "Data is not valid";
    }

  }

}


