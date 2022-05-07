export interface IGoogleAnalitcs {
  id?: number;
  googleAnalyticsID?: string;
}

export class GoogleAnalitcs implements IGoogleAnalitcs {
  constructor(public id?: number, public googleAnalyticsID?: string) {}
}
