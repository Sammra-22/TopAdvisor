"""
Build rules for Android targets.
"""

load(
    "@build_bazel_rules_android//android:rules.bzl",
    _android_binary = "android_binary",
    _android_instrumentation_test = "android_instrumentation_test",
    _android_library = "android_library",
    _android_local_test = "android_local_test",
)
load(
    "@io_bazel_rules_kotlin//kotlin:kotlin.bzl",
    _kt_android_library = "kt_android_library",
    _kt_jvm_test = "kt_jvm_test",
)
load(
    "@rules_java//java:defs.bzl",
    _java_library = "java_library",
    _java_plugin = "java_plugin",
)

def android_library(**args):
    _android_library(**args)

def android_binary(**args):
    _android_binary(**args)

def android_local_test(**args):
    _android_local_test(**args)

def android_instrumentation_test(**args):
    _android_instrumentation_test(**args)

def kt_android_library(**args):
    _kt_android_library(**args)

def kt_jvm_test(**args):
    _kt_jvm_test( **args)

def java_library(**args):
    _java_library(**args)

def java_plugin(**args):
    _java_plugin(**args)
