import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SlideProductComponent } from './slide-product.component';

describe('SlideProductComponent', () => {
  let component: SlideProductComponent;
  let fixture: ComponentFixture<SlideProductComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SlideProductComponent]
    });
    fixture = TestBed.createComponent(SlideProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
