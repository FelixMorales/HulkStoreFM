import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { Injector } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserDTO } from 'src/app/modelos/User';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  private router: Router = this.injector.get(Router);
  private userService: UserService = this.injector.get(UserService);
  public user : UserDTO = new UserDTO();

  constructor(protected injector: Injector) { 

  }


  ngOnInit(): void {
  }

  iniciarSesion()
  {

    this.userService.login(this.user).then(res =>{
      console.log(res)
      window.alert("Login exitoso: "+res._name);

      localStorage.setItem("token", res._token);
    }, e =>{
      window.alert("credenciales incorrectas");
    } );

    this.user._email = "";
    this.user._password = "";
  }



}
