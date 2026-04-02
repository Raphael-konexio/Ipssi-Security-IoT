package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class z1 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<z1> CREATOR = new b2();
    private final int f;
    private List<String> g;

    public z1() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z1(int i, List<String> list) {
        List<String> emptyList;
        this.f = i;
        if (list == null || list.isEmpty()) {
            emptyList = Collections.emptyList();
        } else {
            for (int i2 = 0; i2 < list.size(); i2++) {
                list.set(i2, com.google.android.gms.common.util.k.a(list.get(i2)));
            }
            emptyList = Collections.unmodifiableList(list);
        }
        this.g = emptyList;
    }

    private z1(List<String> list) {
        this.f = 1;
        this.g = new ArrayList();
        if (list == null || list.isEmpty()) {
            return;
        }
        this.g.addAll(list);
    }

    public static z1 b(z1 z1Var) {
        return new z1(z1Var != null ? z1Var.g : null);
    }

    public static z1 c() {
        return new z1(null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.g(parcel, 1, this.f);
        com.google.android.gms.common.internal.w.c.l(parcel, 2, this.g, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
