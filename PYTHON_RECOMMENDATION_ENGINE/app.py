from flask import Flask
from app.routes import route_bp

from flask_cors import CORS
app = Flask(__name__)
cors = CORS(app)
app.config['CORS_HEADERS'] = 'Content-Type'

app.register_blueprint(route_bp)



if __name__ == '__main__':
    app.run(host='0.0.0.0',debug=True,port=5005)

