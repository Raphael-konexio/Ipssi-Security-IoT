package a.l.a;

import androidx.lifecycle.j;
import androidx.lifecycle.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public abstract class a {
    public static <T extends j & w> a b(T t) {
        return new b(t, t.f());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void c();
}
