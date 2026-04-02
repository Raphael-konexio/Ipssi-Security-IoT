package com.google.firebase.database.r;

import com.google.firebase.database.n.c;
import com.google.firebase.database.n.h;
import com.google.firebase.database.r.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class c implements n {
    public static Comparator<com.google.firebase.database.r.b> i = new a();
    private final com.google.firebase.database.n.c<com.google.firebase.database.r.b, n> f;
    private final n g;
    private String h;

    /* loaded from: classes.dex */
    class a implements Comparator<com.google.firebase.database.r.b> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.google.firebase.database.r.b bVar, com.google.firebase.database.r.b bVar2) {
            return bVar.compareTo(bVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends h.b<com.google.firebase.database.r.b, n> {

        /* renamed from: a  reason: collision with root package name */
        boolean f2352a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AbstractC0104c f2353b;

        b(AbstractC0104c abstractC0104c) {
            this.f2353b = abstractC0104c;
        }

        @Override // com.google.firebase.database.n.h.b
        /* renamed from: b */
        public void a(com.google.firebase.database.r.b bVar, n nVar) {
            if (!this.f2352a && bVar.compareTo(com.google.firebase.database.r.b.m()) > 0) {
                this.f2352a = true;
                this.f2353b.b(com.google.firebase.database.r.b.m(), c.this.c());
            }
            this.f2353b.b(bVar, nVar);
        }
    }

    /* renamed from: com.google.firebase.database.r.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0104c extends h.b<com.google.firebase.database.r.b, n> {
        public abstract void b(com.google.firebase.database.r.b bVar, n nVar);

        @Override // com.google.firebase.database.n.h.b
        /* renamed from: c */
        public void a(com.google.firebase.database.r.b bVar, n nVar) {
            b(bVar, nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d implements Iterator<m> {
        private final Iterator<Map.Entry<com.google.firebase.database.r.b, n>> f;

        public d(Iterator<Map.Entry<com.google.firebase.database.r.b, n>> it) {
            this.f = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public m next() {
            Map.Entry<com.google.firebase.database.r.b, n> next = this.f.next();
            return new m(next.getKey(), next.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c() {
        this.h = null;
        this.f = c.a.b(i);
        this.g = r.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(com.google.firebase.database.n.c<com.google.firebase.database.r.b, n> cVar, n nVar) {
        this.h = null;
        if (cVar.isEmpty() && !nVar.isEmpty()) {
            throw new IllegalArgumentException("Can't create empty ChildrenNode with priority!");
        }
        this.g = nVar;
        this.f = cVar;
    }

    private static void d(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(" ");
        }
    }

    private void m(StringBuilder sb, int i2) {
        String str;
        if (this.f.isEmpty() && this.g.isEmpty()) {
            str = "{ }";
        } else {
            sb.append("{\n");
            Iterator<Map.Entry<com.google.firebase.database.r.b, n>> it = this.f.iterator();
            while (it.hasNext()) {
                Map.Entry<com.google.firebase.database.r.b, n> next = it.next();
                int i3 = i2 + 2;
                d(sb, i3);
                sb.append(next.getKey().e());
                sb.append("=");
                boolean z = next.getValue() instanceof c;
                n value = next.getValue();
                if (z) {
                    ((c) value).m(sb, i3);
                } else {
                    sb.append(value.toString());
                }
                sb.append("\n");
            }
            if (!this.g.isEmpty()) {
                d(sb, i2 + 2);
                sb.append(".priority=");
                sb.append(this.g.toString());
                sb.append("\n");
            }
            d(sb, i2);
            str = "}";
        }
        sb.append(str);
    }

    @Override // com.google.firebase.database.r.n
    public int a() {
        return this.f.size();
    }

    @Override // com.google.firebase.database.r.n
    public n b(com.google.firebase.database.r.b bVar) {
        return (!bVar.w() || this.g.isEmpty()) ? this.f.d(bVar) ? this.f.e(bVar) : g.s() : this.g;
    }

    @Override // com.google.firebase.database.r.n
    public n c() {
        return this.g;
    }

    @Override // java.lang.Comparable
    /* renamed from: e */
    public int compareTo(n nVar) {
        if (isEmpty()) {
            return nVar.isEmpty() ? 0 : -1;
        } else if (nVar.k() || nVar.isEmpty()) {
            return 1;
        } else {
            return nVar == n.f2368b ? -1 : 0;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (c().equals(cVar.c()) && this.f.size() == cVar.f.size()) {
                Iterator<Map.Entry<com.google.firebase.database.r.b, n>> it = this.f.iterator();
                Iterator<Map.Entry<com.google.firebase.database.r.b, n>> it2 = cVar.f.iterator();
                while (it.hasNext() && it2.hasNext()) {
                    Map.Entry<com.google.firebase.database.r.b, n> next = it.next();
                    Map.Entry<com.google.firebase.database.r.b, n> next2 = it2.next();
                    if (next.getKey().equals(next2.getKey()) || !next.getValue().equals(next2.getValue())) {
                        return false;
                    }
                    while (it.hasNext()) {
                        Map.Entry<com.google.firebase.database.r.b, n> next3 = it.next();
                        Map.Entry<com.google.firebase.database.r.b, n> next22 = it2.next();
                        if (next3.getKey().equals(next22.getKey())) {
                        }
                        return false;
                    }
                }
                if (it.hasNext() || it2.hasNext()) {
                    throw new IllegalStateException("Something went wrong internally.");
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void f(AbstractC0104c abstractC0104c) {
        g(abstractC0104c, false);
    }

    public void g(AbstractC0104c abstractC0104c, boolean z) {
        if (!z || c().isEmpty()) {
            this.f.m(abstractC0104c);
        } else {
            this.f.m(new b(abstractC0104c));
        }
    }

    @Override // com.google.firebase.database.r.n
    public String getHash() {
        if (this.h == null) {
            String v = v(n.b.V1);
            this.h = v.isEmpty() ? "" : com.google.firebase.database.p.g0.l.h(v);
        }
        return this.h;
    }

    @Override // com.google.firebase.database.r.n
    public Object getValue() {
        return r(false);
    }

    @Override // com.google.firebase.database.r.n
    public n h(com.google.firebase.database.p.l lVar) {
        com.google.firebase.database.r.b x = lVar.x();
        return x == null ? this : b(x).h(lVar.A());
    }

    public int hashCode() {
        Iterator<m> it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            m next = it.next();
            i2 = (((i2 * 31) + next.c().hashCode()) * 17) + next.d().hashCode();
        }
        return i2;
    }

    public com.google.firebase.database.r.b i() {
        return this.f.i();
    }

    @Override // com.google.firebase.database.r.n
    public boolean isEmpty() {
        return this.f.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<m> iterator() {
        return new d(this.f.iterator());
    }

    @Override // com.google.firebase.database.r.n
    public n j(n nVar) {
        return this.f.isEmpty() ? g.s() : new c(this.f, nVar);
    }

    @Override // com.google.firebase.database.r.n
    public boolean k() {
        return false;
    }

    public com.google.firebase.database.r.b l() {
        return this.f.g();
    }

    @Override // com.google.firebase.database.r.n
    public com.google.firebase.database.r.b n(com.google.firebase.database.r.b bVar) {
        return this.f.l(bVar);
    }

    @Override // com.google.firebase.database.r.n
    public boolean o(com.google.firebase.database.r.b bVar) {
        return !b(bVar).isEmpty();
    }

    @Override // com.google.firebase.database.r.n
    public n p(com.google.firebase.database.r.b bVar, n nVar) {
        if (bVar.w()) {
            return j(nVar);
        }
        com.google.firebase.database.n.c<com.google.firebase.database.r.b, n> cVar = this.f;
        if (cVar.d(bVar)) {
            cVar = cVar.u(bVar);
        }
        if (!nVar.isEmpty()) {
            cVar = cVar.s(bVar, nVar);
        }
        return cVar.isEmpty() ? g.s() : new c(cVar, this.g);
    }

    @Override // com.google.firebase.database.r.n
    public n q(com.google.firebase.database.p.l lVar, n nVar) {
        com.google.firebase.database.r.b x = lVar.x();
        return x == null ? nVar : x.w() ? j(nVar) : p(x, b(x).q(lVar.A(), nVar));
    }

    @Override // com.google.firebase.database.r.n
    public Object r(boolean z) {
        Integer j;
        if (isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<com.google.firebase.database.r.b, n>> it = this.f.iterator();
        int i2 = 0;
        boolean z2 = true;
        int i3 = 0;
        while (it.hasNext()) {
            Map.Entry<com.google.firebase.database.r.b, n> next = it.next();
            String e = next.getKey().e();
            hashMap.put(e, next.getValue().r(z));
            i2++;
            if (z2) {
                if ((e.length() > 1 && e.charAt(0) == '0') || (j = com.google.firebase.database.p.g0.l.j(e)) == null || j.intValue() < 0) {
                    z2 = false;
                } else if (j.intValue() > i3) {
                    i3 = j.intValue();
                }
            }
        }
        if (z || !z2 || i3 >= i2 * 2) {
            if (z && !this.g.isEmpty()) {
                hashMap.put(".priority", this.g.getValue());
            }
            return hashMap;
        }
        ArrayList arrayList = new ArrayList(i3 + 1);
        for (int i4 = 0; i4 <= i3; i4++) {
            arrayList.add(hashMap.get("" + i4));
        }
        return arrayList;
    }

    @Override // com.google.firebase.database.r.n
    public Iterator<m> t() {
        return new d(this.f.t());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        m(sb, 0);
        return sb.toString();
    }

    @Override // com.google.firebase.database.r.n
    public String v(n.b bVar) {
        boolean z;
        if (bVar == n.b.V1) {
            StringBuilder sb = new StringBuilder();
            if (!this.g.isEmpty()) {
                sb.append("priority:");
                sb.append(this.g.v(n.b.V1));
                sb.append(":");
            }
            ArrayList<m> arrayList = new ArrayList();
            Iterator<m> it = iterator();
            loop0: while (true) {
                while (it.hasNext()) {
                    m next = it.next();
                    arrayList.add(next);
                    z = z || !next.d().c().isEmpty();
                }
            }
            if (z) {
                Collections.sort(arrayList, q.j());
            }
            for (m mVar : arrayList) {
                String hash = mVar.d().getHash();
                if (!hash.equals("")) {
                    sb.append(":");
                    sb.append(mVar.c().e());
                    sb.append(":");
                    sb.append(hash);
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Hashes on children nodes only supported for V1");
    }
}
