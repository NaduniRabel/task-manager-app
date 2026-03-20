import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-edit-task',
  imports: [ReactiveFormsModule],
  templateUrl: './edit-task.html',
  styleUrl: './edit-task.css',
})
export class EditTask implements OnInit{
  /** Component for Edit Task */
  /** Task id recieved through route */
  constructor(private route: ActivatedRoute, private http:HttpClient,  private router: Router){}
  /** Form validatins */
  taskForm: FormGroup = new FormGroup
  (
    {
      id: new FormControl({ value: '', disabled: true }),
      title: new FormControl("", [Validators.required, Validators.maxLength(50)]),
      description: new FormControl("", [Validators.maxLength(300)]),
      status: new FormControl(""),
    }
  )
  /** On component load call the getTaskByID to fetch data
   * of the relevant task
   */
  ngOnInit(): void 
  {   
      const id= Number(this.route.snapshot.paramMap.get('id'));
      if(id){
        this.getTaskByID(id);
      }
      
  }
  /** Gets task details using the id as a path variable */
  getTaskByID(id: Number)
    {
      this.http.get(`${environment.url}/task/${id}`).subscribe({
        next: (result: any)=>{
          /** Assign the retrieve values to the form
           * This will display the relevant task details
           */
          this.taskForm.patchValue({
            id: result.id,
            title: result.title,
            description: result.description,
            status: result.status
          })
        },
        error: (error: any)=>{
          alert(error.statusText)
        }
    })
    }
  /** Submit edit form */
  /**Sends the details using a PUT request */
  submitForm()
  {
    const id= Number(this.route.snapshot.paramMap.get('id'));
    
    this.http.put(`${environment.url}/task/update/${id}`, this.taskForm.value).subscribe({
    next: (result: any)=>{
        alert("Task Updated.")
        this.router.navigate(['/list-tasks'])
    },
    error: (error: any)=>{
        alert(error.statusText)
    }}
  )
  }
  }
