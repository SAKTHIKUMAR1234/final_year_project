import psycopg2

def getAllUsers():
    try:
        conn = psycopg2.connect(
            dbname='D1',
            user='postgres',
            password='123ajmal',
            host='localhost'
        )
        print("Database connection established successfully.")
        arr=[]
        cursor = conn.cursor()
        cursor.execute("""
            SELECT u.user_id ,
            ARRAY_AGG(i.content) AS interests
            FROM users u
            LEFT JOIN users_interests ui ON u.user_id = ui.user_user_id
            LEFT JOIN interests i ON ui.interests_interest_id = i.interest_id
            GROUP BY u.user_id, u.user_name, u.first_name, u.last_name;
        """)
        records = cursor.fetchall()
        for record in records:
            arr.append(record)

        conn.commit()
        cursor.close()
        conn.close()
        
        return arr

    except psycopg2.Error as e:
        print("Error:", e)
