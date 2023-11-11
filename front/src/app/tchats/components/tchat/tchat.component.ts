import { Component, Input, OnInit } from '@angular/core';
import { TchatMessage } from 'src/app/core/models/tchat/tchatMessage.interface';
import { LocalStorageService } from 'src/app/core/services/local-storage.service';

@Component({
  selector: 'app-tchat',
  templateUrl: './tchat.component.html',
  styleUrls: ['./tchat.component.css'],
})
export class TchatComponent implements OnInit {
  public userAndCompany!: string;
  public username!: string;
  public company!: string;

  @Input() tchatMessage!: TchatMessage;

  constructor(private localStorageService: LocalStorageService) {}
  ngOnInit(): void {
    this.username = this.localStorageService.get('ycyw-username') + '';
    this.company = this.localStorageService.get('ycyw-company') + '';
    this.userAndCompany = '' + this.username + this.company;
  }

  getUserAndCompany(): string {
      const isBottom =
        document.documentElement.scrollTop + window.innerHeight ===
        document.documentElement.offsetHeight;
      if (!isBottom) {
        window.scrollTo(0, document.body.scrollHeight + 100);
      }
      return this.userAndCompany;   
  }
}
