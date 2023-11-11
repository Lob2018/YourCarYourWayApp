import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { UserTchat } from '../models/user/userTchat.interface';

@Injectable({
  providedIn: 'root',
})
export class TchatService {
  private pathService = 'http://localhost:8081/tchat';

  constructor(private httpClient: HttpClient) {}

  getTchatUSerInfo(): Observable<UserTchat> {
    return this.httpClient
      .get<{ user: UserTchat }>(this.pathService + '')
      .pipe(map((json) => json.user));
  }
}
