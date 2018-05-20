import {Component, OnInit} from '@angular/core';
import {MigrationService} from './migration.service';
import {MessageService} from '../message/message.service';

@Component({
  selector: 'app-migration',
  templateUrl: './migration.component.html',
  styleUrls: ['./migration.component.css'],
  providers: [MigrationService, MessageService]
})
export class MigrationComponent implements OnInit {

  data = '';

  dataType = 'user';

  constructor(private migrationService: MigrationService,
              private msgService: MessageService) {
  }

  ngOnInit() {
  }


  importData() {
    this.migrationService.importData(this.data, this.dataType).subscribe(response => {
      this.msgService.pushSuccessMessage(`${this.dataType} import success`);
      this.data = '';
    }, error => {
      this.msgService.pushErrorMessage(`${this.dataType} import failed`)
    })
  }

  exportData() {
    this.migrationService.exportData(this.dataType).subscribe(response => {
      this.data = JSON.stringify(response);
      this.msgService.pushSuccessMessage(`${this.dataType} export success`)
    }, error => {
      this.msgService.pushErrorMessage(`${this.dataType} export failed`);
      this.data = '';
    })

  }
}
