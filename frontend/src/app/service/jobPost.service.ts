export class JobPost {
  constructor(public jobTitle: string,
              public location: string,
              public datePosted: string,
              public showButton: boolean)
  {
    this.jobTitle = jobTitle;
    this.location = location;
    this.datePosted = datePosted;
    this.showButton = showButton;
  }
}