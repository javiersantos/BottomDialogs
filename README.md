<h1 align="center">BottomDialogs</h1>
<h4 align="center">Android Library</h4>

<p align="center">
  <a target="_blank" href="https://android-arsenal.com/api?level=11"><img src="https://img.shields.io/badge/API-11%2B-orange.svg"></a>
  <a target="_blank" href="https://travis-ci.org/javiersantos/BottomDialogs"><img src="https://travis-ci.org/javiersantos/BottomDialogs.svg?branch=master"></a>
  <a target="_blank" href="https://www.paypal.me/javiersantos" title="Donate using PayPal"><img src="https://img.shields.io/badge/paypal-donate-yellow.svg" /></a>
  <a target="_blank" href="http://patreon.com/javiersantos" title="Donate using Patreon"><img src="https://img.shields.io/badge/patreon-donate-yellow.svg" /></a>
</p>

<p align="center">Android Library that shows a customizable Material-based bottom sheet.</p>

<table>
    <tr>
        <td>
            <img src="https://raw.githubusercontent.com/javiersantos/BottomDialogs/master/Screenshots/gif-1.gif" />
        </td>
        <td>
            <img src="https://raw.githubusercontent.com/javiersantos/BottomDialogs/master/Screenshots/gif-2.gif" />
        </td>
    </tr>
</table>

## How to include
Add the repository to your project **build.gradle**:

```Javascript
repositories {
    jcenter()
    maven {
        url "https://jitpack.io"
    }
}
```

And add the library to your module **build.gradle**:

```Javascript
dependencies {
    compile 'com.github.javiersantos:BottomDialogs:1.0'
}
```

## Usage
### Basic Bottom Dialog
A basic bottom dialog will be shown with the provided title (optional) and content.

```Java
new BottomDialog(this)
        .setTitle("Awesome!")
        .setContent("What can we improve? Your feedback is always welcome.")
        .show();
```
or using the builder...

```Java
BottomDialog dialog = new BottomDialog(this)
        .setTitle("Awesome!")
        .setContent("What can we improve? Your feedback is always welcome.")
        .build();
...
dialog.show();
```


## Customizations

```Java
// Set an icon for the bottom dialog.
.setIcon(R.drawable.ic_launcher)
```
```Java
// Set if the dialog will be hidden when touching outside.
// Default: true
.setCancelable(false)
```
```Java
// Set a positive / negative Material-based button for the bottom dialog.
.setPositiveText("OK");
.onPositive(new BottomDialog.ButtonCallback() {
        @Override
        public void onClick(BottomDialog dialog) {
                Log.d("BottomDialogs", "Do something!");
        }
})
//.setNegativeText(...)
//.onNegative(...)
```
```Java
// Set a custom view for the bottom dialog.
// Check out the wiki for more documentation: https://github.com/javiersantos/BottomDialogs/wiki/Adding-a-custom-view
.setCustomView(your_custom_view)

// Set a custom view for the bottom dialog with optional padding in DP.
// Check out the wiki for more documentation: https://github.com/javiersantos/BottomDialogs/wiki/Adding-a-custom-view
.setCustomView(your_custom_view, int left, int top, int right, int bottom)
```

## Apps already using this library
Feel free to send me new projects by submitting an [issue](https://github.com/javiersantos/BottomDialogs/issues) or a [pull request](https://github.com/javiersantos/BottomDialogs/pulls).

## License
	Copyright 2016 Javier Santos

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	   http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
