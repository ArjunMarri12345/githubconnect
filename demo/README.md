# 🚀 GitHub API Integration (Spring Boot)

This project integrates with GitHub API using Spring Boot.

## 📌 Features
- Get user repositories
- Create GitHub issues
- List repository issues

---

## 🛠️ Tech Stack
- Java
- Spring Boot
- RestTemplate

---

## 🔐 Configuration

Add your GitHub token in `application.properties`:
github.token=YOUR_TOKEN_HERE


---

## 📡 API Endpoints

### 🔹 Get Repositories
GET /api/github/repos/{username}

### 🔹 Create Issue
POST /api/github/issue/{owner}/{repo}

Body:

{
"title": "Issue title",
"body": "Issue description"
}


### 🔹 List Issues
GET /api/github/issues/{owner}/{repo}

---

## ▶️ Run Project


mvn spring-boot:run


---

## 👨‍💻 Author
Arjun
