package a.g.k.b0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
/* loaded from: classes.dex */
public final class a extends ClickableSpan {
    private final int f;
    private final c g;
    private final int h;

    public a(int i, c cVar, int i2) {
        this.f = i;
        this.g = cVar;
        this.h = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f);
        this.g.N(this.h, bundle);
    }
}
