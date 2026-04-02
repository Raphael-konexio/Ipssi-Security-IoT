package io.flutter.embedding.engine.g;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import org.json.JSONArray;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
final class a {

    /* renamed from: a  reason: collision with root package name */
    static final String f2493a = c.class.getName() + ".aot-shared-library-name";

    /* renamed from: b  reason: collision with root package name */
    static final String f2494b = c.class.getName() + ".vm-snapshot-data";

    /* renamed from: c  reason: collision with root package name */
    static final String f2495c = c.class.getName() + ".isolate-snapshot-data";

    /* renamed from: d  reason: collision with root package name */
    static final String f2496d = c.class.getName() + ".flutter-assets-dir";

    private static ApplicationInfo a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String b(ApplicationInfo applicationInfo, Context context) {
        int i;
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null && (i = bundle.getInt("io.flutter.network-policy", 0)) > 0) {
            JSONArray jSONArray = new JSONArray();
            try {
                XmlResourceParser xml = context.getResources().getXml(i);
                xml.next();
                for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                    if (eventType == 2) {
                        if (xml.getName().equals("domain-config")) {
                            f(xml, jSONArray, false);
                        }
                    }
                }
                return jSONArray.toString();
            } catch (IOException | XmlPullParserException unused) {
                return null;
            }
        }
        return null;
    }

    private static String c(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str, null);
    }

    public static b d(Context context) {
        ApplicationInfo a2 = a(context);
        return new b(c(a2.metaData, f2493a), c(a2.metaData, f2494b), c(a2.metaData, f2495c), c(a2.metaData, f2496d), b(a2, context), a2.nativeLibraryDir, Build.VERSION.SDK_INT >= 23 ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() : true);
    }

    private static void e(XmlResourceParser xmlResourceParser, JSONArray jSONArray, boolean z) {
        boolean attributeBooleanValue = xmlResourceParser.getAttributeBooleanValue(null, "includeSubdomains", false);
        xmlResourceParser.next();
        if (xmlResourceParser.getEventType() != 4) {
            throw new IllegalStateException("Expected text");
        }
        String trim = xmlResourceParser.getText().trim();
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(trim);
        jSONArray2.put(attributeBooleanValue);
        jSONArray2.put(z);
        jSONArray.put(jSONArray2);
        xmlResourceParser.next();
        if (xmlResourceParser.getEventType() != 3) {
            throw new IllegalStateException("Expected end of domain tag");
        }
    }

    private static void f(XmlResourceParser xmlResourceParser, JSONArray jSONArray, boolean z) {
        boolean attributeBooleanValue = xmlResourceParser.getAttributeBooleanValue(null, "cleartextTrafficPermitted", z);
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 2) {
                if (xmlResourceParser.getName().equals("domain")) {
                    e(xmlResourceParser, jSONArray, attributeBooleanValue);
                } else if (xmlResourceParser.getName().equals("domain-config")) {
                    f(xmlResourceParser, jSONArray, attributeBooleanValue);
                } else {
                    g(xmlResourceParser);
                }
            } else if (next == 3) {
                return;
            }
        }
    }

    private static void g(XmlResourceParser xmlResourceParser) {
        String name = xmlResourceParser.getName();
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            if (eventType == 3 && xmlResourceParser.getName() == name) {
                return;
            }
            eventType = xmlResourceParser.next();
        }
    }
}
