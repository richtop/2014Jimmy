package com.team254.frc2014.auto;

import com.team254.frc2014.AutoMode;
import com.team254.frc2014.AutoModeSelector.Configuration;

/**
 * ConfigurationAutoMode.java
 * ConfigurationAutoMode defines all autonomi which utilize configurations.
 * @author Tom Bottiglieri (tom@team254.com)
 */
public abstract class ConfigurationAutoMode extends AutoMode {

  public ConfigurationAutoMode(String d) {
    super(d);
  }

  protected Configuration config;

  public void setConfiguration(Configuration config) {
    this.config = config;
  }
}