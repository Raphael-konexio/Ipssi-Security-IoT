package com.google.firebase.database.o.m;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends Reader {
    private List<String> f;
    private boolean g = false;
    private int h;
    private int j = this.h;
    private int i;
    private int k = this.i;
    private boolean l = false;

    public b() {
        this.f = null;
        this.f = new ArrayList();
    }

    private long b(long j) {
        long j2 = 0;
        while (this.i < this.f.size() && j2 < j) {
            long j3 = j - j2;
            long e = e();
            if (j3 < e) {
                this.h = (int) (this.h + j3);
                j2 += j3;
            } else {
                j2 += e;
                this.h = 0;
                this.i++;
            }
        }
        return j2;
    }

    private void c() {
        if (this.g) {
            throw new IOException("Stream already closed");
        }
        if (!this.l) {
            throw new IOException("Reader needs to be frozen before read operations can be called");
        }
    }

    private String d() {
        if (this.i < this.f.size()) {
            return this.f.get(this.i);
        }
        return null;
    }

    private int e() {
        String d2 = d();
        if (d2 == null) {
            return 0;
        }
        return d2.length() - this.h;
    }

    public void a(String str) {
        if (this.l) {
            throw new IllegalStateException("Trying to add string after reading");
        }
        if (str.length() > 0) {
            this.f.add(str);
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c();
        this.g = true;
    }

    public void f() {
        if (this.l) {
            throw new IllegalStateException("Trying to freeze frozen StringListReader");
        }
        this.l = true;
    }

    @Override // java.io.Reader
    public void mark(int i) {
        c();
        this.j = this.h;
        this.k = this.i;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public int read() {
        c();
        String d2 = d();
        if (d2 == null) {
            return -1;
        }
        char charAt = d2.charAt(this.h);
        b(1L);
        return charAt;
    }

    @Override // java.io.Reader, java.lang.Readable
    public int read(CharBuffer charBuffer) {
        c();
        int remaining = charBuffer.remaining();
        String d2 = d();
        int i = 0;
        while (remaining > 0 && d2 != null) {
            int min = Math.min(d2.length() - this.h, remaining);
            int i2 = this.h;
            charBuffer.put(this.f.get(this.i), i2, i2 + min);
            remaining -= min;
            i += min;
            b(min);
            d2 = d();
        }
        if (i > 0 || d2 != null) {
            return i;
        }
        return -1;
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i, int i2) {
        c();
        String d2 = d();
        int i3 = 0;
        while (d2 != null && i3 < i2) {
            int min = Math.min(e(), i2 - i3);
            int i4 = this.h;
            d2.getChars(i4, i4 + min, cArr, i + i3);
            i3 += min;
            b(min);
            d2 = d();
        }
        if (i3 > 0 || d2 != null) {
            return i3;
        }
        return -1;
    }

    @Override // java.io.Reader
    public boolean ready() {
        c();
        return true;
    }

    @Override // java.io.Reader
    public void reset() {
        this.h = this.j;
        this.i = this.k;
    }

    @Override // java.io.Reader
    public long skip(long j) {
        c();
        return b(j);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.f) {
            sb.append(str);
        }
        return sb.toString();
    }
}
