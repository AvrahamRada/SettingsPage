# SettingsPage
Library of settings page for Advanced Android course

## Description:
Hi :)

This is a library that can help anyone add setting page easily in their app.
I created 6 types of layouts you can add to your setting activity:
1. TITLE
2. TITLE + CONTENT
3. CHECKBOX
4. SWITCH
5. SEEKBAR
6. IMAGE

## Screenshots:

<img src="images/settings01.png" width=250>
<img src="images/settings01.jpeg" width=250>
<img src="images/settings01" width=250>

## Setup:
Step 1. Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
          maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency:

```
dependencies {
      implementation 'com.github.AvrahamRada:ScreenLockerApp:1.00.01'
}


```
## Usage

Add this line in the activity where you want you screen locker will appear:
```java                    

        MySharedPreferences.init(this);

```

![](assets/new_password.gif)

After that check if password has not already set.
If not, call setNewPassword. If yes, call checkPassword:
```java                    

        if (MySharedPreferences.getString("password", null) == null) // Set new password
            ScreenLock.setNewPassword(this, Constants.NUMBERS, SuccessActivity.class);
        else {
            ScreenLock.checkPassword(this, Constants.NUMBERS, SuccessActivity.class);
        }

```

![](assets/check_password.gif)

If you want to change the password please call changePassword:
```java                    

        ScreenLock.changePassword(SuccessActivity.this, Constants.NUMBERS, MainActivity.class);

```

![](assets/change_password.gif)   


          
## License

    Copyright 2020 Avraham Rada

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
