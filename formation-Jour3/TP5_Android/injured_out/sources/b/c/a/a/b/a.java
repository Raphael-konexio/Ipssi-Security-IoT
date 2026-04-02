package b.c.a.a.b;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.q;
/* loaded from: classes.dex */
public final class a extends com.google.android.gms.common.internal.w.a {
    private final int f;
    private final int g;
    private final PendingIntent h;
    private final String i;
    public static final a j = new a(0);
    public static final Parcelable.Creator<a> CREATOR = new n();

    public a(int i) {
        this(i, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f = i;
        this.g = i2;
        this.h = pendingIntent;
        this.i = str;
    }

    public a(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public a(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String n(int i) {
        if (i != 99) {
            if (i != 1500) {
                switch (i) {
                    case -1:
                        return "UNKNOWN";
                    case 0:
                        return "SUCCESS";
                    case 1:
                        return "SERVICE_MISSING";
                    case 2:
                        return "SERVICE_VERSION_UPDATE_REQUIRED";
                    case 3:
                        return "SERVICE_DISABLED";
                    case 4:
                        return "SIGN_IN_REQUIRED";
                    case 5:
                        return "INVALID_ACCOUNT";
                    case 6:
                        return "RESOLUTION_REQUIRED";
                    case 7:
                        return "NETWORK_ERROR";
                    case 8:
                        return "INTERNAL_ERROR";
                    case 9:
                        return "SERVICE_INVALID";
                    case 10:
                        return "DEVELOPER_ERROR";
                    case 11:
                        return "LICENSE_CHECK_FAILED";
                    default:
                        switch (i) {
                            case 13:
                                return "CANCELED";
                            case 14:
                                return "TIMEOUT";
                            case 15:
                                return "INTERRUPTED";
                            case 16:
                                return "API_UNAVAILABLE";
                            case 17:
                                return "SIGN_IN_FAILED";
                            case 18:
                                return "SERVICE_UPDATING";
                            case 19:
                                return "SERVICE_MISSING_PERMISSION";
                            case 20:
                                return "RESTRICTED_PROFILE";
                            case 21:
                                return "API_VERSION_UPDATE_REQUIRED";
                            default:
                                StringBuilder sb = new StringBuilder(31);
                                sb.append("UNKNOWN_ERROR_CODE(");
                                sb.append(i);
                                sb.append(")");
                                return sb.toString();
                        }
                }
            }
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        return "UNFINISHED";
    }

    public final int b() {
        return this.g;
    }

    public final String c() {
        return this.i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.g == aVar.g && com.google.android.gms.common.internal.q.a(this.h, aVar.h) && com.google.android.gms.common.internal.q.a(this.i, aVar.i);
        }
        return false;
    }

    public final PendingIntent h() {
        return this.h;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.b(Integer.valueOf(this.g), this.h, this.i);
    }

    public final boolean j() {
        return (this.g == 0 || this.h == null) ? false : true;
    }

    public final boolean k() {
        return this.g == 0;
    }

    public final String toString() {
        q.a c2 = com.google.android.gms.common.internal.q.c(this);
        c2.a("statusCode", n(this.g));
        c2.a("resolution", this.h);
        c2.a("message", this.i);
        return c2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.g(parcel, 1, this.f);
        com.google.android.gms.common.internal.w.c.g(parcel, 2, b());
        com.google.android.gms.common.internal.w.c.j(parcel, 3, h(), i, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 4, c(), false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
