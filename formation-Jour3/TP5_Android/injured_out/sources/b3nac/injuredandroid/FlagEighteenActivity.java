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
public final class FlagEighteenActivity extends androidx.appcompat.app.c {
    private int w;
    private com.google.firebase.database.d x;
    private com.google.firebase.database.d y;

    /* loaded from: classes.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String str;
            if (FlagEighteenActivity.this.I() == 0) {
                d.s.d.g.c(view);
                str = "Use another activity to move the file!";
            } else if (FlagEighteenActivity.this.I() == 1) {
                d.s.d.g.c(view);
                str = "Use another Android app to access internal directories.";
            } else if (FlagEighteenActivity.this.I() != 2) {
                if (FlagEighteenActivity.this.I() == 3) {
                    d.s.d.g.c(view);
                    Snackbar X = Snackbar.X(view, "Hashes.", 0);
                    X.Y("Action", null);
                    X.N();
                    FlagEighteenActivity.this.J(0);
                    return;
                }
                return;
            } else {
                d.s.d.g.c(view);
                str = "Uri permissions.";
            }
            Snackbar X2 = Snackbar.X(view, str, 0);
            X2.Y("Action", null);
            X2.N();
            FlagEighteenActivity flagEighteenActivity = FlagEighteenActivity.this;
            flagEighteenActivity.J(flagEighteenActivity.I() + 1);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements l {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1453b;

        b(String str) {
            this.f1453b = str;
        }

        @Override // com.google.firebase.database.l
        public void a(com.google.firebase.database.b bVar) {
            d.s.d.g.e(bVar, "databaseError");
            Log.e("Access denied", "onCancelled", bVar.g());
        }

        @Override // com.google.firebase.database.l
        public void b(com.google.firebase.database.a aVar) {
            d.s.d.g.e(aVar, "dataSnapshot");
            if (!d.s.d.g.a(this.f1453b, (String) aVar.c())) {
                Toast.makeText(FlagEighteenActivity.this, "Try again! :D", 0).show();
                return;
            }
            FlagsOverview.P = true;
            j jVar = new j();
            Context applicationContext = FlagEighteenActivity.this.getApplicationContext();
            d.s.d.g.d(applicationContext, "applicationContext");
            jVar.b(applicationContext, "flagEighteenButtonColor", true);
            FlagEighteenActivity.this.H();
        }
    }

    public FlagEighteenActivity() {
        com.google.firebase.database.f b2 = com.google.firebase.database.f.b();
        d.s.d.g.d(b2, "FirebaseDatabase.getInstance()");
        com.google.firebase.database.d d2 = b2.d();
        d.s.d.g.d(d2, "FirebaseDatabase.getInstance().reference");
        this.x = d2;
        com.google.firebase.database.d h = d2.h("/fileprovider");
        d.s.d.g.d(h, "database.child(\"/fileprovider\")");
        this.y = h;
    }

    private final void G() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        d.s.d.g.d(firebaseAuth, "FirebaseAuth.getInstance()");
        firebaseAuth.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        startActivity(new Intent(this, FlagOneSuccess.class));
    }

    public final int I() {
        return this.w;
    }

    public final void J(int i) {
        this.w = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_flag_eighteen);
        C((Toolbar) findViewById(R.id.toolbar));
        j.j.a(this);
        setResult(-1, getIntent());
        G();
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new a());
    }

    public final void submitFlag(View view) {
        EditText editText = (EditText) findViewById(R.id.enterFlag);
        d.s.d.g.d(editText, "editText");
        this.y.b(new b(editText.getText().toString()));
    }
}
