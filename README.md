Rick and Morty Explorer App
A Jetpack Compose Android application that allows users to browse characters and episodes from the Rick and Morty universe using the official Rick and Morty API.
Show Image
![WhatsApp Image 2025-03-24 at 8 40 51 AM](https://github.com/user-attachments/assets/a7a4dbeb-b4aa-4cd9-987a-fb88a76289d6)
![WhatsApp Image 2025-03-24 at 8 40 51 AM (3)](https://github.com/user-attachments/assets/90115c99-e5c3-4f0b-9f3b-65dfdcda3f8d)
![WhatsApp Image 2025-03-24 at 8 40 51 AM (2)](https://github.com/user-attachments/assets/f98a210b-1f3a-4206-a2d4-50ccd0a62313)
![WhatsApp Image 2025-03-24 at 8 40 51 AM (1)](https://github.com/user-attachments/assets/ae8908d4-a070-45aa-a67a-42917063e3f7)

Features

📱 Modern UI built with Jetpack Compose
🧠 MVVM architecture
🌐 RESTful API integration with Retrofit
🔍 Search functionality for both characters and episodes
📄 Pagination support for browsing large datasets
🎨 Material Design 3 theming

App Structure
Main Screens
The app has four main sections accessible through the bottom navigation:

Characters - Browse all characters with pagination
Episodes - Browse all episodes with pagination
Search Characters - Find specific characters by name
Search Episodes - Find specific episodes by name

Architecture
This app follows the MVVM (Model-View-ViewModel) architecture pattern:

Model: Data classes representing API responses (Character, Episode)
View: Compose UI screens and components
ViewModel: Manages UI-related data and communicates with the API

Technical Implementation
API Integration
The app uses Retrofit to communicate with the Rick and Morty API:

Base URL: https://rickandmortyapi.com/api/
Endpoints:

/character - Get all characters or search by name
/episode - Get all episodes or search by name



Navigation
Navigation is implemented using the Jetpack Navigation Compose library:

Bottom navigation bar for switching between main sections
NavHost for managing screen transitions

UI Components

Material 3 components (Cards, Buttons, TextFields)
LazyColumn for efficient list rendering
Coil for image loading
TopAppBar with pagination controls

Setup Instructions

Clone the repository
Open the project in Android Studio
Run the app on an emulator or physical device

Dependencies

Jetpack Compose
Navigation Compose
Retrofit with Gson converter
Coil for image loading
Material 3 Components
Kotlin Coroutines & Flow

Code Structure
The app is organized into several packages:

data: Contains model classes and API service interfaces
ui: Contains Compose screens and UI components
viewmodel: Contains the ViewModel that manages UI data

