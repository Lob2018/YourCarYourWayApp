import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatCardModule } from '@angular/material/card';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatDividerModule } from '@angular/material/divider';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { TchatListComponent } from './components/tchat-list/tchat-list.component';
import { TchatComponent } from './components/tchat/tchat.component';
import { TchatsRoutingModule } from './tchats-routing.module';
import { NewTchatComponent } from './components/new-tchat/new-tchat.component';
import { rxStompServiceFactory } from './components/rx-stomp-service-factory';
import { RxStompService } from './components/rx-stomp.service';


const materialModules = [
  MatButtonModule,
  MatProgressSpinnerModule,
  MatCardModule,
  MatInputModule,
  MatIconModule,
  MatSnackBarModule,
  MatDividerModule,
  MatSelectModule,
];

@NgModule({
  declarations: [
    TchatListComponent,
    TchatComponent,
    NewTchatComponent,
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    TchatsRoutingModule,
    FormsModule,
    ...materialModules,
  ],
  providers: [
    {
      provide: RxStompService,
      useFactory: rxStompServiceFactory,
    },
  ],
  exports: [

    TchatListComponent,
    TchatComponent,
  ],
})
export class TchatsModule { }
