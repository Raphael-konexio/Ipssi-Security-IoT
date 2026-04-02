package io.flutter.plugin.platform;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.recyclerview.widget.RecyclerView;
import io.flutter.embedding.engine.i.h;
import java.io.FileNotFoundException;
import java.util.List;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f2639a;

    /* renamed from: b  reason: collision with root package name */
    private final io.flutter.embedding.engine.i.h f2640b;

    /* renamed from: c  reason: collision with root package name */
    private final c f2641c;

    /* renamed from: d  reason: collision with root package name */
    private h.j f2642d;
    private int e;
    final h.InterfaceC0122h f;

    /* loaded from: classes.dex */
    class a implements h.InterfaceC0122h {
        a() {
        }

        @Override // io.flutter.embedding.engine.i.h.InterfaceC0122h
        public void b() {
            d.this.m();
        }

        @Override // io.flutter.embedding.engine.i.h.InterfaceC0122h
        public void c(h.i iVar) {
            d.this.l(iVar);
        }

        @Override // io.flutter.embedding.engine.i.h.InterfaceC0122h
        public void d(List<h.k> list) {
            d.this.q(list);
        }

        @Override // io.flutter.embedding.engine.i.h.InterfaceC0122h
        public void e() {
            d.this.n();
        }

        @Override // io.flutter.embedding.engine.i.h.InterfaceC0122h
        public void f(String str) {
            d.this.o(str);
        }

        @Override // io.flutter.embedding.engine.i.h.InterfaceC0122h
        public void g(h.j jVar) {
            d.this.s(jVar);
        }

        @Override // io.flutter.embedding.engine.i.h.InterfaceC0122h
        public void h(int i) {
            d.this.r(i);
        }

        @Override // io.flutter.embedding.engine.i.h.InterfaceC0122h
        public void i(h.c cVar) {
            d.this.p(cVar);
        }

        @Override // io.flutter.embedding.engine.i.h.InterfaceC0122h
        public void j(h.g gVar) {
            d.this.u(gVar);
        }

        @Override // io.flutter.embedding.engine.i.h.InterfaceC0122h
        public boolean k() {
            CharSequence k = d.this.k(h.e.PLAIN_TEXT);
            return k != null && k.length() > 0;
        }

        @Override // io.flutter.embedding.engine.i.h.InterfaceC0122h
        public CharSequence l(h.e eVar) {
            return d.this.k(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2644a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2645b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f2646c;

        static {
            int[] iArr = new int[h.d.values().length];
            f2646c = iArr;
            try {
                iArr[h.d.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2646c[h.d.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[h.k.values().length];
            f2645b = iArr2;
            try {
                iArr2[h.k.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2645b[h.k.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[h.g.values().length];
            f2644a = iArr3;
            try {
                iArr3[h.g.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2644a[h.g.LIGHT_IMPACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2644a[h.g.MEDIUM_IMPACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2644a[h.g.HEAVY_IMPACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2644a[h.g.SELECTION_CLICK.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean b();
    }

    public d(Activity activity, io.flutter.embedding.engine.i.h hVar, c cVar) {
        a aVar = new a();
        this.f = aVar;
        this.f2639a = activity;
        this.f2640b = hVar;
        hVar.j(aVar);
        this.f2641c = cVar;
        this.e = 1280;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence k(h.e eVar) {
        ClipboardManager clipboardManager = (ClipboardManager) this.f2639a.getSystemService("clipboard");
        if (clipboardManager.hasPrimaryClip()) {
            try {
                ClipData primaryClip = clipboardManager.getPrimaryClip();
                if (primaryClip == null) {
                    return null;
                }
                if (eVar != null && eVar != h.e.PLAIN_TEXT) {
                    return null;
                }
                ClipData.Item itemAt = primaryClip.getItemAt(0);
                if (itemAt.getUri() != null) {
                    this.f2639a.getContentResolver().openTypedAssetFileDescriptor(itemAt.getUri(), "text/*", null);
                }
                return itemAt.coerceToText(this.f2639a);
            } catch (FileNotFoundException unused) {
                return null;
            } catch (SecurityException e) {
                c.a.b.f("PlatformPlugin", "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", e);
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(h.i iVar) {
        if (iVar == h.i.CLICK) {
            this.f2639a.getWindow().getDecorView().playSoundEffect(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        c cVar = this.f2641c;
        if (cVar == null || !cVar.b()) {
            Activity activity = this.f2639a;
            if (activity instanceof androidx.activity.c) {
                ((androidx.activity.c) activity).i().c();
            } else {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str) {
        ((ClipboardManager) this.f2639a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(h.c cVar) {
        int i = Build.VERSION.SDK_INT;
        if (i < 21) {
            return;
        }
        if (i < 28 && i > 21) {
            this.f2639a.setTaskDescription(new ActivityManager.TaskDescription(cVar.f2548b, (Bitmap) null, cVar.f2547a));
        }
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2639a.setTaskDescription(new ActivityManager.TaskDescription(cVar.f2548b, 0, cVar.f2547a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(List<h.k> list) {
        int i = (list.size() != 0 || Build.VERSION.SDK_INT < 19) ? 1798 : 5894;
        for (int i2 = 0; i2 < list.size(); i2++) {
            int i3 = b.f2645b[list.get(i2).ordinal()];
            if (i3 == 1) {
                i &= -5;
            } else if (i3 == 2) {
                i = i & (-513) & (-3);
            }
        }
        this.e = i;
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i) {
        this.f2639a.setRequestedOrientation(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(h.j jVar) {
        Window window = this.f2639a.getWindow();
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= 26) {
            h.d dVar = jVar.f2552d;
            if (dVar != null) {
                int i = b.f2646c[dVar.ordinal()];
                if (i == 1) {
                    systemUiVisibility |= 16;
                } else if (i == 2) {
                    systemUiVisibility &= -17;
                }
            }
            Integer num = jVar.f2551c;
            if (num != null) {
                window.setNavigationBarColor(num.intValue());
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            h.d dVar2 = jVar.f2550b;
            if (dVar2 != null) {
                int i2 = b.f2646c[dVar2.ordinal()];
                if (i2 == 1) {
                    systemUiVisibility |= 8192;
                } else if (i2 == 2) {
                    systemUiVisibility &= -8193;
                }
            }
            Integer num2 = jVar.f2549a;
            if (num2 != null) {
                window.setStatusBarColor(num2.intValue());
            }
        }
        if (jVar.e != null && Build.VERSION.SDK_INT >= 28) {
            window.addFlags(RecyclerView.UNDEFINED_DURATION);
            window.clearFlags(134217728);
            window.setNavigationBarDividerColor(jVar.e.intValue());
        }
        decorView.setSystemUiVisibility(systemUiVisibility);
        this.f2642d = jVar;
    }

    public void j() {
        this.f2640b.j(null);
    }

    public void t() {
        this.f2639a.getWindow().getDecorView().setSystemUiVisibility(this.e);
        h.j jVar = this.f2642d;
        if (jVar != null) {
            s(jVar);
        }
    }

    void u(h.g gVar) {
        int i;
        View decorView = this.f2639a.getWindow().getDecorView();
        int i2 = b.f2644a[gVar.ordinal()];
        int i3 = 1;
        if (i2 != 1) {
            if (i2 != 2) {
                i3 = 3;
                if (i2 != 3) {
                    i3 = 4;
                    if (i2 != 4) {
                        if (i2 != 5 || Build.VERSION.SDK_INT < 21) {
                            return;
                        }
                    } else if (Build.VERSION.SDK_INT < 23) {
                        return;
                    } else {
                        i = 6;
                    }
                }
            }
            decorView.performHapticFeedback(i3);
            return;
        }
        i = 0;
        decorView.performHapticFeedback(i);
    }
}
