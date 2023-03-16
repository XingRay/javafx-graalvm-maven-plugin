package com.xingray.javafx.graalvm.maven.plugin.util;

import com.xingray.javafx.graalvm.maven.plugin.NativeBaseMojo;
import com.xingray.javafx.graalvm.maven.plugin.compiler.CompileConfig;

public class CompilerConfigUtil {

    public static CompileConfig makeCompileConfig(NativeBaseMojo mojo){
        CompileConfig compileConfig = new CompileConfig();

        compileConfig.setGraalvmHome(mojo.getGraalvmHome());

        return compileConfig;
    }
}
