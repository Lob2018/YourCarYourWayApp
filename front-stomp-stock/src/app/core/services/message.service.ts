import { Injectable } from '@angular/core';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MessageService {
  constructor() {
    this.initializeWebSocketConnection();
  }
  public stompClient!: Stomp.Client;
  public subscription!: Stomp.Subscription;

  public msg: string[] = [];

  initializeWebSocketConnection() {
    const serverUrl = environment.app_url;
    console.log('######### Le serveur est : ' + serverUrl);

    const ws = new SockJS(serverUrl);
    this.stompClient = Stomp.over(ws);
    const that = this;
    // tslint:disable-next-line:only-arrow-functions
    //     this.stompClient.connect({}, function (frame) {
    //         that.stompClient.subscribe('/chat', (message) => {
    //         console.log('2 ###');
    //         if (message.body) {
    //           console.log(message.body);
    //           that.msg.push(message.body);
    //         }
    //       });
    //     });

    this.stompClient.connect({}, function (frame) {
        console.log('Connected to WebSocket');

      that.subscription = that.stompClient.subscribe('/chat', (message) => {
        console.log('2 ###');
        if (message.body) {
          console.log(message.body);
          that.msg.push(message.body);
        }
      });
    });
  }

  sendMessage(message: string) {
    console.log('######### Mon message : ' + message);
    this.stompClient.send('/topic/messages', {}, message);
  }
}
