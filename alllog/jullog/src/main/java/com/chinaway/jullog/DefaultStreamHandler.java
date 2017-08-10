package com.chinaway.jullog;

import java.io.OutputStream;
import java.util.logging.StreamHandler;


public class DefaultStreamHandler extends StreamHandler {

    @Override
    public synchronized void setOutputStream(OutputStream out) throws SecurityException {
        super.setOutputStream(out);
    }
}