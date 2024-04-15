from flask import jsonify
from utils import Resume

def scan_resume(resume_file: str):
    response = Resume.Resume(resume_file)
    
    return jsonify(response)