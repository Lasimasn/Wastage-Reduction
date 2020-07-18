import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SignupOuterComponent } from './signup-outer/signup-outer.component';
import { RestaurantDashboardComponent } from './restaurant-dashboard/restaurant-dashboard.component';
import { LoginComponent } from './login/login.component';
import { CharityDashBoardComponent } from './charity-dash-board/charity-dash-board.component';
import { DeliveryBoyDashBoardComponent } from './delivery-boy-dash-board/delivery-boy-dash-board.component';
import { DashboardComponent } from './dashboard/dashboard.component'
import { ProfileEditableComponent } from './profile-editable/profile-editable.component';
import { RouteMapComponent } from './route-map/route-map.component';


const routes: Routes = [
  {path : '',component :HomeComponent},
  {path: 'SignUp', component : SignUpComponent},
  {path: 'SignUpOuter', component : SignupOuterComponent},
  {path: 'restaurantDashboard', component : RestaurantDashboardComponent},
  {path: 'Login', component : LoginComponent },
  {path: 'DeliveryBoyDashBoard',component : DeliveryBoyDashBoardComponent},
  {path: 'CharityDashBoard',component : CharityDashBoardComponent},
  {path: 'DashboardComponent',component : DashboardComponent },
  {path: 'ProfileEditable',component:ProfileEditableComponent},
  {path: 'RouteMap',component:RouteMapComponent}

];


@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
