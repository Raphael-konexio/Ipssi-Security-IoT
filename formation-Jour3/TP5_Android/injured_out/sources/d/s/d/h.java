package d.s.d;

import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class h<R> implements f<R>, Serializable {
    public h(int i) {
    }

    public String toString() {
        String d2 = m.d(this);
        g.d(d2, "Reflection.renderLambdaToString(this)");
        return d2;
    }
}
