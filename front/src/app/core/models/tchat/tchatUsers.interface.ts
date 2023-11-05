import { TchatUser } from './tchatUser.interface';

export interface TchatUsers {
  me: TchatUser;
  others: TchatUser[];
}
