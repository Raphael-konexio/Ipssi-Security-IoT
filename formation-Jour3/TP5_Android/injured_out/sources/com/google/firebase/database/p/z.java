package com.google.firebase.database.p;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f2344a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private int f2345b;

    private z(l lVar) {
        this.f2345b = 0;
        Iterator<com.google.firebase.database.r.b> it = lVar.iterator();
        while (it.hasNext()) {
            this.f2344a.add(it.next().e());
        }
        this.f2345b = Math.max(1, this.f2344a.size());
        for (int i = 0; i < this.f2344a.size(); i++) {
            this.f2345b += f(this.f2344a.get(i));
        }
        a();
    }

    private void a() {
        if (this.f2345b > 768) {
            throw new com.google.firebase.database.c("Data has a key path longer than 768 bytes (" + this.f2345b + ").");
        } else if (this.f2344a.size() <= 32) {
        } else {
            throw new com.google.firebase.database.c("Path specified exceeds the maximum depth that can be written (32) or object contains a cycle " + e());
        }
    }

    private static String b(String str, List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(str);
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    private String c() {
        List<String> list;
        String remove = this.f2344a.remove(list.size() - 1);
        this.f2345b -= f(remove);
        if (this.f2344a.size() > 0) {
            this.f2345b--;
        }
        return remove;
    }

    private void d(String str) {
        if (this.f2344a.size() > 0) {
            this.f2345b++;
        }
        this.f2344a.add(str);
        this.f2345b += f(str);
        a();
    }

    private String e() {
        if (this.f2344a.size() == 0) {
            return "";
        }
        return "in path '" + b("/", this.f2344a) + "'";
    }

    private static int f(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt <= 127) {
                i2++;
            } else if (charAt <= 2047) {
                i2 += 2;
            } else if (Character.isHighSurrogate(charAt)) {
                i2 += 4;
                i++;
            } else {
                i2 += 3;
            }
            i++;
        }
        return i2;
    }

    public static void g(l lVar, Object obj) {
        new z(lVar).h(obj);
    }

    private void h(Object obj) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            for (String str : map.keySet()) {
                if (!str.startsWith(".")) {
                    d(str);
                    h(map.get(str));
                    c();
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            for (int i = 0; i < list.size(); i++) {
                d(Integer.toString(i));
                h(list.get(i));
                c();
            }
        }
    }
}
