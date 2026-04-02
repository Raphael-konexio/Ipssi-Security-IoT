package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.h;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
class i implements g {

    /* renamed from: a  reason: collision with root package name */
    private final Notification.Builder f719a;

    /* renamed from: b  reason: collision with root package name */
    private final h.d f720b;

    /* renamed from: c  reason: collision with root package name */
    private RemoteViews f721c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f722d;
    private final List<Bundle> e = new ArrayList();
    private final Bundle f = new Bundle();
    private int g;
    private RemoteViews h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h.d dVar) {
        Icon icon;
        List<String> e;
        Bundle bundle;
        String str;
        this.f720b = dVar;
        Context context = dVar.f711a;
        this.f719a = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(dVar.f711a, dVar.K) : new Notification.Builder(dVar.f711a);
        Notification notification = dVar.S;
        this.f719a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.e).setContentText(dVar.f).setContentInfo(dVar.k).setContentIntent(dVar.g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.h, (notification.flags & 128) != 0).setLargeIcon(dVar.j).setNumber(dVar.l).setProgress(dVar.t, dVar.u, dVar.v);
        if (Build.VERSION.SDK_INT < 21) {
            this.f719a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f719a.setSubText(dVar.q).setUsesChronometer(dVar.o).setPriority(dVar.m);
            Iterator<h.a> it = dVar.f712b.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            Bundle bundle2 = dVar.D;
            if (bundle2 != null) {
                this.f.putAll(bundle2);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (dVar.z) {
                    this.f.putBoolean("android.support.localOnly", true);
                }
                String str2 = dVar.w;
                if (str2 != null) {
                    this.f.putString("android.support.groupKey", str2);
                    if (dVar.x) {
                        bundle = this.f;
                        str = "android.support.isGroupSummary";
                    } else {
                        bundle = this.f;
                        str = "android.support.useSideChannel";
                    }
                    bundle.putBoolean(str, true);
                }
                String str3 = dVar.y;
                if (str3 != null) {
                    this.f.putString("android.support.sortKey", str3);
                }
            }
            this.f721c = dVar.H;
            this.f722d = dVar.I;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.f719a.setShowWhen(dVar.n);
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 19 && i < 21 && (e = e(f(dVar.f713c), dVar.V)) != null && !e.isEmpty()) {
            this.f.putStringArray("android.people", (String[]) e.toArray(new String[e.size()]));
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f719a.setLocalOnly(dVar.z).setGroup(dVar.w).setGroupSummary(dVar.x).setSortKey(dVar.y);
            this.g = dVar.P;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f719a.setCategory(dVar.C).setColor(dVar.E).setVisibility(dVar.F).setPublicVersion(dVar.G).setSound(notification.sound, notification.audioAttributes);
            List<String> e2 = Build.VERSION.SDK_INT < 28 ? e(f(dVar.f713c), dVar.V) : dVar.V;
            if (e2 != null && !e2.isEmpty()) {
                for (String str4 : e2) {
                    this.f719a.addPerson(str4);
                }
            }
            this.h = dVar.J;
            if (dVar.f714d.size() > 0) {
                Bundle bundle3 = dVar.c().getBundle("android.car.EXTENSIONS");
                bundle3 = bundle3 == null ? new Bundle() : bundle3;
                Bundle bundle4 = new Bundle(bundle3);
                Bundle bundle5 = new Bundle();
                for (int i2 = 0; i2 < dVar.f714d.size(); i2++) {
                    bundle5.putBundle(Integer.toString(i2), j.b(dVar.f714d.get(i2)));
                }
                bundle3.putBundle("invisible_actions", bundle5);
                bundle4.putBundle("invisible_actions", bundle5);
                dVar.c().putBundle("android.car.EXTENSIONS", bundle3);
                this.f.putBundle("android.car.EXTENSIONS", bundle4);
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && (icon = dVar.U) != null) {
            this.f719a.setSmallIcon(icon);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f719a.setExtras(dVar.D).setRemoteInputHistory(dVar.s);
            RemoteViews remoteViews = dVar.H;
            if (remoteViews != null) {
                this.f719a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = dVar.I;
            if (remoteViews2 != null) {
                this.f719a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = dVar.J;
            if (remoteViews3 != null) {
                this.f719a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f719a.setBadgeIconType(dVar.L).setSettingsText(dVar.r).setShortcutId(dVar.M).setTimeoutAfter(dVar.O).setGroupAlertBehavior(dVar.P);
            if (dVar.B) {
                this.f719a.setColorized(dVar.A);
            }
            if (!TextUtils.isEmpty(dVar.K)) {
                this.f719a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (Build.VERSION.SDK_INT >= 28) {
            Iterator<k> it2 = dVar.f713c.iterator();
            while (it2.hasNext()) {
                this.f719a.addPerson(it2.next().h());
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f719a.setAllowSystemGeneratedContextualActions(dVar.Q);
            this.f719a.setBubbleMetadata(h.c.i(dVar.R));
            androidx.core.content.b bVar = dVar.N;
            if (bVar != null) {
                this.f719a.setLocusId(bVar.a());
            }
        }
        if (dVar.T) {
            if (this.f720b.x) {
                this.g = 2;
            } else {
                this.g = 1;
            }
            this.f719a.setVibrate(null);
            this.f719a.setSound(null);
            int i3 = notification.defaults & (-2);
            notification.defaults = i3;
            int i4 = i3 & (-3);
            notification.defaults = i4;
            this.f719a.setDefaults(i4);
            if (Build.VERSION.SDK_INT >= 26) {
                if (TextUtils.isEmpty(this.f720b.w)) {
                    this.f719a.setGroup("silent");
                }
                this.f719a.setGroupAlertBehavior(this.g);
            }
        }
    }

    private void b(h.a aVar) {
        int i = Build.VERSION.SDK_INT;
        if (i < 20) {
            if (i >= 16) {
                this.e.add(j.f(this.f719a, aVar));
                return;
            }
            return;
        }
        IconCompat e = aVar.e();
        Notification.Action.Builder builder = Build.VERSION.SDK_INT >= 23 ? new Notification.Action.Builder(e != null ? e.n() : null, aVar.i(), aVar.a()) : new Notification.Action.Builder(e != null ? e.c() : 0, aVar.i(), aVar.a());
        if (aVar.f() != null) {
            for (RemoteInput remoteInput : l.b(aVar.f())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        if (Build.VERSION.SDK_INT >= 24) {
            builder.setAllowGeneratedReplies(aVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", aVar.g());
        if (Build.VERSION.SDK_INT >= 28) {
            builder.setSemanticAction(aVar.g());
        }
        if (Build.VERSION.SDK_INT >= 29) {
            builder.setContextual(aVar.j());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.h());
        builder.addExtras(bundle);
        this.f719a.addAction(builder.build());
    }

    private static List<String> e(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        a.d.b bVar = new a.d.b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    private static List<String> f(List<k> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (k kVar : list) {
            arrayList.add(kVar.g());
        }
        return arrayList;
    }

    private void g(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i = notification.defaults & (-2);
        notification.defaults = i;
        notification.defaults = i & (-3);
    }

    @Override // androidx.core.app.g
    public Notification.Builder a() {
        return this.f719a;
    }

    public Notification c() {
        Bundle a2;
        RemoteViews f;
        RemoteViews d2;
        h.e eVar = this.f720b.p;
        if (eVar != null) {
            eVar.b(this);
        }
        RemoteViews e = eVar != null ? eVar.e(this) : null;
        Notification d3 = d();
        if (e != null || (e = this.f720b.H) != null) {
            d3.contentView = e;
        }
        if (Build.VERSION.SDK_INT >= 16 && eVar != null && (d2 = eVar.d(this)) != null) {
            d3.bigContentView = d2;
        }
        if (Build.VERSION.SDK_INT >= 21 && eVar != null && (f = this.f720b.p.f(this)) != null) {
            d3.headsUpContentView = f;
        }
        if (Build.VERSION.SDK_INT >= 16 && eVar != null && (a2 = h.a(d3)) != null) {
            eVar.a(a2);
        }
        return d3;
    }

    protected Notification d() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            return this.f719a.build();
        }
        if (i >= 24) {
            Notification build = this.f719a.build();
            if (this.g != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.g == 2) {
                    g(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.g == 1) {
                    g(build);
                }
            }
            return build;
        } else if (i >= 21) {
            this.f719a.setExtras(this.f);
            Notification build2 = this.f719a.build();
            RemoteViews remoteViews = this.f721c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f722d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.g != 0) {
                if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.g == 2) {
                    g(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.g == 1) {
                    g(build2);
                }
            }
            return build2;
        } else if (i >= 20) {
            this.f719a.setExtras(this.f);
            Notification build3 = this.f719a.build();
            RemoteViews remoteViews4 = this.f721c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f722d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.g != 0) {
                if (build3.getGroup() != null && (build3.flags & 512) != 0 && this.g == 2) {
                    g(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.g == 1) {
                    g(build3);
                }
            }
            return build3;
        } else if (i >= 19) {
            SparseArray<Bundle> a2 = j.a(this.e);
            if (a2 != null) {
                this.f.putSparseParcelableArray("android.support.actionExtras", a2);
            }
            this.f719a.setExtras(this.f);
            Notification build4 = this.f719a.build();
            RemoteViews remoteViews6 = this.f721c;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f722d;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (i >= 16) {
            Notification build5 = this.f719a.build();
            Bundle a3 = h.a(build5);
            Bundle bundle = new Bundle(this.f);
            for (String str : this.f.keySet()) {
                if (a3.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a3.putAll(bundle);
            SparseArray<Bundle> a4 = j.a(this.e);
            if (a4 != null) {
                h.a(build5).putSparseParcelableArray("android.support.actionExtras", a4);
            }
            RemoteViews remoteViews8 = this.f721c;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f722d;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        } else {
            return this.f719a.getNotification();
        }
    }
}
