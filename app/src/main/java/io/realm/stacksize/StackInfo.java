package io.realm.stacksize;

/**
 * Created by cc on 8/21/15.
 */
public class StackInfo {
    public static native long getStackSize();
    public static native long getCurStackSS();
    public static native long getSignalStackSize();
    public static native long getSignalStackSP();
}
