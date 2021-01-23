export type DoctorsResponse = {
    content: Doctor[];
    totalPages: number;
}

export type Doctor = {
    id: number;
    name: string;
    crmNumber: number;
    phoneNumber: string;
    address: string;
    complement: string;
    homeNumber: string;
    neighborhood: string;
    cellphoneNumber: string;
    zipCode: string;
    specialties: Specialty[];
}

export type Specialty = {
    id: number;
    name: string;
}