import { HttpClient } from '@angular/common/http';
import { Component, OnInit,ChangeDetectorRef } from '@angular/core';
import { RouterLink } from '@angular/router';
import { environment } from '../../../environments/environment';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-list-tasks',
  imports: [RouterLink, FormsModule],
  templateUrl: './list-tasks.html',
  styleUrl: './list-tasks.css',
})
export class ListTasks implements OnInit {
  /** Component for the List tasks */
  taskList: any[]=[];
  selectedStatus: string = 'ALL';
  constructor(private http:HttpClient, private cdr: ChangeDetectorRef){}
  /**On load call getTasks function to fetch all tasks */
  ngOnInit(): void 
  {
      this.getTasks();
  }
  /** Retrieves all tsks
   * GET request sent
   */
  getTasks()
  {
    this.http.get(`${environment.url}/task/all`).subscribe((result: any)=>{
      this.taskList = [...result];
      this.cdr.detectChanges();
    })
  }
  /** Delete task by id */
  /** DELETE request */
  deleteTask(id: number)
  { 
    /** Confirm delete */
    if(!confirm("Confirm Delete")) return;

    this.http.delete(`${environment.url}/task/delete/${id}`).subscribe({
    next: (result: any)=>{
        alert("Task Deleted.")
        this.getTasks();
    },
    error: (error: any)=>{
        alert(error.statusText)
    }}
  )

  }
}
