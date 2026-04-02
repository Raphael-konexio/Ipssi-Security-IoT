package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f707a;

        /* renamed from: b  reason: collision with root package name */
        private IconCompat f708b;

        /* renamed from: c  reason: collision with root package name */
        private final l[] f709c;

        /* renamed from: d  reason: collision with root package name */
        private final l[] f710d;
        private boolean e;
        boolean f;
        private final int g;
        private final boolean h;
        @Deprecated
        public int i;
        public CharSequence j;
        public PendingIntent k;

        public a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i != 0 ? IconCompat.b(null, "", i) : null, charSequence, pendingIntent);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, l[] lVarArr, l[] lVarArr2, boolean z, int i, boolean z2, boolean z3) {
            this.f = true;
            this.f708b = iconCompat;
            if (iconCompat != null && iconCompat.g() == 2) {
                this.i = iconCompat.c();
            }
            this.j = d.d(charSequence);
            this.k = pendingIntent;
            this.f707a = bundle == null ? new Bundle() : bundle;
            this.f709c = lVarArr;
            this.f710d = lVarArr2;
            this.e = z;
            this.g = i;
            this.f = z2;
            this.h = z3;
        }

        public PendingIntent a() {
            return this.k;
        }

        public boolean b() {
            return this.e;
        }

        public l[] c() {
            return this.f710d;
        }

        public Bundle d() {
            return this.f707a;
        }

        public IconCompat e() {
            int i;
            if (this.f708b == null && (i = this.i) != 0) {
                this.f708b = IconCompat.b(null, "", i);
            }
            return this.f708b;
        }

        public l[] f() {
            return this.f709c;
        }

        public int g() {
            return this.g;
        }

        public boolean h() {
            return this.f;
        }

        public CharSequence i() {
            return this.j;
        }

        public boolean j() {
            return this.h;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends e {
        private CharSequence e;

        @Override // androidx.core.app.h.e
        public void a(Bundle bundle) {
            super.a(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.e);
            }
        }

        @Override // androidx.core.app.h.e
        public void b(g gVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(gVar.a()).setBigContentTitle(this.f716b).bigText(this.e);
                if (this.f718d) {
                    bigText.setSummaryText(this.f717c);
                }
            }
        }

        @Override // androidx.core.app.h.e
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public b h(CharSequence charSequence) {
            this.e = d.d(charSequence);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a {
            static Notification.BubbleMetadata a(c cVar) {
                if (cVar == null || cVar.f() == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setIcon(cVar.e().n()).setIntent(cVar.f()).setDeleteIntent(cVar.b()).setAutoExpandBubble(cVar.a()).setSuppressNotification(cVar.h());
                if (cVar.c() != 0) {
                    suppressNotification.setDesiredHeight(cVar.c());
                }
                if (cVar.d() != 0) {
                    suppressNotification.setDesiredHeightResId(cVar.d());
                }
                return suppressNotification.build();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class b {
            static Notification.BubbleMetadata a(c cVar) {
                if (cVar == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder builder = cVar.g() != null ? new Notification.BubbleMetadata.Builder(cVar.g()) : new Notification.BubbleMetadata.Builder(cVar.f(), cVar.e().n());
                builder.setDeleteIntent(cVar.b()).setAutoExpandBubble(cVar.a()).setSuppressNotification(cVar.h());
                if (cVar.c() != 0) {
                    builder.setDesiredHeight(cVar.c());
                }
                if (cVar.d() != 0) {
                    builder.setDesiredHeightResId(cVar.d());
                }
                return builder.build();
            }
        }

        public static Notification.BubbleMetadata i(c cVar) {
            if (cVar == null) {
                return null;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                return b.a(cVar);
            }
            if (i == 29) {
                return a.a(cVar);
            }
            return null;
        }

        public abstract boolean a();

        public abstract PendingIntent b();

        public abstract int c();

        public abstract int d();

        public abstract IconCompat e();

        public abstract PendingIntent f();

        public abstract String g();

        public abstract boolean h();
    }

    /* loaded from: classes.dex */
    public static class d {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        androidx.core.content.b N;
        long O;
        int P;
        boolean Q;
        c R;
        Notification S;
        boolean T;
        Icon U;
        @Deprecated
        public ArrayList<String> V;

        /* renamed from: a  reason: collision with root package name */
        public Context f711a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f712b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<k> f713c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<a> f714d;
        CharSequence e;
        CharSequence f;
        PendingIntent g;
        PendingIntent h;
        RemoteViews i;
        Bitmap j;
        CharSequence k;
        int l;
        int m;
        boolean n;
        boolean o;
        e p;
        CharSequence q;
        CharSequence r;
        CharSequence[] s;
        int t;
        int u;
        boolean v;
        String w;
        boolean x;
        String y;
        boolean z;

        @Deprecated
        public d(Context context) {
            this(context, null);
        }

        public d(Context context, String str) {
            this.f712b = new ArrayList<>();
            this.f713c = new ArrayList<>();
            this.f714d = new ArrayList<>();
            this.n = true;
            this.z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.S = notification;
            this.f711a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.S.audioStreamType = -1;
            this.m = 0;
            this.V = new ArrayList<>();
            this.Q = true;
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private void j(int i, boolean z) {
            Notification notification;
            int i2;
            if (z) {
                notification = this.S;
                i2 = i | notification.flags;
            } else {
                notification = this.S;
                i2 = (~i) & notification.flags;
            }
            notification.flags = i2;
        }

        public d a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f712b.add(new a(i, charSequence, pendingIntent));
            return this;
        }

        public Notification b() {
            return new i(this).c();
        }

        public Bundle c() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public d e(boolean z) {
            j(16, z);
            return this;
        }

        public d f(String str) {
            this.K = str;
            return this;
        }

        public d g(PendingIntent pendingIntent) {
            this.g = pendingIntent;
            return this;
        }

        public d h(CharSequence charSequence) {
            this.f = d(charSequence);
            return this;
        }

        public d i(CharSequence charSequence) {
            this.e = d(charSequence);
            return this;
        }

        public d k(boolean z) {
            this.z = z;
            return this;
        }

        public d l(int i) {
            this.m = i;
            return this;
        }

        public d m(int i) {
            this.S.icon = i;
            return this;
        }

        public d n(e eVar) {
            if (this.p != eVar) {
                this.p = eVar;
                if (eVar != null) {
                    eVar.g(this);
                }
            }
            return this;
        }

        public d o(CharSequence charSequence) {
            this.S.tickerText = d(charSequence);
            return this;
        }

        public d p(long j) {
            this.S.when = j;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        protected d f715a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f716b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f717c;

        /* renamed from: d  reason: collision with root package name */
        boolean f718d = false;

        public void a(Bundle bundle) {
            if (this.f718d) {
                bundle.putCharSequence("android.summaryText", this.f717c);
            }
            CharSequence charSequence = this.f716b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String c2 = c();
            if (c2 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c2);
            }
        }

        public abstract void b(g gVar);

        protected abstract String c();

        public RemoteViews d(g gVar) {
            return null;
        }

        public RemoteViews e(g gVar) {
            return null;
        }

        public RemoteViews f(g gVar) {
            return null;
        }

        public void g(d dVar) {
            if (this.f715a != dVar) {
                this.f715a = dVar;
                if (dVar != null) {
                    dVar.n(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return notification.extras;
        }
        if (i >= 16) {
            return j.c(notification);
        }
        return null;
    }
}
