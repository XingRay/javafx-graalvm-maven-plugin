package com.xingray.javafx.graalvm.maven.plugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

@Mojo(name = "nativerun", requiresDependencyResolution = ResolutionScope.RUNTIME)
public class NativeRunMojo extends NativeBaseMojo {

    @Override
    public void execute() throws MojoExecutionException {

//        try {
//            SubstrateDispatcher dispatcher = createSubstrateDispatcher();
//            dispatcher.nativeRun();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new MojoExecutionException("Error", e);
//        }
    }
}
