package com.google.firebase.auth.internal;
/* loaded from: classes.dex */
final class i implements Runnable {
    private final /* synthetic */ FederatedSignInActivity f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FederatedSignInActivity federatedSignInActivity) {
        this.f = federatedSignInActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f.v();
        FederatedSignInActivity.u(null);
    }
}
