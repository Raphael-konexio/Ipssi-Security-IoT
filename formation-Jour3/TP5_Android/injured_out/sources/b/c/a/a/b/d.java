package b.c.a.a.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.app.h;
import com.google.android.gms.common.api.GoogleApiActivity;
/* loaded from: classes.dex */
public class d extends e {

    /* renamed from: d  reason: collision with root package name */
    private static final Object f1214d = new Object();
    private static final d e = new d();

    /* renamed from: c  reason: collision with root package name */
    private String f1215c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends b.c.a.a.d.a.d {

        /* renamed from: a  reason: collision with root package name */
        private final Context f1216a;

        public a(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.f1216a = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                StringBuilder sb = new StringBuilder(50);
                sb.append("Don't know how to handle this message: ");
                sb.append(i);
                Log.w("GoogleApiAvailability", sb.toString());
                return;
            }
            int f = d.this.f(this.f1216a);
            if (d.this.h(f)) {
                d.this.n(this.f1216a, f);
            }
        }
    }

    public static d l() {
        return e;
    }

    static Dialog o(Context context, int i, com.google.android.gms.common.internal.f fVar, DialogInterface.OnCancelListener onCancelListener) {
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        AlertDialog.Builder builder = "Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId)) ? new AlertDialog.Builder(context, 5) : null;
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(com.google.android.gms.common.internal.e.d(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String c2 = com.google.android.gms.common.internal.e.c(context, i);
        if (c2 != null) {
            builder.setPositiveButton(c2, fVar);
        }
        String g = com.google.android.gms.common.internal.e.g(context, i);
        if (g != null) {
            builder.setTitle(g);
        }
        return builder.create();
    }

    static void p(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof androidx.fragment.app.d) {
            j.B1(dialog, onCancelListener).A1(((androidx.fragment.app.d) activity).n(), str);
            return;
        }
        b.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    private final void r(Context context, int i, String str, PendingIntent pendingIntent) {
        int i2;
        if (i == 18) {
            q(context);
        } else if (pendingIntent == null) {
            if (i == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            }
        } else {
            String f = com.google.android.gms.common.internal.e.f(context, i);
            String e2 = com.google.android.gms.common.internal.e.e(context, i);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            h.d dVar = new h.d(context);
            dVar.k(true);
            dVar.e(true);
            dVar.i(f);
            h.b bVar = new h.b();
            bVar.h(e2);
            dVar.n(bVar);
            if (com.google.android.gms.common.util.g.b(context)) {
                com.google.android.gms.common.internal.r.j(com.google.android.gms.common.util.i.e());
                dVar.m(context.getApplicationInfo().icon);
                dVar.l(2);
                if (com.google.android.gms.common.util.g.c(context)) {
                    dVar.a(b.c.a.a.a.a.common_full_open_on_phone, resources.getString(b.c.a.a.a.b.common_open_on_phone), pendingIntent);
                } else {
                    dVar.g(pendingIntent);
                }
            } else {
                dVar.m(17301642);
                dVar.o(resources.getString(b.c.a.a.a.b.common_google_play_services_notification_ticker));
                dVar.p(System.currentTimeMillis());
                dVar.g(pendingIntent);
                dVar.h(e2);
            }
            if (com.google.android.gms.common.util.i.h()) {
                com.google.android.gms.common.internal.r.j(com.google.android.gms.common.util.i.h());
                String t = t();
                if (t == null) {
                    t = "com.google.android.gms.availability";
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                    String b2 = com.google.android.gms.common.internal.e.b(context);
                    if (notificationChannel == null) {
                        notificationChannel = new NotificationChannel("com.google.android.gms.availability", b2, 4);
                    } else if (!b2.contentEquals(notificationChannel.getName())) {
                        notificationChannel.setName(b2);
                    }
                    notificationManager.createNotificationChannel(notificationChannel);
                }
                dVar.f(t);
            }
            Notification b3 = dVar.b();
            if (i == 1 || i == 2 || i == 3) {
                i2 = 10436;
                g.f1221b.set(false);
            } else {
                i2 = 39789;
            }
            notificationManager.notify(i2, b3);
        }
    }

    private final String t() {
        String str;
        synchronized (f1214d) {
            str = this.f1215c;
        }
        return str;
    }

    @Override // b.c.a.a.b.e
    public Intent a(Context context, int i, String str) {
        return super.a(context, i, str);
    }

    @Override // b.c.a.a.b.e
    public PendingIntent b(Context context, int i, int i2) {
        return super.b(context, i, i2);
    }

    @Override // b.c.a.a.b.e
    public final String d(int i) {
        return super.d(i);
    }

    @Override // b.c.a.a.b.e
    public int f(Context context) {
        return super.f(context);
    }

    @Override // b.c.a.a.b.e
    public int g(Context context, int i) {
        return super.g(context, i);
    }

    @Override // b.c.a.a.b.e
    public final boolean h(int i) {
        return super.h(i);
    }

    public Dialog j(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return o(activity, i, com.google.android.gms.common.internal.f.a(activity, a(activity, i, "d"), i2), onCancelListener);
    }

    public PendingIntent k(Context context, b.c.a.a.b.a aVar) {
        return aVar.j() ? aVar.h() : b(context, aVar.b(), 0);
    }

    public boolean m(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog j = j(activity, i, i2, onCancelListener);
        if (j == null) {
            return false;
        }
        p(activity, j, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void n(Context context, int i) {
        r(context, i, null, c(context, i, 0, "n"));
    }

    final void q(Context context) {
        new a(context).sendEmptyMessageDelayed(1, 120000L);
    }

    public final boolean s(Context context, b.c.a.a.b.a aVar, int i) {
        PendingIntent k = k(context, aVar);
        if (k != null) {
            r(context, aVar.b(), null, GoogleApiActivity.a(context, k, i));
            return true;
        }
        return false;
    }
}
