package b.b;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes.dex */
public class c extends WebView {
    private a f;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, int i2, int i3, int i4);
    }

    public c(Context context) {
        super(context);
    }

    public a getOnScrollChangedCallback() {
        return this.f;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(i, i2, i3, i4);
        }
    }

    public void setOnScrollChangedCallback(a aVar) {
        this.f = aVar;
    }
}
