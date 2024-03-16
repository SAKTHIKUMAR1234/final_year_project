from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import linear_kernel
from app.utils.fetchFromDB import getAllUsers

def recommend_interests(user_id):
    
    user_interests = getAllUsers()
    num_recommendations=len(user_interests)
    user_interests = [(user[0], ['' if interest is None else interest for interest in user[1]]) for user in user_interests]
    user_ids = [user[0] for user in user_interests]
    interest_strings = [' '.join(user[1]) for user in user_interests]
    tfidf_vectorizer = TfidfVectorizer()
    tfidf_matrix = tfidf_vectorizer.fit_transform(interest_strings)
    user_similarities = linear_kernel(tfidf_matrix, tfidf_matrix)
    user_index = user_ids.index(user_id)
    user_scores = user_similarities[user_index]
    similar_users_indices = user_scores.argsort()[::-1][1:]
    most_similar_user_index = similar_users_indices[0]
    recommended_interests = user_interests[most_similar_user_index][1]
    return recommended_interests[:num_recommendations]


def recommend_users(user_id):

    user_interests = getAllUsers()
    num_recommendations=len(user_interests)
    user_interests = [(user[0], ['' if interest is None else interest for interest in user[1]]) for user in user_interests]

    user_ids = [str(user[0]) for user in user_interests]
    interest_strings = [' '.join(user[1]) for user in user_interests]

    tfidf_vectorizer = TfidfVectorizer()
    tfidf_matrix = tfidf_vectorizer.fit_transform(interest_strings)

    user_similarities = linear_kernel(tfidf_matrix, tfidf_matrix)


    user_index = user_ids.index(user_id)
    user_scores = user_similarities[user_index]
    similar_users_indices = user_scores.argsort()[::-1][1:]
    recommended_users = [user_ids[i] for i in similar_users_indices[:num_recommendations]]
    return recommended_users

 
def engineGetInterest(target_user_id):
 return recommend_interests(target_user_id)

def engineGetUsers(target_user_id):
 return recommend_users(target_user_id)
