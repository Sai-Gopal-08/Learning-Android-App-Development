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

### Services in Android

#### Definition and Purpose

- **General-Purpose Entry Point**:
  - Keeps an app running in the background for various reasons.
  - Performs long-running operations or work for remote processes.
  - Does not provide a user interface.

#### Examples

- **Background Music**:
  - A service might play music in the background while the user is in a different app.
- **Data Fetching**:
  - A service might fetch data over the network without blocking user interaction with an activity.

#### Types of Services

- **Started Services**:

  - Tell the system to keep them running until their work is completed.
  - Examples include syncing data in the background or playing music.
  - **Music Playback**:
    - User is directly aware of it.
    - App indicates it wants to be in the foreground with a notification.
    - System prioritizes keeping the service’s process running to avoid a bad user experience.
  - **Regular Sync Background Service**:
    - User is not directly aware of it.
    - System has more freedom in managing its process.
    - Might be killed and restarted later if the system needs RAM for more immediate concerns.

- **Bound Services**:
  - Run because another app (or the system) wants to use the service.
  - Provide an API to another process.
  - System keeps the service’s process running because of the dependency.
  - If a bound service is used by a process that the user cares about, the system treats the service’s process as important as well.

#### Flexibility and Use Cases

- **Useful Building Blocks**:
  - Services are used for higher-level system concepts like live wallpapers, notification listeners, screen savers, input methods, and accessibility services.
  - Core system features are built as services that applications implement and the system binds to when they run.

#### Implementation

- Developers can implement a service as a subclass of `Service`.
- For more information, refer to the [Services overview](https://developer.android.com/guide/components/services).

### Broadcast Receivers in Android

#### Definition and Purpose

- **Component for Event Delivery**:
  - Allows the system to deliver events to the app outside of a regular user flow.
  - Enables the app to respond to system-wide broadcast announcements.
  - Can receive broadcasts even when the app is not currently running.

#### Examples of Use

- **System Broadcasts**:
  - Announcements such as the screen turning off, the battery being low, or a picture being captured.
- **App-Initiated Broadcasts**:
  - Notifications for other apps about data being downloaded and available for use.

#### Features

- **No User Interface**:
  - Broadcast receivers do not display a user interface.
  - Can create status bar notifications to alert the user when a broadcast event occurs.
- **Minimal Work**:
  - Typically serve as gateways to other components and perform minimal work themselves.
  - Example: Scheduling a `JobService` to perform work based on an event using `JobScheduler`.

#### Implementation

- **BroadcastReceiver Class**:
  - Implement a broadcast receiver as a subclass of `BroadcastReceiver`.
  - Each broadcast is delivered as an `Intent` object.
  - For more information, refer to the [BroadcastReceiver class](https://developer.android.com/reference/android/content/BroadcastReceiver).

#### Security Considerations

- **App Interaction**:
  - Broadcast receivers often involve interaction between different apps.
  - Important to be aware of security implications when setting up broadcast receivers.

#### Practical Example

- **Alarm Notification**:
  - An app can schedule an alarm to post a notification about an upcoming event.
  - The alarm is delivered to a `BroadcastReceiver` in the app, eliminating the need for the app to remain running until the alarm goes off.

### Content Providers in Android

#### Definition and Purpose

- **Managing Shared Data**:
  - Manages a shared set of app data stored in various persistent storage locations (file system, SQLite database, web, etc.).
  - Allows other apps to query or modify the data, given the appropriate permissions.

#### Example Use Case

- **Contacts Management**:
  - Android system provides a content provider for managing user contact information.
  - Apps with proper permissions can use `ContactsContract.Data` to read and write contact information.

#### Core Concept

- **Not Just a Database Abstraction**:
  - Though they support database-like operations, content providers serve a broader purpose.
  - Function as entry points into apps for publishing named data items identified by a URI scheme.

#### System Benefits

- **URI Assignment and Persistence**:
  - URIs can persist after their owning apps exit.
  - System ensures the owning app runs when data is retrieved from a URI.
- **Fine-Grained Security Model**:
  - URIs enable secure data sharing.
  - Temporary URI permission grants allow controlled access to data.

#### Private Data Management

- **Private Data Handling**:
  - Useful for reading and writing data that is private to the app and not shared with other apps.

#### Implementation

- **ContentProvider Class**:
  - Implement a content provider as a subclass of `ContentProvider`.
  - Must implement standard APIs to enable transactions by other apps.
  - For more information, see the [Content providers developer guide](https://developer.android.com/guide/topics/providers/content-providers).

#### Inter-App Component Activation

- **Starting Other App Components**:
  - Android system allows any app to start another app's component.
  - Example: Using the device camera app to capture a photo.
  - No need to link to the camera app's code; the system handles the activation.

#### Process Management

- **Separate Processes for Apps**:
  - Each app runs in a separate process with restricted file permissions.
  - System starts the required app process and component when needed.

#### No Single Entry Point

- **Component-Based Entry Points**:
  - Unlike apps on most other systems, android apps don't have a single `main()` function.
  - System delivers an intent message to activate components in other apps.

### Practical Example

- **Photo Capture**:
  - Start the camera app’s activity to capture a photo, which runs in the camera app's process.
  - Captured photo is returned to your app, making it appear integrated to the user.

### Activating Components

#### Overview

- **Intents**:
  - Asynchronous messages that activate activities, services, and broadcast receivers.
  - Bind individual components at runtime, acting as messengers to request actions.

#### Types of Intents

- **Explicit Intents**:
  - Target a specific component.
- **Implicit Intents**:
  - Target a specific type of component.

#### Intent Usage

- **Activities and Services**:

  - Define actions such as viewing or sending something.
  - May specify the URI of the data to act on.
  - Example: Request an activity to show an image or open a web page.
  - Can start an activity to receive a result, returning the result in an Intent.
  - Example: Issue an intent to let the user pick a contact, returning a URI pointing to the chosen contact.

- **Broadcast Receivers**:
  - Define broadcast announcements.
  - Example: A broadcast indicating the device battery is low includes an action string indicating low battery.

#### Content Providers

- **Activation**:
  - Activated by a request from a `ContentResolver`.
  - `ContentResolver` handles direct transactions with the content provider.
  - Provides a layer of abstraction for security reasons.

#### Methods for Activating Components

- **Activities**:

  - Use `startActivity()` to start an activity.
  - Use `startActivityForResult()` to start an activity and receive a result.

- **Services**:

  - Use `JobScheduler` (API level 21+) to schedule actions.
  - For earlier versions, use `startService()` to start a service.
  - Use `bindService()` to bind to a service.

- **Broadcasts**:

  - Use `sendBroadcast()` or `sendOrderedBroadcast()` to initiate a broadcast.

- **Content Providers**:
  - Use `query()` on a `ContentResolver` to perform queries.

#### References

- **Further Information**:
  - [Intents and Intent Filters](https://developer.android.com/guide/components/intents-filters)
  - [Introduction to Activities](https://developer.android.com/guide/components/activities/intro-activities)
  - [Services Overview](https://developer.android.com/guide/components/services)
  - [BroadcastReceiver](https://developer.android.com/reference/android/content/BroadcastReceiver)
  - [Content Providers](https://developer.android.com/guide/topics/providers/content-providers)

## The Manifest File

### Overview

- **Purpose**: The manifest file (`AndroidManifest.xml`) informs the Android system about the app's components. It is located at the root of the app project directory.

### Key Functions

- **Component Declaration**: Declares all app components such as activities, services, broadcast receivers, and content providers.
- **Permissions**: Identifies any user permissions required by the app, such as internet access or read-access to the user's contacts.
- **API Level**: Declares the minimum API level required by the app based on the APIs it uses.
- **Hardware and Software Features**: Declares the hardware and software features used or required by the app, such as a camera, Bluetooth services, or a multitouch screen.
- **API Libraries**: Declares any additional API libraries the app needs to be linked against, other than the Android framework APIs, such as the Google Maps library.

### Declare Components

#### Purpose

- **Primary Task**: The manifest file (`AndroidManifest.xml`) informs the system about the app's components.

#### Example of Declaring an Activity

- **Manifest File Example**:
  ```xml
  <?xml version="1.0" encoding="utf-8"?>
  <manifest ... >
      <application android:icon="@drawable/app_icon.png" ... >
          <activity android:name="com.example.project.ExampleActivity"
                    android:label="@string/example_label" ... >
          </activity>
          ...
      </application>
  </manifest>
  ```
- **Explanation**:
  - **`<application>` Element**:
    - `android:icon`: Points to resources for an icon that identifies the app.
  - **`<activity>` Element**:
    - `android:name`: Specifies the fully qualified class name of the Activity subclass.
    - `android:label`: Specifies a string to use as the user-visible label for the activity.

#### Required Elements

- **Activities**: Use `<activity>` elements.
- **Services**: Use `<service>` elements.
- **Broadcast Receivers**: Use `<receiver>` elements.
- **Content Providers**: Use `<provider>` elements.

#### Notes

- **Visibility**: Activities, services, and content providers must be declared in the manifest to be visible to the system and able to run.
- **Broadcast Receivers**:
  - Can be declared in the manifest.
  - Can also be created dynamically in code as `BroadcastReceiver` objects and registered with the system using `registerReceiver()`.

### Declare Component Capabilities

#### Using Intents to Start Components

- **Intents**: Used to start activities, services, and broadcast receivers.
  - **Explicit Intent**: Names the target component using its class name.
  - **Implicit Intent**: Describes the action to perform and optionally the data to act on. The system finds a component that can handle the action.

#### Security Caution

- **Explicit Intents for Services**: Always use explicit intents to start a service to ensure security.
  - **Avoid Implicit Intents**: Using an implicit intent for a service is a security risk as it’s uncertain which service will respond.
  - **API Level 21+**: The system throws an exception if `bindService()` is called with an implicit intent.

#### Intent Filters

- **Purpose**: The system identifies components that can respond to an intent by matching it with intent filters declared in the manifest of other apps.
- **Declaring Intent Filters**:
  - Add `<intent-filter>` elements in the manifest file to specify which intents the component can handle.

#### Example of Declaring an Intent Filter

- **Manifest File Example**:
  ```xml
  <manifest ... >
      ...
      <application ... >
          <activity android:name="com.example.project.ComposeEmailActivity">
              <intent-filter>
                  <action android:name="android.intent.action.SEND" />
                  <data android:type="*/*" />
                  <category android:name="android.intent.category.DEFAULT" />
              </intent-filter>
          </activity>
      </application>
  </manifest>
  ```
- **Explanation**:
  - **`<action>`**: Specifies the action the component can handle (`android.intent.action.SEND` in this case).
  - **`<data>`**: Defines the MIME type of the data (`*/*` to accept any type).
  - **`<category>`**: Adds a category (`android.intent.category.DEFAULT`) to the intent filter.

#### How It Works

- If another app creates an intent with the `ACTION_SEND` action and calls `startActivity()`, the system might start your activity if it matches the intent filter.

### Declare App Requirements

#### Device and Software Requirements

- **Purpose**: To ensure your app is only installed on devices that meet specific feature and capability requirements.
- **System Behavior**: Most declarations are for informational purposes only and are not read by the Android system. However, external services like Google Play use these declarations to filter apps based on device compatibility.

##### Example Requirement: Camera and API Level

- **Scenario**: If your app requires a camera and uses APIs from Android 8.0 (API level 26), you need to declare these requirements in the manifest file.
- Implementation
  - Mandated camera requirement
    ```groovy
     <manifest ... >
       <uses-feature android:name="android.hardware.camera.any"
                 android:required="true" />
       ...
     </manifest>
    ```
  - Optional camera requirement
    ```groovy
     <manifest ... >
       <uses-feature android:name="android.hardware.camera.any"
                 android:required="false" />
       ...
     </manifest>
    ```

#### Declaring API Levels

- **Setting in `build.gradle`**:
  - Define `minSdkVersion` and `targetSdkVersion` in your app module's `build.gradle` file to specify the minimum and target API levels for your app.
  ```groovy
  android {
    ...
    defaultConfig {
      ...
      minSdkVersion 26
      targetSdkVersion 29
    }
  }
  ```

### App Resources

#### Overview

- An Android app requires more than just code; it includes resources such as images, audio files, and visual elements.
- Resources allow you to define animations, menus, styles, colors, and layouts separately from code, making updates easier.

#### Resource IDs

- The SDK build tools generate unique integer IDs for each resource.
- **Example**: For an image file named `logo.png` in the `res/drawable/` directory, the generated resource ID is `R.drawable.logo`.

```xml
<ImageView
    android:src="@drawable/logo" />
```

#### Alternative Resources

- Resources can be optimized for different device configurations, such as languages and screen sizes.
- **Example**: Define UI strings in XML and provide translations in separate files based on language qualifiers.
  - **Default Strings**: `res/values/strings.xml`
  - **French Strings**: `res/values-fr/strings.xml`
    ```xml
      <!-- Default strings.xml -->
      <resources>
       <string name="welcome_message">Welcome</string>
      </resources>

      <!-- French strings.xml -->
      <resources>
        <string name="welcome_message">Bienvenue</string>
      </resources>
    ```

#### Resource Qualifiers

- **Definition**: Qualifiers are short strings added to resource directory names to specify device configurations.

- **Example**: Create different layouts based on screen orientation.

  **Portrait Layout**:
  ```xml
  <!-- res/layout/portrait_layout.xml -->
  <LinearLayout
      android:orientation="vertical"
      ... >
      <!-- UI elements arranged vertically -->
  </LinearLayout>
  ```

#### Automatic Resource Selection

- **Mechanism**: The Android system automatically applies the appropriate resource based on the device's current configuration.




[//]: # "Reference used"
[wiki]: https://developer.android.com/guide/components/fundamentals
````
