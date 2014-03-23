Your Emulator need to have SD card. 

more info: https://class.coursera.org/android-001/forum/thread?thread_id=11567
----------------

By Pietro Ciullo:
---------

If your view isn't getting locations added to it even though you're not getting errors and you are seeing the "Entered addNewPlace()" line in your logs I may have an explanation and guidance for you.

In PlaceViewAdapter.java
In my opinion it starts right in the constructor because it checks ONLY for if externalStorageState is MEDIA_MOUNTED. If it's not read/write then the constructor is exited without any fanfare and we are unaware that we have no place to store images.

This is further exacerbated in add() with its call to storeBitmapToFile(). If storeBitmapToFile returns false nothing is written and we aren't notified that there was a problem. It just seems like the UI might not be working. So, the root of the problem in add() is in storeBitmapToFile().

In storeBitmapToFile() the code again is only checking if external storage is MEDIA_MOUNTED. If not ... it returns false without warning, as just noted. 

So, before anyone responds "You just need to have external storage in your emulator" ... That is not a good developer solution. As developers we should recognize that no external storage isn't an edge case and that we should handle the situation.

We have options.

Don't save anything and inform the user in a Toast that the information cannot be saved because there is no external storage.
Save the location data without storing the image locally. We'll have to handle this when displaying the information in our ListView by either pulling it from the internet or putting in a default image or something similar.
Check for available space in internal storage and store the images there or notify (Toast) the user that there isn't enough internal storage to store the images. Since the filePath is one of the values stored it won't create any problems if someone were to mount external storage later. Those new locations are then stored on external storage and are accessible there unless, of course, that storage is again removed and then the external stored images would present a problem when displaying in the ListView as noted in #2. 

It took me a longer than I would've liked to locate the problem with nothing being displayed in the ListView because there were no log messages indicating nothing was saved (or why). Once I started putting in my own log messages I quickly discovered the issue and worked up an incomplete solution (I'm not checking available internal storage space but would if this were a real-world application that I was developing). I'm only checking for external storage and if it's not available I get a path to the internal storage and use that. If I can't store the image I log that.

Again, if I were doing a real-world app and not just this class assignment I would be doing option #3 with all the checks for available space and if I wasn't able to store the image I would also be doing #2 and storing the information without the image and adjusting the ListView accordingly.

Since there was nothing noted in the assignment writeup that "External Storage" was required in the emulator (or on a physical device) and again, no log messages were indicating a problem, I initially wasn't looking for the problem in the add() or storeBitmapToFile or even the constructor of PlaceViewAdapter.

Hopefully, if there are others having this problem, I've put enough of the right keywords in here so that you'll find this easily and save yourself some time trying to debug your likely working program that just doesn't have access to external storage in your emulator or device.