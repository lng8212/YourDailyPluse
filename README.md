# YourDailyPluse

This repository contains a sample Kotlin Multiplatform Mobile (KMM) project for building a cross-platform mobile application supporting both Android and iOS.

## Overview

YourDailyPluse demonstrates how to share business logic between two platforms using KMM. This approach allows you to write your code once, share it across Android and iOS, and avoid redundancy in the logic layer.

## Key Features

- **Shared Business Logic**: The core logic is written in Kotlin, shared across Android and iOS.
    
- **Platform-specific UI**: Each platform has its own UI layer, but the business logic is abstracted and shared.
    

## How to Use

1. **Clone the repository**:
    
    `git clone https://github.com/lng8212/YourDailyPluse.git`
    
2. **Open in IDE**:
    
    - For Android: Open in Android Studio.
        
    - For iOS: Open in Xcode.
        
3. **Building the Project**:
    
    - For Android: Simply sync the project with Gradle.
        
    - For iOS: Use Xcode to build and run the app.
        
4. **Shared Code**: The shared business logic is found in the `shared` module. The logic can be modified here for changes that reflect across both platforms.
    

## Key Directories

- `androidApp/`: Android-specific code.
    
- `iosApp/`: iOS-specific code.
    
- `shared/`: Shared code for both platforms.
    

## Benefits of KMM

- **Maintain One Codebase**: Share most of the logic across platforms, saving time and effort in development.
    
- **Platform-Specific UI**: You can customize the user interface for each platform without affecting the shared code.
    
- **Future Scalability**: Easily scale to include more platforms (e.g., desktop, web).
    

## How This Works

- **Kotlin Multiplatform**: This project uses KMM to handle the logic in the shared module, which is then integrated into both Android and iOS projects.
    
- **Dependencies**: Shared logic uses platform-specific libraries where necessary, but the core functionality is platform-agnostic.
    
## Screenshots

Below are some screenshots of the app running on different platforms:

_Android Platform Screenshot_
<img src="https://github.com/user-attachments/assets/37242e4f-4ee5-4ef3-b1fb-236db59ecb19" width="300">
<img src="https://github.com/user-attachments/assets/a0986ece-cfe9-4ee1-acea-d86f9e52a43e" width="300">
<img src="https://github.com/user-attachments/assets/8307a645-f397-4244-8182-86d8e1db9b29" width="300">

_iOS Platform Screenshot_
<img src="https://github.com/user-attachments/assets/8707966b-a0fc-47d2-844f-c77995b915b0" width="300">
<img src="https://github.com/user-attachments/assets/33b1b5c0-bcf2-43d5-9b49-ee3aeff878f4" width="300">
<img src="https://github.com/user-attachments/assets/e63daed8-9059-490d-9aa3-d806480478c8" width="300">

## Contributing

Feel free to fork the repo, make changes, and submit pull requests.
