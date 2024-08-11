import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './page/home/home.component';
import { RouterOutlet } from '@angular/router';
import { AdminComponent } from './page/admin/admin.component';
import { InfoComponent } from './page/info/info.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { SlideProductComponent } from './component/slide-product/slide-product.component';
import { NewProductComponent } from './component/new-product/new-product.component';
import { NewCategoryComponent } from './component/new-category/new-category.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AdminComponent,
    InfoComponent,
    HeaderComponent,
    FooterComponent,
    SlideProductComponent,
    NewProductComponent,
    NewCategoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterOutlet,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
