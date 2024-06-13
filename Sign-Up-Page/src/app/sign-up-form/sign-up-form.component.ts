import { Component,} from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up-form',
  templateUrl: './sign-up-form.component.html',
  styleUrl: './sign-up-form.component.css'
})
export class SignUpFormComponent {
  form : Form = new Form();
  constructor(private http:HttpClient,private router:Router){}
  submit() {
      console.log(this.form);
      this.http.post<Form>("http://localhost:8080/register",this.form).subscribe(
        response => {
          console.log('Registration Successful',response);
          alert('User Registered Successful , Please to go to Login Page');
        },
        error => {
          console.error('Error registering user',error);
          alert('Existing user');
        }
      );
  }

}
class Form{
  firstName: string = '';
  lastName : string = '';
  email : string = '';
  password : string ='';
  confirmPassword : string ='';
}
