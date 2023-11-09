import { ErrorHandlerService } from 'src/app/core/services/error-handler.service';
import { WebSocketService } from 'src/app/core/services/websocket-service.service';
import { Router, RouterModule, Routes } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { Message } from 'stompjs';
import { MessageService } from 'src/app/core/services/message.service';

@Component({
  selector: 'app-new-tchat',
  templateUrl: './new-tchat.component.html',
  styleUrls: ['./new-tchat.component.css'],
})
export class NewTchatComponent {
  title = 'angular8-springboot-websocket';
  topic = '/topic/messages';
  messages: string[] = [];

  constructor(
    private errorHandler: ErrorHandlerService,
    private messageService: MessageService
  ) {}

  ngOnInit() {}

  onSendMessage(message: string): void {
    if (message) {
      this.messageService.sendMessage(message);
    }
  }
}
