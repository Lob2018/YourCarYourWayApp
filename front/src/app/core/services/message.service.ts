import { Injectable } from '@angular/core';

import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';
import { Client, Message, Frame, over } from 'stompjs';
import * as SockJS from 'sockjs-client';
import { TchatMessage } from '../models/tchat/tchatMessage.interface';

@Injectable({
  providedIn: 'root',
})
export class MessageService {
  constructor() {
    this.initializeWebSocketConnection();
  }
  public stompClient!: Client;

  public msg: TchatMessage[] = [];
  public listenToTopic: string = '/topic/messages';

  initializeWebSocketConnection() {
    const serverUrl = environment.app_url;
    // Create a WebSocket connection at http://localhost:8081/ws
    const ws = new SockJS(serverUrl);
    // Create a new StompClient object with the WebSocket endpoint
    this.stompClient = over(ws);
    const that = this;
    // Start the STOMP communications, provide a callback for when the CONNECTED frame arrives.
    this.stompClient.connect({}, function (frame: Frame | undefined) {
      // Subscribe to "/topic/messages". Whenever there is a new message, add the text in a list-item element in the unordered list.
      that.stompClient.subscribe(that.listenToTopic, (payload: Message) => {
        if (payload.body) {
          const output: TchatMessage = JSON.parse(payload.body);
          that.msg.push(output);
        }
      });
    });
  }
  // Function to send message. This function is invoked while you click on the
  // Send in the HTML page. It takes the value in the ‘message-input’ text field
  // and send it to the server with empty headers ({})
  sendMessage(topic: string, message: string) {
    this.stompClient.send(topic, {}, message);
  }
}
