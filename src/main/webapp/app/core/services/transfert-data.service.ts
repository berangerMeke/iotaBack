import { Injectable, EventEmitter } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransfertDataService {

  private messageSource = new BehaviorSubject('default message');
  currentMessage = this.messageSource.asObservable();

  private data: any;
  onGetData: EventEmitter<any> = new EventEmitter();

  constructor(
  ) { }



  changeMessage(message: any): void {
    this.messageSource.next(message); 
  }
    
    
  getDataEven(): void {
      this.onGetData.emit();
  }

  setData(data: any): void{
    this.data = data;
  }

  getData(): any{
    const temp = this.data;
    this.clearData();
    return temp;
  }

  clearData(): void{
    this.data = undefined;
  }

}
