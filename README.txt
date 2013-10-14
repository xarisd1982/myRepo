I wrote two classes. One is the actual program and the other is some unit tests.
By doing this I help the continuous integration (any change should pass all unit tests),
and reduced the risks of introducing bugs in possible extention or refactoring.
For this reason my methods are also small and clear

1.Let's suppose each character has the maximum of 4 bytes.
Then with 8 characters per string we have 32 bytes per string.
We have 200MB= 200 * 1024 * 1024 bytes = 209715200 bytes.
So we can have 209715200/32=6553600 strings.
Of course not all of the JVM heap space can be given to load the strings so it will be something less than that.
2.In order to increase this limit without increasing the Java Heap Space I would cut each file in smaller parts, something that
would increase the process time but will need less data in the memory.
3.Yes, because it uses standard tested libraries, like apache file utils, and not custom solutions.
4.I would increase the cpu and memory.