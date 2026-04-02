package io.flutter.plugin.editing;

import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import io.flutter.embedding.engine.i.m;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
class c extends SpannableStringBuilder {
    private int f = 0;
    private int g = 0;
    private ArrayList<b> h = new ArrayList<>();
    private ArrayList<b> i = new ArrayList<>();
    private String j;
    private String k;
    private int l;
    private int m;
    private int n;
    private int o;
    private BaseInputConnection p;

    /* loaded from: classes.dex */
    class a extends BaseInputConnection {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Editable f2618a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(c cVar, View view, boolean z, Editable editable) {
            super(view, z);
            this.f2618a = editable;
        }

        @Override // android.view.inputmethod.BaseInputConnection
        public Editable getEditable() {
            return this.f2618a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z, boolean z2, boolean z3);
    }

    public c(m.e eVar, View view) {
        if (eVar != null) {
            l(eVar);
        }
        this.p = new a(this, view, true, this);
    }

    private void h(b bVar, boolean z, boolean z2, boolean z3) {
        this.g++;
        bVar.a(z, z2, z3);
        this.g--;
    }

    private void i(boolean z, boolean z2, boolean z3) {
        if (z || z2 || z3) {
            Iterator<b> it = this.h.iterator();
            while (it.hasNext()) {
                h(it.next(), z, z2, z3);
            }
        }
    }

    public void a(b bVar) {
        ArrayList<b> arrayList;
        if (this.g > 0) {
            c.a.b.b("ListenableEditingState", "adding a listener " + bVar.toString() + " in a listener callback");
        }
        if (this.f > 0) {
            c.a.b.e("ListenableEditingState", "a listener was added to EditingState while a batch edit was in progress");
            arrayList = this.i;
        } else {
            arrayList = this.h;
        }
        arrayList.add(bVar);
    }

    public void b() {
        this.f++;
        if (this.g > 0) {
            c.a.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        if (this.f != 1 || this.h.isEmpty()) {
            return;
        }
        this.k = toString();
        this.l = g();
        this.m = f();
        this.n = e();
        this.o = d();
    }

    public void c() {
        int i = this.f;
        if (i == 0) {
            c.a.b.b("ListenableEditingState", "endBatchEdit called without a matching beginBatchEdit");
            return;
        }
        if (i == 1) {
            Iterator<b> it = this.i.iterator();
            while (it.hasNext()) {
                h(it.next(), true, true, true);
            }
            if (!this.h.isEmpty()) {
                c.a.b.d("ListenableEditingState", "didFinishBatchEdit with " + String.valueOf(this.h.size()) + " listener(s)");
                boolean z = false;
                i(!toString().equals(this.k), (this.l == g() && this.m == f()) ? false : true, (this.n == e() && this.o == d()) ? true : true);
            }
        }
        this.h.addAll(this.i);
        this.i.clear();
        this.f--;
    }

    public final int d() {
        return BaseInputConnection.getComposingSpanEnd(this);
    }

    public final int e() {
        return BaseInputConnection.getComposingSpanStart(this);
    }

    public final int f() {
        return Selection.getSelectionEnd(this);
    }

    public final int g() {
        return Selection.getSelectionStart(this);
    }

    public void j(b bVar) {
        if (this.g > 0) {
            c.a.b.b("ListenableEditingState", "removing a listener " + bVar.toString() + " in a listener callback");
        }
        this.h.remove(bVar);
        if (this.f > 0) {
            this.i.remove(bVar);
        }
    }

    public void k(int i, int i2) {
        if (i < 0 || i >= i2) {
            BaseInputConnection.removeComposingSpans(this);
        } else {
            this.p.setComposingRegion(i, i2);
        }
    }

    public void l(m.e eVar) {
        b();
        replace(0, length(), (CharSequence) eVar.f2593a);
        int i = eVar.f2594b;
        if (i >= 0) {
            Selection.setSelection(this, i, eVar.f2595c);
        } else {
            Selection.removeSelection(this);
        }
        k(eVar.f2596d, eVar.e);
        c();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i, int i2, CharSequence charSequence, int i3, int i4) {
        if (this.g > 0) {
            c.a.b.b("ListenableEditingState", "editing state should not be changed in a listener callback");
        }
        int i5 = i2 - i;
        boolean z = true;
        boolean z2 = i5 != i4 - i3;
        for (int i6 = 0; i6 < i5 && !z2; i6++) {
            z2 |= charAt(i + i6) != charSequence.charAt(i3 + i6);
        }
        if (z2) {
            this.j = null;
        }
        int g = g();
        int f = f();
        int e = e();
        int d2 = d();
        SpannableStringBuilder replace = super.replace(i, i2, charSequence, i3, i4);
        if (this.f > 0) {
            return replace;
        }
        boolean z3 = (g() == g && f() == f) ? false : true;
        if (e() == e && d() == d2) {
            z = false;
        }
        i(z2, z3, z);
        return replace;
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public String toString() {
        String str = this.j;
        if (str != null) {
            return str;
        }
        String spannableStringBuilder = super.toString();
        this.j = spannableStringBuilder;
        return spannableStringBuilder;
    }
}
