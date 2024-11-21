package com.kranzilla;

import com.google.cloud.functions.Context;
import com.google.cloud.functions.RawBackgroundFunction;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.control.ActivateRequestContext;
import jakarta.inject.Named;

import java.util.UUID;

import org.jboss.logging.MDC;

import io.quarkus.logging.Log;

@Named("pubSubFunction")
@ApplicationScoped
public class LoggingPubSubFunction implements RawBackgroundFunction {

    @ActivateRequestContext
    @Override
    public void accept(String event, Context context) throws Exception {
        MDC.put("id", UUID.randomUUID().toString());
        Log.info("test log message");
    }
}
