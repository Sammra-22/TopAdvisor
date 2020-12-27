# TopAdvisor

Sample app for listing top attractions.

Showcase for MVVM architecture using android architecture components (ViewModel/LiveData).


## Prerequisites

- Install [Bazel][bazel] or [Bazelisk][bazelisk] which is a simple wrapper for managing multiple versions of Bazel
- Set the `ANDROID_HOME` variable to the location of the Android SDK:
```
export ANDROID_HOME=$HOME/Library/Android/sdk
```

## Build

To build the Android application via Gradle:
```
./gradlew assembleDebug
```

To build the Android application via Bazel:
```
bazel build //app
```

[bazel]: https://docs.bazel.build/versions/master/install.html
[bazelisk]: https://github.com/bazelbuild/bazelis
