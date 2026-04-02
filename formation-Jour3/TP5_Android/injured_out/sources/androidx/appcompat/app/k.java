package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import java.util.Calendar;
/* loaded from: classes.dex */
class k {

    /* renamed from: d  reason: collision with root package name */
    private static k f522d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f523a;

    /* renamed from: b  reason: collision with root package name */
    private final LocationManager f524b;

    /* renamed from: c  reason: collision with root package name */
    private final a f525c = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f526a;

        /* renamed from: b  reason: collision with root package name */
        long f527b;

        /* renamed from: c  reason: collision with root package name */
        long f528c;

        /* renamed from: d  reason: collision with root package name */
        long f529d;
        long e;
        long f;

        a() {
        }
    }

    k(Context context, LocationManager locationManager) {
        this.f523a = context;
        this.f524b = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k a(Context context) {
        if (f522d == null) {
            Context applicationContext = context.getApplicationContext();
            f522d = new k(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f522d;
    }

    private Location b() {
        Location c2 = androidx.core.content.c.b(this.f523a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location c3 = androidx.core.content.c.b(this.f523a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        return (c3 == null || c2 == null) ? c3 != null ? c3 : c2 : c3.getTime() > c2.getTime() ? c3 : c2;
    }

    private Location c(String str) {
        try {
            if (this.f524b.isProviderEnabled(str)) {
                return this.f524b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    private boolean e() {
        return this.f525c.f > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j;
        a aVar = this.f525c;
        long currentTimeMillis = System.currentTimeMillis();
        j b2 = j.b();
        b2.a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = b2.f519a;
        b2.a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = b2.f521c == 1;
        long j3 = b2.f520b;
        long j4 = b2.f519a;
        boolean z2 = z;
        b2.a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = b2.f520b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = (currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
        }
        aVar.f526a = z2;
        aVar.f527b = j2;
        aVar.f528c = j3;
        aVar.f529d = j4;
        aVar.e = j5;
        aVar.f = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        a aVar = this.f525c;
        if (e()) {
            return aVar.f526a;
        }
        Location b2 = b();
        if (b2 != null) {
            f(b2);
            return aVar.f526a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
