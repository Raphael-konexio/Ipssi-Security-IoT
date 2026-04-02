package b3nac.injuredandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
/* loaded from: classes.dex */
public final class QXV0aA extends androidx.appcompat.app.c {
    private FirebaseAuth w;

    /* loaded from: classes.dex */
    static final class a<TResult> implements b.c.a.a.f.c<Object> {
        a() {
        }

        @Override // b.c.a.a.f.c
        public final void a(b.c.a.a.f.g<Object> gVar) {
            QXV0aA qXV0aA;
            String str;
            d.s.d.g.e(gVar, "task");
            if (gVar.l()) {
                qXV0aA = QXV0aA.this;
                str = "Authentication succeeded.";
            } else {
                qXV0aA = QXV0aA.this;
                str = "Authentication failed.";
            }
            Toast.makeText(qXV0aA, str, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_qxv0a);
    }

    public final void signInAnonymously(View view) {
        d.s.d.g.e(view, "view");
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        this.w = firebaseAuth;
        d.s.d.g.c(firebaseAuth);
        firebaseAuth.d().b(this, new a());
    }
}
