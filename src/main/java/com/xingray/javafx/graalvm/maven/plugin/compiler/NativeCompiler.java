package com.xingray.javafx.graalvm.maven.plugin.compiler;

public interface NativeCompiler {
    int prepare() throws CompilerException;
    int executeCompile() throws CompilerException;

    int executeLink() throws CompilerException;

    int executePackage() throws CompilerException;

    int executeInstall() throws CompilerException;

    int executeRun() throws CompilerException;
}
