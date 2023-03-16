package com.xingray.javafx.graalvm.maven.plugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

@Mojo(name = "link", defaultPhase = LifecyclePhase.COMPILE,
        requiresDependencyResolution = ResolutionScope.COMPILE)
public class NativeLinkMojo extends NativeBaseMojo {

    @Override
    public void execute() throws MojoExecutionException {

        boolean result = true;
//        try {
//            SubstrateDispatcher dispatcher = createSubstrateDispatcher();
//            result = dispatcher.nativeLink();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new MojoExecutionException("Error", e);
//        }

        if (!result) {
            throw new MojoExecutionException("Linking failed");
        }
    }
}
