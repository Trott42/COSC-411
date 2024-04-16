from flask import Flask
from flask_cors import CORS
from controllers.scan_resume_controller import scan_resume_controller

def create_app():
    app = Flask(__name__)    
    CORS(app, resources={"/ml/*": {"origins": "*"}})
    
    app.register_blueprint(scan_resume_controller, url_prefix='/ml')
    
    return app
    
if __name__ == '__main__':
    app = create_app()
    app.run(port="5000", debug=True)
    