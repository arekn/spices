import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-migration',
  templateUrl: './migration.component.html',
  styleUrls: ['./migration.component.css']
})
export class MigrationComponent implements OnInit {

  dataType = 'users';

  data = '';

  constructor() { }

  ngOnInit() {
  }


  importData() {

  }

  exportData() {

  }
}
