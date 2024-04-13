from flask import Flask
from flask_cors import CORS
from controllers.scan_resume_controller import scan_resume_controller

def create_app() -> Flask:
    app = Flask(__name__)
    app.register_blueprint(scan_resume_controller, url_prefix='/ml')
    
    FRONTEND_URL = "http://localhost:4200/"
    CORS(app, resources={"/ml/*": {"origins": "*"}})
    
    return app
    
if __name__ == '__main__':
    app = create_app()
    app.run(port="5000", debug=True)
    