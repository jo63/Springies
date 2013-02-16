hi
in general
 - add names to ALL files you modified
 - use CompSci 308 formatting and clean up rules on your code
 - poor commenting and name choices in many classes
 - unneccessary "get/set" methods in many classes (like Spring, Factory, Model, etc.)

Force hierarchy is poorly designed/implemented:
 - why does Force extend Vector (instead of contain)?
 - why does Force contain bounds and directions (only used in 1 or 2 subclasses each)?
 - why does WallRepulsion extend CenterOfMass?
 - bounce as a Force and a method in Mass
 - magic numbers for WallRepulsion
 - duplicated code in constructors
 - unnecessary overriding of functions in subclasses

Factory
 - I do not understand the name "getCommand" since it does not return a command
 - it is also not properly overridden in subclasses (add @Override tag to see error)
 - in SpriteCommand, getCommand should take mass Map rather than storing it as an instance variable
    (in addition to more understandable code, it will clean many things up)
 - why is wall not implemented as a command like the others?

Physics
 - is definitely NOT closed, lots of special case code

Model
 - add (Sprite) method is unnecessary

Controller is potentially a good idea, but the code is a mess
 - not clear "order" of calls to constructor, init(), and setActionListeners() to make performAction() work
 - setActionListeners() is a poor function name for what it does
 - why store the Model in, when all you need is the Canvas
 - how about a descriptive name like TOP_WALL instead of TOGGLE_WALL_ONE

KeyActions
 - hierarchy filled with duplicated code (no need for separate Force subclasses or separate Increase/Decrease)
 - superclass should not have constant INCREASE_FACTOR and definitely not getIncreaseFactor

MouseActions
 - this is just terrible code :(

Canvas
 - seperate, duplicated, loadModel() and loadAssembly() methods???
 - not sure why getMouseButton() method is needed