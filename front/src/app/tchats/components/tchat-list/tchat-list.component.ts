import { Component, OnInit } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { TchatMessage } from 'src/app/core/models/tchat/tchatMessage.interface';
import { ErrorHandlerService } from 'src/app/core/services/error-handler.service';
import { map, take } from 'rxjs/operators';
import { Router } from '@angular/router';
import { TchatService } from 'src/app/core/services/tchat.service';
import { MessageService } from 'src/app/core/services/message.service';
import { UserTchat } from 'src/app/core/models/user/userTchat.interface';
import { LocalStorageService } from 'src/app/core/services/local-storage.service';

@Component({
  selector: 'app-tchat-list',
  templateUrl: './tchat-list.component.html',
  styleUrls: ['./tchat-list.component.css'],
})
export class TchatListComponent implements OnInit {
  public msg: TchatMessage[] = [];

  constructor(
    private tchatService: TchatService,
    private messageService: MessageService,
    private localStorageService: LocalStorageService,
    private errorHandler: ErrorHandlerService
  ) {
    this.msg = this.messageService.msg;
  }

  ngOnInit(): void {
    // user's info
    this.tchatService
      .getTchatUSerInfo()
      .pipe(take(1))
      .subscribe({
        next: (response: UserTchat) => {
          this.localStorageService.remove('ycyw-username');
          this.localStorageService.remove('ycyw-company');
          this.localStorageService.set('ycyw-username', response.username);
          this.localStorageService.set('ycyw-company', response.companyname);
        },
        error: (error) => this.errorHandler.handleError(error),
      });
  }
}
