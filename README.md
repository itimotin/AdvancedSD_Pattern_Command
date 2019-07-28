# AdvancedSD_Pattern_Command
 bassed on GoF design patterns book

Command

Intent

Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.

Also Known As

Action, Transaction

Motivation

Sometimes it's necessary to issue requests to objects without knowing anything about the operation being requested or the receiver of the request. For example, user interface toolkits include objects like buttons and menus that carry out a request in response to user input. But the toolkit can't implement the request explicitly in the button or menu, because only applications that use the toolkit know what should be done on which object. As toolkit designers we have no way of knowing the receiver of the request or the operations that will carry it out.

The Command pattern lets toolkit objects make requests of unspecified application objects by turning the request itself into an object. This object can be stored and passed around like other objects. The key to this pattern is an abstract Command class, which declares an interface for executing operations. In the simplest form this interface includes an abstract Execute operation. Concrete Command subclasses specify a receiver-action pair by storing the receiver as an instance variable and Execute to invoke the request. The receiver has the knowledge required to carry out the request.

Menus can be implemented easily with Command objects. Each choice in a Menu is an instance of a MenuItem class. An Application class creates these menus and their menu items along with the rest of the user interface. The Application class also keeps track of Document objects that a user has opened.

The application configures each MenuItem with an instance of a concrete Command subclass. When the user selects a MenuItem, the MenuItem calls Execute on its command, and Execute carries out the operation. MenuItems don't know which subclass of Command they use. Command subclasses store the receiver of the request and invoke one or more operations on the receiver.

For example, PasteCommand supports pasting text from the clipboard into a Document. PasteCommand's receiver is the Document object it is supplied upon instantiation. The Execute operation invokes Paste on the receiving Document.



OpenCommand's Execute operation is different: it prompts the user for a document name, creates a corresponding Document object, adds the document to the receiving application, and opens the document.


# Homework
If you click the + button, the count value in the Counter is incremented (from 4 to 5), and the TextFrame shows the value 5, the RectFrame shows a rectangle of 5 by 5, and the OvalFrame shows a circle with diameter 5. If you click the - button, the count value in the Counter is decremented (from 5 to 4), etc.
We want to add Undo/Redo functionality to this small counter application. So we add an Undo and a Redo button.
	
	a. Draw the class diagram with the Command pattern that makes it possible to implement undo/redo functionality to this application. Draw a sequence diagram 
	that shows how the command pattern works ( first click +, then -, then undo, then undo)
	

	b. In the given example, the Counter knows the 3 Frame classes(Text, Rectangle, Oval). With the Observer pattern we learned that in this case it is better 
	to make the 3 Frames (Text, Rectangle, Oval) observe the Counter class. Draw the class diagram with the Command pattern together with the Observer pattern 
	that makes it possible to implement undo/redo functionality to this application. Draw a sequence diagram that shows how the command pattern works ( first click +, 
	then -, then undo, then undo) together with the Observer pattern.
	

# Lab
![Command Laborator](https://github.com/itimotin/AdvancedSD_Pattern_Command/blob/master/CommandLab.png)
	
We want to add undo/redo functionality for the methods deposit(), withdraw() and transferFunds().
	
	a. Draw the modified class diagram with the command pattern applied.

	b. Draw a sequence diagram that shows how your new design works. On the sequence diagram you should first call deposit() on the AccountService, and then execute the
	undo() action.

	c. Implement the command pattern in the given code. You should be able to undo/redo the methods deposit(), withdraw() and transferFunds()on the AccountService.
