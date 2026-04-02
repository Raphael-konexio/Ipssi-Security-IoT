package b.c.c;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.l;
/* loaded from: classes.dex */
public class f implements l {
    @Override // com.google.android.gms.common.api.internal.l
    public Exception a(Status status) {
        return status.b() == 8 ? new e(status.j()) : new a(status.j());
    }
}
