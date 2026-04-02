package b.c.a.a.d.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class w1 extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<w1> CREATOR = new v1();
    private List<u1> f;

    public w1() {
        this.f = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w1(List<u1> list) {
        this.f = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    public static w1 b(w1 w1Var) {
        List<u1> list = w1Var.f;
        w1 w1Var2 = new w1();
        if (list != null) {
            w1Var2.f.addAll(list);
        }
        return w1Var2;
    }

    public final List<u1> c() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.n(parcel, 2, this.f, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
