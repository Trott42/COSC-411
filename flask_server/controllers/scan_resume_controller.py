from flask import Blueprint
from services.scan_resume_service import scan_resume

scan_resume_controller = Blueprint("scan_resume_controller", __name__)

@scan_resume_controller.route("/scan-results/<str:resume>", methods=['GET', 'POST'])
def scan_results(resume: str):
    return scan_resume(resume)