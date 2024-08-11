import { AdminComponent } from './../page/admin/admin.component';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private productUrl = 'http://localhost:8080/api/products';

  constructor(private http: HttpClient) { }

  getProduct(): Observable<any[]>{
    return this.http.get<any[]>(`${this.productUrl}/list`);
  }
  getProductById(id: number): Observable<any> {
    return this.http.get<any>(`${this.productUrl}/${id}`);
  }

}
