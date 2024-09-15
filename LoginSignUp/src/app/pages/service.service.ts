import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor( private http:HttpClient, private router:Router) { }


 // private apiUrl = 'localhost:8081/api/login';

 
 login(userName: string, password: string): void {
  const loginPayload = { userName, password };
  this.http.post<{ token: string }>('http://localhost:8081/api/login', loginPayload, {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
        responseType: 'json'
  }).subscribe({
      next: (response) => {
          console.log('Login successful:', response);
          const token = response.token;
          // Store token in localStorage or a service for further requests
          localStorage.setItem('authToken', token);
          // Navigate to the next page
          this.router.navigate(['/register']); // Or any other page you want to route to
      },
      error: (error) => {
        alert("invalid creditials")
          console.error('Login failed:', error);
      }
  });
}



}
