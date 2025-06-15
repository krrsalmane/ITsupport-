import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PanneForm } from './panne-form';

describe('PanneForm', () => {
  let component: PanneForm;
  let fixture: ComponentFixture<PanneForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PanneForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PanneForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
