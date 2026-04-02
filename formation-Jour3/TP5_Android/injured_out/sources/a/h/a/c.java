package a.h.a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public abstract class c extends a {
    private int n;
    private int o;
    private LayoutInflater p;

    @Deprecated
    public c(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.o = i;
        this.n = i;
        this.p = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // a.h.a.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.p.inflate(this.o, viewGroup, false);
    }

    @Override // a.h.a.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.p.inflate(this.n, viewGroup, false);
    }
}
