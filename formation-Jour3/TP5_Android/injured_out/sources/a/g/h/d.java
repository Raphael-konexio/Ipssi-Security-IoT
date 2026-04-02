package a.g.h;

import a.g.j.i;
import android.util.Base64;
import java.util.List;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f157a;

    /* renamed from: b  reason: collision with root package name */
    private final String f158b;

    /* renamed from: c  reason: collision with root package name */
    private final String f159c;

    /* renamed from: d  reason: collision with root package name */
    private final List<List<byte[]>> f160d;
    private final int e;
    private final String f;

    public d(String str, String str2, String str3, List<List<byte[]>> list) {
        i.c(str);
        this.f157a = str;
        i.c(str2);
        this.f158b = str2;
        i.c(str3);
        this.f159c = str3;
        i.c(list);
        this.f160d = list;
        this.e = 0;
        this.f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List<List<byte[]>> b() {
        return this.f160d;
    }

    public int c() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.f;
    }

    public String e() {
        return this.f157a;
    }

    public String f() {
        return this.f158b;
    }

    public String g() {
        return this.f159c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f157a + ", mProviderPackage: " + this.f158b + ", mQuery: " + this.f159c + ", mCertificates:");
        for (int i = 0; i < this.f160d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.f160d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.e);
        return sb.toString();
    }
}
