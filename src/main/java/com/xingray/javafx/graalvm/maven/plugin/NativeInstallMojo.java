package com.xingray.javafx.graalvm.maven.plugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

@Mojo(name = "install", requiresDependencyResolution = ResolutionScope.RUNTIME)
public class NativeInstallMojo extends NativeBaseMojo {

    @Override
    public void execute() throws MojoExecutionException {
        getLog().info("javafx-native-maven-plugin  NativeInstallMojo#execute()");
        getLog().info(this.toString());

        boolean result = true;
//        try {
//            SubstrateDispatcher dispatcher = createSubstrateDispatcher();
//            result = dispatcher.nativeInstall();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new MojoExecutionException("Error", e);
//        }

        if (!result) {
            throw new MojoExecutionException("Installing failed");
        }
    }
}
