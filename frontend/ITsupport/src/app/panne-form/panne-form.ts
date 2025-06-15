import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl, ReactiveFormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-panne-form',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, RouterModule],
  templateUrl: './panne-form.html',
  styleUrls: ['./panne-form.css']
})
export class PanneFormComponent implements OnInit {
  panneForm: FormGroup;
  isEditMode: boolean = false;
  panneId: number | null = null;

  get nomControl(): FormControl {
    return this.panneForm.get('nom') as FormControl;
  }

  get descriptionControl(): FormControl {
    return this.panneForm.get('description') as FormControl;
  }

  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.panneForm = this.fb.group({
      nom: ['', [Validators.required, Validators.minLength(3)]],
      description: ['', [Validators.required, Validators.minLength(10)]]
    });
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (id) {
        this.isEditMode = true;
        this.panneId = Number(id);
        this.fetchPanne(this.panneId);
      }
    });
  }

  fetchPanne(id: number): void {
    this.http.get<any>(`/api/pannes/${id}`).subscribe({
      next: (panne) => {
        this.panneForm.patchValue({
          nom: panne.nom,
          description: panne.description
        });
      },
      error: (err) => {
        console.error('Error fetching panne:', err);
        alert('Erreur lors du chargement de la panne.');
      }
    });
  }

  onSubmit(): void {
    if (this.panneForm.invalid) {
      this.panneForm.markAllAsTouched();
      return;
    }

    const panneData = {
      nom: this.panneForm.get('nom')?.value,
      description: this.panneForm.get('description')?.value
    };

    if (this.isEditMode && this.panneId) {
      this.http.put(`/api/pannes/${this.panneId}`, panneData).subscribe({
        next: () => this.router.navigate(['/pannes']),
        error: (err) => {
          console.error('Error updating panne:', err);
          alert('Erreur lors de la mise à jour de la panne.');
        }
      });
    } else {
      this.http.post('/api/pannes', panneData).subscribe({
        next: () => this.router.navigate(['/pannes']),
        error: (err) => {
          console.error('Error adding panne:', err);
          alert('Erreur lors de l\'ajout de la panne.');
        }
      });
    }
  }

  onCancel(): void {
    this.router.navigate(['/pannes']);
  }
}