import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './page/home/home.component';
import { AdminComponent } from './page/admin/admin.component';
import { InfoComponent } from './page/info/info.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'info', component: InfoComponent },
  { path: 'admin', component: AdminComponent },

  // {
  //   path: '', component: HomeComponent,
  //   children: [
  //     { path: 'info', component: InfoComponent }
  //   ]
  // },
  // {
  //   path: 'admin', component: AdminComponent,
  //   children: [
  //   ]
  // }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
