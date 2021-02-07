import { Component, Injector, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserDTO } from 'src/app/modelos/User';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  private router: Router = this.injector.get(Router);
  private userService: UserService = this.injector.get(UserService);
  public user : UserDTO = new UserDTO();
  
  constructor(protected injector: Injector) { }

  ngOnInit(): void {
  }

  registrarse(){

    this.userService.register(this.user).then(res => {
      window.alert("registro exitoso");
      this.router.navigate(['/']);
    }, error =>{
      console.log(error);
      window.alert("Error al registrarse");

    })

  }

}
