import { Component, Input } from '@angular/core';
import { SidebarComponent } from '../sidebar/sidebar.component';

@Component({
    selector: 'app-job-posting',
    standalone: true,
    imports: [ SidebarComponent ],
    templateUrl: './job-posting.component.html',
    styleUrl: './job-posting.component.scss'
})
export class JobPostingComponent {
    @Input() jobTitle!: string;
    @Input() location!: string;
    @Input() datePosted!: string;
}
