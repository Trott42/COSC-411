export class SidebarService {
  visible = false;

  show() {
    this.visible = true;
  }

  hide() {
    this.visible = false;
  }
}