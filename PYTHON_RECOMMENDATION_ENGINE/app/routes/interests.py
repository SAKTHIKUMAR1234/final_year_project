from flask import Blueprint, jsonify
import psycopg2
from app.utils.recommendationEngine import engineGetInterest
import pandas

interests_bp = Blueprint('interests', __name__)


@interests_bp.route('/recommended-interests/<user>', methods=['GET'])
def get_recommended_interests(user):
    result = engineGetInterest(int(user))
    return jsonify(result)



@interests_bp.route('/get',methods=['GET'])
def get():
    conn = psycopg2.connect(
            dbname='D1',
            user='postgres',
            password='123ajmal',
            host='localhost'
        )
    print("Database connection established successfully.")
    cursor = conn.cursor()
    cursor.execute("select * from interests")
    arr=cursor.fetchall()
    return jsonify(arr)

@interests_bp.route('/get_current_trended_courses',methods = ['GET'])
def get_current_trends():
    
    df = pandas.DataFrame(pandas.read_csv('recommedation_web_crawler/today_job_trend_course.csv'))
    response_body = [
        {
            'title':data['Title'],
            'link':data['Search_Url']
        }
        for index,data in df.iterrows()
    ]
    return jsonify(response_body)