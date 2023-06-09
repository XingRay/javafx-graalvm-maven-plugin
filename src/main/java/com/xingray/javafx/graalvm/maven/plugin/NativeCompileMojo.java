package com.xingray.javafx.graalvm.maven.plugin;

import com.xingray.javafx.graalvm.maven.plugin.compiler.CompileConfig;
import com.xingray.javafx.graalvm.maven.plugin.compiler.CompilerException;
import com.xingray.javafx.graalvm.maven.plugin.compiler.NativeCompiler;
import com.xingray.javafx.graalvm.maven.plugin.compiler.NativeCompilerFactory;
import com.xingray.javafx.graalvm.maven.plugin.util.CompilerConfigUtil;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

@Mojo(name = "compile", defaultPhase = LifecyclePhase.COMPILE,
        requiresDependencyResolution = ResolutionScope.COMPILE_PLUS_RUNTIME)
@Execute(phase = LifecyclePhase.PROCESS_CLASSES)
public class NativeCompileMojo extends NativeBaseMojo {

    @Override
    public void execute() throws MojoExecutionException {
        CompileConfig compileConfig = CompilerConfigUtil.makeCompileConfig(this);
        try {
            NativeCompiler compiler = new NativeCompilerFactory().createNativeCompiler(compileConfig);
            int resultValue = compiler.executeCompile();
            if (resultValue != 0) {
                throw new MojoExecutionException("Compiling failed, resultValue:" + resultValue);
            }
        } catch (CompilerException e) {
            throw new MojoExecutionException(e);
        }
    }
}
