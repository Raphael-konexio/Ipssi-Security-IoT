package b3nac.injuredandroid;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
public final class FlagSevenSqliteActivity extends androidx.appcompat.app.c {
    private final String C;
    private final String D;
    private com.google.firebase.database.d E;
    private com.google.firebase.database.d F;
    private com.google.firebase.database.d G;
    private l H;
    private l I;
    private int w;
    private f x = new f(this);
    private final String y = "c3FsaXRl";
    private final String z = "ZjFhZy1wYTU1";
    private byte[] A = Base64.decode("c3FsaXRl", 0);
    private byte[] B = Base64.decode(this.z, 0);

    /* loaded from: classes.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int G = FlagSevenSqliteActivity.this.G();
            if (G == 0) {
                d.s.d.g.c(view);
                Snackbar X = Snackbar.X(view, "Run ADB as root.", 0);
                X.Y("Action", null);
                X.N();
                FlagSevenSqliteActivity flagSevenSqliteActivity = FlagSevenSqliteActivity.this;
                flagSevenSqliteActivity.I(flagSevenSqliteActivity.G() + 1);
            } else if (G == 1) {
                d.s.d.g.c(view);
                Snackbar X2 = Snackbar.X(view, "Stay on this activity.", 0);
                X2.Y("Action", null);
                X2.N();
                FlagSevenSqliteActivity.this.I(0);
            } else if (G != 2) {
            } else {
                d.s.d.g.c(view);
                Snackbar X3 = Snackbar.X(view, "Not all encodings are the same, some need to be rotated.", 0);
                X3.Y("Action", null);
                X3.N();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements l {
        b() {
        }

        @Override // com.google.firebase.database.l
        public void a(com.google.firebase.database.b bVar) {
            d.s.d.g.e(bVar, "databaseError");
            Log.e("SqliteActivity", "onCancelled", bVar.g());
        }

        @Override // com.google.firebase.database.l
        public void b(com.google.firebase.database.a aVar) {
            d.s.d.g.e(aVar, "dataSnapshot");
            j jVar = new j();
            Context applicationContext = FlagSevenSqliteActivity.this.getApplicationContext();
            d.s.d.g.d(applicationContext, "applicationContext");
            jVar.d(applicationContext, "flagSevenEncrypted", (String) aVar.c());
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements l {
        c() {
        }

        @Override // com.google.firebase.database.l
        public void a(com.google.firebase.database.b bVar) {
            d.s.d.g.e(bVar, "databaseError");
            Log.e("SqliteActivity", "onCancelled", bVar.g());
        }

        @Override // com.google.firebase.database.l
        public void b(com.google.firebase.database.a aVar) {
            d.s.d.g.e(aVar, "dataSnapshotTwo");
            j jVar = new j();
            Context applicationContext = FlagSevenSqliteActivity.this.getApplicationContext();
            d.s.d.g.d(applicationContext, "applicationContext");
            jVar.d(applicationContext, "flagSevenPasswordEncrypted", (String) aVar.c());
        }
    }

    public FlagSevenSqliteActivity() {
        byte[] bArr = this.A;
        d.s.d.g.d(bArr, "decodedDirectoryOne");
        Charset charset = StandardCharsets.UTF_8;
        d.s.d.g.d(charset, "StandardCharsets.UTF_8");
        this.C = new String(bArr, charset);
        byte[] bArr2 = this.B;
        d.s.d.g.d(bArr2, "decodedDirectoryTwo");
        Charset charset2 = StandardCharsets.UTF_8;
        d.s.d.g.d(charset2, "StandardCharsets.UTF_8");
        this.D = new String(bArr2, charset2);
        com.google.firebase.database.f b2 = com.google.firebase.database.f.b();
        d.s.d.g.d(b2, "FirebaseDatabase.getInstance()");
        com.google.firebase.database.d d2 = b2.d();
        d.s.d.g.d(d2, "FirebaseDatabase.getInstance().reference");
        this.E = d2;
        com.google.firebase.database.d h = d2.h(this.C);
        d.s.d.g.d(h, "database.child(refDirectory)");
        this.F = h;
        com.google.firebase.database.d h2 = this.E.h(this.D);
        d.s.d.g.d(h2, "database.child(refDirectoryTwo)");
        this.G = h2;
    }

    private final void F() {
        startActivity(new Intent(this, FlagOneSuccess.class));
    }

    private final void H() {
        com.google.firebase.database.d dVar = this.F;
        b bVar = new b();
        dVar.c(bVar);
        this.H = bVar;
        com.google.firebase.database.d dVar2 = this.G;
        c cVar = new c();
        dVar2.c(cVar);
        this.I = cVar;
    }

    public final int G() {
        return this.w;
    }

    public final void I(int i) {
        this.w = i;
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_flag_seven_sqlite);
        C((Toolbar) findViewById(R.id.toolbar));
        j.j.a(this);
        H();
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new a());
        SQLiteDatabase writableDatabase = this.x.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", Base64.decode("VGhlIGZsYWcgaGFzaCE=", 0));
        contentValues.put("subtitle", Base64.decode("MmFiOTYzOTBjN2RiZTM0MzlkZTc0ZDBjOWIwYjE3Njc=", 0));
        writableDatabase.insert("Thisisatest", null, contentValues);
        contentValues.put("title", Base64.decode("VGhlIGZsYWcgaXMgYWxzbyBhIHBhc3N3b3JkIQ==", 0));
        contentValues.put("subtitle", h.c());
        writableDatabase.insert("Thisisatest", null, contentValues);
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, android.app.Activity
    public void onDestroy() {
        this.x.close();
        deleteDatabase("Thisisatest.db");
        l lVar = this.H;
        if (lVar != null) {
            com.google.firebase.database.d dVar = this.F;
            d.s.d.g.c(lVar);
            dVar.f(lVar);
        }
        l lVar2 = this.I;
        if (lVar2 != null) {
            com.google.firebase.database.d dVar2 = this.G;
            d.s.d.g.c(lVar2);
            dVar2.f(lVar2);
        }
        super.onDestroy();
    }

    public final void submitFlag(View view) {
        EditText editText = (EditText) findViewById(R.id.editText8);
        d.s.d.g.d(editText, "editText8");
        String obj = editText.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.editText7);
        d.s.d.g.d(editText2, "editText7");
        String obj2 = editText2.getText().toString();
        j jVar = new j();
        String c2 = jVar.c("flagSevenEncrypted", "");
        String c3 = jVar.c("flagSevenPasswordEncrypted", "");
        if (!d.s.d.g.a(obj, c2) || !d.s.d.g.a(obj2, c3)) {
            Toast.makeText(this, "Try again! :D", 0).show();
            return;
        }
        FlagsOverview.H = true;
        j jVar2 = new j();
        Context applicationContext = getApplicationContext();
        d.s.d.g.d(applicationContext, "applicationContext");
        jVar2.b(applicationContext, "flagSevenButtonColor", true);
        F();
    }
}
