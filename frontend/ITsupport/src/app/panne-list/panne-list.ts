import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-panne-list',
  standalone: true,
  templateUrl: './panne-list.html',
  styleUrls: ['./panne-list.css']
})
export class PanneListComponent implements OnInit {
  pannes: any[] = [];

  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit(): void {
    this.fetchPannes();
  }

  fetchPannes() {
    this.http.get<any[]>('/api/pannes').subscribe(data => {
      this.pannes = data;
    });
  }

  deletePanne(id: number) {
    this.http.delete(`/api/pannes/${id}`).subscribe(() => {
      this.fetchPannes(); // Refresh the list after deleting
    });
  }

  editPanne(id: number) {
    this.router.navigate(['/pannes/edit', id]);
  }

  addPanne() {
    this.router.navigate(['/pannes/add']);
  }
}
