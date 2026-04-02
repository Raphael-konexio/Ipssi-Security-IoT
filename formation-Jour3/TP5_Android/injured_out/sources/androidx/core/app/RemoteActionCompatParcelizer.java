package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(androidx.versionedparcelable.a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f698a = (IconCompat) aVar.v(remoteActionCompat.f698a, 1);
        remoteActionCompat.f699b = aVar.l(remoteActionCompat.f699b, 2);
        remoteActionCompat.f700c = aVar.l(remoteActionCompat.f700c, 3);
        remoteActionCompat.f701d = (PendingIntent) aVar.r(remoteActionCompat.f701d, 4);
        remoteActionCompat.e = aVar.h(remoteActionCompat.e, 5);
        remoteActionCompat.f = aVar.h(remoteActionCompat.f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(false, false);
        aVar.M(remoteActionCompat.f698a, 1);
        aVar.D(remoteActionCompat.f699b, 2);
        aVar.D(remoteActionCompat.f700c, 3);
        aVar.H(remoteActionCompat.f701d, 4);
        aVar.z(remoteActionCompat.e, 5);
        aVar.z(remoteActionCompat.f, 6);
    }
}
