import { HttpClient } from '@angular/common/http';
import { Component} from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { environment } from '../../../environments/environment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-task',
  imports: [ReactiveFormsModule],
  templateUrl: './create-task.html',
  styleUrl: './create-task.css',
})
export class CreateTask {
  /** Component for the Create Task form */
  constructor(private http:HttpClient, private router: Router){}
  /** Form validations */ 
  taskForm: FormGroup = new FormGroup
  (
    {
      title: new FormControl("", [Validators.required, Validators.maxLength(50)]),
      description: new FormControl("", [Validators.maxLength(300)]),
      status: new FormControl(""),
    }
  )
  /**Function to submit the form*/
  /**POST request */
  submitForm()
  {
    this.http.post(`${environment.url}/task/create`, this.taskForm.value).subscribe({
    next: (result: any)=>{
        alert("Task Created.");
        this.router.navigate(['/list-tasks']);
    },
    error: (error: any)=>{
        alert(error.statusText)
    }}
  )
  } 
}
