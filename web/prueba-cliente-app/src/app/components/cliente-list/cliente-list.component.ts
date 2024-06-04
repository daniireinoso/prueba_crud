import { Component, OnInit } from '@angular/core';
import { Cliente } from '../../models/cliente';
import { ClienteService } from '../../services/cliente.service';

@Component({
  selector: 'app-cliente-list',
  templateUrl: './cliente-list.component.html',
  styleUrls: ['./cliente-list.component.css'],
})
export class ClienteListComponent implements OnInit {
  clientes: Cliente[] = [];
  clienteSeleccionado: Cliente | null = null;

  constructor(private clienteService: ClienteService) {}

  ngOnInit(): void {
    this.loadClientes();
  }

  loadClientes(): void {
    this.clienteService.getAllClientes().subscribe(clientes => {
      this.clientes = clientes;
    });
  }

  selectCliente(cliente: Cliente): void {
    this.clienteSeleccionado = cliente;
  }

  createCliente(cliente: Cliente): void {
    this.clienteService.createCliente(cliente).subscribe(() => {
      this.loadClientes();
    });
  }

  updateCliente(cliente: Cliente): void {
    if (this.clienteSeleccionado && this.clienteSeleccionado.id !== undefined) {
      this.clienteService.updateCliente(this.clienteSeleccionado.id, cliente).subscribe(() => {
        this.loadClientes();
      });
    }
  }

  deleteCliente(id: number): void {
    this.clienteService.deleteCliente(id).subscribe(() => {
      this.loadClientes();
    });
  }
}
