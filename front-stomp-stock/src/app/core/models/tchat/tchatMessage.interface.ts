export interface TchatMessage {
  tchatuuid: string;
  sender_senderuuid: string;
  createdat: Date;
  updatedat: Date;
  active: boolean;
  content: string;
}
