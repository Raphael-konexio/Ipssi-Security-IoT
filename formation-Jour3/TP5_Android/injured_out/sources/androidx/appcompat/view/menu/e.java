package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e implements m, AdapterView.OnItemClickListener {
    Context f;
    LayoutInflater g;
    g h;
    ExpandedMenuView i;
    int j;
    int k;
    int l;
    private m.a m;
    a n;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private int f = -1;

        public a() {
            a();
        }

        void a() {
            i v = e.this.h.v();
            if (v != null) {
                ArrayList<i> z = e.this.h.z();
                int size = z.size();
                for (int i = 0; i < size; i++) {
                    if (z.get(i) == v) {
                        this.f = i;
                        return;
                    }
                }
            }
            this.f = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b */
        public i getItem(int i) {
            ArrayList<i> z = e.this.h.z();
            int i2 = i + e.this.j;
            int i3 = this.f;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return z.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = e.this.h.z().size() - e.this.j;
            return this.f < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                e eVar = e.this;
                view = eVar.g.inflate(eVar.l, viewGroup, false);
            }
            ((n.a) view).e(getItem(i), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public e(int i, int i2) {
        this.l = i;
        this.k = i2;
    }

    public e(Context context, int i) {
        this(i, 0);
        this.f = context;
        this.g = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.n == null) {
            this.n = new a();
        }
        return this.n;
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
        m.a aVar = this.m;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    public n c(ViewGroup viewGroup) {
        if (this.i == null) {
            this.i = (ExpandedMenuView) this.g.inflate(a.a.g.abc_expanded_menu_layout, viewGroup, false);
            if (this.n == null) {
                this.n = new a();
            }
            this.i.setAdapter((ListAdapter) this.n);
            this.i.setOnItemClickListener(this);
        }
        return this.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // androidx.appcompat.view.menu.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(android.content.Context r3, androidx.appcompat.view.menu.g r4) {
        /*
            r2 = this;
            int r0 = r2.k
            if (r0 == 0) goto L14
            android.view.ContextThemeWrapper r0 = new android.view.ContextThemeWrapper
            int r1 = r2.k
            r0.<init>(r3, r1)
            r2.f = r0
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r0)
        L11:
            r2.g = r3
            goto L23
        L14:
            android.content.Context r0 = r2.f
            if (r0 == 0) goto L23
            r2.f = r3
            android.view.LayoutInflater r0 = r2.g
            if (r0 != 0) goto L23
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            goto L11
        L23:
            r2.h = r4
            androidx.appcompat.view.menu.e$a r3 = r2.n
            if (r3 == 0) goto L2c
            r3.notifyDataSetChanged()
        L2c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.e.d(android.content.Context, androidx.appcompat.view.menu.g):void");
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean e(r rVar) {
        if (rVar.hasVisibleItems()) {
            new h(rVar).d(null);
            m.a aVar = this.m;
            if (aVar != null) {
                aVar.c(rVar);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void f(boolean z) {
        a aVar = this.n;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean g() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean i(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean j(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void k(m.a aVar) {
        this.m = aVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.h.M(this.n.getItem(i), this, 0);
    }
}
