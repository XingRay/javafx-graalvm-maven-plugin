package com.xingray.javafx.graalvm.maven.plugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

@Mojo(name = "compile", defaultPhase = LifecyclePhase.COMPILE,
        requiresDependencyResolution = ResolutionScope.COMPILE_PLUS_RUNTIME)
@Execute(phase = LifecyclePhase.PROCESS_CLASSES)
public class NativeCompileMojo extends NativeBaseMojo {

    @Override
    public void execute() throws MojoExecutionException {
        getLog().info("javafx-native-maven-plugin  NativeCompileMojo#execute()");
        getLog().info(this.toString());

        getLog().info("MainClassName = " + mainClass);
//        getLog().debug("ProjectName = " + project.getName());
        getLog().info("BuildRoot = " + outputDir);

        boolean result = true;
//        try {
//            SubstrateDispatcher dispatcher = createSubstrateDispatcher();
//            result = dispatcher.nativeCompile();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new MojoExecutionException("Error", e);
//        }

        if (!result) {
            throw new MojoExecutionException("Compiling failed");
        }
    }
}
