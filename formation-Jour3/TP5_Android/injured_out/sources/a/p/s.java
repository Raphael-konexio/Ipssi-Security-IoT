package a.p;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class s {

    /* renamed from: b  reason: collision with root package name */
    public View f412b;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f411a = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<m> f413c = new ArrayList<>();

    @Deprecated
    public s() {
    }

    public s(View view) {
        this.f412b = view;
    }

    public boolean equals(Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            return this.f412b == sVar.f412b && this.f411a.equals(sVar.f411a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f412b.hashCode() * 31) + this.f411a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f412b + "\n") + "    values:";
        for (String str2 : this.f411a.keySet()) {
            str = str + "    " + str2 + ": " + this.f411a.get(str2) + "\n";
        }
        return str;
    }
}
