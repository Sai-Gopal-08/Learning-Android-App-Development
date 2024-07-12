# Android 

### What is Android ?
- **Android** is a mobile operating system based on a modified version of the Linux kernel and other open-source software, designed primarily for touchscreen mobile devices.

 - **Android** is developed by a consortium of developers known as the Open Handset Alliance, though its most widely used version is primarily developed by Google.
 
 - At its core, the operating system is known as the **Android Open Source Project** (AOSP) and is free and open-source software (FOSS) primarily licensed under the *Apache* License.
 
 
 ### Language Mastery
 - In the world of app development, creating user interfaces has been traditionally approached in an imperative manner.
    - **<span style="font-size:1.3em;">Imperative Approach</span>** (Traditional Android UI): In traditional Android UI development, 
        - You might use [Java](https://docs.oracle.com/javase/8/docs/technotes/guides/language/index.html) or [Kotlin](https://kotlinlang.org) to create UI elements imperatively, specifying each element’s properties and how they should be displayed.
        ```Kotlin
            // Imperative Approach (Traditional Android UI)
            val button:Button = findViewById(R.id.button)
            button.text = "Click me"
            button.setOnClickListener {
            // Do something when the button is clicked
            }
            layout.addView(button)
        ```
        - You use [xml](https://en.wikipedia.org/wiki/XML) to define the UI.
        ```xml
        <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <Button
            android:id="@+id/button"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Left Button"/>
        </LinearLayout>
        ```
    -  **<span style="font-size:1.3em;">Declarative Approach</span>**  ***Jetpack Compose***: With Jetpack Compose, you describe the UI structure declaratively using a composable function. You state what you want and let the framework handle the rest.
        ```Kotlin
        // Define the UI
        @Composable
        fun Greeting(name: String) {
            Text(text = "Hello, $name!")
        }

        // In the UI code - Use it
        Greeting(name = "OMAR")
        ```
        
### Right Application Development Tools and Environment  
 - If you are stepping into Android App development, it is very important that you familiarize yourself with the build automation tools as well as the integrated development environment before you start developing your app. 
 - You can use [Android app studio IDE](https://developer.android.com/studio) or [Eclipse](https://www.eclipse.org) for the tools; they will help you learn the basics and many other things that will help improve your code.
 - Additionally you can familiarize yourself with source control tools and concepts like *git*.


### App components
 - App components are the essential building blocks of an Android app. 
 - Each component is an entry point through which the system or a user can enter your app. Some components depend on others.
 - App components:
    ---

    1. Activities:
        * This is a component that represents a single screen with a user interface.
        
    2. Services:
        * This is a component that runs in the background to perform work for remote processes or long-running operations.
     
    3. Content providers:
        * This is the component that manages a shared set of app data.
    
    4. Broadcast receivers:
        * This is the component that responds to system-wide broadcast announcements.
    
    5. Activating components:
        * An asynchronous message called an intent activates three of the four component types: activities, services, and broadcast receivers.    
    ---

### Terminology - Asynchronous, Tasks, ANR, Crashes
 - A **task** is a collection of activities that users interact with when trying to do something in your app. These activities are arranged in a stack called the *back stack* in the order in which each activity is opened.
 - An Android app *crashes* whenever there’s an unexpected exit caused by an unhandled exception or signal. When an app crashes, Android terminates the app's process and displays a dialog to let the user know that the app has stopped.
 - When the UI thread of an Android app is blocked for too long, an **Application Not Responding** (ANR) error is triggered. ANRs are a problem because the app's main thread, which is responsible for updating the UI, can't process user input events or draw, causing frustration to the user.
 - **Asynchronous** work is the second component of background work, alongside persistent work. 
    - While both persistent and asynchronous work take place in the background, they are ultimately quite different. 
    - In kotlin you can use **Coroutines**, while in java you can use **Threads**.
 
 
 [//]: # (Reference used)
 [wiki]: <https://en.wikipedia.org/wiki/Android_(operating_system)>