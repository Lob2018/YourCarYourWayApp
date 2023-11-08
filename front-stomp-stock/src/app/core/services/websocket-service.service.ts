import { Injectable } from '@angular/core';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WebSocketService {
  private serverUrl = 'http://localhost:8080/ws';
  private stompClient!:Stomp.Client;

  public connect(): Observable<any> {
    const socket = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(socket);
    const observable = new Observable(observer => {
      this.stompClient.connect({}, (frame) => {
        observer.next(frame);
      });
    });
    return observable;
  }

  public subscribe(topic: string): Observable<any> {
    const observable = new Observable(observer => {
      this.stompClient.subscribe(topic, (message:Stomp.Message) => {
        observer.next(message);
      });
    });
    return observable;
  }

  public send(topic: string, message: string): void {
    this.stompClient.send(topic, {}, message);
  }
}