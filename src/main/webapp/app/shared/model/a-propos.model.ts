export interface IAPropos {
  id?: number;
  titreFr?: string;
  titreEn?: string;
  titreGer?: string;
  titreSw?: string;
  sousTitreFr?: string;
  sousTitreEn?: string;
  sousTitreGer?: string;
  sousTitreSw?: string;
  textParagraphe1Fr?: string;
  textParagraphe1En?: string;
  textParagraphe1Ger?: string;
  textParagraphe1Sw?: string;
  textParagraphe2Fr?: string;
  textParagraphe2En?: string;
  textParagraphe2Ger?: string;
  textParagraphe2Sw?: string;
  textParagraphe3Fr?: string;
  textParagraphe3En?: string;
  textParagraphe3Ger?: string;
  textParagraphe3Sw?: string;
  textParagraphe4Fr?: string;
  textParagraphe4En?: string;
  textParagraphe4Ger?: string;
  textParagraphe4Sw?: string;
  textParagraphe5Fr?: string;
  textParagraphe5En?: string;
  textParagraphe5Ger?: string;
  textParagraphe5Sw?: string;
  imageContentType?: string;
  image?: any;
}

export class APropos implements IAPropos {
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
    public textParagraphe1Fr?: string,
    public textParagraphe1En?: string,
    public textParagraphe1Ger?: string,
    public textParagraphe1Sw?: string,
    public textParagraphe2Fr?: string,
    public textParagraphe2En?: string,
    public textParagraphe2Ger?: string,
    public textParagraphe2Sw?: string,
    public textParagraphe3Fr?: string,
    public textParagraphe3En?: string,
    public textParagraphe3Ger?: string,
    public textParagraphe3Sw?: string,
    public textParagraphe4Fr?: string,
    public textParagraphe4En?: string,
    public textParagraphe4Ger?: string,
    public textParagraphe4Sw?: string,
    public textParagraphe5Fr?: string,
    public textParagraphe5En?: string,
    public textParagraphe5Ger?: string,
    public textParagraphe5Sw?: string,
    public imageContentType?: string,
    public image?: any
  ) {}
}
