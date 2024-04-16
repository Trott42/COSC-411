from flask import jsonify
from utils.Resume import Resume

def calc_score(resume):
    """
    remember to change this to score every skill listed in the job description
    """
    res_dict = resume.extract()
    
    try:
        skill_score = len(res_dict["skills"])
        school_score = res_dict["education"]["score"]
        years_worked = res_dict["experience"]["start_date"] - res_dict["experience"]["end_date"]
        
        score = (skill_score + school_score + years_worked) / 3
        
        return score
    except KeyError as e:
        print("Was not able to properly parse resume data.\n" + str(e))
        return 0

def scan_resume():
    resume = Resume(r"C:\Users\16162\OneDrive\Documents\Resume\Job Search\Home version\Thacker, Luke - Resume.pdf")
    resume_score = calc_score(resume)
    
    return jsonify({
        "Access-Control-Allow-Origin": "http://localhost:4200/*",
        "resume": resume.extract(),
        "score": resume_score
    })