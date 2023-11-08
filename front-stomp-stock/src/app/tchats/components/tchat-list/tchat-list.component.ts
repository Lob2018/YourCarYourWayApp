import { Component, OnInit } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { TchatMessage } from 'src/app/core/models/tchat/tchatMessage.interface';
import { ErrorHandlerService } from 'src/app/core/services/error-handler.service';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';
import { TchatService } from 'src/app/core/services/tchat.service';
import { TchatUsers } from 'src/app/core/models/tchat/tchatUsers.interface';
@Component({
  selector: 'app-tchat-list',
  templateUrl: './tchat-list.component.html',
  styleUrls: ['./tchat-list.component.css']
})
export class TchatListComponent {
  messages$!: Observable<[TchatUsers,TchatMessage[]]>;
  sortDirection: 'ascending' | 'descending' = 'ascending';

  constructor(
    private tchatService: TchatService,
    private errorHandler: ErrorHandlerService,
  ) {}

  ngOnInit(): void {
    // this.messages$ = this.tchatService.getTchatMessages().pipe(
    //   catchError((error) => {
    //     return this.errorHandler.handleError(error);
    //   })
    // );
  }
}
