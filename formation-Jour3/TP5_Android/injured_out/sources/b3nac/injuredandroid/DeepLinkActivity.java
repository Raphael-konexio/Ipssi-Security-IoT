package b3nac.injuredandroid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.l;
/* loaded from: classes.dex */
public final class DeepLinkActivity extends androidx.appcompat.app.c {
    private com.google.firebase.database.d A;
    private com.google.firebase.database.d B;
    private int w;
    private FirebaseAuth y;
    private final String x = "DeepLinkActivity";
    private final String z = "/binary";

    /* loaded from: classes.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (DeepLinkActivity.this.H() == 0) {
                Snackbar X = Snackbar.X(view, "This is one part of the puzzle.", 0);
                X.Y("Action", null);
                X.N();
                DeepLinkActivity deepLinkActivity = DeepLinkActivity.this;
                deepLinkActivity.I(deepLinkActivity.H() + 1);
            } else if (DeepLinkActivity.this.H() == 1) {
                Snackbar X2 = Snackbar.X(view, "Find the compiled treasure.", 0);
                X2.Y("Action", null);
                X2.N();
                DeepLinkActivity.this.I(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b<TResult> implements b.c.a.a.f.c<Object> {
        b() {
        }

        @Override // b.c.a.a.f.c
        public final void a(b.c.a.a.f.g<Object> gVar) {
            DeepLinkActivity deepLinkActivity;
            String str;
            d.s.d.g.e(gVar, "task");
            if (gVar.l()) {
                deepLinkActivity = DeepLinkActivity.this;
                str = "Authentication succeeded.";
            } else {
                deepLinkActivity = DeepLinkActivity.this;
                str = "Authentication failed.";
            }
            Toast.makeText(deepLinkActivity, str, 0).show();
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements l {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1448b;

        c(String str) {
            this.f1448b = str;
        }

        @Override // com.google.firebase.database.l
        public void a(com.google.firebase.database.b bVar) {
            d.s.d.g.e(bVar, "databaseError");
            Log.e(DeepLinkActivity.this.x, "onCancelled", bVar.g());
        }

        @Override // com.google.firebase.database.l
        public void b(com.google.firebase.database.a aVar) {
            d.s.d.g.e(aVar, "dataSnapshot");
            if (!d.s.d.g.a(this.f1448b, (String) aVar.c())) {
                Toast.makeText(DeepLinkActivity.this, "Try again! :D", 0).show();
                return;
            }
            new FlagsOverview().G(true);
            j jVar = new j();
            Context applicationContext = DeepLinkActivity.this.getApplicationContext();
            d.s.d.g.d(applicationContext, "applicationContext");
            jVar.b(applicationContext, "flagElevenButtonColor", true);
            DeepLinkActivity.this.G();
        }
    }

    public DeepLinkActivity() {
        com.google.firebase.database.f b2 = com.google.firebase.database.f.b();
        d.s.d.g.d(b2, "FirebaseDatabase.getInstance()");
        com.google.firebase.database.d d2 = b2.d();
        d.s.d.g.d(d2, "FirebaseDatabase.getInstance().reference");
        this.A = d2;
        com.google.firebase.database.d h = d2.h(this.z);
        d.s.d.g.d(h, "database.child(refDirectory)");
        this.B = h;
    }

    public final void G() {
        startActivity(new Intent(this, FlagOneSuccess.class));
    }

    public final int H() {
        return this.w;
    }

    public final void I(int i) {
        this.w = i;
    }

    public final void J() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        this.y = firebaseAuth;
        d.s.d.g.c(firebaseAuth);
        firebaseAuth.d().b(this, new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_deep_link);
        j.j.a(this);
        Intent intent = getIntent();
        d.s.d.g.d(intent, "intentToUri");
        Uri data = intent.getData();
        if (d.s.d.g.a("flag11", data != null ? data.getScheme() : null)) {
            startActivity(new Intent("android.intent.action.VIEW"));
        }
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new a());
    }

    public final void submitFlag(View view) {
        EditText editText = (EditText) findViewById(R.id.editText5);
        d.s.d.g.d(editText, "editText5");
        String obj = editText.getText().toString();
        J();
        this.B.b(new c(obj));
    }
}
