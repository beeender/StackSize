#include <jni.h>

#include <sys/resource.h>
#include <signal.h>

JNIEXPORT jlong JNICALL
Java_io_realm_stacksize_StackInfo_getStackSize(JNIEnv *env, jclass type) {
    struct rlimit rlp;
    getrlimit(RLIMIT_STACK, &rlp);

    return rlp.rlim_cur;
}

JNIEXPORT jlong JNICALL
Java_io_realm_stacksize_StackInfo_getSignalStackSize(JNIEnv *env, jclass type) {
    stack_t ss;
    sigaltstack(NULL, &ss);

    return ss.ss_size;
}

JNIEXPORT jlong JNICALL
Java_io_realm_stacksize_StackInfo_getCurStackSS(JNIEnv *env, jclass type) {
    volatile int i = 0;
    return &i;
}

JNIEXPORT jlong JNICALL
Java_io_realm_stacksize_StackInfo_getSignalStackSP(JNIEnv *env, jclass type) {
    stack_t ss;
    sigaltstack(NULL, &ss);

    return ss.ss_sp;
}