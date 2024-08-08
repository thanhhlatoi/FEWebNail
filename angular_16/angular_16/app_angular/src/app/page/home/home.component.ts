import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { CategoryService } from 'src/app/service/category.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  selectedCategory1: any;
selectedCategory2: any;
selectedCategory3: any;
selectedCategory4: any;
selectedCategory5: any;

constructor(private categoryService: CategoryService) {}

ngOnInit(): void {
  this.getCategoryById(1); // Gọi danh mục với ID = 1
  this.getCategoryById(2); // Gọi danh mục với ID = 2
  this.getCategoryById(3); // Gọi danh mục với ID = 3
  this.getCategoryById(4); // Gọi danh mục với ID = 4
  this.getCategoryById(5); // Gọi danh mục với ID = 5
}

getCategoryById(id: number): void {
  this.categoryService.getCategoryById(id).subscribe(
    data => {
      switch (id) {
        case 1: this.selectedCategory1 = data; break;
        case 2: this.selectedCategory2 = data; break;
        case 3: this.selectedCategory3 = data; break;
        case 4: this.selectedCategory4 = data; break;
        case 5: this.selectedCategory5 = data; break;
        default: break;
      }
    },
    error => {
      console.error('Error fetching category by ID', error);
    }
  );
}

  

}