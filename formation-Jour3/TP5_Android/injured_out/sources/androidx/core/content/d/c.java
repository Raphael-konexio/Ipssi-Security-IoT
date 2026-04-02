package androidx.core.content.d;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    public interface a {
    }

    /* loaded from: classes.dex */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final C0041c[] f737a;

        public b(C0041c[] c0041cArr) {
            this.f737a = c0041cArr;
        }

        public C0041c[] a() {
            return this.f737a;
        }
    }

    /* renamed from: androidx.core.content.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0041c {

        /* renamed from: a  reason: collision with root package name */
        private final String f738a;

        /* renamed from: b  reason: collision with root package name */
        private int f739b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f740c;

        /* renamed from: d  reason: collision with root package name */
        private String f741d;
        private int e;
        private int f;

        public C0041c(String str, int i, boolean z, String str2, int i2, int i3) {
            this.f738a = str;
            this.f739b = i;
            this.f740c = z;
            this.f741d = str2;
            this.e = i2;
            this.f = i3;
        }

        public String a() {
            return this.f738a;
        }

        public int b() {
            return this.f;
        }

        public int c() {
            return this.e;
        }

        public String d() {
            return this.f741d;
        }

        public int e() {
            return this.f739b;
        }

        public boolean f() {
            return this.f740c;
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements a {

        /* renamed from: a  reason: collision with root package name */
        private final a.g.h.d f742a;

        /* renamed from: b  reason: collision with root package name */
        private final int f743b;

        /* renamed from: c  reason: collision with root package name */
        private final int f744c;

        /* renamed from: d  reason: collision with root package name */
        private final String f745d;

        public d(a.g.h.d dVar, int i, int i2, String str) {
            this.f742a = dVar;
            this.f744c = i;
            this.f743b = i2;
            this.f745d = str;
        }

        public int a() {
            return this.f744c;
        }

        public a.g.h.d b() {
            return this.f742a;
        }

        public String c() {
            return this.f745d;
        }

        public int d() {
            return this.f743b;
        }
    }

    private static int a(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    public static a b(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> c(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static a d(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static a e(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), a.g.c.FontFamily);
        String string = obtainAttributes.getString(a.g.c.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(a.g.c.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(a.g.c.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(a.g.c.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(a.g.c.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(a.g.c.FontFamily_fontProviderFetchTimeout, 500);
        String string4 = obtainAttributes.getString(a.g.c.FontFamily_fontProviderSystemFontFamily);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new d(new a.g.h.d(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((C0041c[]) arrayList.toArray(new C0041c[arrayList.size()]));
    }

    private static C0041c f(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), a.g.c.FontFamilyFont);
        int i = obtainAttributes.getInt(obtainAttributes.hasValue(a.g.c.FontFamilyFont_fontWeight) ? a.g.c.FontFamilyFont_fontWeight : a.g.c.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(a.g.c.FontFamilyFont_fontStyle) ? a.g.c.FontFamilyFont_fontStyle : a.g.c.FontFamilyFont_android_fontStyle, 0);
        int i2 = obtainAttributes.hasValue(a.g.c.FontFamilyFont_ttcIndex) ? a.g.c.FontFamilyFont_ttcIndex : a.g.c.FontFamilyFont_android_ttcIndex;
        String string = obtainAttributes.getString(obtainAttributes.hasValue(a.g.c.FontFamilyFont_fontVariationSettings) ? a.g.c.FontFamilyFont_fontVariationSettings : a.g.c.FontFamilyFont_android_fontVariationSettings);
        int i3 = obtainAttributes.getInt(i2, 0);
        int i4 = obtainAttributes.hasValue(a.g.c.FontFamilyFont_font) ? a.g.c.FontFamilyFont_font : a.g.c.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i4, 0);
        String string2 = obtainAttributes.getString(i4);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new C0041c(string2, i, z, string, i3, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
