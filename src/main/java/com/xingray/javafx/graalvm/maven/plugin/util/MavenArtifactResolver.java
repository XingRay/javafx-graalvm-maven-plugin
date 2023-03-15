package com.xingray.javafx.graalvm.maven.plugin.util;


import org.apache.maven.artifact.Artifact;

import java.util.List;
import java.util.Set;


public class MavenArtifactResolver {

//    private static final String DEFAULT_LOCAL_REPO = org.apache.maven.repository.RepositorySystem.
//            defaultUserLocalRepository.getAbsolutePath();
//
//    private final RepositorySystem repositorySystem;
//    private final List<RemoteRepository> remoteRepositories;
//    private final RepositorySystemSession systemSession;

    private static MavenArtifactResolver instance;

    /**
     * Returns an existing instance of MavenArtifactResolver.
     * <p>
     * If the instance hasn't been created yet, it will throw an
     * {@code IllegalStateException}. To prevent this,
     * {@link #initRepositories(List)} has to be called first.
     *
     * @return an instance of MavenArtifactResolver
     */
    public static MavenArtifactResolver getInstance() {
        if (instance == null) {
            throw new IllegalStateException("MavenArtifactResolver not initialized");
        }
        return instance;
    }

//    private MavenArtifactResolver(List<Repository> repositories) {
//        repositorySystem = createRepositorySystem();
//        systemSession = createRepositorySystemSession(repositorySystem, DEFAULT_LOCAL_REPO);
//        remoteRepositories = new LinkedList<>();
//        repositories.forEach(r -> {
//            org.apache.maven.model.RepositoryPolicy releases = r.getReleases();
//            RepositoryPolicy releasesRepositoryPolicy = null;
//            if (releases != null) {
//                releasesRepositoryPolicy = new RepositoryPolicy(releases.isEnabled(),
//                        releases.getUpdatePolicy() == null ? UPDATE_POLICY_NEVER : releases.getUpdatePolicy(),
//                        releases.getChecksumPolicy());
//            }
//            RepositoryPolicy snapshotsRepositoryPolicy = null;
//            org.apache.maven.model.RepositoryPolicy snapshots = r.getSnapshots();
//            if (snapshots != null) {
//                snapshotsRepositoryPolicy = new RepositoryPolicy(snapshots.isEnabled(),
//                        snapshots.getUpdatePolicy() == null ? UPDATE_POLICY_NEVER : snapshots.getUpdatePolicy(),
//                        snapshots.getChecksumPolicy());
//            }
//            if (releasesRepositoryPolicy == null && snapshotsRepositoryPolicy == null) {
//                if (r.getUrl().toLowerCase(Locale.ROOT).contains("/release")) {
//                    releasesRepositoryPolicy = new RepositoryPolicy(true, UPDATE_POLICY_DAILY, CHECKSUM_POLICY_WARN);
//                    snapshotsRepositoryPolicy = new RepositoryPolicy(false, UPDATE_POLICY_DAILY, CHECKSUM_POLICY_WARN);
//                } else if (r.getUrl().toLowerCase(Locale.ROOT).contains("/snapshot")) {
//                    releasesRepositoryPolicy = new RepositoryPolicy(false, UPDATE_POLICY_DAILY, CHECKSUM_POLICY_WARN);
//                    snapshotsRepositoryPolicy = new RepositoryPolicy(true, UPDATE_POLICY_DAILY, CHECKSUM_POLICY_WARN);
//                }
//            }
//
//            RemoteRepository repository = new RemoteRepository
//                .Builder(r.getId(), "default", r.getUrl())
//                    .setReleasePolicy(releasesRepositoryPolicy)
//                    .setSnapshotPolicy(snapshotsRepositoryPolicy)
//                    .build();
//            remoteRepositories.add(repository);
//        });
//    }

    /**
     * Creates and initializes a new instance with a list of remote
     * repositories, only if such instance doesn't already exist
     *
     * @param repositories a list of remote repositories
     */
//    public static void initRepositories(List<Repository> repositories) {
//        if (instance != null) {
//            return;
//        }
//        instance = new MavenArtifactResolver(repositories);
//    }

//    public static DefaultServiceLocator newServiceLocator()
//    {
//        DefaultServiceLocator locator = new DefaultServiceLocator();
//        locator.addService( ArtifactDescriptorReader.class, DefaultArtifactDescriptorReader.class );
//        locator.addService( VersionResolver.class, DefaultVersionResolver.class );
//        locator.addService( VersionRangeResolver.class, DefaultVersionRangeResolver.class );
//        locator.addService( MetadataGeneratorFactory.class, SnapshotMetadataGeneratorFactory.class );
//        locator.addService( MetadataGeneratorFactory.class, VersionsMetadataGeneratorFactory.class );
//        return locator;
//    }

//    private RepositorySystem createRepositorySystem() {
//        DefaultServiceLocator serviceLocator = newServiceLocator();
//        serviceLocator.addService(RepositoryConnectorFactory.class, BasicRepositoryConnectorFactory.class);
//        serviceLocator.addService(TransporterFactory.class, FileTransporterFactory.class);
//        serviceLocator.addService(TransporterFactory.class, HttpTransporterFactory.class);
//        serviceLocator.setErrorHandler(new DefaultServiceLocator.ErrorHandler() {
//            @Override
//            public void serviceCreationFailed(Class<?> type, Class<?> impl, Throwable exception) {
//                throw new RuntimeException(exception);
//            }
//        });
//        return serviceLocator.getService(RepositorySystem.class);
//    }
//
//    private DefaultRepositorySystemSession createRepositorySystemSession(RepositorySystem system, String localRepoPath) {
//        DefaultRepositorySystemSession systemSession = MavenRepositorySystemUtils.newSession();
//        LocalRepository localRepo = new LocalRepository(localRepoPath);
//        systemSession.setLocalRepositoryManager(system.newLocalRepositoryManager(systemSession, localRepo));
//        return systemSession;
//    }
//
//    /**
//     * Finds a set of existing artifacts for a created artifact out of on some coordinates and
//     * classifier
//     *
//     * @param artifact the created artifact
//     * @return a set of existing artifacts
//     */
    public Set<org.apache.maven.artifact.Artifact> resolve(Artifact artifact) {
//        return resolve(artifact, null);
        return null;
    }

    /**
     * Finds a set of existing artifacts for a created artifact out of on some coordinates and
     * classifier
     *
     * @param artifact the created artifact
     * @param exclusionsFilter a filter that identifies artifacts that will be excluded, it can be null
     * @return a set of existing artifacts
     */
//    public Set<Artifact> resolve(Artifact artifact, Object /*DependencyFilter*/ exclusionsFilter) {
//        ArtifactResult resolvedArtifact;
//        try {
//            List<ArtifactRequest> artifactRequests = Arrays.asList(
//                    new ArtifactRequest(new DefaultArtifact(artifact.getGroupId(), artifact.getArtifactId(),
//                            artifact.getClassifier() != null ? artifact.getClassifier() : "",
//                            artifact.getExtension(), artifact.getVersion()),
//                    remoteRepositories, JavaScopes.RUNTIME));
//            List<ArtifactResult> results = repositorySystem.resolveArtifacts(systemSession, artifactRequests);
//            resolvedArtifact = results.get(results.size() - 1);
//        } catch (ArtifactResolutionException e) {
//            Logger.getLogger(MavenArtifactResolver.class.getName()).log(Level.SEVERE, "Error resolving artifact: " + e.getMessage());
//            return null;
//        }
//
//        CollectRequest collectRequest = new CollectRequest();
//        collectRequest.setRoot(new Dependency(resolvedArtifact.getArtifact(), JavaScopes.COMPILE));
//        collectRequest.setRepositories(remoteRepositories);
//
//        DependencyFilter classpathFilter;
//        if (exclusionsFilter != null) {
//            classpathFilter = DependencyFilterUtils.andFilter(
//                    DependencyFilterUtils.classpathFilter(JavaScopes.COMPILE),
//                    DependencyFilterUtils.notFilter(exclusionsFilter));
//        } else {
//            classpathFilter = DependencyFilterUtils.classpathFilter(JavaScopes.COMPILE);
//        }
//        DependencyRequest dependencyRequest = new DependencyRequest(collectRequest, classpathFilter);
//
//        List<ArtifactResult> artifactResults;
//        try {
//            artifactResults = repositorySystem.resolveDependencies(systemSession, dependencyRequest)
//                    .getArtifactResults();
//        } catch (DependencyResolutionException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//        return artifactResults.stream()
//                .map(ArtifactResult::getArtifact)
//                .map(a -> {
//                    org.apache.maven.artifact.Artifact ar = new org.apache.maven.artifact.DefaultArtifact(
//                            a.getGroupId(), a.getArtifactId(), a.getVersion(),
//                            "compile", "jar", a.getClassifier(), new DefaultArtifactHandler("jar"));
//                    ar.setFile(a.getFile());
//                    return ar;
//                })
//                .collect(Collectors.toSet());
//    }

}