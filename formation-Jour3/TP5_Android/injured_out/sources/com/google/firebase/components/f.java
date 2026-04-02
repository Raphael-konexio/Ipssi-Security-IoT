package com.google.firebase.components;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class f<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f1973a;

    /* renamed from: b  reason: collision with root package name */
    private final c<T> f1974b;

    /* loaded from: classes.dex */
    private static class b implements c<Context> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<? extends Service> f1975a;

        private b(Class<? extends Service> cls) {
            this.f1975a = cls;
        }

        private Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.f1975a), 128);
                if (serviceInfo == null) {
                    Log.w("ComponentDiscovery", this.f1975a + " has no service info.");
                    return null;
                }
                return serviceInfo.metaData;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        @Override // com.google.firebase.components.f.c
        /* renamed from: c */
        public List<String> a(Context context) {
            Bundle b2 = b(context);
            if (b2 == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : b2.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(b2.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    interface c<T> {
        List<String> a(T t);
    }

    f(T t, c<T> cVar) {
        this.f1973a = t;
        this.f1974b = cVar;
    }

    public static f<Context> b(Context context, Class<? extends Service> cls) {
        return new f<>(context, new b(cls));
    }

    private static List<h> c(List<String> list) {
        String format;
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            try {
                Class<?> cls = Class.forName(str);
                if (h.class.isAssignableFrom(cls)) {
                    arrayList.add((h) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } else {
                    Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", str, "com.google.firebase.components.ComponentRegistrar"));
                }
            } catch (ClassNotFoundException e) {
                e = e;
                format = String.format("Class %s is not an found.", str);
                Log.w("ComponentDiscovery", format, e);
            } catch (IllegalAccessException e2) {
                e = e2;
                format = String.format("Could not instantiate %s.", str);
                Log.w("ComponentDiscovery", format, e);
            } catch (InstantiationException e3) {
                e = e3;
                format = String.format("Could not instantiate %s.", str);
                Log.w("ComponentDiscovery", format, e);
            } catch (NoSuchMethodException e4) {
                e = e4;
                format = String.format("Could not instantiate %s", str);
                Log.w("ComponentDiscovery", format, e);
            } catch (InvocationTargetException e5) {
                e = e5;
                format = String.format("Could not instantiate %s", str);
                Log.w("ComponentDiscovery", format, e);
            }
        }
        return arrayList;
    }

    public List<h> a() {
        return c(this.f1974b.a(this.f1973a));
    }
}
