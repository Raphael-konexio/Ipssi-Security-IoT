package b3nac.injuredandroid;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.l;
import d.n;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
/* loaded from: classes.dex */
public final class RCEActivity extends androidx.appcompat.app.c {
    private com.google.firebase.database.d w;
    private com.google.firebase.database.d x;
    private int y;

    /* loaded from: classes.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String str;
            if (RCEActivity.this.K() == 0) {
                d.s.d.g.c(view);
                str = "Find the binary!";
            } else if (RCEActivity.this.K() != 1) {
                if (RCEActivity.this.K() == 2) {
                    d.s.d.g.c(view);
                    Snackbar X = Snackbar.X(view, "Combine output.", 0);
                    X.Y("Action", null);
                    X.N();
                    RCEActivity.this.L(0);
                    return;
                }
                return;
            } else {
                d.s.d.g.c(view);
                str = "Permissions matter.";
            }
            Snackbar X2 = Snackbar.X(view, str, 0);
            X2.Y("Action", null);
            X2.N();
            RCEActivity rCEActivity = RCEActivity.this;
            rCEActivity.L(rCEActivity.K() + 1);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements l {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1465b;

        b(String str) {
            this.f1465b = str;
        }

        @Override // com.google.firebase.database.l
        public void a(com.google.firebase.database.b bVar) {
            d.s.d.g.e(bVar, "databaseError");
            Log.e("RCEActivity", "onCancelled", bVar.g());
        }

        @Override // com.google.firebase.database.l
        public void b(com.google.firebase.database.a aVar) {
            d.s.d.g.e(aVar, "dataSnapshot");
            if (!d.s.d.g.a(this.f1465b, (String) aVar.c())) {
                Toast.makeText(RCEActivity.this, "Try again! :D", 0).show();
                return;
            }
            FlagsOverview.L = true;
            j jVar = new j();
            Context applicationContext = RCEActivity.this.getApplicationContext();
            d.s.d.g.d(applicationContext, "applicationContext");
            jVar.b(applicationContext, "flagThirteenButtonColor", true);
            RCEActivity.this.J();
        }
    }

    /* loaded from: classes.dex */
    static final class c extends d.s.d.h implements d.s.c.l<String, n> {
        final /* synthetic */ StringBuilder f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(StringBuilder sb) {
            super(1);
            this.f = sb;
        }

        @Override // d.s.c.l
        public /* bridge */ /* synthetic */ n c(String str) {
            d(str);
            return n.f2401a;
        }

        public final void d(String str) {
            d.s.d.g.e(str, "it");
            this.f.append(str);
        }
    }

    public RCEActivity() {
        com.google.firebase.database.f b2 = com.google.firebase.database.f.b();
        d.s.d.g.d(b2, "FirebaseDatabase.getInstance()");
        com.google.firebase.database.d d2 = b2.d();
        d.s.d.g.d(d2, "FirebaseDatabase.getInstance().reference");
        this.w = d2;
        com.google.firebase.database.d h = d2.h("/rce");
        d.s.d.g.d(h, "database.child(\"/rce\")");
        this.x = h;
    }

    private final void G() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        d.s.d.g.d(firebaseAuth, "FirebaseAuth.getInstance()");
        firebaseAuth.d();
    }

    private final void H() {
        String[] strArr;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        StringBuilder sb;
        AssetManager assets = getAssets();
        InputStream inputStream2 = null;
        try {
            strArr = assets.list("");
        } catch (IOException e) {
            Log.e("tag", "Failed to get asset file list.", e);
            strArr = null;
        }
        if (strArr != null) {
            for (String str : strArr) {
                if ((!d.s.d.g.a(str, "webkit")) && (!d.s.d.g.a(str, "images")) && (!d.s.d.g.a(str, "flutter_assets")) && (!d.s.d.g.a(str, "locales"))) {
                    try {
                        inputStream = assets.open(str);
                        try {
                            StringBuilder sb2 = new StringBuilder();
                            File filesDir = getFilesDir();
                            d.s.d.g.d(filesDir, "filesDir");
                            sb2.append(filesDir.getParent());
                            sb2.append("/files/");
                            fileOutputStream = new FileOutputStream(new File(sb2.toString(), str));
                            try {
                                try {
                                    I(inputStream, fileOutputStream);
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e2) {
                                            Log.e("TAG", "Failed to close file successfully: " + str, e2);
                                        }
                                    }
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e3) {
                                        e = e3;
                                        sb = new StringBuilder();
                                        sb.append("Failed to close file successfully: ");
                                        sb.append(str);
                                        Log.e("TAG", sb.toString(), e);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    inputStream2 = inputStream;
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e4) {
                                            Log.e("TAG", "Failed to close file successfully: " + str, e4);
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e5) {
                                            Log.e("TAG", "Failed to close file successfully: " + str, e5);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (IOException e6) {
                                e = e6;
                                Log.e("TAG", "Failed to copy asset file: " + str, e);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e7) {
                                        Log.e("TAG", "Failed to close file successfully: " + str, e7);
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e8) {
                                        e = e8;
                                        sb = new StringBuilder();
                                        sb.append("Failed to close file successfully: ");
                                        sb.append(str);
                                        Log.e("TAG", sb.toString(), e);
                                    }
                                }
                            }
                        } catch (IOException e9) {
                            e = e9;
                            fileOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = null;
                        }
                    } catch (IOException e10) {
                        e = e10;
                        inputStream = null;
                        fileOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                    }
                }
            }
        }
    }

    private final void I(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        startActivity(new Intent(this, FlagOneSuccess.class));
    }

    public final int K() {
        return this.y;
    }

    public final void L(int i) {
        this.y = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_rce);
        j.j.a(this);
        C((Toolbar) findViewById(R.id.toolbar));
        G();
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new a());
        if (getIntent() != null) {
            Intent intent = getIntent();
            d.s.d.g.d(intent, "intent");
            if (intent.getData() != null) {
                H();
                Intent intent2 = getIntent();
                d.s.d.g.d(intent2, "intent");
                Uri data = intent2.getData();
                try {
                    d.s.d.g.c(data);
                    String queryParameter = data.getQueryParameter("binary");
                    String queryParameter2 = data.getQueryParameter("param");
                    String queryParameter3 = data.getQueryParameter("combined");
                    if (queryParameter3 != null) {
                        this.x.b(new b(queryParameter3));
                    } else {
                        Runtime runtime = Runtime.getRuntime();
                        StringBuilder sb = new StringBuilder();
                        File filesDir = getFilesDir();
                        d.s.d.g.d(filesDir, "filesDir");
                        sb.append(filesDir.getParent());
                        sb.append("/files/");
                        sb.append(queryParameter);
                        sb.append(" ");
                        sb.append(queryParameter2);
                        Process exec = runtime.exec(sb.toString());
                        d.s.d.g.d(exec, "process");
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                        StringBuilder sb2 = new StringBuilder();
                        d.r.c.a(bufferedReader, new c(sb2));
                        exec.waitFor();
                        TextView textView = (TextView) findViewById(R.id.RCEView);
                        d.s.d.g.d(textView, "tv");
                        textView.setText(sb2.toString());
                    }
                } catch (IOException e) {
                    Log.e("RCEActivity", "OH NO AN ERROR OCCURED!!!:" + e.getMessage());
                }
            }
        }
    }
}
