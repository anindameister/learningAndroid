# Android Studio

Using Android Studio

## codeWithAninda

Used Android studio, a week ago, to create the first android app. Completely forgot about what I did. I would try  to recollect and write down some details later.
Recollecting steps:
1. Chose "Empty Activity"

## CurrencyConverter

Created that on the first day, got errors and later got frustrated. So, today, I have deleted the project to help me not to get into the frustration of fixing the codes again. Now, that I write about it, it seems that sometimes fixing could prove good. This is my vacation time and hence taking it easy.

## MaulikConvertsCurrency

Initialised today. Important points would be noted down here.

1. res/drawable can accept images
2. But, first attempting to create the minimal app 
3. So decided to choose the view as "Basic Activity". This format gives a basic text along with a button" Deleted the button as it wasn't available in the codewithharry android section, and proceeded.
4. Seemed to have made a minimal view with some headline text, image view, name box, button. During compilation, error came up and it seems that the error says that it is in regards to the button which was initially there and now it's not; but the java code associated to the button exists. Found the java code. Let me try to remove and check if it works or not.
5. my understanding was right. remove the block of code and now the build has been successful. Sorry to myself that I didn't commit the code with errors, actually didn't expect that the code would build successfully, just after the removal.
6. Another point to be noted that, previously, as in on the first day; I was working on all the .xml file codes. Well, I have to be careful while doing that. Got to keep track of the content.xml which seems to be the master file.
7. The app build was successful and the problem that came up was that the the text box, image, button; all got merged up. Fixed that, my establishing relation between the button, text box, button; with the help of the spring. Still the problem with the headline doesn't get fixed. The headline has been covered. Now, the problem is that it was edited on the default and default contains layers. Let's find out what did codewithharry do at the begining. The question is that, did he edit the defaults or created a new. Before proceeding to the video, got to build successful, app testing, code push.
8. To comment/uncomment one line, use: Ctrl + /.. so basically what was done is a thorough investigation of each xml code. The main error was the image view in the content.xml, where it was absolutely mentioned that this image view box is gonna coverup the headline unless it has an association with the headline. So moved the entire code for imageview, name box, button to the firstcontent.xml and now the app looks fine in the phone. Now, got to handle that problems which are gonna come up due to the fact that am handling stuffs from firstContent.xml and not content.xml
9. Look at the code


```java
public void butclick(View view){
        EditText EuroAmounts=(EditText) findViewById(R.id.EuroAmount);
        String euros= EuroAmounts.getText().toString();
        Double doubleEuros= Double.parseDouble(euros);
        Double doubleInr=88.27 * doubleEuros;
        String toastText="="+doubleInr.toString() + "Euros";

        Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
```
1. public: accessible from anywhere
2. void: doesn't return anything
3. butclick: function name, which was the name assigned to the onClick functionality of the button for converting euro amount to inr
4. View view is required to be imported and it has been already
5. EditText EuroAmounts(the id that was used for amount), this should be equal to the function named findViewById which helps to find out the "view" by using "id".. This function would return the view and in order to do that we do findViewById(R.id.EuroAmount)
6. EuroAmount is (the id that was used for amount)