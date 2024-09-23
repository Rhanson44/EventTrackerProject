import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { Transaction } from '../models/transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  private url = environment.baseUrl + "api/transactions";

  constructor(private http: HttpClient) { }

  // Retrieve all transactions
  index(): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(this.url).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(() => new Error('TransactionService.index(): error retrieving transactions'));
      })
    );
  }

  // Create a new transaction
  create(transaction: Transaction): Observable<Transaction> {
    return this.http.post<Transaction>(this.url, transaction).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(() => new Error('TransactionService.create(): error creating transaction'));
      })
    );
  }

  // Update an existing transaction
  update(transaction: Transaction): Observable<Transaction> {
    return this.http.put<Transaction>(`${this.url}/${transaction.id}`, transaction).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(() => new Error('TransactionService.update(): error updating transaction'));
      })
    );
  }

  // Delete a transaction
  destroy(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(() => new Error('TransactionService.destroy(): error deleting transaction'));
      })
    );
  }
}

