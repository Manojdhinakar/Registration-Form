import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.css'
})
export class LoginFormComponent {
  form: Form = new Form();
  constructor(private http:HttpClient,private router:Router){}
  submit() {
    console.log(this.form);
    this.http.post<{success:boolean,message:string,user?: Form}>("http://localhost:8080/login",this.form).subscribe(
      response=>{
        if(response.success){
          console.log('Login Successful',response);
          alert('Login Successful');
         }
      },
        error => {
          console.error(' Error during login',error);
          alert('Username or Password wrong ,  If Not Registered Please Sign-Up '+error.message);
        }
      
    );
}
}
class Form{
  email : string = '';
  password : string ='';
}
