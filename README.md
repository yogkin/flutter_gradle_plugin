# FlutterGradlePlugin

a gradle plugin，fix flutter2.5.3 framework bug。

link:https://github.com/flutter/flutter/issues/94329

use gradle+asm

## Add a dependency in you root project.
```grovvy
   buildscript {
    dependencies {
        classpath 'io.github.yogkin:my_flutter_plugin:1.0.0.1'
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
```

## apply plugin in you app.gradle
```grovvy
  apply plugin: 'com.my.plugin'
```

### finally you will get this result

![image](https://user-images.githubusercontent.com/13175725/181191794-da773f6d-a190-402f-9bb3-109233be24a7.png)

