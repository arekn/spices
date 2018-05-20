import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from 'rxjs/Observable';

@Injectable()
export class MigrationService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private http: HttpClient) {
  }


  importData(data: string, dataType: string): Observable<any> {
    return this.http.post(`/${dataType}/import`, data, this.httpOptions)
  }

  exportData(dataType: string): Observable<any> {
    return this.http.get(`/${dataType}/export`, this.httpOptions)
  }

}
