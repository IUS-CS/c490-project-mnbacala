
## Motivation

In this section, describe the motivation behind your choice of app to design and implement. Also indicate who is the target user base. Include references to existing apps that are similar to the app you are proposing – references must include the name of the app, the platform (e.g., iOS, Android, Windows, MacOS, etc.), and a link to a website describing the app.

***
![Spongebob](https://imgflip.com/s/meme/Mocking-Spongebob.jpg)
The motivation behind Mockify is the Spongebob mocking meme. The meme is used to imply a mocking tone towards an opinion/point of view. In the meme, the message is written with random capital letters ("tHIs iS An eXAmPle"). It usually takes a little bit of time to determine which letters should be capitalized. Because of this, I'll be making an application in which a user enters text and the output will be the message with randomized capital letters. The user will be able to copy and paste the message and will have an option to view history of previous messages. 

There are similar applications and websites that can generate memes, such as Meme Generator on iOS, as well as the imgflip meme generator (https://imgflip.com/memegenerator).

## User Interface

In my app's user interface, it will consist of four screens, a home screen and three other screens. One button will take you to a screen containing a text window that will allow the user to enter text. There will be two buttons in this screen, one button that will randomly capitalize the letters of the given message. The second button that will take the user to an additional screen that will generate an image of Spongebob containing the message will be produced, allowing the user to save, copy, or share the image. The user will also be able to copy the output text.

In the fourth screen, the user will be able to view a history of submitted text, the generated text, and the image.

When not connected to the Internet, the data will be cached within the device storage. When the app is paused, the application's current state will be saved, and when the app resumes, it will start at the save state. The user will be able to swipe right from the edge of the screen to return back to the previous menu. The user will not lose any input data when swiching between screens, the save state will be stored locally. When switching screens, the app will seamlessly save and restore the user's UI state to ensure the user's user interface state expectation.

## Communication

Mockify will communicate with the outside world via Wi-fi and will communicate with the Imgflip API to generate the image. The data will be stored in a table and will be utilizing Firebase. When the device is connected to the Internet, it will store the cached files within a Firebase database. To test this I will disconnect from Wi-fi and shut down using onDestroy() event, and then restart the app to see if the cached files will appear in the table.

The main menu will contain the mocking Spongebob image and two buttons, a button that will take the user to a screen to utilize the function of the application, the second button to view a history of previously submitted messages, the generated text, and the generated image. The menus will resemble what we have done in previous assignments. All screens will support both portrait and landscape layouts. Each view will utilize a LinearLayout. 

![Diagram of application](https://github.com/IUS-CS/c490-project-mnbacala/blob/master/images/mockify-diagram.png)