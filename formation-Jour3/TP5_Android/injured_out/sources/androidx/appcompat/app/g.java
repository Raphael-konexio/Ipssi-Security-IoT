package androidx.appcompat.app;

import a.a.n.b;
import a.g.k.e;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class g extends Dialog implements d {
    private e f;
    private final e.a g;

    /* loaded from: classes.dex */
    class a implements e.a {
        a() {
        }

        @Override // a.g.k.e.a
        public boolean b(KeyEvent keyEvent) {
            return g.this.e(keyEvent);
        }
    }

    public g(Context context, int i) {
        super(context, b(context, i));
        this.g = new a();
        e a2 = a();
        a2.G(b(context, i));
        a2.s(null);
    }

    private static int b(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(a.a.a.dialogTheme, typedValue, true);
            return typedValue.resourceId;
        }
        return i;
    }

    public e a() {
        if (this.f == null) {
            this.f = e.h(this, this);
        }
        return this.f;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().c(view, layoutParams);
    }

    @Override // androidx.appcompat.app.d
    public void c(a.a.n.b bVar) {
    }

    @Override // androidx.appcompat.app.d
    public void d(a.a.n.b bVar) {
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return a.g.k.e.e(this.g, getWindow().getDecorView(), this, keyEvent);
    }

    boolean e(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean f(int i) {
        return a().A(i);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) a().i(i);
    }

    @Override // androidx.appcompat.app.d
    public a.a.n.b g(b.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        a().n();
        super.onCreate(bundle);
        a().s(bundle);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        a().y();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        a().B(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().C(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().D(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        a().H(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().H(charSequence);
    }
}
