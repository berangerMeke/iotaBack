export interface IImprint {
  id?: number;
  titreImprintEn?: string;
  titreImprintFr?: string;
  titreImprintGer?: string;
  titreImprintSw?: string;
  contenuImprintEn?: string;
  contenuImprintGer?: string;
  contenuImprintFr?: string;
  contenuImprintSw?: string;
}

export class Imprint implements IImprint {
  constructor(
    public id?: number,
    public titreImprintEn?: string,
    public titreImprintFr?: string,
    public titreImprintGer?: string,
    public titreImprintSw?: string,
    public contenuImprintEn?: string,
    public contenuImprintGer?: string,
    public contenuImprintFr?: string,
    public contenuImprintSw?: string
  ) {}
}
