export interface IEquipe {
  id?: number;
  titreFr?: string;
  titreEn?: string;
  titreGer?: string;
  titreSw?: string;
  souTitreFr?: string;
  souTitreEn?: string;
  souTitreGer?: string;
  souTitreSw?: string;
  nom1?: string;
  nom2?: string;
  nom3?: string;
  nom4?: string;
  nom5?: string;
  nom6?: string;
  nom7?: string;
  nom8?: string;
  prenom1?: string;
  prenom2?: string;
  prenom3?: string;
  prenom4?: string;
  prenom5?: string;
  prenom6?: string;
  prenom7?: string;
  prenom8?: string;
  qualite1?: string;
  qualite2?: string;
  qualite3?: string;
  qualite4?: string;
  qualite5?: string;
  qualite6?: string;
  qualite7?: string;
  qualite8?: string;
  image1ContentType?: string;
  image1?: any;
  image2ContentType?: string;
  image2?: any;
  image3ContentType?: string;
  image3?: any;
  image4ContentType?: string;
  image4?: any;
  image5ContentType?: string;
  image5?: any;
  image6ContentType?: string;
  image6?: any;
  image7ContentType?: string;
  image7?: any;
  image8ContentType?: string;
  image8?: any;
}

export class Equipe implements IEquipe {
  constructor(
    public id?: number,
    public titreFr?: string,
    public titreEn?: string,
    public titreGer?: string,
    public titreSw?: string,
    public souTitreFr?: string,
    public souTitreEn?: string,
    public souTitreGer?: string,
    public souTitreSw?: string,
    public nom1?: string,
    public nom2?: string,
    public nom3?: string,
    public nom4?: string,
    public nom5?: string,
    public nom6?: string,
    public nom7?: string,
    public nom8?: string,
    public prenom1?: string,
    public prenom2?: string,
    public prenom3?: string,
    public prenom4?: string,
    public prenom5?: string,
    public prenom6?: string,
    public prenom7?: string,
    public prenom8?: string,
    public qualite1?: string,
    public qualite2?: string,
    public qualite3?: string,
    public qualite4?: string,
    public qualite5?: string,
    public qualite6?: string,
    public qualite7?: string,
    public qualite8?: string,
    public image1ContentType?: string,
    public image1?: any,
    public image2ContentType?: string,
    public image2?: any,
    public image3ContentType?: string,
    public image3?: any,
    public image4ContentType?: string,
    public image4?: any,
    public image5ContentType?: string,
    public image5?: any,
    public image6ContentType?: string,
    public image6?: any,
    public image7ContentType?: string,
    public image7?: any,
    public image8ContentType?: string,
    public image8?: any
  ) {}
}
