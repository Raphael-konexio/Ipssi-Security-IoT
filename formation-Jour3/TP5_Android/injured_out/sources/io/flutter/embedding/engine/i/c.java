package io.flutter.embedding.engine.i;

import android.os.Build;
import android.view.InputDevice;
import android.view.KeyEvent;
import c.a.c.a.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private a f2530a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.c.a.a<Object> f2531b;

    /* loaded from: classes.dex */
    public interface a {
        void a(KeyEvent keyEvent);

        void b(KeyEvent keyEvent);
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final KeyEvent f2532a;

        /* renamed from: b  reason: collision with root package name */
        public final Character f2533b;

        public b(KeyEvent keyEvent, Character ch) {
            this.f2532a = keyEvent;
            this.f2533b = ch;
        }
    }

    public c(c.a.c.a.b bVar) {
        this.f2531b = new c.a.c.a.a<>(bVar, "flutter/keyevent", c.a.c.a.d.f1488a);
    }

    private void b(b bVar, Map<String, Object> map) {
        int i;
        map.put("flags", Integer.valueOf(bVar.f2532a.getFlags()));
        int i2 = 0;
        map.put("plainCodePoint", Integer.valueOf(bVar.f2532a.getUnicodeChar(0)));
        map.put("codePoint", Integer.valueOf(bVar.f2532a.getUnicodeChar()));
        map.put("keyCode", Integer.valueOf(bVar.f2532a.getKeyCode()));
        map.put("scanCode", Integer.valueOf(bVar.f2532a.getScanCode()));
        map.put("metaState", Integer.valueOf(bVar.f2532a.getMetaState()));
        Character ch = bVar.f2533b;
        if (ch != null) {
            map.put("character", ch.toString());
        }
        map.put("source", Integer.valueOf(bVar.f2532a.getSource()));
        InputDevice device = InputDevice.getDevice(bVar.f2532a.getDeviceId());
        if (device == null || Build.VERSION.SDK_INT < 19) {
            i = 0;
        } else {
            i2 = device.getVendorId();
            i = device.getProductId();
        }
        map.put("vendorId", Integer.valueOf(i2));
        map.put("productId", Integer.valueOf(i));
        map.put("deviceId", Integer.valueOf(bVar.f2532a.getDeviceId()));
        map.put("repeatCount", Integer.valueOf(bVar.f2532a.getRepeatCount()));
    }

    a.e<Object> a(final KeyEvent keyEvent) {
        return new a.e() { // from class: io.flutter.embedding.engine.i.a
            @Override // c.a.c.a.a.e
            public final void a(Object obj) {
                c.this.e(keyEvent, obj);
            }
        };
    }

    public void c(b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "keydown");
        hashMap.put("keymap", "android");
        b(bVar, hashMap);
        this.f2531b.d(hashMap, a(bVar.f2532a));
    }

    public void d(b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", "keyup");
        hashMap.put("keymap", "android");
        b(bVar, hashMap);
        this.f2531b.d(hashMap, a(bVar.f2532a));
    }

    public /* synthetic */ void e(KeyEvent keyEvent, Object obj) {
        a aVar = this.f2530a;
        if (aVar == null) {
            return;
        }
        try {
            if (obj == null) {
                aVar.b(keyEvent);
            } else if (((JSONObject) obj).getBoolean("handled")) {
                this.f2530a.a(keyEvent);
            } else {
                this.f2530a.b(keyEvent);
            }
        } catch (JSONException e) {
            c.a.b.b("KeyEventChannel", "Unable to unpack JSON message: " + e);
            this.f2530a.b(keyEvent);
        }
    }

    public void f(a aVar) {
        this.f2530a = aVar;
    }
}
