package com.xingray.javafx.graalvm.maven.plugin.compiler;

import com.xingray.graalvm.compiler.common.Platform;
import com.xingray.graalvm.compiler.core.argument.CompileArgument;

import java.util.HashMap;
import java.util.Map;

public class CompileConfigMapper {

    private static final Map<String, Platform> platformMapping = new HashMap<>();

    static {
        platformMapping.put("windows", Platform.WINDOWS);
        platformMapping.put("linux", Platform.WINDOWS);
        platformMapping.put("macos", Platform.WINDOWS);
        platformMapping.put("web", Platform.WINDOWS);
        platformMapping.put("android", Platform.WINDOWS);
        platformMapping.put("ios", Platform.WINDOWS);
    }

    public CompileArgument toGraalvmCompileArgument(CompileConfig compileConfig) throws CompilerException {
        CompileArgument compileArgument = new CompileArgument();

        compileArgument.setGraalvmHome(compileConfig.getGraalvmHome());

        //        outputDir = Path.of(JavafxGraalvmMavenPluginConstants.OUTPUT_DIR);/*Path.of(project.getBuild().getDirectory(), JavafxGraalvmMavenPluginConstants.OUTPUT_DIR);*/
//        ProjectConfiguration substrateConfiguration = createSubstrateConfiguration();
//        return new SubstrateDispatcher(outputDir, substrateConfiguration);

//        compileArgument.setJavaStaticSdkVersion(javaStaticSdkVersion);
//        compileArgument.setJavafxStaticSdkVersion(javafxStaticSdkVersion);
        String platformName = compileConfig.getPlatform();
        Platform platform = platformMapping.get(platformName);
        if (platform == null) {
            throw new CompilerException("unknown platform:" + platformName);
        }

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
        return compileArgument;
    }
}
