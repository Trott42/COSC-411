import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from 'src/app/service/data.service';
import { Candidate } from 'src/app/model/Candidate';

@Component({
    selector: 'app-login-popup',
    standalone: true,
    templateUrl: './login-popup.component.html',
    styleUrl: './login-popup.component.scss',
    imports: [FormsModule]
})
export class LoginPopupComponent implements OnInit {
  form!: FormGroup;
  loading = false;
  submitted = false;
  email: string = "";
  hashedPassword: string = "";
  value = "";
  public account: Candidate[] | undefined;
  public account2: Candidate = new Candidate();

  constructor(
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private userService: DataService
  ) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
    localStorage.setItem("ACCOUNT", "");
  }

  // convenience getter for easy access to form fields
  get f() { return this.form.controls; }

  onClickSubmit(): void {
    this.account2.email = this.email!;
    this.account2.hashedPassword = this.hashedPassword!;
    this.userService.candidateLogin(this.account2).subscribe((response) => {
      if (response.jwtToken) {
        const jwtToken = response.jwtToken;
        localStorage.setItem('JWT', jwtToken);
        localStorage.setItem('EMAIL', this.email);
        this.router.navigateByUrl('dashboard');
      }
    })
    this.value = "Email or Password is invalid";
  }
}
