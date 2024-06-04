import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app.routes';
import { FormsModule } from '@angular/forms';
import { ClienteListComponent } from './components/cliente-list/cliente-list.component';
import { ClienteService } from './services/cliente.service';
import { CommonModule, NgFor } from '@angular/common';



@NgModule({
  declarations: [
    AppComponent,
    ClienteListComponent,
    BrowserModule,
    CommonModule
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    CommonModule,
    NgFor
  ],
  providers: [ClienteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
