package com.xingray.javafx.graalvm.maven.plugin.compiler;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.DefaultArtifact;
import org.apache.maven.model.Dependency;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NativeCompilerImpl {
    //    private ProcessDestroyer processDestroyer;

//    public SubstrateDispatcher createSubstrateDispatcher() throws IOException, MojoExecutionException {
//        if (getGraalvmHome().isEmpty()) {
//            throw new MojoExecutionException("GraalVM installation directory not found." +
//                    " Either set GRAALVM_HOME as an environment variable or" +
//                    " set graalvmHome in " + JavafxGraalvmMavenPluginConstants.PLUGIN_NAME + "-plugin configuration");
//        }
//        outputDir = Path.of(JavafxGraalvmMavenPluginConstants.OUTPUT_DIR);/*Path.of(project.getBuild().getDirectory(), JavafxGraalvmMavenPluginConstants.OUTPUT_DIR);*/
//        ProjectConfiguration substrateConfiguration = createSubstrateConfiguration();
//        return new SubstrateDispatcher(outputDir, substrateConfiguration);
//    }

//    private ProjectConfiguration createSubstrateConfiguration() {
//        ProjectConfiguration clientConfig = new ProjectConfiguration(mainClass, getProjectClasspath());
//
//        clientConfig.setGraalPath(Path.of(getGraalvmHome().get()));
//        clientConfig.setJavaStaticSdkVersion(javaStaticSdkVersion);
//        clientConfig.setJavafxStaticSdkVersion(javafxStaticSdkVersion);
//
//        Triplet targetTriplet;
//        switch (target) {
//            case Constants.PROFILE_HOST:
//                targetTriplet = Triplet.fromCurrentOS();
//                break;
//            case Constants.PROFILE_IOS:
//                targetTriplet = new Triplet(Constants.Profile.IOS);
//                break;
//            case Constants.PROFILE_IOS_SIM:
//                targetTriplet = new Triplet(Constants.Profile.IOS_SIM);
//                break;
//            case Constants.PROFILE_ANDROID:
//                targetTriplet = new Triplet(Constants.Profile.ANDROID);
//                break;
//            case Constants.PROFILE_LINUX_AARCH64:
//                targetTriplet = new Triplet(Constants.Profile.LINUX_AARCH64);
//                break;
//            case Constants.PROFILE_WEB:
//                targetTriplet = new Triplet(Constants.Profile.WEB);
//                break;
//            default:
//                throw new RuntimeException("No valid target found for " + target);
//        }
//        if (releaseConfiguration != null) {
//            clientConfig.setReleaseConfiguration(releaseConfiguration.toSubstrate());
//        }
//        clientConfig.setTarget(targetTriplet);
//
//        clientConfig.setBundlesList(bundlesList);
//        clientConfig.setResourcesList(resourcesList);
//        clientConfig.setJniList(jniList);
//        clientConfig.setCompilerArgs(nativeImageArgs);
//        clientConfig.setLinkerArgs(linkerArgs);
//        clientConfig.setRuntimeArgs(runtimeArgs);
//        clientConfig.setReflectionList(reflectionList);
////        clientConfig.setAppId(appIdentifier != null ? appIdentifier : project.getGroupId() + "." + project.getArtifactId());
////        clientConfig.setAppName(project.getName());
//        clientConfig.setVerbose("true".equals(verbose));
//        clientConfig.setUsePrismSW("true".equals(enableSWRendering));
//        clientConfig.setRemoteHostName(remoteHostName);
//        clientConfig.setRemoteDir(remoteDir);
//
//        return clientConfig;
//    }

//    ProcessDestroyer getProcessDestroyer() {
//        if (processDestroyer == null) {
//            processDestroyer = new ShutdownHookProcessDestroyer();
//        }
//        return processDestroyer;
//    }

//    private String getProjectClasspath() {
//        List<File> classPath = getClasspathElements(project);
//        getLog().debug("classPath = " + classPath);
//        return classPath.stream()
//                .map(File::getAbsolutePath)
//                .collect(Collectors.joining(File.pathSeparator));
//    }

    private List<File> getClasspathElements(/*MavenProject*/String project) {
//        List<Repository> repositories = project.getRepositories();
//        Repository gluonRepository = new Repository();
//        gluonRepository.setId("Gluon");
//        gluonRepository.setUrl("https://nexus.gluonhq.com/nexus/content/repositories/releases");
//        repositories.add(gluonRepository);
//        MavenArtifactResolver.initRepositories(repositories);


        List<File> list = new ArrayList<>();
//        List<File> list = project.getArtifacts().stream()
//                .filter(d -> ALLOWED_DEPENDENCY_TYPES.stream().anyMatch(t -> t.equals(d.getType())))
//                .sorted((a1, a2) -> {
//                    int compare = a1.compareTo(a2);
//                    if (compare == 0) {
//                        // give precedence to classifiers
//                        return a1.hasClassifier() ? 1 : (a2.hasClassifier() ? -1 : 0);
//                    }
//                    return compare;
//                })
//                .map(new Function<Artifact, File>() {
//                    @Override
//                    public File apply(Artifact artifact) {
//                        return null;
//                    }
//                })
//                .collect(Collectors.toList());
//        list.add(0, new File(project.getBuild().getOutputDirectory()));
//
//        // include runtime dependencies
//        getRuntimeDependencies().stream()
//                .filter(d -> !list.contains(d))
//                .forEach(list::add);
//
//        // remove provided dependencies
//        getProvidedDependencies().stream()
//                .filter(list::contains)
//                .forEach(list::remove);

        // WEB
//        if (Constants.PROFILE_WEB.equals(target)) {
//            project.getArtifacts().stream()
//                    .filter(artifact -> "org.openjfx".equals(artifact.getGroupId()) && artifact.getClassifier() != null)
//                    .map(a -> {
//                        return new org.apache.maven.artifact.DefaultArtifact(a.getGroupId(), a.getArtifactId(),
//                                Constants.WEB_AOT_CLASSIFIER, "jar", Constants.DEFAULT_JAVAFX_JS_SDK_VERSION);
//                    })
//                    .flatMap(artifact -> {
//                        DependencyFilter exclusions = (node, parents) ->
//                                !node.getArtifact().getClassifier().equals(Constants.WEB_AOT_CLASSIFIER);
//                        Set<Artifact> resolve = MavenArtifactResolver.getInstance().resolve(artifact, exclusions);
//                        if (resolve == null) {
//                            return Stream.empty();
//                        }
//                        return resolve.stream();
//                        return Stream.empty();
//                    })
//                    .distinct()
//                    .map(Artifact::getFile)
//                    .forEach(list::add);

//            WebTargetConfiguration.WEB_AOT_DEPENDENCIES.stream()
//                    .map(s -> s.split(":"))
//                    .map(a -> new DefaultArtifact(a[0], a[1],
//                            a.length == 4 ? a[3] : null, "jar", a[2]))
//                    .flatMap(a -> {
//                        Set<Artifact> resolve = MavenArtifactResolver.getInstance().resolve(a);
//                        if (resolve == null) {
//                            return Stream.empty();
//                        }
//                        return resolve.stream();
//                    })
//                    .distinct()
//                    .map(Artifact::getFile)
//                    .forEach(list::add);
//        }
        return list;
    }

    private List<File> getRuntimeDependencies() {
        return getDependencies("runtime");
    }

    private List<File> getProvidedDependencies() {
        return getDependencies("provided");
    }

    private List<File> getDependencies(String scope) {
        return new ArrayList<>();

//        if (scope == null || scope.isEmpty()) {
//            return new ArrayList<>();
//        }
//        return project.getDependencies().stream()
//                .filter(dependency -> ALLOWED_DEPENDENCY_TYPES.stream().anyMatch(t -> t.equals(dependency.getType())))
//                .filter(d -> scope.equals(d.getScope()))
//                .map(NativeBaseMojo::dependencyToArtifact)
//                .flatMap(artifact -> {
//                    Set<Artifact> resolve = MavenArtifactResolver.getInstance().resolve(artifact);
//                    if (resolve == null) {
//                        return Stream.empty();
//                    }
//                    return resolve.stream();
//                })
//                .distinct()
//                .map(Artifact::getFile)
//                .collect(Collectors.toList());
    }

    private static Artifact dependencyToArtifact(Dependency dependency) {
        String groupId = dependency.getGroupId();
        String artifactId = dependency.getArtifactId();
        String version = dependency.getVersion();
        String scope = dependency.getScope();
        String type = dependency.getType();
        String classifier = dependency.getClassifier();
        return new DefaultArtifact(groupId, artifactId, version, scope, type, classifier, null);
    }

//    Optional<String> getGraalvmHome() {
//        return Optional.ofNullable(graalvmHome)
//                .or(() -> Optional.ofNullable(System.getenv("GRAALVM_HOME")));
//    }
}
