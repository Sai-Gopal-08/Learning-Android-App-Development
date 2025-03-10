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

| Directory    | Resource Type |
|-------------|--------------|
| `animator/` | XML files that define Property animations. |
| `anim/` | XML files that define Tween animations. Property animations can also be saved in this directory, but `animator/` is preferred to distinguish between the two types. |
| `color/` | XML files that define a state list of colors. See [Color state list resource](https://developer.android.com/guide/topics/resources/color-list). |
| `drawable/` | Bitmap files (`PNG`, `.9.png`, `JPG`, `GIF`) or XML files compiled into different drawable resource subtypes such as bitmaps, nine-patches, state lists, shapes, animation drawables, etc. See [Drawable resources](https://developer.android.com/guide/topics/resources/drawable-resource). |
| `mipmap/` | Drawable files for different launcher icon densities. See [Put app icons in mipmap directories](https://developer.android.com/guide/practices/ui_guidelines/icon_design_adaptive). |
| `layout/` | XML files that define UI layouts. See [Layout resource](https://developer.android.com/guide/topics/resources/layout-resource). |
| `menu/` | XML files that define app menus (options menu, context menu, submenus). See [Menu resource](https://developer.android.com/guide/topics/resources/menu-resource). |
| `raw/` | Arbitrary files saved in raw form. Can be accessed using `Resources.openRawResource()`. Consider using `assets/` if original filenames and hierarchy need to be preserved. |
| `values/` | XML files containing simple values like strings, integers, and colors. Different types of values can be organized into separate files: `arrays.xml`, `colors.xml`, `dimens.xml`, `strings.xml`, `styles.xml`. See [More resource types](https://developer.android.com/guide/topics/resources/providing-resources). |
| `xml/` | Arbitrary XML files that can be read at runtime using `Resources.getXML()`. Used for configuration files like search configuration. |
| `font/` | Font files (`TTF`, `OTF`, `TTC`) or XML defining a `<font-family>`. See [Add a font as an XML resource](https://developer.android.com/guide/topics/ui/look-and-feel/fonts-in-xml). |

### Order of Precedence for Configuration Qualifiers in Android

| Precedence | Qualifier               | Description                                                                                                                                                                                                                           |
|------------|-------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1          | **MCC and MNC**         | Mobile Country Code (MCC) and Mobile Network Code (MNC) from the SIM card. Example: `mcc310-mnc004` for U.S. on Verizon. :contentReference[oaicite:0]{index=0} |
| 2          | **Language and Region** | Language and region qualifiers. Examples: `en`, `en-rUS`, `fr-rFR`.                                                                                                                            |
| 3          | **Layout Direction**    | Layout direction of the user interface. Examples: `ldltr` for left-to-right, `ldrtl` for right-to-left.                                                                                        |
| 4          | **Smallest Width**      | Specifies the smallest available width of the screen in density-independent pixels (dp). Example: `sw600dp` for screens with at least 600dp width.                                             |
| 5          | **Available Width**     | Specifies the available width of the screen in dp. Example: `w720dp` for screens with at least 720dp width.                                                                                    |
| 6          | **Available Height**    | Specifies the available height of the screen in dp. Example: `h1024dp` for screens with at least 1024dp height.                                                                                |
| 7          | **Screen Size**         | General size of the screen. Qualifiers: `small`, `normal`, `large`, `xlarge`.                                                                                                                  |
| 8          | **Screen Aspect**       | Aspect ratio of the screen. Qualifiers: `long`, `notlong`.                                                                                                                                      |
| 9          | **Round Screen**        | Specifies whether the screen is round. Qualifiers: `round`, `notround`.                                                                                                                         |
| 10         | **Wide Color Gamut**    | Specifies whether the screen supports a wide color gamut. Qualifiers: `widecg`, `nowidecg`.                                                                                                    |
| 11         | **High Dynamic Range**  | Specifies whether the screen supports high dynamic range. Qualifiers: `highdr`, `lowdr`.                                                                                                       |
| 12         | **Screen Orientation**  | Orientation of the screen. Qualifiers: `port` for portrait, `land` for landscape.                                                                                                              |
| 13         | **UI Mode**             | Specifies the user interface mode. Qualifiers: `car`, `desk`, `television`, `appliance`, `watch`, `vrheadset`.                                                                                 |
| 14         | **Night Mode**          | Specifies the night mode. Qualifiers: `night`, `notnight`.                                                                                                                                      |
| 15         | **Density**             | Specifies the screen pixel density. Qualifiers: `ldpi`, `mdpi`, `hdpi`, `xhdpi`, `xxhdpi`, `xxxhdpi`, `nodpi`, `tvdpi`.                                                                         |
| 16         | **Touchscreen Type**    | Type of touchscreen. Qualifiers: `notouch`, `finger`.                                                                                                                                           |
| 17         | **Keyboard Availability** | Availability of a keyboard. Qualifiers: `keysexposed`, `keyshidden`, `keyssoft`.                                                                                                                |
| 18         | **Primary Text Input**  | Primary method of text input. Qualifiers: `nokeys`, `qwerty`, `12key`.                                                                                                                          |
| 19         | **Navigation Key Availability** | Availability of navigation keys. Qualifiers: `navexposed`, `navhidden`.                                                                                                                        |
| 20         | **Primary Non-Touch Navigation Method** | Primary method of non-touch navigation. Qualifiers: `nonav`, `dpad`, `trackball`, `wheel`.                                                                                                      |
| 21         | **Platform Version**    | Specifies the platform version. Example: `v21` for API level 21.                                                                                                                               |
### Qualifier Name Rules in Android Resources

#### 1. Using Multiple Qualifiers  
- Multiple qualifiers **can be combined** in a single resource directory name using dashes (`-`).  
- **Example:**  
  - ✅ `drawable-en-rUS-land/` → Used for US-English devices in landscape mode.  
  - ❌ `drawable-hdpi-port/` (Incorrect)  
  - ✅ `drawable-port-hdpi/` (Correct)

#### 2. Order of Qualifiers  
- Qualifiers **must** follow the order specified in Table 2 of the Android documentation.  
- Incorrect ordering can cause resource selection issues.

#### 3. Nesting Resource Directories is Not Allowed  
- **Wrong:** `res/drawable/drawable-en/` (Nested directories are invalid)  
- **Correct:** `res/drawable-en/` (Qualifier applied at the top level)

#### 4. Case-Insensitive Directory Names  
- Qualifier values are **case-insensitive**.  
- The resource compiler **converts all directory names to lowercase** before processing.  
- Capitalization in examples is **only for readability**.

#### 5. Only One Value Per Qualifier Type  
- **Incorrect:** `drawable-es-fr/` (Can't specify multiple locales in one directory)  
- **Correct:**  
  - `drawable-es/` → Resources for Spanish  
  - `drawable-fr/` → Resources for French  
- To avoid file duplication, use **resource aliasing** (see *Create alias resources*).

#### 6. Automatic Resource Selection  
- Android **automatically selects the best-matching resource** based on the device's current configuration.  
- If no matching resource is found, **the default resource (without qualifiers) is used**.

#### 7. Best Practices  
- Follow the **correct qualifier order** for reliable resource selection.  
- Avoid **nested resource directories** to prevent compilation issues.  
- Use **default resources** as a fallback for unsupported configurations.  

### Creating Alias Resources in Android

#### 1. Purpose of Alias Resources  
- Prevent **duplicate resources** by creating an alias instead of copying the same file into multiple directories.  
- Useful when a **resource needs to be shared across multiple device configurations** without setting it as the default.

#### 2. Use Case Example  
- Assume you have an app icon **`icon.png`**, and different locales require unique versions.  
- **English-Canadian (`en-rCA`)** and **French-Canadian (`fr-rCA`)** need the same version.  
- Instead of duplicating `icon.png`, you can:  
  1. **Save it as** `icon_ca.png` in the **default `res/drawable/` directory**.  
  2. **Create XML alias files** in both `res/drawable-en-rCA/` and `res/drawable-fr-rCA/`.





