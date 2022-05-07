export interface IFooterSection {
  id?: number;
  titreEn?: string;
  titreGer?: string;
  titreFr?: string;
  titreSw?: string;
  sousTitreEn?: string;
  sousTitreGer?: string;
  sousTitreFr?: string;
  sousTitreSw?: string;
  logoContentType?: string;
  logo?: any;
  texteBouton?: string;
  twitterlink?: string;
  discordLink?: string;
}

export class FooterSection implements IFooterSection {
  constructor(
    public id?: number,
    public titreEn?: string,
    public titreGer?: string,
    public titreFr?: string,
    public titreSw?: string,
    public sousTitreEn?: string,
    public sousTitreGer?: string,
    public sousTitreFr?: string,
    public sousTitreSw?: string,
    public logoContentType?: string,
    public logo?: any,
    public texteBouton?: string,
    public twitterlink?: string,
    public discordLink?: string
  ) {}
}
