export class Transaction {
  id: number;
  type: string;
  amount: number;
  description: string;
  paymentDate: string;

  constructor(id: number = 0,
    type: string = '',
    amount: number = 0,
    description: string = '',
    paymentDate: string = '')
    {
    this.id = id;
    this.type = type;
    this.amount = amount;
    this.description = description;
    this.paymentDate = paymentDate;
  }
}
