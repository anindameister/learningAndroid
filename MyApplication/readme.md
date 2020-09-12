# give an application name

This name can be in any form such as this name could have two words with spaces in between

# give a package name

just make sure that this is unique because if someday you decide to publish your app in app store then you'll be able to use this particular project name which has this package name

#### shubhadeep app

com.kibo.android=company domain+application name=package name

set by default

![set by default](https://github.com/anindameister/learningAndroid/blob/master/MyApplication/snaps/1.PNG)

options available

![options available](https://github.com/anindameister/learningAndroid/blob/master/MyApplication/snaps/2.png)

selecting project option because simpler view, that's the first option

1. app
2. source
3. main
java- contains java file where we write the java code
res- contains the resources
AndroidManifest.xml- version controlling etc changing theme etc.;landscape/portrait

![AndroidManifest.xml](https://github.com/anindameister/learningAndroid/blob/master/MyApplication/snaps/3.PNG)

intent-filter: let's us know, which activity should start first

```
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
```

under resources or res, we have layout and under layout we have activity_main.xml

#### MainActivity.java

1. java file
2. xml file
3. a file in xml for menu

the following are for the menus, we dont need now and hence deleting

```
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
```

now we remove AppCompatActivity and make it just Activity, this throws an error and hence we just import the package or class to remove the error

#### activity_main.xml

1. code
2. design 
3. split

### summarisation of video 1

1. downloading android studio
2. creating a project
- application
- company domain
- package name should be taken care of
3. after creating the project
-  java
-  res
-  AndroidManifest
4. Work
a. java- we write the code under MainActivity.java
-  in regular java, for execution it searches for main method and then executes the main method
-  in android, for execution it goes to MainActivity and searches for onCreate method
b. we design under activity_main.xml
c. For giving permission, eg:memory card, internet, camera access