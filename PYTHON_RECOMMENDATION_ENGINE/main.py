from flask import Flask
from app.routes import route_bp
from recommedation_web_crawler.main import web_crawler_main
from scheduler.scheduler import scheduler

from flask_cors import CORS
app = Flask(__name__)
cors = CORS(app)
app.config['CORS_HEADERS'] = 'Content-Type'

app.register_blueprint(route_bp)
scheduler.init_app(app)



if __name__ == '__main__':
    # web_crawler_main()
    # if scheduler.state == 0:
    #     scheduler.start()
    app.run(host='0.0.0.0',debug=False,port=5005)

