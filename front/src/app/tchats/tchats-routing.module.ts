import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from '../core/guards/auth.guard';
import { TchatListComponent } from './components/tchat-list/tchat-list.component';

const routes: Routes = [
  { path: '', component: TchatListComponent, canActivate: [AuthGuard] },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TchatsRoutingModule {}
