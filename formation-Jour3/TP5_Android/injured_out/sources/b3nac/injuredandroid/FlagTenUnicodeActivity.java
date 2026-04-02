package b3nac.injuredandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.l;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
/* loaded from: classes.dex */
public final class FlagTenUnicodeActivity extends androidx.appcompat.app.c {
    private com.google.firebase.database.d A;
    private com.google.firebase.database.d B;
    private FirebaseAuth C;
    private int w;
    private final String x = "dW5pY29kZS8=";
    private byte[] y;
    private final String z;

    /* loaded from: classes.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (FlagTenUnicodeActivity.this.H() == 0) {
                Snackbar X = Snackbar.X(view, "Find the email address.", 0);
                X.Y("Action", null);
                X.N();
                FlagTenUnicodeActivity flagTenUnicodeActivity = FlagTenUnicodeActivity.this;
                flagTenUnicodeActivity.I(flagTenUnicodeActivity.H() + 1);
            } else if (FlagTenUnicodeActivity.this.H() == 1) {
                Snackbar X2 = Snackbar.X(view, "Cause a unicode collision.", 0);
                X2.Y("Action", null);
                X2.N();
                FlagTenUnicodeActivity.this.I(0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements l {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1462b;

        b(String str) {
            this.f1462b = str;
        }

        @Override // com.google.firebase.database.l
        public void a(com.google.firebase.database.b bVar) {
            d.s.d.g.e(bVar, "databaseError");
            Toast.makeText(FlagTenUnicodeActivity.this, "User not logged in!", 0).show();
        }

        @Override // com.google.firebase.database.l
        public void b(com.google.firebase.database.a aVar) {
            FlagTenUnicodeActivity flagTenUnicodeActivity;
            String str;
            d.s.d.g.e(aVar, "dataSnapshot");
            String str2 = (String) aVar.c();
            if (d.s.d.g.a(this.f1462b, str2)) {
                flagTenUnicodeActivity = FlagTenUnicodeActivity.this;
                str = "No cheating. :]";
            } else {
                String str3 = this.f1462b;
                Locale locale = Locale.ROOT;
                d.s.d.g.d(locale, "Locale.ROOT");
                if (str3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String upperCase = str3.toUpperCase(locale);
                d.s.d.g.d(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                d.s.d.g.c(str2);
                Locale locale2 = Locale.ROOT;
                d.s.d.g.d(locale2, "Locale.ROOT");
                if (str2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String upperCase2 = str2.toUpperCase(locale2);
                d.s.d.g.d(upperCase2, "(this as java.lang.String).toUpperCase(locale)");
                if (d.s.d.g.a(upperCase, upperCase2)) {
                    FlagTenUnicodeActivity.this.G();
                    return;
                } else {
                    flagTenUnicodeActivity = FlagTenUnicodeActivity.this;
                    str = "Try again! :D";
                }
            }
            Toast.makeText(flagTenUnicodeActivity, str, 0).show();
        }
    }

    public FlagTenUnicodeActivity() {
        byte[] decode = Base64.decode("dW5pY29kZS8=", 0);
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
        Intent intent = new Intent(this, FlagOneSuccess.class);
        new FlagsOverview().K(true);
        new j().b(this, "flagTenButtonColor", true);
        startActivity(intent);
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
        setContentView(R.layout.activity_flag_ten_unicode);
        j.j.a(this);
        C((Toolbar) findViewById(R.id.toolbar));
        this.C = FirebaseAuth.getInstance();
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new a());
    }

    public final void submitFlag(View view) {
        d.s.d.g.e(view, "view");
        FirebaseAuth firebaseAuth = this.C;
        if ((firebaseAuth != null ? firebaseAuth.c() : null) == null) {
            Toast.makeText(this, "Not authenticated!", 0).show();
            return;
        }
        EditText editText = (EditText) findViewById(R.id.editText4);
        d.s.d.g.d(editText, "editText");
        this.B.b(new b(editText.getText().toString()));
    }
}
