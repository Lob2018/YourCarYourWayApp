import { ErrorHandlerService } from 'src/app/core/services/error-handler.service';
import { Router, RouterModule, Routes } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { Message } from 'stompjs';
import { MessageService } from 'src/app/core/services/message.service';
import { LocalStorageService } from 'src/app/core/services/local-storage.service';
import * as DOMPurify from 'dompurify';

@Component({
  selector: 'app-new-tchat',
  templateUrl: './new-tchat.component.html',
  styleUrls: ['./new-tchat.component.css'],
})
export class NewTchatComponent {
  messages: string[] = [];
  sendToTopic: string = '/app/chat';

  constructor(
    private errorHandler: ErrorHandlerService,
    private messageService: MessageService,
    private localStorageService: LocalStorageService
  ) {}

  ngOnInit() {}

  onSendMessage(msg: string): void {
    const message = DOMPurify.sanitize(msg);
    if (message) {
      const username = this.localStorageService.get('ycyw-username');
      const companyname = this.localStorageService.get('ycyw-company');
      const content = {
        username: username,
        companyname: companyname,
        content: message,
      };
      this.messageService.sendMessage(
        this.sendToTopic,
        JSON.stringify(content)
      );
    }
  }
}
