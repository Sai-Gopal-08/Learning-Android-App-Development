# App Resources
##### <small>Deep diving into App Resources</small>

### App Resources Overview

- **Definition**: Resources include additional files and static content such as

  - **Bitmaps**: Images used in the app.
  - **Layout definitions**: XML files defining the UI
  - **UI Strings**: text displayed to users.
  - **Animations**: XML or programmatic animations.
  
- Importance of Externalizing Resources:

  - Easier maintenance.
  - Better localization support for different languages.
  - Adaptation for various device configurations.
  
- Providing Alternative Resources:

  - Use configuration qualifiers to provide optimized resources:
    - **Screen Size**: Different layouts for phones and tablets.
    - **Language**: Localized string files for different languages.
    - **Density**: High-resolution images for high-DPI screens.
  - Android automatically selects the best-matching resource based on device configuration.

- Accessing Resources:

  - Use the `R` class in Android to reference resources:
    ```kotlin
    val myString = getString(R.string.app_name)
    val myImage = ContextCompat.getDrawable(context, R.drawable.logo)
    ```
  - Resources can also be accessed from XML:
    ```kotlin
    <ImageView android:src="@drawable/logo" />
    <TextView android:text="@string/app_name" />
    ```

