import { Component, OnInit } from '@angular/core';
import { Calendar } from '../../../models/calendar.model';
import { CalendarService } from '../../../service/calendar.service';

@Component({
  selector: 'app-calendario',
  templateUrl: './calendario.component.html',
  styleUrl: './calendario.component.css'
})
export class CalendarioComponent implements OnInit {
  calendars: Calendar[] = [];
  filteredCalendars: { [key: string]: Calendar[] } = {};
  filterYear: number | null = null;
  monthsOrder: string[] = [
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11'
  ]; // Orden de los meses

  constructor(private calendarService: CalendarService) { }

  ngOnInit() {
    this.loadCalendars();
  }

  loadCalendars() {
    this.calendarService.getCalendars().subscribe(
      data => {
        this.calendars = data;
        this.applyFilter();
      },
      error => {
        console.error('Error fetching calendars', error);
      }
    );
  }

  applyFilter() {
    if (this.filterYear) {
      const filtered = this.calendars.filter(calendar => calendar.year === this.filterYear);
      this.filteredCalendars = this.groupByMonth(filtered);
    } else {
      this.filteredCalendars = this.groupByMonth(this.calendars);
    }
  }

  onYearFilterChange(event: Event) {
    const inputElement = event.target as HTMLInputElement;
    this.filterYear = inputElement.value ? parseInt(inputElement.value, 10) : null;
    this.applyFilter();
  }

  groupByMonth(calendars: Calendar[]): { [key: string]: Calendar[] } {
    return calendars.reduce((acc, calendar) => {
      const month = new Date(calendar.fecha).getMonth().toString();
      if (!acc[month]) {
        acc[month] = [];
      }
      acc[month].push(calendar);
      return acc;
    }, {} as { [key: string]: Calendar[] });
  }

  getCalendarItemClass(calendar: Calendar): string {
    if (calendar && calendar.tipo && calendar.tipo.tipo) {
      switch (calendar.tipo.tipo.trim()) {
        case 'Fin de Semana':
          return 'weekend';
        case 'Día laboral':
          return 'workday';
        case 'Día festivo':
          return 'holiday';
        default:
          return '';
      }
    } else {

      return '';
    }
  }

  getMonthName(month: string): string {
    const monthNames = [
      'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
      'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'
    ];
    return monthNames[parseInt(month, 10)];
  }

  parseMonthKey(monthKey: string): number {
    return parseInt(monthKey, 10);
  }

  getMonthDays(month: number, year: number): (Date | null)[][] {
    const daysInMonth = new Date(year, month + 1, 0).getDate();
    const firstDayOfMonth = new Date(year, month, 1).getDay();
    const days: Date[] = [];
    for (let day = 1; day <= daysInMonth; day++) {
      days.push(new Date(year, month, day));
    }

    const weeks: (Date | null)[][] = [];
    let currentWeek: (Date | null)[] = new Array(firstDayOfMonth).fill(null);

    days.forEach(date => {
      currentWeek.push(date);
      if (currentWeek.length === 7) {
        weeks.push(currentWeek);
        currentWeek = [];
      }
    });

    if (currentWeek.length > 0) {
      while (currentWeek.length < 7) {
        currentWeek.push(null); // Usar null para celdas vacías
      }
      weeks.push(currentWeek);
    }

    return weeks;
  }


  findCalendarDay(calendars: Calendar[], day: number): Calendar | undefined {
    return calendars.find(calendar => new Date(calendar.fecha).getDate() === day);
  }
}
