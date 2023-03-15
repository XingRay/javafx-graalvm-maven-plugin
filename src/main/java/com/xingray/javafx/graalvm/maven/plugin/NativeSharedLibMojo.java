package com.xingray.javafx.graalvm.maven.plugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

@Mojo(name = "sharedlib", defaultPhase = LifecyclePhase.COMPILE,
        requiresDependencyResolution = ResolutionScope.COMPILE)
@Execute(phase = LifecyclePhase.PROCESS_CLASSES)
public class NativeSharedLibMojo extends NativeBaseMojo {

    @Override
    public void execute() throws MojoExecutionException {
        getLog().info("javafx-native-maven-plugin  NativeSharedLibMojo#execute()");
        getLog().info(this.toString());

        boolean result = true;
//        try {
//            SubstrateDispatcher dispatcher = createSubstrateDispatcher();
//            result = dispatcher.nativeSharedLibrary();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new MojoExecutionException("Error", e);
//        }

        if (!result) {
            throw new MojoExecutionException("Native shared library failed");
        }
    }
}