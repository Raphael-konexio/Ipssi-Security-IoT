package b.c.a.a.c;

import android.os.IBinder;
import b.c.a.a.c.a;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public final class b<T> extends a.AbstractBinderC0057a {

    /* renamed from: a  reason: collision with root package name */
    private final T f1238a;

    private b(T t) {
        this.f1238a = t;
    }

    public static <T> T g(a aVar) {
        if (aVar instanceof b) {
            return ((b) aVar).f1238a;
        }
        IBinder asBinder = aVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            int length = declaredFields.length;
            StringBuilder sb = new StringBuilder(64);
            sb.append("Unexpected number of IObjectWrapper declared fields: ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        } else if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        } else {
            field.setAccessible(true);
            try {
                return (T) field.get(asBinder);
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
            } catch (NullPointerException e2) {
                throw new IllegalArgumentException("Binder object is null.", e2);
            }
        }
    }

    public static <T> a h(T t) {
        return new b(t);
    }
}
