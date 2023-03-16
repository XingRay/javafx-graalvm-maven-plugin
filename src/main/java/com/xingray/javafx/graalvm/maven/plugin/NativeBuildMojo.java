package com.xingray.javafx.graalvm.maven.plugin;


import org.apache.maven.model.Activation;
import org.apache.maven.model.Model;
import org.apache.maven.model.Profile;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.shared.invoker.*;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Mojo(name = "build", defaultPhase = LifecyclePhase.COMPILE,
        requiresDependencyResolution = ResolutionScope.COMPILE,
        aggregator = true)
public class NativeBuildMojo extends NativeBaseMojo {

    @Override
    public void execute() throws MojoExecutionException {
        File pomFile = new File(this.pom);

        try {
            Model model = new MavenXpp3Reader().read(new FileInputStream(pomFile));
            System.out.println(model);
            System.out.println(model.getClass());

            model.getProfiles().stream().filter(new Predicate<Profile>() {
                @Override
                public boolean test(Profile profile) {
                    Activation activation = profile.getActivation();
                    return activation != null && activation.isActiveByDefault();
                }
            }).forEach(new Consumer<Profile>() {
                @Override
                public void accept(Profile profile) {
                    getLog().info(profile.toString());
                }
            });

            // prepare the execution:
            final InvocationRequest invocationRequest = new DefaultInvocationRequest();

            // apply profiles to both goals
            invocationRequest.setProfiles(model.getProfiles().stream()
                    .map(Profile::getId)
                    .collect(Collectors.toList()));

            invocationRequest.setPomFile(new File(pom));
            invocationRequest.setGoals(Arrays.asList(Constants.GOAL_COMPILE, Constants.GOAL_LINK));

            DefaultInvoker invoker = new DefaultInvoker();
            final InvocationResult invocationResult = invoker.execute(invocationRequest);
            if (invocationResult.getExitCode() != 0) {
                throw new MojoExecutionException("Error, " + Constants.GOAL_BUILD + " failed", invocationResult.getExecutionException());
            }
        } catch (IOException | XmlPullParserException e) {
            getLog().error(e);
            e.printStackTrace();
            throw new MojoExecutionException(e);
        } catch (MavenInvocationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "NativeBuildMojo{" +
                "pom='" + pom + '\'' +
                "} " + super.toString();
    }
}
