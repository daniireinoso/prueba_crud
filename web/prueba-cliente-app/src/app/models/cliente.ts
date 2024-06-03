// src/app/models/cliente.ts
export interface Cliente {
    id?: number;
    nombre: string;
    apellido: string;
    ordenes?: Orden[];
  }
  
  export interface Orden {
    id?: number;
    codigo: string;
    fecha: Date;
    articulos?: Articulo[];
  }
  
  export interface Articulo {
    id?: number;
    codigo: string;
    nombre: string;
    precioUnitario: number;
  }
  