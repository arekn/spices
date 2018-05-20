import {Injectable} from '@angular/core';
import {Message} from './message';

@Injectable()
export class MessageService {

  public messages: Array<Message> = [];

  constructor() {
  }

  public closeMessage(msg: Message) {
    const index: number = this.messages.indexOf(msg);
    this.messages.splice(index, 1);
  }

  public pushSuccessMessage(text: string) {
    let msg = new Message();
    msg.id = this.messages.length + 1;
    msg.type = 'success';
    msg.text = text;
    this.messages.push(msg);
    console.log(this.messages)
  }

  public pushErrorMessage(text: string) {
    let msg = new Message();
    msg.id = this.messages.length + 1;
    msg.type = 'danger';
    msg.text = text;
    this.messages.push(msg);
  }
}
