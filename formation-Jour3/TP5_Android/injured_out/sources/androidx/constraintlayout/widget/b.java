package androidx.constraintlayout.widget;

import a.e.a.j.j;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class b extends View {
    protected int[] f;
    protected int g;
    protected Context h;
    protected j i;
    protected boolean j;
    private String k;

    public b(Context context) {
        super(context);
        this.f = new int[32];
        this.j = false;
        this.h = context;
        b(null);
    }

    private void a(String str) {
        int i;
        Object c2;
        if (str == null || this.h == null) {
            return;
        }
        String trim = str.trim();
        try {
            i = g.class.getField(trim).getInt(null);
        } catch (Exception unused) {
            i = 0;
        }
        if (i == 0) {
            i = this.h.getResources().getIdentifier(trim, "id", this.h.getPackageName());
        }
        if (i == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (c2 = ((ConstraintLayout) getParent()).c(0, trim)) != null && (c2 instanceof Integer)) {
            i = ((Integer) c2).intValue();
        }
        if (i != 0) {
            setTag(i, null);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    private void setIds(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                a(str.substring(i));
                return;
            } else {
                a(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == h.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.k = string;
                    setIds(string);
                }
            }
        }
    }

    public void c(ConstraintLayout constraintLayout) {
    }

    public void d(ConstraintLayout constraintLayout) {
    }

    public void e(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.k);
        }
        j jVar = this.i;
        if (jVar == null) {
            return;
        }
        jVar.J0();
        for (int i = 0; i < this.g; i++) {
            View e = constraintLayout.e(this.f[i]);
            if (e != null) {
                this.i.I0(constraintLayout.f(e));
            }
        }
    }

    public void f() {
        if (this.i == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.a) {
            ((ConstraintLayout.a) layoutParams).k0 = this.i;
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f, this.g);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.j) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.g = 0;
        for (int i : iArr) {
            setTag(i, null);
        }
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        int i2 = this.g + 1;
        int[] iArr = this.f;
        if (i2 > iArr.length) {
            this.f = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f;
        int i3 = this.g;
        iArr2[i3] = i;
        this.g = i3 + 1;
    }
}
