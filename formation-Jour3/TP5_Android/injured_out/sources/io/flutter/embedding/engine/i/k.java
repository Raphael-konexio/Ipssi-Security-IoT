package io.flutter.embedding.engine.i;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final c.a.c.a.a<Object> f2575a;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final c.a.c.a.a<Object> f2576a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, Object> f2577b = new HashMap();

        a(c.a.c.a.a<Object> aVar) {
            this.f2576a = aVar;
        }

        public void a() {
            c.a.b.d("SettingsChannel", "Sending message: \ntextScaleFactor: " + this.f2577b.get("textScaleFactor") + "\nalwaysUse24HourFormat: " + this.f2577b.get("alwaysUse24HourFormat") + "\nplatformBrightness: " + this.f2577b.get("platformBrightness"));
            this.f2576a.c(this.f2577b);
        }

        public a b(b bVar) {
            this.f2577b.put("platformBrightness", bVar.f);
            return this;
        }

        public a c(float f) {
            this.f2577b.put("textScaleFactor", Float.valueOf(f));
            return this;
        }

        public a d(boolean z) {
            this.f2577b.put("alwaysUse24HourFormat", Boolean.valueOf(z));
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        light("light"),
        dark("dark");
        
        public String f;

        b(String str) {
            this.f = str;
        }
    }

    public k(io.flutter.embedding.engine.e.a aVar) {
        this.f2575a = new c.a.c.a.a<>(aVar, "flutter/settings", c.a.c.a.d.f1488a);
    }

    public a a() {
        return new a(this.f2575a);
    }
}
