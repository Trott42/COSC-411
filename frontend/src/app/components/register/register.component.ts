import { Component } from '@angular/core';
import { FormBuilder, FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Candidate } from 'src/app/model/Candidate';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {
  fname:string="";
  lname:string="";
  email:string="";
  phone: string="";
  address:string="";
  city:string="";
  zipCode=null;
  password:string="";
  confirm:string="";
  cnt=0;
  empty="*At least one of the fields is empty";
  value="";
  public account: Candidate[] | undefined; 
  public account2: Candidate = new Candidate; 
  constructor(
    private formBuilder: FormBuilder,private userService: DataService,
    private router: Router
  )   {

}
onClickSubmit():void {
  
  console.log("33333333333333");   
  const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]+$/;
  if(this.fname==""||this.lname==""||this.phone==""||this.email==""
    ||this.password==""||this.confirm==""||this.address==""||this.city==""||this.zipCode==null)
  {
    this.value=this.empty;
    return;
  }
  if(this.password.length<16 || !passwordRegex.test(this.password))
  {
    this.value="Password does not meet criteria";
    return;
  }
  for(let i=0; i<this.email.length;i++)
  {
    if(this.email[i]=='@')
    {
      this.cnt++;
    }
  }
  if(this.cnt!=1)
  {
    this.value="Invalid Email";
    return;
  }
  if(this.password!=this.confirm)
  {
    return;
  }
  this.account2.fname=this.fname;
  this.account2.lname=this.lname;
  this.account2.phone=this.phone;
  this.account2.email=this.email.toLowerCase();
  this.account2.address=this.address!;
  this.account2.city=this.city!;
  this.account2.zipCode=this.zipCode!;
  this.account2.hashedPassword=this.password!;
 
  console.log(this.account2);
  this.userService.signup(this.account2).subscribe(
    (response) => {
      console.log('POST request successful:', response);
      localStorage.setItem("ACCOUNT","Account Created Successfully")
      this.router.navigateByUrl('/login');
    },
    (error) => {
      console.error('Error:', error);
    }
  ); 
}
}