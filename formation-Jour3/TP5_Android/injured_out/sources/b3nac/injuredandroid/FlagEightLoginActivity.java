package b3nac.injuredandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.l;
/* loaded from: classes.dex */
public final class FlagEightLoginActivity extends androidx.appcompat.app.c {
    private int w;
    private com.google.firebase.database.d x;
    private com.google.firebase.database.d y;

    /* loaded from: classes.dex */
    static final class a<TResult> implements b.c.a.a.f.c<Object> {
        a() {
        }

        @Override // b.c.a.a.f.c
        public final void a(b.c.a.a.f.g<Object> gVar) {
            d.s.d.g.e(gVar, "task");
            if (gVar.l()) {
                Log.d("FlagEightLoginActivity", "signInAnonymously:success");
                return;
            }
            Log.w("FlagEightLoginActivity", "signInAnonymously:failure", gVar.i());
            Toast.makeText(FlagEightLoginActivity.this, "Authentication failed.", 0).show();
        }
    }

    /* loaded from: classes.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (FlagEightLoginActivity.this.H() == 0) {
                d.s.d.g.c(view);
                Snackbar X = Snackbar.X(view, "AWS CLI.", 0);
                X.Y("Action", null);
                X.N();
                FlagEightLoginActivity flagEightLoginActivity = FlagEightLoginActivity.this;
                flagEightLoginActivity.I(flagEightLoginActivity.H() + 1);
            } else if (FlagEightLoginActivity.this.H() == 1) {
                d.s.d.g.c(view);
                Snackbar X2 = Snackbar.X(view, "AWS profiles and credentials.", 0);
                X2.Y("Action", null);
                X2.N();
                FlagEightLoginActivity.this.I(0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements l {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1451b;

        c(String str) {
            this.f1451b = str;
        }

        @Override // com.google.firebase.database.l
        public void a(com.google.firebase.database.b bVar) {
            d.s.d.g.e(bVar, "databaseError");
            Log.e("FlagEightLoginActivity", "onCancelled", bVar.g());
        }

        @Override // com.google.firebase.database.l
        public void b(com.google.firebase.database.a aVar) {
            d.s.d.g.e(aVar, "dataSnapshot");
            if (!d.s.d.g.a(this.f1451b, (String) aVar.c())) {
                Toast.makeText(FlagEightLoginActivity.this, "Try again! :D", 0).show();
                return;
            }
            FlagsOverview.I = true;
            j jVar = new j();
            Context applicationContext = FlagEightLoginActivity.this.getApplicationContext();
            d.s.d.g.d(applicationContext, "applicationContext");
            jVar.b(applicationContext, "flagEightButtonColor", true);
            FlagEightLoginActivity.this.G();
        }
    }

    public FlagEightLoginActivity() {
        com.google.firebase.database.f b2 = com.google.firebase.database.f.b();
        d.s.d.g.d(b2, "FirebaseDatabase.getInstance()");
        com.google.firebase.database.d d2 = b2.d();
        d.s.d.g.d(d2, "FirebaseDatabase.getInstance().reference");
        this.x = d2;
        com.google.firebase.database.d h = d2.h("/aws");
        d.s.d.g.d(h, "database.child(\"/aws\")");
        this.y = h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        startActivity(new Intent(this, FlagOneSuccess.class));
    }

    public final int H() {
        return this.w;
    }

    public final void I(int i) {
        this.w = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_flag_eight_login);
        j.j.a(this);
        C((Toolbar) findViewById(R.id.toolbar));
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        d.s.d.g.d(firebaseAuth, "FirebaseAuth.getInstance()");
        firebaseAuth.d().b(this, new a());
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new b());
    }

    public final void submitFlag(View view) {
        EditText editText = (EditText) findViewById(R.id.editText9);
        d.s.d.g.d(editText, "editText2");
        this.y.b(new c(editText.getText().toString()));
    }
}
