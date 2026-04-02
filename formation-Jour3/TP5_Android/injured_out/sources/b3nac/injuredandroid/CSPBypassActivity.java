package b3nac.injuredandroid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import b.a.a.o;
import b.a.a.t;
import b.a.a.v.m;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.l;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class CSPBypassActivity extends androidx.appcompat.app.c {
    private HashMap A;
    private int w;
    private final String x = "/csp";
    private com.google.firebase.database.d y;
    private com.google.firebase.database.d z;

    /* loaded from: classes.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String str;
            int J = CSPBypassActivity.this.J();
            if (J == 0) {
                d.s.d.g.c(view);
                str = "Check protocols.";
            } else if (J != 1) {
                if (J != 2) {
                    return;
                }
                d.s.d.g.c(view);
                Snackbar X = Snackbar.X(view, "Monitor traffic.", 0);
                X.Y("Action", null);
                X.N();
                CSPBypassActivity.this.N(0);
                return;
            } else {
                d.s.d.g.c(view);
                str = "Deep links.";
            }
            Snackbar X2 = Snackbar.X(view, str, 0);
            X2.Y("Action", null);
            X2.N();
            CSPBypassActivity cSPBypassActivity = CSPBypassActivity.this;
            cSPBypassActivity.N(cSPBypassActivity.J() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b<T> implements o.b<String> {
        b() {
        }

        @Override // b.a.a.o.b
        /* renamed from: b */
        public final void a(String str) {
            TextView textView = (TextView) CSPBypassActivity.this.F(i.textView7);
            d.s.d.g.d(textView, "textView7");
            StringBuilder sb = new StringBuilder();
            sb.append("Response is: ");
            d.s.d.g.d(str, "response");
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = str.substring(0, 500);
            d.s.d.g.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            textView.setText(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c implements o.a {
        c() {
        }

        @Override // b.a.a.o.a
        public final void a(t tVar) {
            TextView textView = (TextView) CSPBypassActivity.this.F(i.textView7);
            d.s.d.g.d(textView, "textView7");
            textView.setText("Try another url! :D");
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements l {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1445b;

        d(String str) {
            this.f1445b = str;
        }

        @Override // com.google.firebase.database.l
        public void a(com.google.firebase.database.b bVar) {
            d.s.d.g.e(bVar, "databaseError");
            Log.e("Database Error", "onCancelled", bVar.g());
        }

        @Override // com.google.firebase.database.l
        public void b(com.google.firebase.database.a aVar) {
            d.s.d.g.e(aVar, "dataSnapshot");
            if (!d.s.d.g.a(this.f1445b, (String) aVar.c())) {
                Toast.makeText(CSPBypassActivity.this, "Try again! :D", 0).show();
                return;
            }
            FlagsOverview.N = true;
            j jVar = new j();
            Context applicationContext = CSPBypassActivity.this.getApplicationContext();
            d.s.d.g.d(applicationContext, "applicationContext");
            jVar.b(applicationContext, "flagSixteenButtonColor", true);
            CSPBypassActivity.this.I();
        }
    }

    public CSPBypassActivity() {
        com.google.firebase.database.f b2 = com.google.firebase.database.f.b();
        d.s.d.g.d(b2, "FirebaseDatabase.getInstance()");
        com.google.firebase.database.d d2 = b2.d();
        d.s.d.g.d(d2, "FirebaseDatabase.getInstance().reference");
        this.y = d2;
        com.google.firebase.database.d h = d2.h(this.x);
        d.s.d.g.d(h, "database.child(directory)");
        this.z = h;
    }

    private final void H() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        d.s.d.g.d(firebaseAuth, "FirebaseAuth.getInstance()");
        firebaseAuth.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I() {
        startActivity(new Intent(this, FlagOneSuccess.class));
    }

    private final void K(String str) {
        String valueOf = String.valueOf(getReferrer());
        if (d.s.d.g.a(valueOf, "android-app://com.android.chrome")) {
            Log.e("BAD ORIGIN!", valueOf);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        startActivity(intent);
    }

    private final void L() {
        StringBuilder sb = new StringBuilder();
        sb.append("https://");
        Intent intent = getIntent();
        d.s.d.g.d(intent, "intent");
        Uri data = intent.getData();
        sb.append(data != null ? data.getHost() : null);
        Intent intent2 = getIntent();
        d.s.d.g.d(intent2, "intent");
        Uri data2 = intent2.getData();
        sb.append(data2 != null ? data2.getPath() : null);
        String sb2 = sb.toString();
        Intent intent3 = new Intent("android.intent.action.VIEW");
        intent3.setData(Uri.parse(sb2));
        M();
        startActivity(intent3);
    }

    private final void M() {
        EditText editText = (EditText) findViewById(R.id.editText10);
        Button button = (Button) findViewById(R.id.button42);
        d.s.d.g.d(editText, "editText");
        editText.setVisibility(0);
        d.s.d.g.d(button, "button");
        button.setVisibility(0);
        m.a(this).a(new b.a.a.v.l(0, k.a(k.b("kOC6ZrdMXEnfIKWihcBNLTWIhDiINUfSQyYrFsTpEBGZy1KmfPMTwtba8CXa/WVAVoJ1ACvJMd8f/MF97/7UaeNCQvC9OD4lZ/vQN6LmpBU=")), new b(), new c()));
    }

    public View F(int i) {
        if (this.A == null) {
            this.A = new HashMap();
        }
        View view = (View) this.A.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.A.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    public final int J() {
        return this.w;
    }

    public final void N(int i) {
        this.w = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r5) {
        /*
            r4 = this;
            super.onCreate(r5)
            r5 = 2131427358(0x7f0b001e, float:1.847633E38)
            r4.setContentView(r5)
            r5 = 2131230885(0x7f0800a5, float:1.8077835E38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.EditText r5 = (android.widget.EditText) r5
            r0 = 2131230835(0x7f080073, float:1.8077734E38)
            android.view.View r0 = r4.findViewById(r0)
            android.widget.Button r0 = (android.widget.Button) r0
            java.lang.String r1 = "editText"
            d.s.d.g.d(r5, r1)
            r1 = 4
            r5.setVisibility(r1)
            java.lang.String r5 = "button"
            d.s.d.g.d(r0, r5)
            r0.setVisibility(r1)
            b3nac.injuredandroid.j$a r5 = b3nac.injuredandroid.j.j
            r5.a(r4)
            r4.H()
            r5 = 2131231086(0x7f08016e, float:1.8078243E38)
            android.view.View r5 = r4.findViewById(r5)
            androidx.appcompat.widget.Toolbar r5 = (androidx.appcompat.widget.Toolbar) r5
            r4.C(r5)
            r5 = 2131230903(0x7f0800b7, float:1.8077872E38)
            android.view.View r5 = r4.findViewById(r5)
            com.google.android.material.floatingactionbutton.FloatingActionButton r5 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r5
            b3nac.injuredandroid.CSPBypassActivity$a r0 = new b3nac.injuredandroid.CSPBypassActivity$a
            r0.<init>()
            r5.setOnClickListener(r0)
            android.content.Intent r5 = r4.getIntent()
            java.lang.String r0 = "intentToUri"
            d.s.d.g.d(r5, r0)
            android.net.Uri r5 = r5.getData()
            r0 = 0
            if (r5 == 0) goto L66
            java.lang.String r1 = r5.getScheme()
            goto L67
        L66:
            r1 = r0
        L67:
            java.lang.String r2 = "http"
            boolean r1 = d.s.d.g.a(r2, r1)
            java.lang.String r3 = "https"
            if (r1 != 0) goto L82
            if (r5 == 0) goto L78
            java.lang.String r1 = r5.getScheme()
            goto L79
        L78:
            r1 = r0
        L79:
            boolean r1 = d.s.d.g.a(r3, r1)
            if (r1 == 0) goto L80
            goto L82
        L80:
            r1 = 0
            goto L83
        L82:
            r1 = 1
        L83:
            if (r1 == 0) goto Lba
            if (r5 == 0) goto L8c
            java.lang.String r1 = r5.getScheme()
            goto L8d
        L8c:
            r1 = r0
        L8d:
            boolean r1 = d.s.d.g.a(r1, r2)
            if (r1 == 0) goto L96
            r4.L()
        L96:
            if (r5 == 0) goto L9d
            java.lang.String r5 = r5.getScheme()
            goto L9e
        L9d:
            r5 = r0
        L9e:
            boolean r5 = d.s.d.g.a(r5, r3)
            if (r5 == 0) goto Lba
            android.content.Intent r5 = r4.getIntent()
            java.lang.String r1 = "intent"
            d.s.d.g.d(r5, r1)
            android.net.Uri r5 = r5.getData()
            if (r5 == 0) goto Lb7
            java.lang.String r0 = r5.toString()
        Lb7:
            r4.K(r0)
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b3nac.injuredandroid.CSPBypassActivity.onCreate(android.os.Bundle):void");
    }

    public final void submitFlag(View view) {
        EditText editText = (EditText) findViewById(R.id.editText10);
        d.s.d.g.d(editText, "editText");
        this.z.b(new d(editText.getText().toString()));
    }
}
