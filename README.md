# Social Media Platform

This project is a simple social media platform built with **Spring Boot** for the backend and **ReactJS** for the frontend. It features a Creator-Listener interaction model, where creators can post content, and listeners can view, comment, and like posts. The creator has the ability to manage their posts, while listeners can engage by liking and commenting.

## Features

### Creator
- **Create Posts**: The creator can create new posts in the app.
- **View Posts**: Creators can view their own posts and the interactions (likes and comments) they receive.
- **Edit Posts**: Creators can modify their existing posts.
- **Delete Posts**: Creators can remove their posts.
  
### Listener
- **View Posts**: Listeners can view the posts created by others.
- **Like Posts**: Listeners can like posts.
- **Comment on Posts**: Listeners can comment on posts.

## Tech Stack

- **Backend**: Spring Boot
  - RESTful APIs to handle post creation, editing, deletion, comments, and likes.
  - Database integration with **MySQL**  for storing user profile, posts, users, comments, and likes.
  
- **Frontend**: ReactJS
  - **Axios** for API calls.
  - **React Router** for navigation.

- **Database**: MySQL
  - Stores user information, posts, comments, likes, etc.

## Project Setup

### Backend Setup (Spring Boot)

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd backend
