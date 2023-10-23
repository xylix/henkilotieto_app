export interface PersonData {
  name: string;
  id: string;
  address: string;
  nationality: string;
  nativeLanguage: string;
  familyInformation: string | undefined;
  birth: Date;
  death: Date | undefined;
}

export interface PersonFormData {
  name: string | undefined;
  id: string | undefined;
  address: string | undefined;
  nationality: string | undefined;
  nativeLanguage: string | undefined;
  familyInformation: string | undefined;
  birth: Date | undefined;
  death: Date | undefined;
}
