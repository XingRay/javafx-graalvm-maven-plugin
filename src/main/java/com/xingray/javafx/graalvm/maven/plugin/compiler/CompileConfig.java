package com.xingray.javafx.graalvm.maven.plugin.compiler;

public class CompileConfig {
    private String graalvmHome;

    private String platform;


    public String getGraalvmHome() {
        return graalvmHome;
    }

    public void setGraalvmHome(String graalvmHome) {
        this.graalvmHome = graalvmHome;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "CompileConfig{" +
                "graalvmHome='" + graalvmHome + '\'' +
                ", platform='" + platform + '\'' +
                '}';
    }
}
