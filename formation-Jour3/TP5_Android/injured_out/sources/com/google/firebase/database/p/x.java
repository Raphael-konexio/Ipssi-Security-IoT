package com.google.firebase.database.p;

import java.lang.Thread;
/* loaded from: classes.dex */
public interface x {

    /* renamed from: a  reason: collision with root package name */
    public static final x f2339a = new a();

    /* loaded from: classes.dex */
    class a implements x {
        a() {
        }

        @Override // com.google.firebase.database.p.x
        public void a(Thread thread, String str) {
            thread.setName(str);
        }

        @Override // com.google.firebase.database.p.x
        public void b(Thread thread, boolean z) {
            thread.setDaemon(z);
        }

        @Override // com.google.firebase.database.p.x
        public void c(Thread thread, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    }

    void a(Thread thread, String str);

    void b(Thread thread, boolean z);

    void c(Thread thread, Thread.UncaughtExceptionHandler uncaughtExceptionHandler);
}
