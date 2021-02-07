import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { UserDTO } from 'src/app/modelos/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  login(user: UserDTO): Promise<any> {

    return this.http.post("http://127.0.0.1:8080/apirest-1.0/api/user/authenticate", user).toPromise()
        .then((res) => {

          return res;
        });
  }

  register(user: UserDTO): Promise<any> {

    return this.http.post("http://127.0.0.1:8080/apirest-1.0/api/user/addClient", user).toPromise()
        .then((res) => {


          return res;
        });
  }

}
