import {BrowserModule} from '@angular/platform-browser';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {MigrationComponent} from './migration/migration.component';
import {MenuComponent} from './menu/menu.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from "@angular/common/http";
import { MessageComponent } from './message/message.component';


@NgModule({
  declarations: [
    AppComponent,
    MigrationComponent,
    MenuComponent,
    MessageComponent
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule {
}
