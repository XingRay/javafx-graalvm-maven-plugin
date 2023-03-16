package com.xingray.javafx.graalvm.maven.plugin.compiler;

import com.xingray.graalvm.compiler.core.GraalvmCompiler;
import com.xingray.graalvm.compiler.core.argument.CompileArgument;

public class NativeCompilerFactory {
    public NativeCompiler createNativeCompiler(CompileConfig compileConfig) throws CompilerException {
        // use graalvm compiler only.
        return createGraalvmCompiler(compileConfig);
    }

    private NativeCompiler createGraalvmCompiler(CompileConfig compileConfig) throws CompilerException {
        CompileArgument compileArgument = new CompileConfigMapper().toGraalvmCompileArgument(compileConfig);
        GraalvmCompiler graalvmCompiler = new GraalvmCompiler(compileArgument);
        return new NativeCompiler() {

            @Override
            public int prepare() throws CompilerException {
                try {
                    return graalvmCompiler.prepare();
                } catch (com.xingray.graalvm.compiler.common.CompilerException e) {
                    e.printStackTrace();
                    throw new CompilerException(e);
                }
            }

            @Override
            public int executeCompile() throws CompilerException {
                try {
                    return graalvmCompiler.executeCompile();
                } catch (com.xingray.graalvm.compiler.common.CompilerException e) {
                    e.printStackTrace();
                    throw new CompilerException(e);
                }
            }

            @Override
            public int executeLink() throws CompilerException {
                try {
                    return graalvmCompiler.executeLink();
                } catch (com.xingray.graalvm.compiler.common.CompilerException e) {
                    e.printStackTrace();
                    throw new CompilerException(e);
                }
            }

            @Override
            public int executePackage() throws CompilerException {
                try {
                    return graalvmCompiler.executePackage();
                } catch (com.xingray.graalvm.compiler.common.CompilerException e) {
                    e.printStackTrace();
                    throw new CompilerException(e);
                }
            }

            @Override
            public int executeInstall() throws CompilerException {
                try {
                    return graalvmCompiler.executeInstall();
                } catch (com.xingray.graalvm.compiler.common.CompilerException e) {
                    e.printStackTrace();
                    throw new CompilerException(e);
                }
            }

            @Override
            public int executeRun() throws CompilerException {
                try {
                    return graalvmCompiler.executeRun();
                } catch (com.xingray.graalvm.compiler.common.CompilerException e) {
                    e.printStackTrace();
                    throw new CompilerException(e);
                }
            }
        };
    }

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
}
