package androidx.navigation;

import android.content.Intent;
import android.net.Uri;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f942a;

    /* renamed from: b  reason: collision with root package name */
    private final String f943b;

    /* renamed from: c  reason: collision with root package name */
    private final String f944c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Intent intent) {
        this(intent.getData(), intent.getAction(), intent.getType());
    }

    i(Uri uri, String str, String str2) {
        this.f942a = uri;
        this.f943b = str;
        this.f944c = str2;
    }

    public String a() {
        return this.f943b;
    }

    public String b() {
        return this.f944c;
    }

    public Uri c() {
        return this.f942a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NavDeepLinkRequest");
        sb.append("{");
        if (this.f942a != null) {
            sb.append(" uri=");
            sb.append(this.f942a.toString());
        }
        if (this.f943b != null) {
            sb.append(" action=");
            sb.append(this.f943b);
        }
        if (this.f944c != null) {
            sb.append(" mimetype=");
            sb.append(this.f944c);
        }
        sb.append(" }");
        return sb.toString();
    }
}
