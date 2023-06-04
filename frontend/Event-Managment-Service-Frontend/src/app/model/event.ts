import { User } from './user';

export interface Event {
  id: number;
  title: string;
  startDate: Date;
  endDate: Date;
  description: string;
  // host: User;
}

export interface EventData {
  title: string;
  startDate: Date;
  endDate: Date;
  description: string;
  // host: User;
}
