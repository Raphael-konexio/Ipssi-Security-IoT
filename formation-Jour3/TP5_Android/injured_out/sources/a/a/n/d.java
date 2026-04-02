package a.a.n;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private int f17a;

    /* renamed from: b  reason: collision with root package name */
    private Resources.Theme f18b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f19c;

    /* renamed from: d  reason: collision with root package name */
    private Configuration f20d;
    private Resources e;

    public d() {
        super(null);
    }

    public d(Context context, int i) {
        super(context);
        this.f17a = i;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f18b = theme;
    }

    private Resources a() {
        Resources resources;
        if (this.e == null) {
            Configuration configuration = this.f20d;
            if (configuration == null) {
                resources = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                resources = createConfigurationContext(configuration).getResources();
            }
            this.e = resources;
        }
        return this.e;
    }

    private void c() {
        boolean z = this.f18b == null;
        if (z) {
            this.f18b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f18b.setTo(theme);
            }
        }
        d(this.f18b, this.f17a, z);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int b() {
        return this.f17a;
    }

    protected void d(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return a();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f19c == null) {
                this.f19c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f19c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f18b;
        if (theme != null) {
            return theme;
        }
        if (this.f17a == 0) {
            this.f17a = a.a.i.Theme_AppCompat_Light;
        }
        c();
        return this.f18b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f17a != i) {
            this.f17a = i;
            c();
        }
    }
}
