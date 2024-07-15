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
        -  By default, App has access only to necessary components.
        - Creates a secure environment as an app can't access parts of the system it is not given permission for.
        
### Data Sharing and System Services Access
  - **Shared Linux User ID**:
    - Allows two apps to share files and run in the same process and VM.
    - Apps must be signed with the same certificate.
  - **Permissions**:
    - Apps can request access to device data (e.g., location, camera, Bluetooth).
    - User must explicitly grant permissions.    

 [//]: # (Reference used)
 [wiki]: <https://developer.android.com/guide/components/fundamentals>