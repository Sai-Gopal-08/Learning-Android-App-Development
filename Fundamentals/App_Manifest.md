# App Manifest

### AndroidManifest.xml: Essential File in Every App Project  

#### 1. Purpose of `AndroidManifest.xml`  
- Every app **must have** an `AndroidManifest.xml` file at the **root of the project source set**.  
- Provides **essential app information** to:  
  - **Android build tools**  
  - **Android operating system**  
  - **Google Play**  

#### 2. Key Declarations in `AndroidManifest.xml`  

##### ✅ **App Components**  
- Defines **activities, services, broadcast receivers, and content providers**.  
- Each component must specify:  
  - **Name of its Kotlin/Java class**  
  - **Capabilities** (e.g., supported device configurations)  
  - **Intent filters** (how the component can be started)  

##### ✅ **Permissions**  
- Declares **permissions required** to access protected system features or other apps.  
- Also specifies **permissions that other apps need** to interact with this app.  

##### ✅ **Hardware & Software Requirements**  
- Specifies **features required** for the app to run (e.g., camera, GPS, sensors).  
- Determines **device compatibility** for installation from Google Play.  

## App Components in `AndroidManifest.xml`

For each app component in your project, declare a corresponding XML element in the manifest file:

### ✅ **Component Declarations**
- `<activity>` → For each subclass of `Activity`
- `<service>` → For each subclass of `Service`
- `<receiver>` → For each subclass of `BroadcastReceiver`
- `<provider>` → For each subclass of `ContentProvider`
- If you subclass any of these components **without declaring** them in the manifest file, the system **can't start it**.
- Specify the **name of your subclass** using the `name` attribute with the **full package designation**.
- ✅ **Example: Declaring an Activity**
  ```xml
  <manifest ... >
      <application ... >
          <activity android:name="com.example.myapp.MainActivity" ... >
          </activity>
      </application>
  </manifest>
  ```

### File Conventions in `AndroidManifest.xml`

#### 📌 **Elements**
- Only `<manifest>` and `<application>` elements are **required** and must appear **only once**.
- Most other elements can occur **zero or more times**, but some are necessary for a **functional manifest**.
- **Attributes, not character data**, define values inside elements.

##### ✅ **Ordering Rules**
- **Generally unordered**, but with **two key exceptions**:
  - `<activity-alias>` **must follow** the `<activity>` it references.
  - `<application>` **must be the last element** inside `<manifest>`.

#### 📌 **Attributes**
- **All attributes are technically optional**, but many are **necessary** for proper functionality.
- **Most attribute names start with `android:`**, e.g., `android:alwaysRetainTaskState`.
- **The `android:` prefix is often omitted** in documentation for brevity.

#### 📌 Multiple Values in `AndroidManifest.xml`

- When **multiple values** are needed, the **element is repeated** instead of listing multiple values within a single element.
- Example: An **intent filter** can specify **multiple actions** by repeating the `<action>` element:
    ```xml
    <intent-filter>
        <action android:name="android.intent.action.VIEW"/>
        <action android:name="android.intent.action.EDIT" />
        <action android:name="android.intent.action.INSERT" />
        <action android:name="android.intent.action.DELETE" />
        ...
    </intent-filter>
    ```

### 🎨 Resource Values in `AndroidManifest.xml`

- Some attributes require **user-visible values**, such as:
  - **Activity title**
  - **App icon**
- These values should be **set from a resource or theme** instead of hardcoding them.
- This allows values to **adapt** based on:
  - **User's language**
  - **Device configuration** (e.g., different icon sizes for various pixel densities)

   #### 📌 Resource Value Format
   ```plaintext
   @[package:]type/name
   ```
   #### 📌 Breakdown of Resource Value Format

   ##### 📦 Package
    - **Optional** if the resource comes from your app.
    - Use **`android`** if referencing a resource from the **Android framework**.

   ##### 🏷️ Type
    - The **type** of resource, such as:
    - `string` → For text values.
    - `drawable` → For images and icons.
    - `color` → For color values.
    - `dimen` → For dimensions like padding or margins.

   ##### 🔖 Name
    - A **unique identifier** assigned to the resource.

    ##### ✅ Example Usage:
    ```xml
      <activity android:label="@string/app_name" />
      <application android:icon="@drawable/ic_launcher" />
      <item android:color="@android:color/black" />
    ```

### 📜 AndroidManifest.xml Elements Reference

| Element | Description |
|---------|-------------|
| `<action>` | Adds an action to an intent filter. |
| `<activity>` | Declares an activity component. |
| `<activity-alias>` | Declares an alias for an activity. |
| `<application>` | Declares the application. |
| `<category>` | Adds a category name to an intent filter. |
| `<compatible-screens>` | Specifies each screen configuration the application is compatible with. |
| `<data>` | Adds a data specification to an intent filter. |
| `<grant-uri-permission>` | Specifies subsets of app data the parent content provider can access. |
| `<instrumentation>` | Declares an Instrumentation class to monitor the app’s interaction with the system. |
| `<intent-filter>` | Specifies the types of intents an activity, service, or broadcast receiver can respond to. |
| `<manifest>` | The root element of the AndroidManifest.xml file. |
| `<meta-data>` | A name-value pair for additional, arbitrary data supplied to the parent component. |
| `<path-permission>` | Defines the path and required permissions for a specific subset of data in a content provider. |
| `<permission>` | Declares a security permission to limit access to specific components or features. |
| `<permission-group>` | Declares a name for a logical grouping of related permissions. |
| `<permission-tree>` | Declares the base name for a tree of permissions. |
| `<provider>` | Declares a content provider component. |
| `<queries>` | Declares the set of other apps that your app intends to access. |
| `<receiver>` | Declares a broadcast receiver component. |
| `<service>` | Declares a service component. |
| `<supports-gl-texture>` | Declares a single GL texture compression format that the app supports. |
| `<supports-screens>` | Declares the screen sizes your app supports and enables screen compatibility mode. |
| `<uses-configuration>` | Indicates specific input features required by the application. |
| `<uses-feature>` | Declares a single hardware or software feature used by the application. |
| `<uses-library>` | Specifies a shared library that the application must link against. |
| `<uses-native-library>` | Specifies a vendor-provided native shared library the app must link against. |
| `<uses-permission>` | Specifies a system permission the user must grant for the app to function correctly. |
| `<uses-permission-sdk-23>` | Specifies that an app requires a permission only if installed on Android 6.0+ (API level 23+). |
| `<uses-sdk>` | Expresses the app’s compatibility with one or more versions of the Android platform via API level. |

#### 🚧 Limits on Manifest Elements

The following tags have a limit on the number of occurrences in a manifest file:

| Tag Name       | Limit |
|---------------|-------|
| `<package>`   | 1000  |
| `<meta-data>` | 1000  |
| `<uses-library>` | 1000  |

#### 🔢 Limits on Attribute Lengths

The following attributes have a limit on their maximum length:

| Attribute    | Limit |
|-------------|-------|
| `name`      | 1024  |
| `versionName` | 1024  |
| `host`      | 255   |
| `mimeType`  | 255   |





