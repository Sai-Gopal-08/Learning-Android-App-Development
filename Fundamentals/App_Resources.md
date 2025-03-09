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
    
### Grouping Resources
- Place each type of resource in a specific sub-directory of your project's `res/` directory.
+-------------+--------------------------------------------+
| Directory   | Resource Type                              |
+=============+============================================+
| `animator/` | XML files that define Property animations. |
+=============+============================================+
| `anim/`     | XML files that define Tween animations. Property animations can also be saved in this directory, but `animator/` is preferred to distinguish between the two types.                                     
+=============+============================================+
| `color/`    | XML files that define a state list of colors. See [Color state list resource](https://developer.android.com/guide/topics/resources/color-list).
+=============+============================================+
| `drawable/` | Bitmap files (`PNG`, `.9.png`, `JPG`, `GIF`) or XML files compiled into different drawable resource subtypes such as bitmaps, nine-patches, state lists, shapes, animation drawables, etc. See [Drawable resources](https://developer.android.com/guide/topics/resources/drawable-resource).
+=============+============================================+
| `mipmap/`   | Drawable files for different launcher icon densities. See [Put app icons in mipmap directories](https://developer.android.com/guide/practices/ui_guidelines/icon_design_adaptive).
+=============+============================================+
| `layout/`   | XML files that define UI layouts. See [Layout resource](https://developer.android.com/guide/topics/resources/layout-resource).
+=============+============================================+
| `menu/`     | XML files that define app menus (options menu, context menu, submenus). See [Menu resource](https://developer.android.com/guide/topics/resources/menu-resource). 
+=============+============================================+
| `raw/`      | Arbitrary files saved in raw form. Can be accessed using `Resources.openRawResource()`. Consider using `assets/` if original filenames and hierarchy need to be preserved. 
+=============+============================================+
| `values/`   | XML files containing simple values like strings, integers, and colors. Different types of values can be organized into separate files: `arrays.xml`, `colors.xml`, `dimens.xml`, `strings.xml`, `styles.xml`. See [More resource types](https://developer.android.com/guide/topics/resources/providing-resources). 
+=============+============================================+
| `xml/`      | Arbitrary XML files that can be read at runtime using `Resources.getXML()`. Used for configuration files like search configuration.
+=============+============================================+
| `font/`     | Font files (`TTF`, `OTF`, `TTC`) or XML defining a `<font-family>`. See [Add a font as an XML resource](https://developer.android.com/guide/topics/ui/look-and-feel/fonts-in-xml). 
+-------------+--------------------------------------------+


