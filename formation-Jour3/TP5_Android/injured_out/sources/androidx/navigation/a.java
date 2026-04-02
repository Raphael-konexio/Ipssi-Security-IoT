package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.navigation.r;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@r.b("activity")
/* loaded from: classes.dex */
public class a extends r<C0046a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f909a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f910b;

    /* renamed from: androidx.navigation.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0046a extends j {
        private Intent n;
        private String o;

        public C0046a(r<? extends C0046a> rVar) {
            super(rVar);
        }

        @Override // androidx.navigation.j
        boolean D() {
            return false;
        }

        public final String E() {
            Intent intent = this.n;
            if (intent == null) {
                return null;
            }
            return intent.getAction();
        }

        public final ComponentName F() {
            Intent intent = this.n;
            if (intent == null) {
                return null;
            }
            return intent.getComponent();
        }

        public final String G() {
            return this.o;
        }

        public final Intent H() {
            return this.n;
        }

        public final C0046a I(String str) {
            if (this.n == null) {
                this.n = new Intent();
            }
            this.n.setAction(str);
            return this;
        }

        public final C0046a J(ComponentName componentName) {
            if (this.n == null) {
                this.n = new Intent();
            }
            this.n.setComponent(componentName);
            return this;
        }

        public final C0046a K(Uri uri) {
            if (this.n == null) {
                this.n = new Intent();
            }
            this.n.setData(uri);
            return this;
        }

        public final C0046a L(String str) {
            this.o = str;
            return this;
        }

        public final C0046a M(String str) {
            if (this.n == null) {
                this.n = new Intent();
            }
            this.n.setPackage(str);
            return this;
        }

        @Override // androidx.navigation.j
        public String toString() {
            String E;
            ComponentName F = F();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (F == null) {
                E = E();
                if (E != null) {
                    sb.append(" action=");
                }
                return sb.toString();
            }
            sb.append(" class=");
            E = F.getClassName();
            sb.append(E);
            return sb.toString();
        }

        @Override // androidx.navigation.j
        public void y(Context context, AttributeSet attributeSet) {
            super.y(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, u.ActivityNavigator);
            String string = obtainAttributes.getString(u.ActivityNavigator_targetPackage);
            if (string != null) {
                string = string.replace("${applicationId}", context.getPackageName());
            }
            M(string);
            String string2 = obtainAttributes.getString(u.ActivityNavigator_android_name);
            if (string2 != null) {
                if (string2.charAt(0) == '.') {
                    string2 = context.getPackageName() + string2;
                }
                J(new ComponentName(context, string2));
            }
            I(obtainAttributes.getString(u.ActivityNavigator_action));
            String string3 = obtainAttributes.getString(u.ActivityNavigator_data);
            if (string3 != null) {
                K(Uri.parse(string3));
            }
            L(obtainAttributes.getString(u.ActivityNavigator_dataPattern));
            obtainAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements r.a {

        /* renamed from: a  reason: collision with root package name */
        private final int f911a;

        /* renamed from: b  reason: collision with root package name */
        private final androidx.core.app.b f912b;

        public androidx.core.app.b a() {
            return this.f912b;
        }

        public int b() {
            return this.f911a;
        }
    }

    public a(Context context) {
        this.f909a = context;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                this.f910b = (Activity) context;
                return;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
    }

    @Override // androidx.navigation.r
    public boolean e() {
        Activity activity = this.f910b;
        if (activity != null) {
            activity.finish();
            return true;
        }
        return false;
    }

    @Override // androidx.navigation.r
    /* renamed from: f */
    public C0046a a() {
        return new C0046a(this);
    }

    final Context g() {
        return this.f909a;
    }

    @Override // androidx.navigation.r
    /* renamed from: h */
    public j b(C0046a c0046a, Bundle bundle, o oVar, r.a aVar) {
        androidx.core.app.b a2;
        Intent intent;
        int intExtra;
        if (c0046a.H() == null) {
            throw new IllegalStateException("Destination " + c0046a.s() + " does not have an Intent set.");
        }
        Intent intent2 = new Intent(c0046a.H());
        if (bundle != null) {
            intent2.putExtras(bundle);
            String G = c0046a.G();
            if (!TextUtils.isEmpty(G)) {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(G);
                while (matcher.find()) {
                    String group = matcher.group(1);
                    if (!bundle.containsKey(group)) {
                        throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill data pattern " + G);
                    }
                    matcher.appendReplacement(stringBuffer, "");
                    stringBuffer.append(Uri.encode(bundle.get(group).toString()));
                }
                matcher.appendTail(stringBuffer);
                intent2.setData(Uri.parse(stringBuffer.toString()));
            }
        }
        boolean z = aVar instanceof b;
        if (z) {
            intent2.addFlags(((b) aVar).b());
        }
        if (!(this.f909a instanceof Activity)) {
            intent2.addFlags(268435456);
        }
        if (oVar != null && oVar.g()) {
            intent2.addFlags(536870912);
        }
        Activity activity = this.f910b;
        if (activity != null && (intent = activity.getIntent()) != null && (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) != 0) {
            intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
        }
        intent2.putExtra("android-support-navigation:ActivityNavigator:current", c0046a.s());
        Resources resources = g().getResources();
        if (oVar != null) {
            int c2 = oVar.c();
            int d2 = oVar.d();
            if ((c2 <= 0 || !resources.getResourceTypeName(c2).equals("animator")) && (d2 <= 0 || !resources.getResourceTypeName(d2).equals("animator"))) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", c2);
                intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", d2);
            } else {
                Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring popEnter resource " + resources.getResourceName(c2) + " and popExit resource " + resources.getResourceName(d2) + "when launching " + c0046a);
            }
        }
        if (!z || (a2 = ((b) aVar).a()) == null) {
            this.f909a.startActivity(intent2);
        } else {
            androidx.core.content.a.i(this.f909a, intent2, a2.a());
        }
        if (oVar == null || this.f910b == null) {
            return null;
        }
        int a3 = oVar.a();
        int b2 = oVar.b();
        if ((a3 <= 0 || !resources.getResourceTypeName(a3).equals("animator")) && (b2 <= 0 || !resources.getResourceTypeName(b2).equals("animator"))) {
            if (a3 >= 0 || b2 >= 0) {
                this.f910b.overridePendingTransition(Math.max(a3, 0), Math.max(b2, 0));
                return null;
            }
            return null;
        }
        Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring enter resource " + resources.getResourceName(a3) + " and exit resource " + resources.getResourceName(b2) + "when launching " + c0046a);
        return null;
    }
}
