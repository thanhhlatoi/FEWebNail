import { Component } from '@angular/core';

@Component({
  selector: 'app-slide-product',
  templateUrl: './slide-product.component.html',
  styleUrls: ['./slide-product.component.css']
})
export class SlideProductComponent {
  items = [
    { image: 'https://res.cloudinary.com/dhttupoeh/image/upload/v1722602186/ntt/product/k.jpg_20240802193623.jpg', name: 'Tối giản' },
    { image: 'https://res.cloudinary.com/dhttupoeh/image/upload/v1722603288/ntt/product/05ac91004feeb7bf58068f69c356b219.png_wh300.png_20240802195445.png', name: 'Chân dung' },
    { image: 'https://images.unsplash.com/photo-1599481238640-4c1288750d7a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2664&q=80', name: 'Động vật' },
    { image: 'https://images.unsplash.com/photo-1599481238640-4c1288750d7a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2664&q=80', name: 'Phong cảnh' },
    { image: 'https://images.unsplash.com/photo-1599481238640-4c1288750d7a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2664&q=80', name: 'Châu á' },
    { image: 'https://images.unsplash.com/photo-1599481238640-4c1288750d7a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2664&q=80', name: 'Chữ' },
    { image: 'https://images.unsplash.com/photo-1599481238640-4c1288750d7a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2664&q=80', name: 'Nét Mảnh' }



  ];

  currentIndex = 0;
  itemWidth = 300; // Width of each item
  translateX = 0;

  prevSlide() {
    const totalItems = this.items.length;
    this.currentIndex = (this.currentIndex - 1 + totalItems) % totalItems;
    this.updateTranslateX();
  }

  nextSlide() {
    const totalItems = this.items.length;
    this.currentIndex = (this.currentIndex + 1) % totalItems;
    this.updateTranslateX();
  }

  updateTranslateX() {
    this.translateX = -this.currentIndex * (this.itemWidth + 20); // 20 is the margin between items
  }
}
