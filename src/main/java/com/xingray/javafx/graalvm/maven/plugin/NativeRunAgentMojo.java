package com.xingray.javafx.graalvm.maven.plugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.*;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@Mojo(name = "run-agent", requiresDependencyResolution = ResolutionScope.RUNTIME)
@Execute(phase = LifecyclePhase.PROCESS_CLASSES)
public class NativeRunAgentMojo extends NativeBaseMojo {

    @Override
    public void execute() throws MojoExecutionException {
//        getLog().debug("javafx-native-maven-plugin  NativeRunAgentMojo#execute()");
//        getLog().debug(this.toString());
//
//        try {
//            createSubstrateDispatcher();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new MojoExecutionException("Error creating Substrate Dispatcher", e);
//        }
//
//        final InvocationRequest invocationRequest = new DefaultInvocationRequest();
//        invocationRequest.setProfiles(project.getActiveProfiles().stream()
//                .map(Profile::getId)
//                .collect(Collectors.toList()));
//        invocationRequest.setProperties(session.getRequest().getUserProperties());
//
//        // 1. Create/Clear directory for config files
//        File agentDirFile = new File(agentDir);
//        if (agentDirFile.exists()) {
//            // TODO: Delete files
//            // otherwise it keeps merging results from different runs
//            // and config files might get outdated.
//        } else {
//            agentDirFile.mkdirs();
//        }
//
//        // 2. Create filter file to exclude platform classes
//        try {
//            createFilterFile();
//        } catch (IOException e) {
//            throw new MojoExecutionException("Error generating agent filter", e);
//        }
//
//        // 3. Create modified pom
//        File agentPomFile = new File(agentPom);
//        try (InputStream is = new FileInputStream(new File(pom))) {
//            // 4. Create model from current pom
//            Model model = new MavenXpp3Reader().read(is);
//
//            model.getBuild().getPlugins().stream()
//                    .filter(p -> p.getGroupId().equalsIgnoreCase("org.openjfx") &&
//                            p.getArtifactId().equalsIgnoreCase("javafx-maven-plugin"))
//                    .findFirst()
//                    .ifPresentOrElse(p -> {
//                        // 5. Modify configuration
//                        p.setConfiguration(modifyConfiguration(p.getConfiguration()));
//                    }, () -> getLog().warn("No JavaFX plugin found",
//                            new MojoExecutionException("No JavaFX plugin found")));
//
//            // 6. Check for Attach Dependencies and if Desktop is supported, add the classifier
////            model.getDependencies().stream()
////                    .filter(p -> p.getGroupId().equalsIgnoreCase(AttachArtifactResolver.DEPENDENCY_GROUP))
////                    .filter(p -> Arrays.stream(AttachService.values())
////                            .filter(AttachService::isDesktopSupported)
////                            .anyMatch(attach -> attach.getServiceName().equalsIgnoreCase(p.getArtifactId()))
////                    )
////                    .forEach(p -> p.setClassifier("desktop"));
//
//            // 7. Serialize new pom
//            try (OutputStream os = new FileOutputStream(agentPomFile)) {
//                new MavenXpp3Writer().write(os, model);
//            }
//        } catch (Exception e) {
//            if (agentPomFile.exists()) {
//                agentPomFile.delete();
//            }
//            throw new MojoExecutionException("Error generating agent pom", e);
//        }
//
//        invocationRequest.setPomFile(agentPomFile);
//        invocationRequest.setGoals(Collections.singletonList("javafx:run"));
//
//        final Invoker invoker = new DefaultInvoker();
//        // 8. Execute:
//        try {
//            final InvocationResult invocationResult = invoker.execute(invocationRequest);
//            if (invocationResult.getExitCode() != 0) {
//                throw new MojoExecutionException("Error, javafx:run failed", invocationResult.getExecutionException());
//            }
//        } catch (MavenInvocationException e) {
//            e.printStackTrace();
//            throw new MojoExecutionException("Error", e);
//        } finally {
//            if (agentPomFile.exists()) {
//                agentPomFile.delete();
//            }
//        }
    }

    private Object modifyConfiguration(Object config) {
//        // 1. Change executable to GRAALVM_HOME
//        Xpp3Dom dom = config == null ? new Xpp3Dom("configuration") : (Xpp3Dom) config;
//        Xpp3Dom executable = dom.getChild("executable");
//        String graalVMJava = Path.of(getGraalvmHome().get(), "bin", "java").toString();
//        if (executable == null) {
//            Xpp3Dom d = new Xpp3Dom("executable");
//            d.setValue(graalVMJava);
//            dom.addChild(d);
//        } else {
//            executable.setValue(graalVMJava);
//        }
//
//        // 2. Add native-image-agent option
//        Xpp3Dom options = dom.getChild("options");
//        if (options == null) {
//            Xpp3Dom os = new Xpp3Dom("options");
//            Xpp3Dom o = new Xpp3Dom("option");
//            o.setValue(AGENTLIB_NATIVE_IMAGE_AGENT_STRING);
//            os.addChild(o);
//            dom.addChild(os);
//        } else {
//            Stream.of(options.getChildren())
//                    .filter(i -> i.getValue() != null && i.getValue().contains("native-image-agent"))
//                    .findFirst()
//                    .ifPresentOrElse(i ->
//                                    i.setValue(AGENTLIB_NATIVE_IMAGE_AGENT_STRING),
//                            () -> {
//                                Xpp3Dom o = new Xpp3Dom("option");
//                                o.setValue(AGENTLIB_NATIVE_IMAGE_AGENT_STRING);
//                                options.addChild(o);
//                            });
//        }
        return config;
    }

    private void createFilterFile() throws IOException {
        File agentDirFilter = new File(agentFilter);
        if (agentDirFilter.exists()) {
            agentDirFilter.delete();
        }
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(agentDirFilter)))) {
            bw.write("{ \"rules\": [\n");
            boolean ruleHasBeenWritten = false;
            for (String rule : Constants.AGENTLIB_EXCLUSION_RULES) {
                if (ruleHasBeenWritten) {
                    bw.write(",\n");
                } else {
                    ruleHasBeenWritten = true;
                }
                bw.write("    {\"excludeClasses\" : \"" + rule + "\"}");
            }
            bw.write("\n  ]\n");
            bw.write("}\n");
        }
    }
}

