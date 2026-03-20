import { Routes } from '@angular/router';
import { ListTasks } from './pages/list-tasks/list-tasks';
import { CreateTask } from './pages/create-task/create-task';
import { EditTask } from './pages/edit-task/edit-task';
import { NotFound } from './pages/not-found/not-found';

export const routes: Routes = [
    /*routes*/
    { 
        path:'',
        redirectTo: 'list-tasks',
        pathMatch:'full'
    },
    {
        path:'list-tasks',
        component:ListTasks,
    },
    {
        path:'create-task',
        component:CreateTask,
    },
    {
        path:'edit-task/:id',
        component:EditTask,
    },
    {
        path:'**',
        component:NotFound,
    }
  
]
