# Mini Social Network Application

## 📘 Scenario
This project is a simple **Mini Social Network Application** written in Java using object-oriented programming principles. Users can create accounts, add friends, share posts, and like other users' posts.

---

## 🧩 Features

### 👤 User Class
- Stores basic user information: **username**, **email**, and **age**.
- Contains an **inner class** `Profile` to hold additional details like:
  - `profilePicture`
  - `bio`

### 👥 Users List
- All users are stored in an `ArrayList<User>`.

### 👫 Friends
- Each user maintains a list of friends using a `HashSet<User>`.
- Ensures no duplicate friends can be added.

### 📝 Posts
- Each user’s posts are stored in a `LinkedList<Post>`.
- Each post maintains a set of likes in a `HashSet<String>` (usernames of those who liked the post).

### 🗃️ Post Storage
- A global `HashMap<String, LinkedList<Post>>` is used to store all posts.
  - **Key**: Username
  - **Value**: List of that user's posts

### 📊 Popularity Ranking
- Uses a `TreeMap<Integer, List<String>>` or `TreeSet` to rank users by the **total number of likes** their posts received.
- Helps identify the most popular users.

### 🔁 Iterator Listing
- All users and their posts are iterated over and displayed using Java **Iterator**.

---

## 💡 Bonus (Optional Creative Feature)
- Implements an **anonymous class** with custom filters.
  - Example filters:
    - List users under 18 years old
    - Find posts containing a specific keyword

---

## Console-Based Application
This application is **console-based**. There is no GUI requirement. All interaction and output happen through the command line.

---

✅ Sample Output

![image](https://github.com/user-attachments/assets/e9a6cf5a-1c52-41b6-963f-153dc5090b65)

