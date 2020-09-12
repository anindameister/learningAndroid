## video 1

### give an application name

This name can be in any form such as this name could have two words with spaces in between

### give a package name

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
- - java- we write the code under MainActivity.java
-  in regular java, for execution it searches for main method and then executes the main method
-  in android, for execution it goes to MainActivity and searches for onCreate method
- - we design under activity_main.xml
- - For giving permission, eg:memory card, internet, camera access

## video 2

#### virtual device

the virtual mobile which runs the app, that's being created by the java

1. open avd manager

![open avd manager](https://github.com/anindameister/learningAndroid/blob/master/MyApplication/snaps/4.png)

2. in the box that opens up, "create virtual device " is your option

3. choose the phone type

4. choose the os

5. Bam! the phone is created

6. run the java file

OOPS! error

getting back to the previous code where no editing was done and here's the code

- MainActivity.java

```
package com.anindamaulik.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

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
}
```
- activity_main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.coordinatorlayout.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <com.google.android.material.appbar.AppBarLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:theme="@style/AppTheme.AppBarOverlay">

        <androidx.appcompat.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            android:background="?attr/colorPrimary"
            app:popupTheme="@style/AppTheme.PopupOverlay" />

    </com.google.android.material.appbar.AppBarLayout>

    <include layout="@layout/content_main" />

    <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/fab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|end"
        android:layout_margin="@dimen/fab_margin"
        app:srcCompat="@android:drawable/ic_dialog_email" />

</androidx.coordinatorlayout.widget.CoordinatorLayout>
```

- output of activity_main.xml in graphical mode which also includes the phone app version

- note: that the phone version and graphical mode in the android studio is not the same

![basic mobile app with no functionality whatsoever](https://github.com/anindameister/learningAndroid/blob/master/MyApplication/snaps/5.PNG)

- content_main.xml

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layout_behavior="@string/appbar_scrolling_view_behavior">

    <fragment
        android:id="@+id/nav_host_fragment"
        android:name="androidx.navigation.fragment.NavHostFragment"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:defaultNavHost="true"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:navGraph="@navigation/nav_graph" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

- note: that the phone version and graphical mode in the android studio for content_main.xml is not the same

![content_main.xml](https://github.com/anindameister/learningAndroid/blob/master/MyApplication/snaps/6.PNG)

- fragment_first.xml

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".FirstFragment">

    <TextView
        android:id="@+id/textview_first"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Welcome to Aninda Meister's palace of love"
        app:layout_constraintBottom_toTopOf="@id/button_first"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button_first"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button named edited by me"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/textview_first" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button created and constrained by pencil"
        app:layout_constraintEnd_toEndOf="@+id/textview_first"
        app:layout_constraintStart_toStartOf="@+id/textview_first"
        tools:layout_editor_absoluteY="310dp" />
</androidx.constraintlayout.widget.ConstraintLayout>


```

- note: probably really needs to be made in here, because this is the sheer fragment part where the actual existence of button lies

![fragment_first.xml](https://github.com/anindameister/learningAndroid/blob/master/MyApplication/snaps/7.PNG)

## changes made in the design 

- just bottom part of the button has been taken care of

- thus top, bottom, right left needs to be taken care of and you get the desired thing, which is also in accordance to the android studio design view for fragment_first.xml

corresponding code for fragment_first.xml


```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".FirstFragment">

    <TextView
        android:id="@+id/textview_first"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Welcome to Aninda Meister's palace of love"
        app:layout_constraintBottom_toTopOf="@id/button_first"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button_first"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button named edited by me"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/textview_first" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button created and constrained by pencil"
        app:layout_constraintBottom_toTopOf="@+id/button_first"
        app:layout_constraintEnd_toEndOf="@+id/textview_first"
        app:layout_constraintStart_toStartOf="@+id/textview_first"
        app:layout_constraintTop_toBottomOf="@+id/textview_first" />
</androidx.constraintlayout.widget.ConstraintLayout>
```
![fragment_first.xml+app view](https://github.com/anindameister/learningAndroid/blob/master/MyApplication/snaps/8.PNG)

- fragment_second.xml which came into existence by clicking on the default available button

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SecondFragment">

    <TextView
        android:id="@+id/textview_second"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toTopOf="@id/button_second"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button_second"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="got2understandVCHpartOfDbuttonISthis"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/textview_second" />
</androidx.constraintlayout.widget.ConstraintLayout>
```
![fragment_second.xml+app view](https://github.com/anindameister/learningAndroid/blob/master/MyApplication/snaps/9.PNG)

#### sdk manager- software development kit--need not worry about this for now-- this is for testers

![sdk manager](https://github.com/anindameister/learningAndroid/blob/master/MyApplication/snaps/10.PNG)

- we need to download the API 
- or else we won't get the stuff while we'd attempt to create the virtual device

#### video 2 end

## video 3

#### activity and intent

![activity and intent](https://github.com/anindameister/learningAndroid/blob/master/MyApplication/snaps/11.PNG)

– onCreate() , এক্টিভিটি ( Activity ) ক্রিয়েট হতেই এই মেথড কল হয়।

– onStart() , যখন এক্টিভিটি ( Activity ) ইউজারের কাছে ভিজিবল।

– onResume() , যখন ইউজার অ্যাপ্লিকেশনের সাথে ইন্টারেকশন শুরু করে।

– onPause() , যদি এক্টিভিটি ( Activity ) পজ করার দরকার হয়।

– onStop(), যখন এক্টিভিটি ( Activity )  ইনভিজিবল করা হয়।

– onDestroy() , ঠিক এক্টিভিটি ( Activity )  ডেস্ট্রয় করার আগের মুহুর্তে এটা কল হয়।

– onRestart() , যখন এক্টিভিটি ( Activity )  স্টপ হওয়ার পর আবার স্ট্যার্ট করতে হয় তখন এই মেথড কল হবে।


### the default content of MainActivity.java

```
package com.anindamaulik.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

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
}
```

- the above is gonna attempted to be edited now

Steps to create actions in regards to the button

1. creating a variable 'b' of type Button

2. importing the package for button

3. 
```
b=(Button) findViewById(R.id.button);
```
Steps

- getting the right id of the button

Note: couldn't find that in the code and hence got it from the design, found it later and yes, it is there

- catching the xml's button by the method call for the variable created, namely 'b'.. the method name is findViewById

- casting the class, because there could be many types of buttons.  b=(Button) findViewById(R.id.button);

- a little confusion before 4:22

- to get the button clicked we need the method setOnClickListener()