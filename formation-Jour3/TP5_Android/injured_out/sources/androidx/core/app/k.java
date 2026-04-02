package androidx.core.app;

import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    CharSequence f726a;

    /* renamed from: b  reason: collision with root package name */
    IconCompat f727b;

    /* renamed from: c  reason: collision with root package name */
    String f728c;

    /* renamed from: d  reason: collision with root package name */
    String f729d;
    boolean e;
    boolean f;

    public IconCompat a() {
        return this.f727b;
    }

    public String b() {
        return this.f729d;
    }

    public CharSequence c() {
        return this.f726a;
    }

    public String d() {
        return this.f728c;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public String g() {
        String str = this.f728c;
        if (str != null) {
            return str;
        }
        if (this.f726a != null) {
            return "name:" + ((Object) this.f726a);
        }
        return "";
    }

    public Person h() {
        return new Person.Builder().setName(c()).setIcon(a() != null ? a().n() : null).setUri(d()).setKey(b()).setBot(e()).setImportant(f()).build();
    }
}
