import { MasterDTO } from "./Gender";

export class UserDTO
{
    public _email : string = "";
    public _password : string = "";
    public _name : string = "";
    public _lastName : string = "";
    public _gender : MasterDTO = new MasterDTO();
    public _country : MasterDTO = new MasterDTO();

    constructor(data?: any) {
        if (data){

            this._email = data._email;
            this._name = data._name;
            this._lastName = data._lastName;
        }
    }

}