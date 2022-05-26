import random
import names

adjectives = None
nouns = None

with open("../lib/adjectives.txt") as f:
    adjectives = f.read().splitlines()

with open("../lib/nouns.txt") as f:
    nouns = f.read().splitlines()

def generateMovieList(n):
    movieList = []
    for _ in range(n):
        movieList.append(generateMovie())
    return movieList

def generateMovie():
    return {
        "title": generateTitle(),
        "actionScore": random.randint(1, 99),
        "comedyScore": random.randint(1, 99),
        "dramaScore": random.randint(1, 99),
        "scifiScore": random.randint(1, 99),
        "horrorScore": random.randint(1, 99),
        "romanceScore": random.randint(1, 99),
    }

def generateTitle():
    return f"{random.choice(adjectives)} {random.choice(nouns)} of {random.choice(nouns)}"

def generateUserList(n):
    userList = []
    for _ in range(n):
        userList.append(generateUser())
    return userList

def generateUser():
    return {
        "name": generateName(),
        "actionScore": random.randint(1, 99),
        "comedyScore": random.randint(1, 99),
        "dramaScore": random.randint(1, 99),
        "scifiScore": random.randint(1, 99),
        "horrorScore": random.randint(1, 99),
        "romanceScore": random.randint(1, 99),
    }

def generateName():
    return names.get_full_name()

with open("../lib/movies.txt", "w") as f:
    movieList = generateMovieList(10)
    for movie in movieList:
        f.write(f"{movie['title']}\n")
        f.write(f"{movie['actionScore']}\n")
        f.write(f"{movie['comedyScore']}\n")
        f.write(f"{movie['dramaScore']}\n")
        f.write(f"{movie['scifiScore']}\n")
        f.write(f"{movie['horrorScore']}\n")
        f.write(f"{movie['romanceScore']}\n")

with open("../lib/users.txt", "w") as f:
    userList = generateUserList(10)
    for user in userList:
        f.write(f"{user['name']}\n")
        f.write(f"{user['actionScore']}\n")
        f.write(f"{user['comedyScore']}\n")
        f.write(f"{user['dramaScore']}\n")
        f.write(f"{user['scifiScore']}\n")
        f.write(f"{user['horrorScore']}\n")
        f.write(f"{user['romanceScore']}\n")