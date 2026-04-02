package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class n implements Iterable<Intent> {
    private final ArrayList<Intent> f = new ArrayList<>();
    private final Context g;

    /* loaded from: classes.dex */
    public interface a {
        Intent e();
    }

    private n(Context context) {
        this.g = context;
    }

    public static n i(Context context) {
        return new n(context);
    }

    public n d(Intent intent) {
        this.f.add(intent);
        return this;
    }

    public n e(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.g.getPackageManager());
        }
        if (component != null) {
            g(component);
        }
        d(intent);
        return this;
    }

    public n f(Activity activity) {
        Intent e = activity instanceof a ? ((a) activity).e() : null;
        if (e == null) {
            e = f.a(activity);
        }
        if (e != null) {
            ComponentName component = e.getComponent();
            if (component == null) {
                component = e.resolveActivity(this.g.getPackageManager());
            }
            g(component);
            d(e);
        }
        return this;
    }

    public n g(ComponentName componentName) {
        int size = this.f.size();
        try {
            Context context = this.g;
            while (true) {
                Intent b2 = f.b(context, componentName);
                if (b2 == null) {
                    return this;
                }
                this.f.add(size, b2);
                context = this.g;
                componentName = b2.getComponent();
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f.iterator();
    }

    public void l() {
        m(null);
    }

    public void m(Bundle bundle) {
        if (this.f.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        ArrayList<Intent> arrayList = this.f;
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (androidx.core.content.a.h(this.g, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.g.startActivity(intent);
    }
}
