export class JobPost {
  constructor(
    public jobTitle: string,
    public location: string,
    public datePosted: string,
    public showButton: boolean,
    public jobDesc: string
  )
  {
    this.jobTitle = jobTitle;
    this.location = location;
    this.datePosted = datePosted;
    this.showButton = showButton;
    if (this.showButton) {
      this.jobDesc = jobDesc;
    } else {
      this.jobDesc = "";
    }
  }
}