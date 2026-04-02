package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public final class DynamiteModule {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f1654a;

    /* renamed from: b  reason: collision with root package name */
    private static c f1655b;

    /* renamed from: c  reason: collision with root package name */
    private static String f1656c;

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<b> f1657d = new ThreadLocal<>();

    @DynamiteApi
    /* loaded from: classes.dex */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* loaded from: classes.dex */
    public static class a extends Exception {
        private a(String str) {
            super(str);
        }

        /* synthetic */ a(String str, com.google.android.gms.dynamite.a aVar) {
            this(str);
        }

        private a(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ a(String str, Throwable th, com.google.android.gms.dynamite.a aVar) {
            this(str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Cursor f1658a;

        private b() {
        }
    }

    public static int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            String valueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e) {
            String valueOf2 = String.valueOf(e.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static int b(Context context, String str) {
        return c(context, str, false);
    }

    public static int c(Context context, String str, boolean z) {
        Class<?> loadClass;
        Field declaredField;
        Boolean bool;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool2 = f1654a;
                if (bool2 == null) {
                    try {
                        loadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                        declaredField = loadClass.getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
                        String valueOf = String.valueOf(e);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(valueOf);
                        Log.w("DynamiteModule", sb.toString());
                        bool2 = Boolean.FALSE;
                    }
                    synchronized (loadClass) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader != null) {
                            if (classLoader != ClassLoader.getSystemClassLoader()) {
                                try {
                                    d(classLoader);
                                } catch (a unused) {
                                }
                                bool = Boolean.TRUE;
                                bool2 = bool;
                                f1654a = bool2;
                            }
                        } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                        } else {
                            try {
                                int f = f(context, str, z);
                                if (f1656c != null && !f1656c.isEmpty()) {
                                    com.google.android.gms.dynamite.b bVar = new com.google.android.gms.dynamite.b(f1656c, ClassLoader.getSystemClassLoader());
                                    d(bVar);
                                    declaredField.set(null, bVar);
                                    f1654a = Boolean.TRUE;
                                    return f;
                                }
                                return f;
                            } catch (a unused2) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                            }
                        }
                        bool = Boolean.FALSE;
                        bool2 = bool;
                        f1654a = bool2;
                    }
                }
                if (bool2.booleanValue()) {
                    try {
                        return f(context, str, z);
                    } catch (a e2) {
                        String valueOf2 = String.valueOf(e2.getMessage());
                        Log.w("DynamiteModule", valueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf2) : new String("Failed to retrieve remote module version: "));
                        return 0;
                    }
                }
                return e(context, str, z);
            }
        } catch (Throwable th) {
            com.google.android.gms.common.util.e.a(context, th);
            throw th;
        }
    }

    private static void d(ClassLoader classLoader) {
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                return;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
            if (queryLocalInterface instanceof e) {
                e eVar = (e) queryLocalInterface;
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new a("Failed to instantiate dynamite loader", e, null);
        }
    }

    private static int e(Context context, String str, boolean z) {
        c g = g(context);
        if (g == null) {
            return 0;
        }
        try {
            if (g.O() >= 2) {
                return g.j(b.c.a.a.c.b.h(context), str, z);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return g.y(b.c.a.a.c.b.h(context), str, z);
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int f(android.content.Context r8, java.lang.String r9, boolean r10) {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            if (r10 == 0) goto La
            java.lang.String r8 = "api_force_staging"
            goto Lc
        La:
            java.lang.String r8 = "api"
        Lc:
            int r10 = r8.length()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            int r10 = r10 + 42
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            int r2 = r2.length()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            int r10 = r10 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            r2.<init>(r10)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.lang.String r10 = "content://com.google.android.gms.chimera/"
            r2.append(r10)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            r2.append(r8)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.lang.String r8 = "/"
            r2.append(r8)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            r2.append(r9)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            android.net.Uri r2 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> L9a
            if (r8 == 0) goto L80
            boolean r9 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L93
            if (r9 == 0) goto L80
            r9 = 0
            int r9 = r8.getInt(r9)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L93
            if (r9 <= 0) goto L79
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r10 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L93
            r1 = 2
            java.lang.String r1 = r8.getString(r1)     // Catch: java.lang.Throwable -> L76
            com.google.android.gms.dynamite.DynamiteModule.f1656c = r1     // Catch: java.lang.Throwable -> L76
            java.lang.String r1 = "loaderVersion"
            int r1 = r8.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L76
            if (r1 < 0) goto L64
            r8.getInt(r1)     // Catch: java.lang.Throwable -> L76
        L64:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L76
            java.lang.ThreadLocal<com.google.android.gms.dynamite.DynamiteModule$b> r10 = com.google.android.gms.dynamite.DynamiteModule.f1657d     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L93
            java.lang.Object r10 = r10.get()     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L93
            com.google.android.gms.dynamite.DynamiteModule$b r10 = (com.google.android.gms.dynamite.DynamiteModule.b) r10     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L93
            if (r10 == 0) goto L79
            android.database.Cursor r1 = r10.f1658a     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L93
            if (r1 != 0) goto L79
            r10.f1658a = r8     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L93
            goto L7a
        L76:
            r9 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L76
            throw r9     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L93
        L79:
            r0 = r8
        L7a:
            if (r0 == 0) goto L7f
            r0.close()
        L7f:
            return r9
        L80:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L93
            com.google.android.gms.dynamite.DynamiteModule$a r9 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L93
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>(r10, r0)     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L93
            throw r9     // Catch: java.lang.Throwable -> L8f java.lang.Exception -> L93
        L8f:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto Lab
        L93:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L9c
        L98:
            r8 = move-exception
            goto Lab
        L9a:
            r8 = move-exception
            r9 = r0
        L9c:
            boolean r10 = r8 instanceof com.google.android.gms.dynamite.DynamiteModule.a     // Catch: java.lang.Throwable -> La9
            if (r10 == 0) goto La1
            throw r8     // Catch: java.lang.Throwable -> La9
        La1:
            com.google.android.gms.dynamite.DynamiteModule$a r10 = new com.google.android.gms.dynamite.DynamiteModule$a     // Catch: java.lang.Throwable -> La9
            java.lang.String r1 = "V2 version check failed"
            r10.<init>(r1, r8, r0)     // Catch: java.lang.Throwable -> La9
            throw r10     // Catch: java.lang.Throwable -> La9
        La9:
            r8 = move-exception
            r0 = r9
        Lab:
            if (r0 == 0) goto Lb0
            r0.close()
        Lb0:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.f(android.content.Context, java.lang.String, boolean):int");
    }

    private static c g(Context context) {
        c dVar;
        synchronized (DynamiteModule.class) {
            if (f1655b != null) {
                return f1655b;
            } else if (b.c.a.a.b.e.e().f(context) != 0) {
                return null;
            } else {
                try {
                    IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                    if (iBinder == null) {
                        dVar = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                        dVar = queryLocalInterface instanceof c ? (c) queryLocalInterface : new d(iBinder);
                    }
                    if (dVar != null) {
                        f1655b = dVar;
                        return dVar;
                    }
                } catch (Exception e) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
                }
                return null;
            }
        }
    }
}
