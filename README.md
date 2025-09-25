

# 🚀 AI Page Summarize Assistant (Chrome Extension + GEMINI -AI +  Spring Boot Backend)

This project is a **AI-powered Summarize assistant** that integrates a **Chrome Extension (frontend)** with a **Spring Boot backend**.
It leverages **Google’s Gemini API** to provide features like:

* 🔹 Page Summarization Assistant
* 🔹 page Sugge

---

## 📂 Project Structure

### 🔹 Frontend (Chrome Extension)

Located inside the `frontend/` folder:

```
frontend/
│── SitePanel.html       # Extension side panel UI
│── SitePanel.css        # Styling for the side panel
│── SitePanel.js         # Handles UI logic & API communication
│── Background.js        # Background script for event handling
│── Image.png            # Extension icon
│── Manifest.json        # Chrome Extension configuration
```

The **frontend** is responsible for interacting with the user, rendering UI in the side panel, and communicating with the backend.

---

### 🔹 Backend (Spring Boot)

The **backend** handles API calls from the extension, communicates with **Google Gemini API**, processes responses, and returns them to the frontend.

---

## ⚙️ Features

* 📑 **Page Summarization** – Summarizes long web pages into concise insights.
* 🔗 **Chrome Extension Integration** – Works seamlessly in a side panel.
* ☁️ **Spring Boot + Gemini API** – Backend processing & AI-powered responses.

---

## 🛠️ Tech Stack

### Frontend:

* HTML, CSS, JavaScript
* Chrome Extension APIs

### Backend:

* Spring Boot (Java)
* REST APIs
* Google Gemini API

---

## ▶️ Getting Started

### 1. Clone Repository

```bash
git clone https://github.com/your-repo/AI-Powered-Summarize-Chrome-Extension--.git
cd Summary-Assistant-ext
```

### 2. Setup Backend (Spring Boot)

* Navigate to `backend/`
* Configure your **Gemini API key** in `application.properties`:

  ```properties
  gemini.api.key=YOUR_API_KEY_HERE
  server.port=8080
  ```
* Run the Spring Boot application:

  ```bash
  mvn spring-boot:run
  ```

  Backend will be available at:
  👉 `http://localhost:8080`

---

### 3. Setup Frontend (Chrome Extension)

1. Open **Chrome** → go to **Settings → Extensions**
2. Enable **Developer Mode**
3. Click **Load Unpacked**
4. Select the `frontend/` folder
5. Extension is now installed as **Summary Assistant**

---

## 🔗 API Endpoints

### 1. AI Assistant Endpoint

**URL:**

```
GET http://localhost:8080/api/v1/ai/get
```


---

## 📌 Usage Flow

1. Start the **Spring Boot backend** (`mvn spring-boot:run`)
2. Load the **Chrome extension** via developer mode
3. Open the extension side panel
4. click **Summarize Page**
5. Request is sent → Backend → Gemini API → Response returned → Displayed in extension

---

## 📷 Screenshots

<img width="1878" height="760" alt="image" src="https://github.com/user-attachments/assets/3ab24518-26cb-407b-aabe-f6524b96996b" />


---



---



