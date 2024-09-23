import { Injectable } from '@angular/core';
import { Category } from '../models/category';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private url = environment.baseUrl + "api/categories";

  constructor(private http: HttpClient) { }

  index(): Observable<Category[]> {
    return this.http.get<Category[]>(this.url).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(() => new Error('CategoryService.index(): error retrieving categories'));
      })
    );
  }

  create(category: Category): Observable<Category> {
    return this.http.post<Category>(this.url, category).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(() => new Error('CategoryService.create(): error creating category'));
      })
    );
  }

  update(category: Category): Observable<Category> {
    return this.http.put<Category>(`${this.url}/${category.id}`, category).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(() => new Error('CategoryService.update(): error updating category'));
      })
    );
  }

  destroy(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(() => new Error('CategoryService.destroy(): error deleting category'));
      })
    );
  }
}

