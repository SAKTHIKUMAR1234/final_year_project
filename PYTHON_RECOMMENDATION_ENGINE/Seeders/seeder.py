import aiohttp
import asyncio
import json
import random
import string

api_url = 'http://localhost:8080/api/v1/userdetails/newUser'

async def generate_email():
    username = ''.join(random.choice(string.ascii_lowercase) for _ in range(8))
    domain = ''.join(random.choice(string.ascii_lowercase) for _ in range(6))
    return f"{username}@{domain}.com"

interests = list(range(1, 38))
accountChoice = list(range(0,2))
genderChoice = list(range(0,2))

accounttype = ['public','private']
gendertype=['Male','Female']

async def generate_phone():
    ph_no = [] 
    num=''
  
    ph_no.append(random.randint(6, 9)) 
  
    for i in range(1, 10): 
        ph_no.append(random.randint(0, 9)) 
  
    for i in ph_no: 
        num+=str(i)

    return num

async def create_user(session, user_id):
    user_interests = random.sample(interests, 10)

    user_email = await generate_email()
    user_firstname = ''.join(random.choice(string.ascii_lowercase) for _ in range(8))
    user_lastname = ''.join(random.choice(string.ascii_lowercase) for _ in range(5))
    user_phno = await generate_phone()
    user_password = ''.join(random.choice(string.ascii_lowercase) for _ in range(8))

    temp1=random.sample(accountChoice,1)[0]
    temp2=random.sample(genderChoice,1)[0]
    interest_arr=[]

    for interest in user_interests:
        interest_arr.append({"interestId":interest})

    user_data = {
        "userName": f"User{user_id}",
        "firstName": user_firstname,
        "lastName": user_lastname,
        "userProfile": "user.png",
        "email": user_email,
        "phNo": user_phno,
        "gender": gendertype[temp2],
        "dateOfBirth": "2000-01-01",
        "password": user_password,
        "accountType": accounttype[temp1],
        "interests": interest_arr
    }

    json_data = json.dumps(user_data)

    headers = {'Content-Type': 'application/json'}

    try:
        async with session.post(api_url, data=json_data, headers=headers) as response:
            if response.status == 200:
                print(f"User {user_id} inserted successfully.")
            else:
                print(f"Failed to insert user {user_id}. Status code:", response.status)
    except aiohttp.ClientError as e:
        print(f"An error occurred while inserting user {user_id}: {e}")

async def main():
    
    
    async with aiohttp.ClientSession() as session:
        tasks = [create_user(session, user_id) for user_id in range(1, 101)]
        await asyncio.gather(*tasks)

if __name__ == "__main__":
    asyncio.run(main())

