# Console_Video
[![Made with JAVA](https://img.shields.io/badge/Made_with-JAVA-1abc9c.svg)](https://en.wikipedia.org/wiki/Java_(programming_language))

## Getting Started
Clone, compile and run right away!

**0. Make cmd or terminal full size**

**1. Clone the repository**
```
git clone https://github.com/OrdinaryHumanDAO/console-video.git
```
**2. Go to the src directory**
```
cd your_path_to_project\console_video
```
**3. Compile the source files**
```
gradle build
```
**4. Run the program**
```
gradle run --args="<your video file path>" --console=plain
```

## Example
**1. Prepare video file**

![console_mexican_cat.mp4](https://github.com/OrdinaryHumanDAO/console-video/blob/main/mexican_cat.mp4)
source=[un dos tres cuatro (mexican cat)](https://www.youtube.com/watch?v=M3Keg5XKJO8)

**2. Run the program**
```
gradle run --args="../mexican_cat.mp4" --console=plain
```
![console_mexican_cat.mp4](https://github.com/OrdinaryHumanDAO/console-video/blob/main/console_mexican_cat.gif)


## License
This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/OrdinaryHumanDAO/console-video/blob/master/LICENSE.md) file for details