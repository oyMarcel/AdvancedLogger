# How to use
### Installing
Just use Maven or Gradle </br>
#### Maven:</br>
- Add the JitPack repository: </br>
```
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
</br>

- And finally add the dependency:
```
<dependency>
	    <groupId>com.github.oyMarcel</groupId>
	    <artifactId>AdvancedLogger</artifactId>
	    <version>v1.1</version>
	</dependency>
```
</br>

#### Gradle:
- Add the JitPack repository: </br>

```	
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
</br>

- And finally add the dependency:
```
dependencies {
		implementation 'com.github.oyMarcel:AdvancedLogger:v1.1'
		}
```
</br>

### Register the logger
Firstly, we want to initialize the logger so it knows if to work or not, and what is your project name. We can do that by using the line
```AdvancedLogger.register("yourAppName");``` ,where "yourAppName" is your app's name.</br>
Now, we can finally create a log.</br>
### Logging
We can use ```AdvancedLogger.inform(message)```, where "message" is your message, to inform the user about someting. Using this would output ```[15:53:14] [yourAppName] [Main/INFO]: message```</br>
Alternatively, we can use ``` AdvancedLogger.alert("message", AlertType.type);``` to warn the user that something isn't right. There are three types of alerts: ```warning, error and fatal```. ```warning``` outputs a warning, like this ```[15:53:14] [yourAppName] [Main/WARNING]: message```. ```error``` outputs a error, like this ```[15:53:14] [yourAppName] [Main/ERROR]: message```. And finally, ```fatal``` outputs a error that was fatal to the program and exits, like this ```[15:53:14] [yourAppName] [Main/ERROR]: message```.
### Saving logs
**This is not yet functional.** To save a log we can use ```AdvancedLogger.log(true, LogType.type);```, where "true" is state of saving logs and "LogType" is the log saving type. There are two Log Types: ```all``` sends all logs created using Adavnced Logger in a txt file, and ```errorsOnly``` only sends errors to the txt file.
# Example program
For the first example we have: </br>
``` public static void main(String[] args)
    {
        AdvancedLogger.register("tester");
        AdvancedLogger.inform("This is a information");
        AdvancedLogger.alert("This is a warning", AlertType.warning);
        AdvancedLogger.alert("This is a error", AlertType.error);
    }
```
</br> Output:
```AdvancedLogger was initialized by tester
[16:16:15] [tester] [Main/INFO]: This is a information
[16:16:15] [tester] [Main/ALERT]: This is a warning
[16:16:15] [tester] [Main/ERROR]: This is a error

Process finished with exit code 0
```
But, if we add ```AdvancedLogger.alert("This is an error that determined a crash", AlertType.fatal);```, the program will crash right after.</br>
Output:
```AdvancedLogger was initialized by tester
[16:18:19] [tester] [Main/INFO]: This is a information
[16:18:19] [tester] [Main/ALERT]: This is a warning
[16:18:19] [tester] [Main/ERROR]: This is a error
[16:18:19] [tester] [Main/ERROR]: This is an error that determined a crash

Process finished with exit code -1
```
</br>
As you can see, our program exited with the code ```-1```, that means an crash occured
