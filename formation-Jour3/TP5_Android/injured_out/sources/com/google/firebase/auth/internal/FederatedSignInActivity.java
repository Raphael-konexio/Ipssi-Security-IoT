package com.google.firebase.auth.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
@KeepName
/* loaded from: classes.dex */
public class FederatedSignInActivity extends androidx.fragment.app.d {
    private static long v;
    private static final h w = h.a();
    private static Handler x;
    private static Runnable y;
    private boolean u = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Runnable u(Runnable runnable) {
        y = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        v = 0L;
        this.u = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (a.m.a.a.b(this).d(intent)) {
            w.b(this);
        } else {
            n.c(this, m0.a("WEB_CONTEXT_CANCELED"));
        }
        finish();
    }

    private final void w(Status status) {
        v = 0L;
        this.u = false;
        Intent intent = new Intent();
        t.a(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (a.m.a.a.b(this).d(intent)) {
            w.b(this);
        } else {
            n.c(getApplicationContext(), status);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.SIGN_IN".equals(action) && !"com.google.firebase.auth.internal.LINK".equals(action) && !"com.google.firebase.auth.internal.REAUTHENTICATE".equals(action)) {
            String valueOf = String.valueOf(action);
            Log.e("IdpSignInActivity", valueOf.length() != 0 ? "Could not do operation - unknown action: ".concat(valueOf) : new String("Could not do operation - unknown action: "));
            v();
            return;
        }
        long a2 = com.google.android.gms.common.util.f.b().a();
        if (a2 - v < 30000) {
            Log.e("IdpSignInActivity", "Could not start operation - already in progress");
            return;
        }
        v = a2;
        if (bundle != null) {
            this.u = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
        }
    }

    @Override // androidx.fragment.app.d, android.app.Activity
    public void onNewIntent(Intent intent) {
        Runnable runnable;
        super.onNewIntent(intent);
        Handler handler = x;
        if (handler != null && (runnable = y) != null) {
            handler.removeCallbacks(runnable);
            y = null;
        }
        setIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a0  */
    @Override // androidx.fragment.app.d, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onResume() {
        /*
            r10 = this;
            super.onResume()
            android.content.Intent r0 = r10.getIntent()
            java.lang.String r1 = r0.getAction()
            java.lang.String r2 = "com.google.firebase.auth.internal.WEB_SIGN_IN_FAILED"
            boolean r1 = r2.equals(r1)
            java.lang.String r2 = "IdpSignInActivity"
            r3 = 0
            r4 = 1
            java.lang.String r5 = "com.google.firebase.auth.internal.OPERATION"
            if (r1 == 0) goto L31
            java.lang.String r1 = "Web sign-in failed, finishing"
            android.util.Log.e(r2, r1)
            boolean r1 = com.google.firebase.auth.internal.t.b(r0)
            if (r1 == 0) goto L2c
            com.google.android.gms.common.api.Status r0 = com.google.firebase.auth.internal.t.c(r0)
            r10.w(r0)
            goto L2f
        L2c:
            r10.v()
        L2f:
            r3 = 1
            goto L9d
        L31:
            boolean r1 = r0.hasExtra(r5)
            if (r1 == 0) goto L9d
            java.lang.String r1 = "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST"
            boolean r6 = r0.hasExtra(r1)
            if (r6 == 0) goto L9d
            java.lang.String r6 = r0.getStringExtra(r5)
            java.lang.String r7 = "com.google.firebase.auth.internal.SIGN_IN"
            boolean r7 = r7.equals(r6)
            if (r7 != 0) goto L5b
            java.lang.String r7 = "com.google.firebase.auth.internal.LINK"
            boolean r7 = r7.equals(r6)
            if (r7 != 0) goto L5b
            java.lang.String r7 = "com.google.firebase.auth.internal.REAUTHENTICATE"
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L9d
        L5b:
            android.os.Parcelable$Creator<b.c.a.a.d.c.a2> r7 = b.c.a.a.d.c.a2.CREATOR
            com.google.android.gms.common.internal.w.d r7 = com.google.android.gms.common.internal.w.e.b(r0, r1, r7)
            b.c.a.a.d.c.a2 r7 = (b.c.a.a.d.c.a2) r7
            java.lang.String r8 = "com.google.firebase.auth.internal.EXTRA_TENANT_ID"
            java.lang.String r0 = r0.getStringExtra(r8)
            r7.c(r0)
            r8 = 0
            com.google.firebase.auth.internal.FederatedSignInActivity.v = r8
            r10.u = r3
            android.content.Intent r3 = new android.content.Intent
            r3.<init>()
            com.google.android.gms.common.internal.w.e.e(r7, r3, r1)
            r3.putExtra(r5, r6)
            java.lang.String r1 = "com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"
            r3.setAction(r1)
            a.m.a.a r1 = a.m.a.a.b(r10)
            boolean r1 = r1.d(r3)
            if (r1 != 0) goto L94
            android.content.Context r1 = r10.getApplicationContext()
            com.google.firebase.auth.internal.n.d(r1, r7, r6, r0)
            goto L99
        L94:
            com.google.firebase.auth.internal.h r0 = com.google.firebase.auth.internal.FederatedSignInActivity.w
            r0.b(r10)
        L99:
            r10.finish()
            goto L2f
        L9d:
            if (r3 == 0) goto La0
            return
        La0:
            boolean r0 = r10.u
            if (r0 != 0) goto Ldf
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.google.firebase.auth.api.gms.ui.START_WEB_SIGN_IN"
            r0.<init>(r1)
            java.lang.String r1 = "com.google.android.gms"
            r0.setPackage(r1)
            android.content.Intent r1 = r10.getIntent()
            android.os.Bundle r1 = r1.getExtras()
            r0.putExtras(r1)
            android.content.Intent r1 = r10.getIntent()
            java.lang.String r1 = r1.getAction()
            r0.putExtra(r5, r1)
            r1 = 40963(0xa003, float:5.7401E-41)
            r10.startActivityForResult(r0, r1)     // Catch: android.content.ActivityNotFoundException -> Lcd
            goto Ldc
        Lcd:
            java.lang.String r0 = "Could not launch web sign-in Intent. Google Play service is unavailable"
            android.util.Log.w(r2, r0)
            com.google.android.gms.common.api.Status r1 = new com.google.android.gms.common.api.Status
            r2 = 17499(0x445b, float:2.4521E-41)
            r1.<init>(r2, r0)
            r10.w(r1)
        Ldc:
            r10.u = r4
            return
        Ldf:
            com.google.firebase.auth.internal.i r0 = new com.google.firebase.auth.internal.i
            r0.<init>(r10)
            com.google.firebase.auth.internal.FederatedSignInActivity.y = r0
            android.os.Handler r0 = com.google.firebase.auth.internal.FederatedSignInActivity.x
            if (r0 != 0) goto Lf1
            b.c.a.a.d.c.g2 r0 = new b.c.a.a.d.c.g2
            r0.<init>()
            com.google.firebase.auth.internal.FederatedSignInActivity.x = r0
        Lf1:
            android.os.Handler r0 = com.google.firebase.auth.internal.FederatedSignInActivity.x
            java.lang.Runnable r1 = com.google.firebase.auth.internal.FederatedSignInActivity.y
            r2 = 800(0x320, double:3.953E-321)
            r0.postDelayed(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.FederatedSignInActivity.onResume():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.u);
    }
}
