Template examples can be found [here](https://gitlab.scs.ryerson.ca/pboutot/ucm4iot-templates/-/tree/master).

You can follow these steps to have the environment work:
## 1. Install the following plugins
1. [xtext](https://www.eclipse.org/Xtext/download.html)
2. [xtend](https://www.eclipse.org/xtend/download.html)

## 2. Download the repository into your workspace
You should see the following packages 
1. mde.iot.ucm4iot 
2. mde.iot.ucm4iot.dsl 
3. mde.iot.ucm4iot.dsl.ide 
4. mde.iot.ucm4iot.tests
5. mde.iot.ucm4iot.ui
6. mde.iot.ucm4iot.ui.tests

## 3. Right-click on any of the above packages and click on Run As >> Eclipse Application

## 4. A new Eclipse Window should open running the UCM4IoT environment
You can tell if the eclipse application is running if you see a tab called UCM4IoT on the toolbar.
1. Click on *UCM4IoT >> Instantiate UCM4IoT File*

## IMPORTANT - READ THIS
Due to how Eclipse works, it does not automatically register some folders from the listed packages above. Eclipse will throw error messages even though it can clearly see that the folders exists. Follow these steps to fix this problem.
1. Open the **Problems** window (Opened by defult, but you can open it from *Window >> Show View >> Problems* if you can't find it)
2. You'll see a list of errors, only look at the ones related to the src and xtend-gen folders (the others will resolve themselves)

The errors will look like the following:
- Project 'mde.iot.ucm4iot.dsl.ide' is missing required source folder: 'xtend-gen'	mde.iot.ucm4iot.dsl.ide		Build path	Build Path Problem
- Project 'mde.iot.ucm4iot.dsl.ui.tests' is missing required source folder: 'src'	mde.iot.ucm4iot.dsl.ui.tests		Build path	Build Path Problem
- Project 'mde.iot.ucm4iot.dsl.ui.tests' is missing required source folder: 'xtend-gen'	mde.iot.ucm4iot.dsl.ui.tests		Build path	Build Path Problem
- Project 'mde.iot.ucm4iot.dsl.ui' is missing required source folder: 'xtend-gen'	mde.iot.ucm4iot.dsl.ui		Build path	Build Path Problem

3. Right-click on one of those error messages. 
4. Select **Quick Fix**
5. In the window that pops up, select **Configure Build Path**
6. Select **Finish**
7. In the window that pops up, select **Apply and Close**
8. Repeat steps 3-7 for each error message.

## Note: in case you're still not able to run the environment
* Make sure the plugins are installed correctly
* Make sure that the packages have been added into your Eclipse workspace correctly
