package com.inkbox.core;

import org.aeonbits.owner.Config;

/**
 * This interface provides access to config properties
 */
@Config.Sources("classpath:application.properties")
public interface ProjectConfig extends Config {

    String url();

    String browser();

    Long browserTimeout();
}
