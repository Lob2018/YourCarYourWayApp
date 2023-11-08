import { Component } from '@angular/core';
import { ErrorHandlerService } from 'src/app/core/services/error-handler.service';
import { Message } from '@stomp/stompjs';
import { RxStompService } from '../../rx-stomp.service';

@Component({
  selector: 'app-new-tchat',
  templateUrl: './new-tchat.component.html',
  styleUrls: ['./new-tchat.component.css'],
})
export class NewTchatComponent {
  receivedMessages: string[] = [];
  // @ts-ignore, to suppress warning related to being undefined
  private topicSubscription: Subscription;

  constructor(
    private errorHandler: ErrorHandlerService,
    private rxStompService: RxStompService
  ) {}

  ngOnInit() {
    this.topicSubscription = this.rxStompService
      .watch('/topic/demo')
      .subscribe((message: Message) => {
        this.receivedMessages.push(message.body);
      });
  }

  ngOnDestroy() {
    this.topicSubscription.unsubscribe();
  }

  onSendMessage() {
    const message = `Message generated at ${new Date()}`;
    this.rxStompService.publish({ destination: '/topic/demo', body: message });
  }
}
