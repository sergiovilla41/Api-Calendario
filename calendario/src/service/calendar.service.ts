import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Calendar } from '../models/calendar.model';
import { environment } from '../environments/enviroment';



@Injectable({
  providedIn: 'root'
})
export class CalendarService {

  private apiUrl = 'http://localhost:8080/api/calendario/listar';
  // private apiUrl = environment.apiUrl + '/api/calendario/listar';

  constructor(private http: HttpClient) { }

  getCalendars(): Observable<Calendar[]> {
    return this.http.get<Calendar[]>(this.apiUrl);
  }
}
