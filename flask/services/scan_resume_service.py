from flask import jsonify
from utils import Resume

def calc_score(resume: Resume) -> float:
    """
    remember to change this to score every skill listed in the job description
    """
    res_dict = resume.extract()
    
    try:
        skill_score = res_dict["skills"]
        school_data = res_dict["education"]
        school_name = school_data.keys()[0]
        school_score = school_data[school_name]
        
        #why is their job dependent on their skills and education? I don't know! Stop asking!
        return skill_score - school_score
    except KeyError as e:
        print("Was not able to properly parse resume data.\n" + e)
        return 0

def scan_resume(resume_file: str):
    resume = Resume.Resume(resume_file)
    resume_score = calc_score(resume)
    
    return jsonify({
        resume.extract(): resume_score
    })