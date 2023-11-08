import { ErrorHandlerService } from 'src/app/core/services/error-handler.service';
import { WebSocketService } from 'src/app/core/services/websocket-service.service';
import { Router, RouterModule, Routes } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import {Message} as Stomp from 'stompjs';

@Component({
  selector: 'app-new-tchat',
  templateUrl: './new-tchat.component.html',
  styleUrls: ['./new-tchat.component.css']
})


export class NewTchatComponent {
  title = 'angular8-springboot-websocket';
  topic = '/topic/messages';
  messages: string[] = [];

  constructor(
    private errorHandler: ErrorHandlerService,
    private webSocketService: WebSocketService
  ) {}

  ngOnInit() {
    this.webSocketService.connect().subscribe(() => {
      this.webSocketService
        .subscribe(this.topic)
        .subscribe((message: Stomp.Message) => {
          this.messages.push(message.body);
        });
    });
  }

  onSendMessage(message: string): void {
    this.webSocketService.send('/app/hello', message);
  }
}
