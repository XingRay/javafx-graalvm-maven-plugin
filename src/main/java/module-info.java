module com.xingray.javafx.graalvm.maven.plugin {
    requires maven.plugin.api;
    requires maven.plugin.annotations;
    requires maven.model;
    requires maven.artifact;
    requires maven.invoker;

//    requires com.xingray.java.maven.core;
    requires plexus.utils;
}