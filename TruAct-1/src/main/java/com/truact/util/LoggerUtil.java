package com.truact.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    private static final Logger logger = LoggerFactory.getLogger(LoggerUtil.class);

    // Log an info message
    public static void logInfo(String message) {
        logger.info(message);
    }

    // Log a warning message
    public static void logWarning(String message) {
        logger.warn(message);
    }

    // Log an error message
    public static void logError(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    // Log a debug message
    public static void logDebug(String message) {
        logger.debug(message);
    }
}