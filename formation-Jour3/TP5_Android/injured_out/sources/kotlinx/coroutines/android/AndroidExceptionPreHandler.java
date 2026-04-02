package kotlinx.coroutines.android;

import android.os.Build;
import androidx.annotation.Keep;
import d.g;
import d.p.a;
import d.p.d;
import d.s.d.k;
import d.s.d.m;
import d.u.e;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlinx.coroutines.CoroutineExceptionHandler;
@Keep
/* loaded from: classes.dex */
public final class AndroidExceptionPreHandler extends a implements CoroutineExceptionHandler, d.s.c.a<Method> {
    static final /* synthetic */ e[] $$delegatedProperties;
    private final d.e preHandler$delegate;

    static {
        k kVar = new k(m.a(AndroidExceptionPreHandler.class), "preHandler", "getPreHandler()Ljava/lang/reflect/Method;");
        m.c(kVar);
        $$delegatedProperties = new e[]{kVar};
    }

    public AndroidExceptionPreHandler() {
        super(CoroutineExceptionHandler.f2695d);
        d.e a2;
        a2 = g.a(this);
        this.preHandler$delegate = a2;
    }

    private final Method getPreHandler() {
        d.e eVar = this.preHandler$delegate;
        e eVar2 = $$delegatedProperties[0];
        return (Method) eVar.getValue();
    }

    public void handleException(d dVar, Throwable th) {
        d.s.d.g.f(dVar, "context");
        d.s.d.g.f(th, "exception");
        Thread currentThread = Thread.currentThread();
        if (Build.VERSION.SDK_INT >= 28) {
            d.s.d.g.b(currentThread, "thread");
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
            return;
        }
        Method preHandler = getPreHandler();
        Object invoke = preHandler != null ? preHandler.invoke(null, new Object[0]) : null;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = invoke instanceof Thread.UncaughtExceptionHandler ? invoke : null;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(currentThread, th);
        }
    }

    @Override // d.s.c.a
    public Method invoke() {
        try {
            boolean z = false;
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            d.s.d.g.b(declaredMethod, "it");
            if (Modifier.isPublic(declaredMethod.getModifiers())) {
                if (Modifier.isStatic(declaredMethod.getModifiers())) {
                    z = true;
                }
            }
            if (z) {
                return declaredMethod;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
