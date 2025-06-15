import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PanneList } from './panne-list';

describe('PanneList', () => {
  let component: PanneList;
  let fixture: ComponentFixture<PanneList>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PanneList]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PanneList);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
