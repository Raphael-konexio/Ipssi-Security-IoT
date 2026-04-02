package b3nac.injuredandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.l;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
/* loaded from: classes.dex */
public final class FlagNineFirebaseActivity extends androidx.appcompat.app.c {
    private com.google.firebase.database.d A;
    private com.google.firebase.database.d B;
    private int w;
    private final String x = "ZmxhZ3Mv";
    private byte[] y;
    private final String z;

    /* loaded from: classes.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String str;
            if (FlagNineFirebaseActivity.this.H() == 0) {
                d.s.d.g.c(view);
                str = "Use the .json trick with database url";
            } else if (FlagNineFirebaseActivity.this.H() != 1) {
                if (FlagNineFirebaseActivity.this.H() == 2) {
                    d.s.d.g.c(view);
                    Snackbar X = Snackbar.X(view, "Encoding.", 0);
                    X.Y("Action", null);
                    X.N();
                    FlagNineFirebaseActivity.this.I(0);
                    return;
                }
                return;
            } else {
                d.s.d.g.c(view);
                str = "Filenames.";
            }
            Snackbar X2 = Snackbar.X(view, str, 0);
            X2.Y("Action", null);
            X2.N();
            FlagNineFirebaseActivity flagNineFirebaseActivity = FlagNineFirebaseActivity.this;
            flagNineFirebaseActivity.I(flagNineFirebaseActivity.H() + 1);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements l {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1456b;

        b(String str) {
            this.f1456b = str;
        }

        @Override // com.google.firebase.database.l
        public void a(com.google.firebase.database.b bVar) {
            d.s.d.g.e(bVar, "databaseError");
            Log.e("FirebaseActivity", "onCancelled", bVar.g());
        }

        @Override // com.google.firebase.database.l
        public void b(com.google.firebase.database.a aVar) {
            d.s.d.g.e(aVar, "dataSnapshot");
            if (!d.s.d.g.a(this.f1456b, (String) aVar.c())) {
                Toast.makeText(FlagNineFirebaseActivity.this, "Try again! :D", 0).show();
                return;
            }
            FlagsOverview.J = true;
            j jVar = new j();
            Context applicationContext = FlagNineFirebaseActivity.this.getApplicationContext();
            d.s.d.g.d(applicationContext, "applicationContext");
            jVar.b(applicationContext, "flagNineButtonColor", true);
            FlagNineFirebaseActivity.this.G();
        }
    }

    public FlagNineFirebaseActivity() {
        byte[] decode = Base64.decode("ZmxhZ3Mv", 0);
        this.y = decode;
        d.s.d.g.d(decode, "decodedDirectory");
        Charset charset = StandardCharsets.UTF_8;
        d.s.d.g.d(charset, "StandardCharsets.UTF_8");
        this.z = new String(decode, charset);
        com.google.firebase.database.f b2 = com.google.firebase.database.f.b();
        d.s.d.g.d(b2, "FirebaseDatabase.getInstance()");
        com.google.firebase.database.d d2 = b2.d();
        d.s.d.g.d(d2, "FirebaseDatabase.getInstance().reference");
        this.A = d2;
        com.google.firebase.database.d h = d2.h(this.z);
        d.s.d.g.d(h, "database.child(refDirectory)");
        this.B = h;
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
        setContentView(R.layout.activity_flag_nine_firebase);
        j.j.a(this);
        C((Toolbar) findViewById(R.id.toolbar));
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new a());
    }

    public final void submitFlag(View view) {
        EditText editText = (EditText) findViewById(R.id.editText2);
        d.s.d.g.d(editText, "editText2");
        byte[] decode = Base64.decode(editText.getText().toString(), 0);
        d.s.d.g.d(decode, "decodedPost");
        Charset charset = StandardCharsets.UTF_8;
        d.s.d.g.d(charset, "StandardCharsets.UTF_8");
        this.B.b(new b(new String(decode, charset)));
    }
}
