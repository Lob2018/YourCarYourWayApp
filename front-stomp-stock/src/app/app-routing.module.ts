import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingPageComponent } from './landing-page/components/landing-page/landing-page.component';
import { LoginComponent } from './auth/components/login/login.component';
import { RegisterComponent } from './auth/components/register/register.component';
import { NotFoundComponent } from './not-found/components/not-found/not-found.component';

const routes: Routes = [
  {
    path: 'tchats',
    loadChildren: () =>
      import('./tchats/tchats.module').then((m) => m.TchatsModule),
  }, // lazy loading for tchats routes

  {
    path: 'user-page',
    loadChildren: () =>
      import('./user-page/user-page.module').then((m) => m.UserPageModule),
  }, // lazy loading for user-page route
  { path: 'auth/login', component: LoginComponent },
  { path: 'auth/register', component: RegisterComponent },
  { path: '', component: LandingPageComponent },
  { path: '404', component: NotFoundComponent },
  { path: '**', redirectTo: '404' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
