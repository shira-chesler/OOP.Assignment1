# Observer_Ex1

In order to run the project, one should the repository to its' computer or download a zip of it, then open it through an IDE, go to the Tests.java file inside src/test/test and run it.

In this assignment we were asked to implement an observer by implementing the given interfaces(Member, Sender).
An observer is a design pattern that is a behavioral design pattern type. In this pattern, objects are represented 
as observers that wait for an event to trigger. When the new event is triggered, the multiple observers catch 
these events.
In our implementation of observer we implemented the objects spoken above as the members created using the 
ConcreteMember class that was created by implementing the Member interface. The event that the members are waiting for 
to happen is an update on the UndoableStringBuilder that belongs to the administrator of the members group created using
the GroupAdmin class, that was created by implementing the Sender interface.

One of the ways to measure efficiency is by the size of an object in the memory. 
In the assignmanet we were introduced to the JVMUtilities libary that allows us to do so.
As shown below, we used the function called printJVMUtilities() from the Tests class. in the function we ran a 
simple example using the GroupAdmin and the ConcreteMember classes, and we used the JVMUtilities libary
functions to measure the size and follow the footprints of the classes objects.
we added extra comments in the code below to showcase more clearly the running process.
the code:

![Screenshot (81)](https://user-images.githubusercontent.com/24610228/209661109-c6b0e434-2b47-48de-9536-20d99c804f05.png)

the output:

![0](https://user-images.githubusercontent.com/24610228/209662398-40388e47-2b6e-40f8-a66a-58563143c599.jpg)

![1](https://user-images.githubusercontent.com/24610228/209662430-1b661d97-4e0f-4704-a4dd-986c9eb28cc5.png)

As seen above in the markings, we can see that each object footprint is based on the classes which the object inheritates
from. In addition, we can see the calculation of the total size of the object including the sizes of the parent classes of the object.
for example, the total size of g is 328 which is the sum of all of the object's sizes included in his footprint above the total sum.
Furthermore, in the part where we used the JVMInfo() function we got basic information about the amount of
total memory, amount of processors and the process ID - which are allocated to the running process.

The data structure we used in our implementation of observer in order to update all the members each time a change was made
is arraylist because it's a data structuret that makes adding or removing members easily and efficiently.
We can see the size of the arraylist used in the observer in the JVMUtilities at...

In the tests to the observer we tried to cover various of edge cases on the UndoableStringBuilder class we wrote
in combination with the observer implementation such as insreting a string out of bounds to the UndoableStringBuilder then
watching how it affects the members, undoing an empty UndoableStringBuilder, etc. 

![classes_diagram](https://user-images.githubusercontent.com/24610228/209660922-9a008767-3647-42b9-a997-6b9e58347daa.png)

