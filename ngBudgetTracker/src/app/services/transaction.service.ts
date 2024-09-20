import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { Transaction } from '../models/transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  url = environment.baseUrl + "api/transactions";

  constructor(private http: HttpClient) { }

  index(): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(()=>new Error('TransactionService.index(): error retreiving transactions: '));
      })
    );
  }
}
