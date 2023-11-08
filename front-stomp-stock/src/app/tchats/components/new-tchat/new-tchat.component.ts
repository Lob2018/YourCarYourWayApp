import { Component } from '@angular/core';
import { ErrorHandlerService } from 'src/app/core/services/error-handler.service';
import { WebSocketService } from 'src/app/core/services/websocket-service.service';
import { Router } from '@angular/router';
import * as Stomp from 'stompjs';
import { Message } from 'stompjs';

@Component({
  selector: 'app-new-tchat',
  templateUrl: './new-tchat.component.html',
  styleUrls: ['./new-tchat.component.css'],
})
export class NewTchatComponent {
  title = 'angular8-springboot-websocket';
  topic = '/topic/messages';
  messages: String[] = [];

  constructor(
    private errorHandler: ErrorHandlerService,
    private webSocketService: WebSocketService
  ) {}

  ngOnInit() {
    this.webSocketService.connect().subscribe(() => {
      this.webSocketService
        .subscribe(this.topic)
        .subscribe((message: Message) => {
          this.messages.push(message.body);
        });
    });
  }

  onSendMessage(message: string): void {
    this.webSocketService.send('/app/hello', message);
  }
}
