package io.flutter.embedding.engine.i;

import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final c.a.c.a.i f2535a;

    public e(io.flutter.embedding.engine.e.a aVar) {
        this.f2535a = new c.a.c.a.i(aVar, "flutter/localization", c.a.c.a.e.f1489a);
    }

    public void a(List<Locale> list) {
        c.a.b.d("LocalizationChannel", "Sending Locales to Flutter.");
        ArrayList arrayList = new ArrayList();
        for (Locale locale : list) {
            c.a.b.d("LocalizationChannel", "Locale (Language: " + locale.getLanguage() + ", Country: " + locale.getCountry() + ", Variant: " + locale.getVariant() + ")");
            arrayList.add(locale.getLanguage());
            arrayList.add(locale.getCountry());
            arrayList.add(Build.VERSION.SDK_INT >= 21 ? locale.getScript() : "");
            arrayList.add(locale.getVariant());
        }
        this.f2535a.c("setLocale", arrayList);
    }
}
