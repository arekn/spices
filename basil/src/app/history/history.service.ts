import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {HistoryLog} from './history-log';

@Injectable()
export class HistoryService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private http: HttpClient) {
  }


  getHistory(): Observable<HistoryLog[]> {
    return this.http.get<HistoryLog[]>('/history', this.httpOptions)
  }

}
