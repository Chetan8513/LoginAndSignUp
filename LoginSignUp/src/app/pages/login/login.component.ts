import { Component } from '@angular/core';
import { ServiceService } from '../service.service';
import { Router, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
//import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';




@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule],
 
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
 
})
export class LoginComponent {

  constructor(private service: ServiceService, private router:Router){}

 




  login(userName: string, password: string): void {
  this.service.login(userName, password)
    

  }

}
