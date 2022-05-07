export interface IPrivacyPolicy {
  id?: number;
  titrePrivacyPolicyEn?: string;
  titrePrivacyPolicyGer?: string;
  titrePrivacyPolicyFr?: string;
  titrePrivacyPolicySw?: string;
  contenuPrivacyPolicyEn?: string;
  contenuPrivacyPolicyGer?: string;
  contenuPrivacyPolicyFr?: string;
  contenuPrivacyPolicySw?: string;
}

export class PrivacyPolicy implements IPrivacyPolicy {
  constructor(
    public id?: number,
    public titrePrivacyPolicyEn?: string,
    public titrePrivacyPolicyGer?: string,
    public titrePrivacyPolicyFr?: string,
    public titrePrivacyPolicySw?: string,
    public contenuPrivacyPolicyEn?: string,
    public contenuPrivacyPolicyGer?: string,
    public contenuPrivacyPolicyFr?: string,
    public contenuPrivacyPolicySw?: string
  ) {}
}
