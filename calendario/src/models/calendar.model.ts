
export interface CalendarType {
  id: number;
  tipo: string;
}

export interface Calendar {
  id: number;
  fecha: string;
  descripcion: string;
  year: number;
  tipo: CalendarType;
}
