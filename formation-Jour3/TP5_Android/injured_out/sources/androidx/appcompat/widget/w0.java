package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.d.f;
/* loaded from: classes.dex */
public class w0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f656a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f657b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f658c;

    private w0(Context context, TypedArray typedArray) {
        this.f656a = context;
        this.f657b = typedArray;
    }

    public static w0 s(Context context, int i, int[] iArr) {
        return new w0(context, context.obtainStyledAttributes(i, iArr));
    }

    public static w0 t(Context context, AttributeSet attributeSet, int[] iArr) {
        return new w0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static w0 u(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new w0(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public boolean a(int i, boolean z) {
        return this.f657b.getBoolean(i, z);
    }

    public int b(int i, int i2) {
        return this.f657b.getColor(i, i2);
    }

    public ColorStateList c(int i) {
        int resourceId;
        ColorStateList c2;
        return (!this.f657b.hasValue(i) || (resourceId = this.f657b.getResourceId(i, 0)) == 0 || (c2 = a.a.k.a.a.c(this.f656a, resourceId)) == null) ? this.f657b.getColorStateList(i) : c2;
    }

    public float d(int i, float f) {
        return this.f657b.getDimension(i, f);
    }

    public int e(int i, int i2) {
        return this.f657b.getDimensionPixelOffset(i, i2);
    }

    public int f(int i, int i2) {
        return this.f657b.getDimensionPixelSize(i, i2);
    }

    public Drawable g(int i) {
        int resourceId;
        return (!this.f657b.hasValue(i) || (resourceId = this.f657b.getResourceId(i, 0)) == 0) ? this.f657b.getDrawable(i) : a.a.k.a.a.d(this.f656a, resourceId);
    }

    public Drawable h(int i) {
        int resourceId;
        if (!this.f657b.hasValue(i) || (resourceId = this.f657b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return j.b().d(this.f656a, resourceId, true);
    }

    public float i(int i, float f) {
        return this.f657b.getFloat(i, f);
    }

    public Typeface j(int i, int i2, f.c cVar) {
        int resourceId = this.f657b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f658c == null) {
            this.f658c = new TypedValue();
        }
        return androidx.core.content.d.f.f(this.f656a, resourceId, this.f658c, i2, cVar);
    }

    public int k(int i, int i2) {
        return this.f657b.getInt(i, i2);
    }

    public int l(int i, int i2) {
        return this.f657b.getInteger(i, i2);
    }

    public int m(int i, int i2) {
        return this.f657b.getLayoutDimension(i, i2);
    }

    public int n(int i, int i2) {
        return this.f657b.getResourceId(i, i2);
    }

    public String o(int i) {
        return this.f657b.getString(i);
    }

    public CharSequence p(int i) {
        return this.f657b.getText(i);
    }

    public CharSequence[] q(int i) {
        return this.f657b.getTextArray(i);
    }

    public boolean r(int i) {
        return this.f657b.hasValue(i);
    }

    public void v() {
        this.f657b.recycle();
    }
}
