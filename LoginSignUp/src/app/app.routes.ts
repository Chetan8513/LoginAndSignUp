import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';

export const routes: Routes = [

    {
        path:'',
        component:LoginComponent,
        pathMatch:'full'
    },
    {
        path:'login',
        component:LoginComponent,
        pathMatch:'full'
    },

    {
        path:'register',
        component:RegisterComponent,
        pathMatch:'full'
    }
   
    
];
