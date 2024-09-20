import { CommonModule } from '@angular/common';
import { Transaction } from '../../models/transaction';
import { TransactionService } from './../../services/transaction.service';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{

  transactions: Transaction[] = [];

  constructor(private transactionService: TransactionService) { }

  ngOnInit(): void {
    this.reloadTransactions();
  }

  reloadTransactions() : void {
    this.transactionService.index().subscribe({
      next: (transactionList) => {
        this.transactions = transactionList;
      },
      error: (fail) => {
        console.error('TransactionComponent.reloadCaves: error retreiving transactionlist');
        console.error(fail);}
    })
  }
}
