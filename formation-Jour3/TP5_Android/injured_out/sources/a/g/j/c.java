package a.g.j;

import android.util.Log;
import java.io.Writer;
@Deprecated
/* loaded from: classes.dex */
public class c extends Writer {
    private final String f;
    private StringBuilder g = new StringBuilder(128);

    public c(String str) {
        this.f = str;
    }

    private void a() {
        if (this.g.length() > 0) {
            Log.d(this.f, this.g.toString());
            StringBuilder sb = this.g;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = cArr[i + i3];
            if (c2 == '\n') {
                a();
            } else {
                this.g.append(c2);
            }
        }
    }
}
