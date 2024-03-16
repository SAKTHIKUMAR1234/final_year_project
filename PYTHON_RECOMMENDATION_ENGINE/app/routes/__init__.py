from flask import Blueprint
from .friends import friends_bp
from .interests import interests_bp

route_bp = Blueprint('routes', __name__)

route_bp.register_blueprint(friends_bp, url_prefix='/recommendation')
route_bp.register_blueprint(interests_bp, url_prefix='/recommendation')
