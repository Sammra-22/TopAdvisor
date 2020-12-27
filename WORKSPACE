workspace(name = "bazel_jvm_linters")

## External rules & toolchains ##

load("//:dependencies.bzl", "generate_workspace_rules")

generate_workspace_rules()

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories", "kt_register_toolchains")

kotlin_repositories()
kt_register_toolchains()
android_sdk_repository(name = "androidsdk")

## External libraries & artifacts ##

load("@rules_jvm_external//:defs.bzl", "maven_install")

ANDROIDX_APPCOMPAT = "1.1.0"
ANDROIDX_CONSTRAINT_LAYOUT = "2.0.4"
ANDROIDX_DATABINDING = "4.0.1"
ANDROIDX_LIFECYCLE = "2.2.0"
ANDROIDX_CORE = "1.1.0"
GITHUB_GLIDE = "4.7.1"
GOOGLE_MATERIAL = "1.2.1"
JUNIT_VERSION = "4.13"
SQUAREUP_MOSHI = "1.11.0"

maven_install(
    artifacts = [
        "androidx.appcompat:appcompat:%s" % ANDROIDX_APPCOMPAT,
        "androidx.constraintlayout:constraintlayout:%s" % ANDROIDX_CONSTRAINT_LAYOUT,
        "androidx.core:core:%s" % ANDROIDX_CORE,
        "androidx.databinding:databinding-common:%s" % ANDROIDX_DATABINDING,
        "androidx.databinding:databinding-adapters:%s" % ANDROIDX_DATABINDING,
        "androidx.databinding:databinding-runtime:%s" % ANDROIDX_DATABINDING,
        "androidx.lifecycle:lifecycle-extensions:%s" % ANDROIDX_LIFECYCLE,
        "androidx.lifecycle:lifecycle-viewmodel-ktx:%s" % ANDROIDX_LIFECYCLE,
        "androidx.recyclerview:recyclerview:%s" % ANDROIDX_APPCOMPAT,
        "com.github.bumptech.glide:compiler:%s" % GITHUB_GLIDE,
        "com.github.bumptech.glide:glide:%s" % GITHUB_GLIDE,
        "com.google.android.material:material:%s" % GOOGLE_MATERIAL,
        "com.squareup.moshi:moshi-kotlin:%s" % SQUAREUP_MOSHI,
        "com.squareup.moshi:moshi-kotlin-codegen:%s" % SQUAREUP_MOSHI,
        "junit:junit:%s" % JUNIT_VERSION,
    ],
    repositories = [
        "https://maven.google.com",
        "https://repo1.maven.org/maven2/",
        "https://jcenter.bintray.com/",
    ],
    fetch_sources = True,
    strict_visibility = True,
)
