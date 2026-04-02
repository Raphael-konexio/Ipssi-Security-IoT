package io.flutter.embedding.engine.h.h;

import c.a.b;
/* loaded from: classes.dex */
public class a {
    public static void a(io.flutter.embedding.engine.a aVar) {
        try {
            Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", io.flutter.embedding.engine.a.class).invoke(null, aVar);
        } catch (Exception unused) {
            b.e("GeneratedPluginsRegister", "Tried to automatically register plugins with FlutterEngine (" + aVar + ") but could not find and invoke the GeneratedPluginRegistrant.");
        }
    }
}
