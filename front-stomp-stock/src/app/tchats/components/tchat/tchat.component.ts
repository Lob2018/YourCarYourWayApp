import { Component, Input, OnInit } from '@angular/core';
import { TchatMessage } from 'src/app/core/models/tchat/tchatMessage.interface';
import { TchatUser } from 'src/app/core/models/tchat/tchatUser.interface';

@Component({
  selector: 'app-tchat',
  templateUrl: './tchat.component.html',
  styleUrls: ['./tchat.component.css'],
})
export class TchatComponent implements OnInit {
  @Input() message!: string;

  @Input() tchatMessage!: TchatMessage;
  @Input() user!: TchatUser;
  // @Input() userMessage!: TchatUser;
  constructor() {}
  ngOnInit(): void {}
}
