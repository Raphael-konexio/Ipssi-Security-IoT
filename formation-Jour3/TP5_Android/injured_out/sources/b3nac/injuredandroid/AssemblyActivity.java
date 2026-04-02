package b3nac.injuredandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.l;
import java.nio.charset.Charset;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class AssemblyActivity extends androidx.appcompat.app.c {
    private int w;
    private com.google.firebase.database.d x;
    private com.google.firebase.database.d y;
    private final String z;

    /* loaded from: classes.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String str;
            int I = AssemblyActivity.this.I();
            if (I == 0) {
                d.s.d.g.c(view);
                str = "Covert the byte array to a string.";
            } else if (I != 1) {
                if (I != 2) {
                    return;
                }
                d.s.d.g.c(view);
                Snackbar X = Snackbar.X(view, "Reverse the XOR string.", 0);
                X.Y("Action", null);
                X.N();
                AssemblyActivity.this.J(0);
                return;
            } else {
                d.s.d.g.c(view);
                str = "Disassemble Shared Object file to find the XOR key.";
            }
            Snackbar X2 = Snackbar.X(view, str, 0);
            X2.Y("Action", null);
            X2.N();
            AssemblyActivity assemblyActivity = AssemblyActivity.this;
            assemblyActivity.J(assemblyActivity.I() + 1);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements l {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1441b;

        b(String str) {
            this.f1441b = str;
        }

        @Override // com.google.firebase.database.l
        public void a(com.google.firebase.database.b bVar) {
            d.s.d.g.e(bVar, "databaseError");
            Log.e("Access denied", "onCancelled", bVar.g());
        }

        @Override // com.google.firebase.database.l
        public void b(com.google.firebase.database.a aVar) {
            d.s.d.g.e(aVar, "dataSnapshot");
            if (!d.s.d.g.a(this.f1441b, (String) aVar.c())) {
                Toast.makeText(AssemblyActivity.this, "Try again! :D", 0).show();
                return;
            }
            FlagsOverview.M = true;
            j jVar = new j();
            Context applicationContext = AssemblyActivity.this.getApplicationContext();
            d.s.d.g.d(applicationContext, "applicationContext");
            jVar.b(applicationContext, "flagFifteenButtonColor", true);
            AssemblyActivity.this.H();
        }
    }

    static {
        System.loadLibrary("native-lib");
    }

    public AssemblyActivity() {
        com.google.firebase.database.f b2 = com.google.firebase.database.f.b();
        d.s.d.g.d(b2, "FirebaseDatabase.getInstance()");
        com.google.firebase.database.d d2 = b2.d();
        d.s.d.g.d(d2, "FirebaseDatabase.getInstance().reference");
        this.x = d2;
        com.google.firebase.database.d h = d2.h("/assembly");
        d.s.d.g.d(h, "database.child(\"/assembly\")");
        this.y = h;
        this.z = stringFromJNI();
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
        setContentView(R.layout.activity_assembly);
        j.j.a(this);
        TextView textView = (TextView) findViewById(R.id.textView10);
        C((Toolbar) findViewById(R.id.toolbar));
        G();
        Charset charset = d.w.c.f2418a;
        String str = this.z;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        d.s.d.g.d(bytes, "(this as java.lang.String).getBytes(charset)");
        d.s.d.g.d(textView, "tv");
        String arrays = Arrays.toString(bytes);
        d.s.d.g.d(arrays, "java.util.Arrays.toString(this)");
        textView.setText(arrays);
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new a());
    }

    public final native String stringFromJNI();

    public final void submitFlag(View view) {
        EditText editText = (EditText) findViewById(R.id.enterFlag);
        d.s.d.g.d(editText, "editText2");
        this.y.b(new b(editText.getText().toString()));
    }
}
