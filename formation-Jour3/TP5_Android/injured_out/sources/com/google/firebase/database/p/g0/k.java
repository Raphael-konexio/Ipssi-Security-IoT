package com.google.firebase.database.p.g0;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class k<T> {

    /* renamed from: a  reason: collision with root package name */
    public Map<com.google.firebase.database.r.b, k<T>> f2192a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public T f2193b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        String str2 = str + "<value>: " + this.f2193b + "\n";
        if (this.f2192a.isEmpty()) {
            return str2 + str + "<empty>";
        }
        for (Map.Entry<com.google.firebase.database.r.b, k<T>> entry : this.f2192a.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(str);
            sb.append(entry.getKey());
            sb.append(":\n");
            sb.append(entry.getValue().a(str + "\t"));
            sb.append("\n");
            str2 = sb.toString();
        }
        return str2;
    }
}
