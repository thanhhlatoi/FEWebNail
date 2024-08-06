import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { CategoryService } from 'src/app/service/category.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  listCategory: any[] = [];
  selectedCategory: any;

  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.getCategories();
  }

  getCategories(): void {
    this.categoryService.getCategories().subscribe(
      data => {
        this.listCategory = data;
        if (this.listCategory.length > 0) {
          // Hiển thị danh mục đầu tiên hoặc bạn có thể chọn một danh mục cụ thể
          this.selectedCategory = this.listCategory[0];
        }
      },
      error => {
        console.error('Error fetching categories', error);
      }
    );
  }
}