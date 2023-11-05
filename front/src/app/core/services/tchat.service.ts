import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { TchatMessage } from '../models/tchat/tchatMessage.interface';
import { TchatUsers } from '../models/tchat/tchatUsers.interface';

@Injectable({
  providedIn: 'root',
})
export class TchatService {
  private pathService = 'http://localhost:8081/tchat';

  constructor(private httpClient: HttpClient) {}

  getTchatMessages(): Observable<[TchatUsers,TchatMessage[]]> {
    return this.httpClient
      .get<{ users:TchatUsers,messages:TchatMessage[] }>(this.pathService + '')
      .pipe(map((response) => [response.users, response.messages]));
  }

  // postPost(post: PostSingleRequest): Observable<PostSingle> {
  //   return this.httpClient.post<PostSingle>(this.pathService + `post`, post);
  // }
}
