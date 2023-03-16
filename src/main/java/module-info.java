module com.xingray.javafx.graalvm.maven.plugin {
    requires maven.plugin.api;
    requires maven.plugin.annotations;
    requires maven.model;
    requires maven.artifact;
    requires maven.invoker;

    requires com.xingray.java.util;
    requires com.xingray.graalvm.compiler.core;
    requires com.xingray.graalvm.compiler.common;

    requires plexus.utils;
}