package com.xingray.javafx.graalvm.maven.plugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.*;

@Mojo(name = "run", requiresDependencyResolution = ResolutionScope.RUNTIME)
@Execute(phase = LifecyclePhase.PROCESS_CLASSES)
public class RunMojo extends NativeBaseMojo {

    /**
     * The execution ID as defined in the POM.
     */
//    @Parameter(defaultValue = "${mojoExecution}", readonly = true)
//    private MojoExecution execution;

    @Parameter(readonly = true, required = true, defaultValue = "${basedir}/pom.xml")
    String pom;

    @Parameter(readonly = true, required = true, defaultValue = "${basedir}/runPom.xml")
    String runPom;

    @Override
    public void execute() throws MojoExecutionException {
        getLog().info("javafx-native-maven-plugin  RunMojo#execute()");
        getLog().info(this.toString());

//        final InvocationRequest invocationRequest = new DefaultInvocationRequest();
//        invocationRequest.setProfiles(project.getActiveProfiles().stream()
//                .map(Profile::getId)
//                .collect(Collectors.toList()));
//        invocationRequest.setProperties(session.getRequest().getUserProperties());
//
//        // 1. Read pom
//        File pomFile = new File(pom);
//        if (!pomFile.exists()) {
//            throw new MojoExecutionException("Error: pom not found at " + pomFile);
//        }
//        // 2. Create temporary pom file
//        File runPomFile = new File(runPom);
//        try (InputStream is = new FileInputStream(pomFile)) {
//            // 3. Create model from current pom
//            Model model = new MavenXpp3Reader().read(is);
//
//            model.getBuild().getPlugins().stream()
//                    .filter(p -> p.getGroupId().equalsIgnoreCase("org.openjfx") &&
//                            p.getArtifactId().equalsIgnoreCase("javafx-maven-plugin"))
//                    .findFirst()
//                    .orElseThrow(() -> new MojoExecutionException("No JavaFX plugin found"));
//
//            // 4. Check for Attach Dependencies and if Desktop is supported, add the classifier
////            model.getDependencies().stream()
////                    .filter(p -> p.getGroupId().equalsIgnoreCase(AttachArtifactResolver.DEPENDENCY_GROUP))
////                    .filter(p -> Arrays.stream(AttachService.values())
////                            .filter(AttachService::isDesktopSupported)
////                            .anyMatch(attach -> attach.getServiceName().equalsIgnoreCase(p.getArtifactId()))
////                    )
////                    .forEach(p -> p.setClassifier("desktop"));
//
//            // 5. Serialize new pom
//            try (OutputStream os = new FileOutputStream(runPomFile)) {
//                new MavenXpp3Writer().write(os, model);
//            }
//        } catch (Exception e) {
//            if (runPomFile.exists()) {
//                runPomFile.delete();
//            }
//            throw new MojoExecutionException("Error reading pom", e);
//        }
//
//        if (!"host".equals(target)) {
//            getLog().warn(String.format("Target '%s' will be ignored for 'gluonfx:run' goal on the host machine", target));
//        }
//
//        invocationRequest.setPomFile(runPomFile);
//        String goal = "javafx:run";
//        if (execution != null) {
//            goal += "@" + execution.getExecutionId();
//        }
//        invocationRequest.setGoals(Collections.singletonList(goal));
//
//        final Invoker invoker = new DefaultInvoker();
//        try {
//            final InvocationResult invocationResult = invoker.execute(invocationRequest);
//            if (invocationResult.getExitCode() != 0) {
//                throw new MojoExecutionException("Error, " + goal + " failed", invocationResult.getExecutionException());
//            }
//        } catch (MavenInvocationException e) {
//            e.printStackTrace();
//            throw new MojoExecutionException("Error", e);
//        } finally {
//            if (runPomFile.exists()) {
//                runPomFile.delete();
//            }
//        }
    }
}
