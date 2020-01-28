<h1 align="center">BottomDialogs <a href="https://github.com/javiersantos/BottomDialogs#how-to-include"><img src="https://jitpack.io/v/javiersantos/BottomDialogs.svg"></a></h1>
<h4 align="center">Android Library</h4>

<p align="center">
  <a target="_blank" href="https://android-arsenal.com/api?level=11"><img src="https://img.shields.io/badge/API-11%2B-orange.svg"></a>
  <a target="_blank" href="https://travis-ci.org/javiersantos/BottomDialogs"><img src="https://travis-ci.org/javiersantos/BottomDialogs.svg?branch=master"></a>
  <a target="_blank" href="http://android-arsenal.com/details/1/3735"><img 		src="https://img.shields.io/badge/Android%20Arsenal-BottomDialogs-blue.svg"></a>
</p>

<p align="center">Android Library that shows a customizable Material-based bottom sheet.</p>

<table align="center">
    <tr>
        <td>
            <img src="https://raw.githubusercontent.com/javiersantos/BottomDialogs/master/Screenshots/gif-1.gif" height="400" />
        </td>
        <td>
            <img src="https://raw.githubusercontent.com/javiersantos/BottomDialogs/master/Screenshots/gif-2.gif" width="500" />
        </td>
    </tr>
</table>

## How to include
Add the repository to your project **build.gradle**:

```Gradle
repositories {
    maven {
        url "https://jitpack.io"
    }
}
```

And add the library to your module **build.gradle**:

```Gradle
dependencies {
    compile 'com.github.javiersantos:BottomDialogs:1.2.1'
}
```

## Usage
### Basic Bottom Dialog
A basic bottom dialog will be shown. You have access to methods such as `setTitle()`, `setContent()`, `setIcon()`, `setCancelable()`, `dismiss()`, etc. Customizations are explained below.

```Java
new BottomDialog.Builder(this)
	.setTitle("Awesome!")
	.setContent("What can we improve? Your feedback is always welcome.")
	.show();
```

or

```Java
BottomDialog bottomDialog = new BottomDialog.Builder(this)
	.setTitle("Awesome!")
	.setContent("What can we improve? Your feedback is always welcome.")
	.build();
...
bottomDialog.show();
```

### Displaying an icon
The bottom dialog icon will be shown to the left of the title.

```Java
new BottomDialog.Builder(this)
	.setTitle("Awesome!")
	.setContent("What can we improve? Your feedback is always welcome.")
	.setIcon(R.drawable.ic_launcher)
	//.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_launcher))
	.show();
```

### Adding buttons and callbacks
Buttons are showed at the end of the bottom dialog. You can add your own text, colors and actions/callbacks.

```Java
new BottomDialog.Builder(this)
	.setTitle("Awesome!")
	.setContent("What can we improve? Your feedback is always welcome.")
	.setPositiveText("OK")
	.setPositiveBackgroundColorResource(R.color.colorPrimary)
	//.setPositiveBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary)
	.setPositiveTextColorResource(android.R.color.white)
	//.setPositiveTextColor(ContextCompat.getColor(this, android.R.color.colorPrimary)
	.onPositive(new BottomDialog.ButtonCallback() {
		@Override
		public void onClick(BottomDialog dialog) {
			Log.d("BottomDialogs", "Do something!");
		}
	}).show();
```

```Java
new BottomDialog.Builder(this)
	.setTitle("Awesome!")
	.setContent("What can we improve? Your feedback is always welcome.")
	.setNegativeText("Exit")
	.setNegativeTextColorResource(R.color.colorAccent)
	//.setNegativeTextColor(ContextCompat.getColor(this, R.color.colorAccent)
	.onNegative(new BottomDialog.ButtonCallback() {
		@Override
		public void onClick(BottomDialog dialog) {
			Log.d("BottomDialogs", "Do something!");
		}
	}).show();
```

If no `onPositive()` or `onNegative()` callbacks are provided, then the bottom dialog will be dismissed when tapping de button.

If `autoDismiss()` is turned `false`, then you must manually dismiss the dialog in these callbacks. Auto dismiss is `true` by default.

### Dismissing when touching outside
The `setCancelable()` method lets you disable dismissing the bottom dialog when you tap outside the dialog window.

```Java
new BottomDialog.Builder(this)
	.setTitle("Awesome!")
	.setContent("What can we improve? Your feedback is always welcome.")
	.setCancelable(false)
	.show();
```

### Adding a custom view
You can add custom view to your bottom dialog just by adding the layout to the `setCustomView()` method.

```Java
new BottomDialog.Builder(this)
	.setTitle("Awesome!")
	.setContent("What can we improve? Your feedback is always welcome.")
	.setCustomView(R.layout.my_custom_view)
	.show();
```

A detailed description is available at: https://github.com/javiersantos/BottomDialogs/wiki/Adding-a-custom-view

### Adding a custom color and font

You can add custom colors and fonts to bottom dialog by using the view objects: `getIconImageView()`, `getTitleTextView()`, `getContentTextView()`, `getNegativeButton()` and `getPositiveButton()`. For example:

```Java
BottomDialog bottomDialog = BottomDialog.Builder(this)
	...
	.build();

bottomDialog.getTitleTextView().setTextColor(Color.parseColor("#8f000000"));
bottomDialog.getTitleTextView().setTypeface(BaseActivity.getFont(Fonts.SEMI_BOLD));
bottomDialog.show();
```

## Third Party Bindings

### React Native
You may now use this library with [React Native](https://github.com/facebook/react-native) via the module [here](https://github.com/prscX/react-native-bottom-action-sheet)


## License
	Copyright 2016-2018 Javier Santos

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	   http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
