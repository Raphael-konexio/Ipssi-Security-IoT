package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class j {
    private final String f;
    private k g;
    private int h;
    private String i;
    private CharSequence j;
    private ArrayList<h> k;
    private a.d.h<c> l;
    private HashMap<String, d> m;

    /* loaded from: classes.dex */
    static class a implements Comparable<a> {
        private final j f;
        private final Bundle g;
        private final boolean h;
        private final boolean i;
        private final int j;

        a(j jVar, Bundle bundle, boolean z, boolean z2, int i) {
            this.f = jVar;
            this.g = bundle;
            this.h = z;
            this.i = z2;
            this.j = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: d */
        public int compareTo(a aVar) {
            if (!this.h || aVar.h) {
                if (this.h || !aVar.h) {
                    if (this.g == null || aVar.g != null) {
                        if (this.g != null || aVar.g == null) {
                            Bundle bundle = this.g;
                            if (bundle != null) {
                                int size = bundle.size() - aVar.g.size();
                                if (size > 0) {
                                    return 1;
                                }
                                if (size < 0) {
                                    return -1;
                                }
                            }
                            if (!this.i || aVar.i) {
                                if (this.i || !aVar.i) {
                                    return this.j - aVar.j;
                                }
                                return -1;
                            }
                            return 1;
                        }
                        return -1;
                    }
                    return 1;
                }
                return -1;
            }
            return 1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public j e() {
            return this.f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Bundle f() {
            return this.g;
        }
    }

    static {
        new HashMap();
    }

    public j(r<? extends j> rVar) {
        this(s.c(rVar.getClass()));
    }

    public j(String str) {
        this.f = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String m(Context context, int i) {
        if (i <= 16777215) {
            return Integer.toString(i);
        }
        try {
            return context.getResources().getResourceName(i);
        } catch (Resources.NotFoundException unused) {
            return Integer.toString(i);
        }
    }

    public final void A(int i) {
        this.h = i;
        this.i = null;
    }

    public final void B(CharSequence charSequence) {
        this.j = charSequence;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void C(k kVar) {
        this.g = kVar;
    }

    boolean D() {
        return true;
    }

    public final void d(String str, d dVar) {
        if (this.m == null) {
            this.m = new HashMap<>();
        }
        this.m.put(str, dVar);
    }

    public final void e(h hVar) {
        if (this.k == null) {
            this.k = new ArrayList<>();
        }
        this.k.add(hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle f(Bundle bundle) {
        HashMap<String, d> hashMap;
        if (bundle == null && ((hashMap = this.m) == null || hashMap.isEmpty())) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        HashMap<String, d> hashMap2 = this.m;
        if (hashMap2 != null) {
            for (Map.Entry<String, d> entry : hashMap2.entrySet()) {
                entry.getValue().c(entry.getKey(), bundle2);
            }
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            HashMap<String, d> hashMap3 = this.m;
            if (hashMap3 != null) {
                for (Map.Entry<String, d> entry2 : hashMap3.entrySet()) {
                    if (!entry2.getValue().d(entry2.getKey(), bundle2)) {
                        throw new IllegalArgumentException("Wrong argument type for '" + entry2.getKey() + "' in argument bundle. " + entry2.getValue().a().c() + " expected.");
                    }
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] g() {
        ArrayDeque arrayDeque = new ArrayDeque();
        j jVar = this;
        while (true) {
            k w = jVar.w();
            if (w == null || w.I() != jVar.s()) {
                arrayDeque.addFirst(jVar);
            }
            if (w == null) {
                break;
            }
            jVar = w;
        }
        int[] iArr = new int[arrayDeque.size()];
        int i = 0;
        Iterator it = arrayDeque.iterator();
        while (it.hasNext()) {
            iArr[i] = ((j) it.next()).s();
            i++;
        }
        return iArr;
    }

    public final Map<String, d> i() {
        HashMap<String, d> hashMap = this.m;
        return hashMap == null ? Collections.emptyMap() : Collections.unmodifiableMap(hashMap);
    }

    public String l() {
        if (this.i == null) {
            this.i = Integer.toString(this.h);
        }
        return this.i;
    }

    public final int s() {
        return this.h;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.i;
        if (str == null) {
            sb.append("0x");
            str = Integer.toHexString(this.h);
        }
        sb.append(str);
        sb.append(")");
        if (this.j != null) {
            sb.append(" label=");
            sb.append(this.j);
        }
        return sb.toString();
    }

    public final String u() {
        return this.f;
    }

    public final k w() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a x(i iVar) {
        ArrayList<h> arrayList = this.k;
        if (arrayList == null) {
            return null;
        }
        Iterator<h> it = arrayList.iterator();
        a aVar = null;
        while (it.hasNext()) {
            h next = it.next();
            Uri c2 = iVar.c();
            Bundle c3 = c2 != null ? next.c(c2, i()) : null;
            String a2 = iVar.a();
            boolean z = a2 != null && a2.equals(next.b());
            String b2 = iVar.b();
            int d2 = b2 != null ? next.d(b2) : -1;
            if (c3 != null || z || d2 > -1) {
                a aVar2 = new a(this, c3, next.e(), z, d2);
                if (aVar == null || aVar2.compareTo(aVar) > 0) {
                    aVar = aVar2;
                }
            }
        }
        return aVar;
    }

    public void y(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, androidx.navigation.v.a.Navigator);
        A(obtainAttributes.getResourceId(androidx.navigation.v.a.Navigator_android_id, 0));
        this.i = m(context, this.h);
        B(obtainAttributes.getText(androidx.navigation.v.a.Navigator_android_label));
        obtainAttributes.recycle();
    }

    public final void z(int i, c cVar) {
        if (D()) {
            if (i == 0) {
                throw new IllegalArgumentException("Cannot have an action with actionId 0");
            }
            if (this.l == null) {
                this.l = new a.d.h<>();
            }
            this.l.i(i, cVar);
            return;
        }
        throw new UnsupportedOperationException("Cannot add action " + i + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
    }
}
