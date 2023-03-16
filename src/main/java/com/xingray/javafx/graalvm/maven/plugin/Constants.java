package com.xingray.javafx.graalvm.maven.plugin;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Constants {
    public static final String PLUGIN_NAME = "javafx-graalvm";
    public static final String OUTPUT_DIR = "javafx-graalvm";

    public static final String GOAL_COMPILE = PLUGIN_NAME + ":compile";
    public static final String GOAL_LINK = PLUGIN_NAME + ":link";
    public static final String GOAL_BUILD = PLUGIN_NAME + ":build";

    private static final List<String> ALLOWED_DEPENDENCY_TYPES = Collections.singletonList("jar");

    public static final String AGENTLIB_NATIVE_IMAGE_AGENT_STRING =
            "-agentlib:native-image-agent=access-filter-file=src/main/resources/META-INF/native-image/filter-file.json,config-merge-dir=src/main/resources/META-INF/native-image";

    public static final List<String> AGENTLIB_EXCLUSION_RULES = Arrays.asList(
            "com.sun.glass.ui.mac.*",
            "com.sun.glass.ui.gtk.*",
            "com.sun.glass.ui.win.*",
            "com.sun.prism.es2.*",
            "com.sun.prism.d3d.*",
            "com.sun.scenario.effect.impl.es2.*",
            "com.sun.scenario.effect.impl.hw.d3d.*"
    );

    public static final String DEFAULT_DESCRIPTION = "Default description";
    public static final String DEFAULT_VENDOR = "Unknown";
    public static final String DEFAULT_VERSION = "1.0";

    public static final String DEFAULT_MAC_APP_CATEGORY = "public.app-category.utilities";
    public static final String DEFAULT_BUNDLE_VERSION = "1.0";
    public static final String DEFAULT_BUNDLE_SHORT_VERSION = "1.0";

    public static final String DEFAULT_VERSION_CODE = "1";
}
