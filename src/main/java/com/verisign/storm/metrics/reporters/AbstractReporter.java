package com.verisign.storm.metrics.reporters;

import com.verisign.storm.metrics.graphite.GraphiteConnectionFailureException;

import java.io.IOException;
import java.util.Map;

public abstract class AbstractReporter {

  public AbstractReporter(Map<String, Object> conf) {
  }

  public abstract void connect() throws GraphiteConnectionFailureException;

  public abstract void disconnect() throws GraphiteConnectionFailureException;

  public abstract void appendToBuffer(String prefix, Map<String, Object> metrics, long timestamp);

  public abstract void emptyBuffer();

  public abstract void sendBufferContents() throws IOException;

  public abstract int getFailures();

  public abstract String getServerFingerprint();

}