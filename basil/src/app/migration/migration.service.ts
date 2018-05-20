import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class MigrationService {

  constructor(private http: HttpClient) { }

}
