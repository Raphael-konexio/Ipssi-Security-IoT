package b.c.c;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.util.k;
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final String f1419a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1420b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1421c;

    /* renamed from: d  reason: collision with root package name */
    private final String f1422d;
    private final String e;
    private final String f;
    private final String g;

    private h(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        r.k(!k.b(str), "ApplicationId must be set.");
        this.f1420b = str;
        this.f1419a = str2;
        this.f1421c = str3;
        this.f1422d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
    }

    public static h a(Context context) {
        v vVar = new v(context);
        String a2 = vVar.a("google_app_id");
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return new h(a2, vVar.a("google_api_key"), vVar.a("firebase_database_url"), vVar.a("ga_trackingId"), vVar.a("gcm_defaultSenderId"), vVar.a("google_storage_bucket"), vVar.a("project_id"));
    }

    public String b() {
        return this.f1419a;
    }

    public String c() {
        return this.f1420b;
    }

    public String d() {
        return this.f1421c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            return q.a(this.f1420b, hVar.f1420b) && q.a(this.f1419a, hVar.f1419a) && q.a(this.f1421c, hVar.f1421c) && q.a(this.f1422d, hVar.f1422d) && q.a(this.e, hVar.e) && q.a(this.f, hVar.f) && q.a(this.g, hVar.g);
        }
        return false;
    }

    public int hashCode() {
        return q.b(this.f1420b, this.f1419a, this.f1421c, this.f1422d, this.e, this.f, this.g);
    }

    public String toString() {
        q.a c2 = q.c(this);
        c2.a("applicationId", this.f1420b);
        c2.a("apiKey", this.f1419a);
        c2.a("databaseUrl", this.f1421c);
        c2.a("gcmSenderId", this.e);
        c2.a("storageBucket", this.f);
        c2.a("projectId", this.g);
        return c2.toString();
    }
}
