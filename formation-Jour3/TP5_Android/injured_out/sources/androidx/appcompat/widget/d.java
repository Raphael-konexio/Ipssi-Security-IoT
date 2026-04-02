package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
/* loaded from: classes.dex */
public class d extends AutoCompleteTextView implements a.g.k.r {
    private static final int[] h = {16843126};
    private final e f;
    private final y g;

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.a.autoCompleteTextViewStyle);
    }

    public d(Context context, AttributeSet attributeSet, int i) {
        super(t0.b(context), attributeSet, i);
        w0 u = w0.u(getContext(), attributeSet, h, i, 0);
        if (u.r(0)) {
            setDropDownBackgroundDrawable(u.g(0));
        }
        u.v();
        e eVar = new e(this);
        this.f = eVar;
        eVar.e(attributeSet, i);
        y yVar = new y(this);
        this.g = yVar;
        yVar.m(attributeSet, i);
        this.g.b();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f;
        if (eVar != null) {
            eVar.b();
        }
        y yVar = this.g;
        if (yVar != null) {
            yVar.b();
        }
    }

    @Override // a.g.k.r
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // a.g.k.r
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        l.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f;
        if (eVar != null) {
            eVar.g(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(a.a.k.a.a.d(getContext(), i));
    }

    @Override // a.g.k.r
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // a.g.k.r
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        y yVar = this.g;
        if (yVar != null) {
            yVar.p(context, i);
        }
    }
}
