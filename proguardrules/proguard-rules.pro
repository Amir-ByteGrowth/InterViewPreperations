# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#-keep class com.example.proguardrules.Client{public *;}
#-keep class com.example.proguardrules.Client
#-renamesourcefileattribute SourceFile
#// here optimization run 5 time more
-optimizationpasses 5

#optimize final classes
-optimizations class/marking/final
#optimize final fields
-optimizations field/marking/private
#If we don't want to optimize at all we use,
-dontoptimize