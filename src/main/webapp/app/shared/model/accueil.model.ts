export interface IAccueil {
  id?: number;
  titreFr?: string;
  titreEn?: string;
  titreGer?: string;
  titreSw?: string;
  sousTitreFr?: string;
  sousTitreEn?: string;
  sousTitreGer?: string;
  sousTitreSw?: string;
  imageContentType?: string;
  image?: any;
}

export class Accueil implements IAccueil {
  constructor(
    public id?: number,
    public titreFr?: string,
    public titreEn?: string,
    public titreGer?: string,
    public titreSw?: string,
    public sousTitreFr?: string,
    public sousTitreEn?: string,
    public sousTitreGer?: string,
    public sousTitreSw?: string,
    public imageContentType?: string,
    public image?: any
  ) {}
}
