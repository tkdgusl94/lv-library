lv-library

### project settings.gradle
```
include ':app'
include ':lv-library'
```

### app module build.gradle
```
dependencies {
    api project(":lv-library")
}
```