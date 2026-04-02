package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    g f;
    private int g = -1;
    private boolean h;
    private final boolean i;
    private final LayoutInflater j;
    private final int k;

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.i = z;
        this.j = layoutInflater;
        this.f = gVar;
        this.k = i;
        a();
    }

    void a() {
        i v = this.f.v();
        if (v != null) {
            ArrayList<i> z = this.f.z();
            int size = z.size();
            for (int i = 0; i < size; i++) {
                if (z.get(i) == v) {
                    this.g = i;
                    return;
                }
            }
        }
        this.g = -1;
    }

    public g b() {
        return this.f;
    }

    @Override // android.widget.Adapter
    /* renamed from: c */
    public i getItem(int i) {
        ArrayList<i> z = this.i ? this.f.z() : this.f.E();
        int i2 = this.g;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return z.get(i);
    }

    public void d(boolean z) {
        this.h = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<i> z = this.i ? this.f.z() : this.f.E();
        int i = this.g;
        int size = z.size();
        return i < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.j.inflate(this.k, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f.F() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        n.a aVar = (n.a) view;
        if (this.h) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.e(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
