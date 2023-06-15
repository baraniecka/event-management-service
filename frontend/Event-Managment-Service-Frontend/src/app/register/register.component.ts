import {Component} from '@angular/core';
import {Location} from "@angular/common";
import {UserService} from "../service/user.service";
import {User, UserData} from "../model/user";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  user: UserData = {username: "", password: "", email: ""};

  constructor(private location: Location,
              private service: UserService) {
  }

  back(): void {
    this.location.back()
  }

  onClickSubmit(data) {
    const {username, password, repeatPassword, email} = data;
    // alert(JSON.stringify(data));
    // if (password == repeatPassword) {
      this.service.addUser({username, email, password} as UserData)
        .subscribe();
    // }
  }

}


