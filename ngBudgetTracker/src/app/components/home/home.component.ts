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
export class HomeComponent implements OnInit {
  transactions: Transaction[] = [];
  newTransaction: Transaction = new Transaction();
  selectedTransaction: Transaction | null = null;

  constructor(private transactionService: TransactionService) {}

  ngOnInit(): void {
    this.reloadTransactions();
  }

  reloadTransactions(): void {
    this.transactionService.index().subscribe({
      next: (transactionList) => this.transactions = transactionList,
      error: (fail) => console.error('Error retrieving transactions', fail)
    });
  }

  createTransaction(): void {
    if (this.newTransaction.type && this.newTransaction.amount > 0) {
      this.transactionService.create(this.newTransaction).subscribe({
        next: (createdTransaction) => {
          this.transactions.push(createdTransaction);
          this.newTransaction = new Transaction();
        },
        error: (fail) => console.error('Error creating transaction', fail)
      });
    }
  }


  updateTransaction(): void {
    if (this.selectedTransaction) {
      this.transactionService.update(this.selectedTransaction).subscribe({
        next: () => this.reloadTransactions(),
        error: (fail) => console.error('Error updating transaction', fail)
      });
    }
  }

  deleteTransaction(id: number): void {
    this.transactionService.destroy(id).subscribe({
      next: () => this.reloadTransactions(),
      error: (fail) => console.error('Error deleting transaction', fail)
    });
  }

  selectTransaction(transaction: Transaction): void {
    this.selectedTransaction = Object.assign({}, transaction);
  }

  clearSelectedTransaction(): void {
    this.selectedTransaction = null;
  }
}

