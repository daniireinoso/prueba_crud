import { RouterModule, Routes } from '@angular/router';
import { ClienteListComponent } from './components/cliente-list/cliente-list.component';
import { NgModule } from '@angular/core';

export const routes: Routes = [
    { path: 'clientes', component: ClienteListComponent },
    { path: '', redirectTo: '/clientes', pathMatch: 'full' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }