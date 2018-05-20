import {Component, OnInit} from '@angular/core';
import {HistoryService} from './history.service';
import {HistoryLog} from './history-log';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css'],
  providers: [HistoryService]
})
export class HistoryComponent implements OnInit {

  historyLog: HistoryLog[] = [];

  constructor(private historyService: HistoryService) {
  }

  ngOnInit() {
    this.historyService.getHistory().subscribe(response => this.historyLog = response);
  }

}
