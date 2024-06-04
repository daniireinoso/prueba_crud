import { Component } from '@angular/core';
import { ClienteService } from '../../services/cliente.service';

@Component({
  selector: 'app-agregar',
  standalone: true,
  imports: [],
  templateUrl: './agregar.component.html',
  styleUrl: './agregar.component.css'
})
export class AgregarComponent {

  item: any = {};
  router: any;

  constructor(private clienteService: ClienteService) {}

  guardarItem() {
    this.clienteService.createCliente(this.item).subscribe(() => {
      this.router.navigate(['/lista']); 
    });
  }
}
