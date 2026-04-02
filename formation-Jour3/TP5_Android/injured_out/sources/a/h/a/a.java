package a.h.a;

import a.h.a.b;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {
    protected boolean f;
    protected boolean g;
    protected Cursor h;
    protected Context i;
    protected int j;
    protected C0015a k;
    protected DataSetObserver l;
    protected a.h.a.b m;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0015a extends ContentObserver {
        C0015a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            a.this.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        f(context, cursor, z ? 1 : 2);
    }

    @Override // a.h.a.b.a
    public void a(Cursor cursor) {
        Cursor j = j(cursor);
        if (j != null) {
            j.close();
        }
    }

    @Override // a.h.a.b.a
    public Cursor b() {
        return this.h;
    }

    @Override // a.h.a.b.a
    public abstract CharSequence c(Cursor cursor);

    public abstract void e(View view, Context context, Cursor cursor);

    void f(Context context, Cursor cursor, int i) {
        b bVar;
        if ((i & 1) == 1) {
            i |= 2;
            this.g = true;
        } else {
            this.g = false;
        }
        boolean z = cursor != null;
        this.h = cursor;
        this.f = z;
        this.i = context;
        this.j = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.k = new C0015a();
            bVar = new b();
        } else {
            bVar = null;
            this.k = null;
        }
        this.l = bVar;
        if (z) {
            C0015a c0015a = this.k;
            if (c0015a != null) {
                cursor.registerContentObserver(c0015a);
            }
            DataSetObserver dataSetObserver = this.l;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View g(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f || (cursor = this.h) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.f) {
            this.h.moveToPosition(i);
            if (view == null) {
                view = g(this.i, this.h, viewGroup);
            }
            e(view, this.i, this.h);
            return view;
        }
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.m == null) {
            this.m = new a.h.a.b(this);
        }
        return this.m;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.f || (cursor = this.h) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.h;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.f && (cursor = this.h) != null && cursor.moveToPosition(i)) {
            return this.h.getLong(this.j);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f) {
            if (this.h.moveToPosition(i)) {
                if (view == null) {
                    view = h(this.i, this.h, viewGroup);
                }
                e(view, this.i, this.h);
                return view;
            }
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    public abstract View h(Context context, Cursor cursor, ViewGroup viewGroup);

    protected void i() {
        Cursor cursor;
        if (!this.g || (cursor = this.h) == null || cursor.isClosed()) {
            return;
        }
        this.f = this.h.requery();
    }

    public Cursor j(Cursor cursor) {
        Cursor cursor2 = this.h;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0015a c0015a = this.k;
            if (c0015a != null) {
                cursor2.unregisterContentObserver(c0015a);
            }
            DataSetObserver dataSetObserver = this.l;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.h = cursor;
        if (cursor != null) {
            C0015a c0015a2 = this.k;
            if (c0015a2 != null) {
                cursor.registerContentObserver(c0015a2);
            }
            DataSetObserver dataSetObserver2 = this.l;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.j = cursor.getColumnIndexOrThrow("_id");
            this.f = true;
            notifyDataSetChanged();
        } else {
            this.j = -1;
            this.f = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
