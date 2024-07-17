# Application Fundamentals

### Programming Language & Compilation

- Supported Languages: Java, Kotlin, C++

- The Android SDK tools compile the code along with any data and resource files into an APK or an Android App Bundle.

### Application Packaging

- Android Package (APK):

  - Archive file with .apk suffix.
  - Contains contents required at runtime.
  - Used by Android-powered devices to install the app.

- Android App Bundle (AAB):

  - Archive file with .aab suffix.
  - Contains project contents and additional metadata not required at runtime.
  - Publishing format, not installable on devices.
  - APK generation and signing deferred to a later stage.

### Application - Under the hood

- Each Android app lives in its own security sandbox.

- Security Features

  - **Multi-user Linux System**:
    - Each app is a different user.
  - **Unique Linux User ID**:
    - Assigned to each app by system (OS).
    - UnKnown to the app.
    - Permissions are set by system so only the app's user ID can access its files.
  - **Virtual Machine (VM) Isolation**:
    - Each process has its own VM.
    - App code runs in isolation from other apps.
  - **Linux Process**:

    - Each app runs in its own process.
    - Process starts when app components need execution.
    - Process shuts down when no longer needed or system needs to recover memory for other apps.

  - **Principle of Least Privilege**:
    - By default, App has access only to necessary components.
    - Creates a secure environment as an app can't access parts of the system it is not given permission for.

### Data Sharing and System Services Access

- **Shared Linux User ID**:
  - Allows two apps to share files and run in the same process and VM.
  - Apps must be signed with the same certificate.
- **Permissions**:
  - Apps can request access to device data (e.g., location, camera, Bluetooth).
  - User must explicitly grant permissions.

## App Components

- App components are the essential building blocks of an Android app.
- Each component is an entry point through which the system or a user can enter your app.
- Some components depend on others.
- There are four types of app components:Activities, Services, Broadcast receivers, Content providers.

### Activities

#### Definition and Purpose

- An activity is the entry point for interacting with the user.
- Represents a single screen with a user interface.
- Activities are independent but work together for a cohesive user experience.
- **Examples**:
  - Instagram Login activity
  - Facebook feed activity
  - YouTube account settings activity

#### Interaction with Other Apps

- **Inter-app Interactions**: Different apps can start activities in other apps if allowed.
- Example: Camera app starting the WhatsApp's share/forward activity to share a picture.

#### Managing System State and App User Experience
- **Current User Focus**:
  - Keeps track of what the user currently cares about (what is on-screen).
  - Ensures the system keeps running the process hosting the activity.
- **Process Prioritization**:
  - Knows which previously used processes contain stopped activities.
  - Prioritizes those processes to keep them available for the user as user might return to them.  
- **State Restoration**:
  - Helps the app handle process termination and restore the previous state when the user returns.





[//]: # "Reference used"
[wiki]: https://developer.android.com/guide/components/fundamentals
