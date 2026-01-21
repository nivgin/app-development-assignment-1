# Android Activity Life Cycle Example

This project demonstrates the **Activity Life Cycle** in Android, showcasing how activities transition through different states during their lifecycle. It includes two activities (`MainActivity` and `SecondActivity`) to illustrate activity navigation and how lifecycle methods are triggered in response to user actions and system events.

## Table of Contents
- [Overview](#overview)
- [Key Concepts](#key-concepts)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [How to Test](#how-to-test)
- [Screenshots](#screenshots)

## Overview
Understanding the **Activity Life Cycle** is crucial for Android app development. Activities are the core building blocks of Android apps, and their lifecycle methods allow developers to manage resources efficiently, handle user interactions, and ensure a smooth app experience.

This project includes:
1. **Lifecycle Logging**: Each lifecycle method is logged to Logcat to observe how the lifecycle transitions.
2. **Activity Navigation**: Demonstrates starting a second activity from the main activity.
3. **Hands-On Interaction**: Encourages students to test lifecycle methods by rotating the screen, pressing the home button, or navigating between activities.

## Key Concepts

- **Activity Life Cycle**:
  - `onCreate`: Initialize the activity.
  - `onStart`: Make the activity visible.
  - `onResume`: Start interacting with the user.
  - `onPause`: Pause user interaction (e.g., another activity partially obscures it).
  - `onStop`: Stop visibility (e.g., navigating to another activity).
  - `onRestart`: Restart after being stopped.
  - `onDestroy`: Clean up resources when the activity is destroyed.

- **Activity Navigation**:
  - Using `Intent` to start a new activity.

- **Testing Lifecycle Transitions**:
  - Rotate the device to trigger `onPause`, `onStop`, and `onDestroy`.
  - Press the home button to see `onPause` and `onStop`.
  - Reopen the app to observe `onRestart`.

## Project Structure

```
|-- app/  
    |-- src/  
        |-- main/  
            |-- java/com/idz/androidactivityfundamentals/ 
                |-- MainActivity.kt  # Main activity with full lifecycle methods  
                |-- SecondActivity.kt  # A secondary activity to demonstrate navigation  
            |-- res/  
                |-- layout/  
                    |-- activity_main.xml  # Layout for MainActivity  
                    |-- activity_second.xml  # Layout for SecondActivity  
                |-- values/  
                    |-- strings.xml  # App string resources  
    |-- AndroidManifest.xml  # App manifest with both activities registered  
```

## Setup Instructions

1. Clone this repository to your local machine:
   `git clone https://github.com/your-username/activity-lifecycle-example.git`

2. Open the project in **Android Studio**.

3. Sync Gradle by clicking "Sync Now" when prompted.

4. Run the project on an emulator or physical device.

## How to Test

1. **Logging Lifecycle Events**:
   - Open Logcat in Android Studio.
   - Filter logs by `ActivityLifecycle` to view lifecycle events for both activities.

2. **Navigate Between Activities**:
   - Launch the app.
   - Click the "Go to Second Activity" button in `MainActivity` to start `SecondActivity`.

3. **Trigger Lifecycle Events**:
   - Rotate the device to trigger configuration changes.
   - Press the home button and reopen the app to observe `onPause`, `onStop`, and `onRestart`.
   - Close the app to observe `onDestroy`.

4. **Understand Logs**:
   - Check Logcat to see the order in which lifecycle methods are called.

## Key Learning Outcomes

1. Understand how **Activity Life Cycle** works in Android.
2. Learn how to navigate between activities using `Intent`.
3. Observe and analyze lifecycle transitions using Logcat.
4. Apply lifecycle methods to manage resources efficiently.

## Contributing

Contributions are welcome! If you have suggestions for improving this project or extending it with new features, feel free to submit a pull request.

## License

This project is licensed under the MIT License. You can find the full license text [here](LICENSE). 
