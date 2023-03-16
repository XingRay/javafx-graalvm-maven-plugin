package com.xingray.javafx.graalvm.maven.plugin;

import com.xingray.javafx.graalvm.maven.plugin.configuration.*;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

public abstract class NativeBaseMojo extends AbstractMojo {

    @Parameter(name = "common")
    private CommonConfiguration common;

    @Parameter(name = "common")
    private WindowsConfiguration windows;
    @Parameter(name = "common")
    private LinuxConfiguration linux;

    @Parameter(name = "common")
    private MacosConfiguration macos;

    @Parameter(name = "common")
    private WebConfiguration web;

    @Parameter(name = "common")
    private AndroidConfiguration android;

    @Parameter(name = "common")
    private IosConfiguration ios;

    @Parameter(defaultValue = "${project}", readonly = true)
//    MavenProject project;
    private String project;

    @Parameter(readonly = true, required = true, defaultValue = "${basedir}/pom.xml")
    private String pom;

    //    @Parameter(defaultValue = "${session}", readonly = true)
//    MavenSession session;
    private String session;

    //    @Component
//    BuildPluginManager pluginManager;
    private String pluginManager;

    /**
     * The execution ID as defined in the POM.
     */
//    @Parameter(defaultValue = "${mojoExecution}", readonly = true)
//    private MojoExecution execution;

    @Parameter(readonly = true, required = true, defaultValue = "${basedir}")
    File basedir;

    @Parameter(readonly = true, required = true, defaultValue = "${basedir}/runPom.xml")
    String runPom;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info(getClass().getName() + "execute()");
        getLog().debug(getClass().getName() + "execute()"
                + "\n");

    }

    @Override
    public String toString() {
        return "NativeBaseMojo{" +
                "common=" + common +
                ", windows=" + windows +
                ", linux=" + linux +
                ", macos=" + macos +
                ", web=" + web +
                ", android=" + android +
                ", ios=" + ios +
                ", project='" + project + '\'' +
                ", pom='" + pom + '\'' +
                ", session='" + session + '\'' +
                ", pluginManager='" + pluginManager + '\'' +
                ", basedir=" + basedir +
                ", runPom='" + runPom + '\'' +
                '}';
    }
}
