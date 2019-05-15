package com.qianlq.eurekacustomer.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author qianliqing
 * @date 2018-06-01 下午10:45
 * mail: qianlq0824@gmail.com
 * <p>
 * 日志工具类
 */

public class LogUtils {

    public static Log errorlog = LogFactory.getLog("error");
    public static Log warnlog = LogFactory.getLog("warn");
    public static Log infolog = LogFactory.getLog("info");
    public static Log debuglog = LogFactory.getLog("debug");

    public LogUtils() {
    }

    public static void error(Object obj) {
        try {
            String location = "";
            StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
            location = stacks[2].getClassName() + "." + stacks[2].getMethodName() + "(" + stacks[2].getLineNumber() + ")";
            if (obj instanceof Exception) {
                Exception e = (Exception) obj;
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw, true));
                String str = sw.toString();
                errorlog.error(location + str);
            } else {
                errorlog.error(location + obj.toString());
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    public static void warn(Object obj) {
        try {
            String location = "";
            StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
            location = stacks[2].getClassName() + "." + stacks[2].getMethodName() + "(" + stacks[2].getLineNumber() + ")";
            if (obj instanceof Exception) {
                Exception e = (Exception) obj;
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw, true));
                String str = sw.toString();
                warnlog.warn(location + str);
            } else {
                warnlog.warn(location + obj.toString());
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    public static void info(Object obj) {
        try {
            String location = "";
            StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
            location = stacks[2].getClassName() + "." + stacks[2].getMethodName() + "(" + stacks[2].getLineNumber() + ")";
            if (obj instanceof Exception) {
                Exception e = (Exception) obj;
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw, true));
                String str = sw.toString();
                infolog.info(location + str);
            } else {
                infolog.info(location + obj.toString());
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    public static void debug(Object obj) {
        try {
            String location = "";
            StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
            location = stacks[2].getClassName() + "." + stacks[2].getMethodName() + "(" + stacks[2].getLineNumber() + ")";
            if (obj instanceof Exception) {
                Exception e = (Exception) obj;
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw, true));
                String str = sw.toString();
                debuglog.debug(location + str);
            } else {
                debuglog.debug(location + obj.toString());
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

    }

    public static String getCodeLocation() {
        try {
            String location = "";
            StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
            location = stacks[2].getClassName() + "." + stacks[2].getMethodName() + "(" + stacks[2].getLineNumber() + ")";
            return location;
        } catch (Exception var2) {
            error(var2);
            return "";
        }
    }
}
