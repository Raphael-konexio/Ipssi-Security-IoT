package b.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import b.b.d;
import c.a.c.a.h;
import c.a.c.a.i;
import c.a.c.a.k;
import c.a.c.a.m;
import java.util.Map;
/* loaded from: classes.dex */
public class b implements i.c, k {

    /* renamed from: c  reason: collision with root package name */
    static i f1203c;

    /* renamed from: a  reason: collision with root package name */
    private Activity f1204a;

    /* renamed from: b  reason: collision with root package name */
    private d f1205b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements ValueCallback<Boolean> {
        a(b bVar) {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(Boolean bool) {
        }
    }

    private b(Activity activity) {
        this.f1204a = activity;
    }

    private void c(h hVar, i.d dVar) {
        d dVar2 = this.f1205b;
        if (dVar2 != null) {
            dVar2.e(hVar, dVar);
        }
    }

    private FrameLayout.LayoutParams d(h hVar) {
        Map map = (Map) hVar.a("rect");
        if (map != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(g(this.f1204a, ((Number) map.get("width")).intValue()), g(this.f1204a, ((Number) map.get("height")).intValue()));
            layoutParams.setMargins(g(this.f1204a, ((Number) map.get("left")).intValue()), g(this.f1204a, ((Number) map.get("top")).intValue()), 0, 0);
            return layoutParams;
        }
        Display defaultDisplay = this.f1204a.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return new FrameLayout.LayoutParams(point.x, point.y);
    }

    private void e(h hVar, i.d dVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().removeAllCookies(new a(this));
        } else {
            CookieManager.getInstance().removeAllCookie();
        }
        dVar.c(null);
    }

    private void f(h hVar, i.d dVar) {
        d dVar2 = this.f1205b;
        if (dVar2 != null) {
            dVar2.i(hVar, dVar);
            this.f1205b = null;
        }
    }

    private int g(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void h(h hVar, i.d dVar) {
        d dVar2 = this.f1205b;
        if (dVar2 != null) {
            dVar2.j(hVar, dVar);
        }
    }

    private void i(h hVar, i.d dVar) {
        d dVar2 = this.f1205b;
        if (dVar2 != null) {
            dVar2.k(hVar, dVar);
        }
    }

    private void j(h hVar, i.d dVar) {
        d dVar2 = this.f1205b;
        if (dVar2 != null) {
            dVar2.l(hVar, dVar);
        }
    }

    private void k(h hVar, i.d dVar) {
        boolean booleanValue = ((Boolean) hVar.a("hidden")).booleanValue();
        String str = (String) hVar.a("url");
        String str2 = (String) hVar.a("userAgent");
        boolean booleanValue2 = ((Boolean) hVar.a("withJavascript")).booleanValue();
        boolean booleanValue3 = ((Boolean) hVar.a("clearCache")).booleanValue();
        boolean booleanValue4 = ((Boolean) hVar.a("clearCookies")).booleanValue();
        boolean booleanValue5 = ((Boolean) hVar.a("withZoom")).booleanValue();
        boolean booleanValue6 = ((Boolean) hVar.a("withLocalStorage")).booleanValue();
        boolean booleanValue7 = ((Boolean) hVar.a("supportMultipleWindows")).booleanValue();
        boolean booleanValue8 = ((Boolean) hVar.a("appCacheEnabled")).booleanValue();
        Map<String, String> map = (Map) hVar.a("headers");
        boolean booleanValue9 = ((Boolean) hVar.a("scrollBar")).booleanValue();
        boolean booleanValue10 = ((Boolean) hVar.a("allowFileURLs")).booleanValue();
        d dVar2 = this.f1205b;
        if (dVar2 == null || dVar2.f1208c) {
            this.f1205b = new d(this.f1204a);
        }
        this.f1204a.addContentView(this.f1205b.f1209d, d(hVar));
        this.f1205b.m(booleanValue2, booleanValue3, booleanValue, booleanValue4, str2, str, map, booleanValue5, booleanValue6, booleanValue9, booleanValue7, booleanValue8, booleanValue10);
        dVar.c(null);
    }

    public static void l(m mVar) {
        f1203c = new i(mVar.h(), "flutter_webview_plugin");
        b bVar = new b(mVar.g());
        mVar.a(bVar);
        f1203c.e(bVar);
    }

    private void m(h hVar, i.d dVar) {
        d dVar2 = this.f1205b;
        if (dVar2 != null) {
            dVar2.n(hVar, dVar);
        }
    }

    private void n(h hVar, i.d dVar) {
        if (this.f1205b != null) {
            this.f1205b.o((String) hVar.a("url"));
        }
    }

    private void o(h hVar, i.d dVar) {
        if (this.f1205b != null) {
            this.f1205b.p(d(hVar));
        }
        dVar.c(null);
    }

    private void p(h hVar, i.d dVar) {
        d dVar2 = this.f1205b;
        if (dVar2 != null) {
            dVar2.q(hVar, dVar);
        }
    }

    private void q(h hVar, i.d dVar) {
        d dVar2 = this.f1205b;
        if (dVar2 != null) {
            dVar2.r(hVar, dVar);
        }
    }

    @Override // c.a.c.a.k
    public boolean a(int i, int i2, Intent intent) {
        d.f fVar;
        d dVar = this.f1205b;
        if (dVar == null || (fVar = dVar.e) == null) {
            return false;
        }
        return fVar.a(i, i2, intent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // c.a.c.a.i.c
    public void b(h hVar, i.d dVar) {
        char c2;
        String str = hVar.f1490a;
        switch (str.hashCode()) {
            case -1747898362:
                if (str.equals("cleanCookies")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case -1109843021:
                if (str.equals("launch")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -948122918:
                if (str.equals("stopLoading")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case -934641255:
                if (str.equals("reload")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -934437708:
                if (str.equals("resize")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -677145915:
                if (str.equals("forward")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 3015911:
                if (str.equals("back")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 3125404:
                if (str.equals("eval")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 3202370:
                if (str.equals("hide")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 3529469:
                if (str.equals("show")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case 94756344:
                if (str.equals("close")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 375437590:
                if (str.equals("reloadUrl")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                k(hVar, dVar);
                return;
            case 1:
                f(hVar, dVar);
                return;
            case 2:
                h(hVar, dVar);
                return;
            case 3:
                o(hVar, dVar);
                return;
            case 4:
                m(hVar, dVar);
                return;
            case 5:
                c(hVar, dVar);
                return;
            case 6:
                i(hVar, dVar);
                return;
            case 7:
                j(hVar, dVar);
                return;
            case '\b':
                p(hVar, dVar);
                return;
            case '\t':
                n(hVar, dVar);
                return;
            case '\n':
                q(hVar, dVar);
                return;
            case 11:
                e(hVar, dVar);
                return;
            default:
                dVar.a();
                return;
        }
    }
}
