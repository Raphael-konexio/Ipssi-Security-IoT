package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements LayoutInflater.Factory2 {
    private final m f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(m mVar) {
        this.f = mVar;
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (g.class.getName().equals(str)) {
            return new g(context, attributeSet, this.f);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.c.Fragment);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(a.j.c.Fragment_android_name);
            }
            int resourceId = obtainStyledAttributes.getResourceId(a.j.c.Fragment_android_id, -1);
            String string = obtainStyledAttributes.getString(a.j.c.Fragment_android_tag);
            obtainStyledAttributes.recycle();
            if (attributeValue == null || !i.b(context.getClassLoader(), attributeValue)) {
                return null;
            }
            int id = view != null ? view.getId() : 0;
            if (id == -1 && resourceId == -1 && string == null) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
            }
            Fragment W = resourceId != -1 ? this.f.W(resourceId) : null;
            if (W == null && string != null) {
                W = this.f.X(string);
            }
            if (W == null && id != -1) {
                W = this.f.W(id);
            }
            if (m.p0(2)) {
                Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + attributeValue + " existing=" + W);
            }
            if (W == null) {
                W = this.f.e0().a(context.getClassLoader(), attributeValue);
                W.r = true;
                W.A = resourceId != 0 ? resourceId : id;
                W.B = id;
                W.C = string;
                W.s = true;
                m mVar = this.f;
                W.w = mVar;
                j<?> jVar = mVar.o;
                W.x = jVar;
                W.q0(jVar.g(), attributeSet, W.g);
                this.f.d(W);
                this.f.z0(W);
            } else if (W.s) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            } else {
                W.s = true;
                j<?> jVar2 = this.f.o;
                W.x = jVar2;
                W.q0(jVar2.g(), attributeSet, W.g);
            }
            m mVar2 = this.f;
            if (mVar2.n >= 1 || !W.r) {
                this.f.z0(W);
            } else {
                mVar2.A0(W, 1);
            }
            View view2 = W.L;
            if (view2 != null) {
                if (resourceId != 0) {
                    view2.setId(resourceId);
                }
                if (W.L.getTag() == null) {
                    W.L.setTag(string);
                }
                return W.L;
            }
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        return null;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
