from flask import Blueprint, jsonify
from app.utils.recommendationEngine import engineGetUsers

friends_bp = Blueprint('friends', __name__)


@friends_bp.route('/recommended-friends/<user>', methods=['GET'])
def get_recommended_friends(user):
    result  = engineGetUsers(user)
    return jsonify(result)