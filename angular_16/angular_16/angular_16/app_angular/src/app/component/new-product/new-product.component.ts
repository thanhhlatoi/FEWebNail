import { Component } from '@angular/core';
import { ProductService } from 'src/app/service/product.service';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrls: ['./new-product.component.css']
})
export class NewProductComponent {
  selectedProduct1: any;
  selectedProduct2: any;
  selectedProduct3:any;
  selectedProduct4:any;
  constructor(
    private productService: ProductService
  ) {}
  
  
  
  ngOnInit(): void {
    this.getProductById(1);
    this.getProductById(2);
    this.getProductById(3);
    this.getProductById(4);
  }
  

  
  getProductById(id:number): void {
    this.productService.getProductById(id).subscribe(
      data => {
        switch (id) {
          case 1: this.selectedProduct1 = data; break;
          case 2: this.selectedProduct2 = data; break;
          case 3: this.selectedProduct3 = data; break;
          case 4: this.selectedProduct4 = data; break;
          default: break;
        }
      },
        error => {
          console.error('Error fetching product by ID', error);
        }
    );
  }
}
