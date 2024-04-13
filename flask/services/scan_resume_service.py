from flask import jsonify

def scan_resume():
    response = {
        "results": "I scanned It!"
    }
    
    return jsonify(response)