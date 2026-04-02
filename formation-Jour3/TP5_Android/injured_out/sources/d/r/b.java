package d.r;

import d.s.d.g;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements d.v.b<String> {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedReader f2406a;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<String> {
        private String f;
        private boolean g;

        a() {
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public String next() {
            if (hasNext()) {
                String str = this.f;
                this.f = null;
                g.c(str);
                return str;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f == null && !this.g) {
                String readLine = b.this.f2406a.readLine();
                this.f = readLine;
                if (readLine == null) {
                    this.g = true;
                }
            }
            return this.f != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(BufferedReader bufferedReader) {
        g.e(bufferedReader, "reader");
        this.f2406a = bufferedReader;
    }

    @Override // d.v.b
    public Iterator<String> iterator() {
        return new a();
    }
}
