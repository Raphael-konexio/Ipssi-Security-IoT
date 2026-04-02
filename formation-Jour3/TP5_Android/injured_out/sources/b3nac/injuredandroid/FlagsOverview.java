package b3nac.injuredandroid;

import a.o.a.a;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
/* loaded from: classes.dex */
public final class FlagsOverview extends androidx.appcompat.app.c {
    public static boolean G;
    public static boolean H;
    public static boolean I;
    public static boolean J;
    public static boolean K;
    public static boolean L;
    public static boolean M;
    public static boolean N;
    public static boolean O;
    public static boolean P;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private final String w = "b3nac.injuredandroid.encrypted";
    public SharedPreferences x;
    private boolean y;
    private boolean z;

    /* loaded from: classes.dex */
    static final class a implements View.OnClickListener {
        public static final a f = new a();

        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Snackbar X = Snackbar.X(view, "If the flag button is green you have captured that flag!", 0);
            X.Y("Action", null);
            X.N();
        }
    }

    private final void F() {
        String c2 = a.o.a.c.c(a.o.a.c.f338a);
        d.s.d.g.d(c2, "MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)");
        SharedPreferences b2 = a.o.a.a.b(this.w, c2, getApplicationContext(), a.d.AES256_SIV, a.e.AES256_GCM);
        d.s.d.g.d(b2, "EncryptedSharedPreferenc…heme.AES256_GCM\n        )");
        this.x = b2;
    }

    public final void G(boolean z) {
        this.F = z;
    }

    public final void H(boolean z) {
        this.C = z;
    }

    public final void I(boolean z) {
        this.B = z;
    }

    public final void J(boolean z) {
        this.y = z;
    }

    public final void K(boolean z) {
        this.E = z;
    }

    public final void L(boolean z) {
        this.A = z;
    }

    public final void M(boolean z) {
        this.z = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        Button button;
        boolean z;
        F();
        super.onCreate(bundle);
        setContentView(R.layout.activity_flags_overview);
        C((Toolbar) findViewById(R.id.toolbar));
        SharedPreferences sharedPreferences = getSharedPreferences("b3nac.injuredandroid", 0);
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(a.f);
        View findViewById = findViewById(R.id.button10);
        d.s.d.g.d(findViewById, "findViewById(R.id.button10)");
        Button button2 = (Button) findViewById;
        View findViewById2 = findViewById(R.id.button12);
        d.s.d.g.d(findViewById2, "findViewById(R.id.button12)");
        Button button3 = (Button) findViewById2;
        View findViewById3 = findViewById(R.id.button13);
        d.s.d.g.d(findViewById3, "findViewById(R.id.button13)");
        Button button4 = (Button) findViewById3;
        View findViewById4 = findViewById(R.id.button14);
        d.s.d.g.d(findViewById4, "findViewById(R.id.button14)");
        Button button5 = (Button) findViewById4;
        View findViewById5 = findViewById(R.id.button15);
        d.s.d.g.d(findViewById5, "findViewById(R.id.button15)");
        Button button6 = (Button) findViewById5;
        View findViewById6 = findViewById(R.id.button16);
        d.s.d.g.d(findViewById6, "findViewById(R.id.button16)");
        Button button7 = (Button) findViewById6;
        View findViewById7 = findViewById(R.id.button17);
        d.s.d.g.d(findViewById7, "findViewById(R.id.button17)");
        Button button8 = (Button) findViewById7;
        View findViewById8 = findViewById(R.id.button18);
        d.s.d.g.d(findViewById8, "findViewById(R.id.button18)");
        Button button9 = (Button) findViewById8;
        View findViewById9 = findViewById(R.id.button19);
        d.s.d.g.d(findViewById9, "findViewById(R.id.button19)");
        Button button10 = (Button) findViewById9;
        View findViewById10 = findViewById(R.id.button20);
        d.s.d.g.d(findViewById10, "findViewById(R.id.button20)");
        Button button11 = (Button) findViewById10;
        View findViewById11 = findViewById(R.id.button21);
        d.s.d.g.d(findViewById11, "findViewById(R.id.button21)");
        Button button12 = (Button) findViewById11;
        View findViewById12 = findViewById(R.id.button22);
        d.s.d.g.d(findViewById12, "findViewById(R.id.button22)");
        Button button13 = (Button) findViewById12;
        View findViewById13 = findViewById(R.id.button37);
        d.s.d.g.d(findViewById13, "findViewById(R.id.button37)");
        Button button14 = (Button) findViewById13;
        View findViewById14 = findViewById(R.id.button38);
        d.s.d.g.d(findViewById14, "findViewById(R.id.button38)");
        Button button15 = (Button) findViewById14;
        View findViewById15 = findViewById(R.id.button41);
        d.s.d.g.d(findViewById15, "findViewById(R.id.button41)");
        Button button16 = (Button) findViewById15;
        View findViewById16 = findViewById(R.id.button43);
        d.s.d.g.d(findViewById16, "findViewById(R.id.button43)");
        Button button17 = (Button) findViewById16;
        View findViewById17 = findViewById(R.id.button46);
        d.s.d.g.d(findViewById17, "findViewById(R.id.button46)");
        Button button18 = (Button) findViewById17;
        View findViewById18 = findViewById(R.id.button47);
        d.s.d.g.d(findViewById18, "findViewById(R.id.button47)");
        Button button19 = (Button) findViewById18;
        SharedPreferences sharedPreferences2 = this.x;
        if (sharedPreferences2 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences2.getBoolean("flagOneButtonColor", false)) {
            SharedPreferences sharedPreferences3 = this.x;
            if (sharedPreferences3 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            }
            this.y = sharedPreferences3.getBoolean("flagOneButtonColor", true);
            button = button13;
            button2.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
        } else {
            button = button13;
        }
        SharedPreferences sharedPreferences4 = this.x;
        if (sharedPreferences4 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences4.getBoolean("flagOneButtonColor", true)) {
            SharedPreferences sharedPreferences5 = this.x;
            if (sharedPreferences5 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                this.y = sharedPreferences5.getBoolean("flagOneButtonColor", false);
                button2.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        if (!this.y) {
            button2.getBackground().setColorFilter(-65536, PorterDuff.Mode.SRC_ATOP);
        }
        SharedPreferences sharedPreferences6 = this.x;
        if (sharedPreferences6 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences6.getBoolean("flagTwoButtonColor", false)) {
            SharedPreferences sharedPreferences7 = this.x;
            if (sharedPreferences7 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                this.z = sharedPreferences7.getBoolean("flagTwoButtonColor", true);
                button3.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        SharedPreferences sharedPreferences8 = this.x;
        if (sharedPreferences8 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences8.getBoolean("flagTwoButtonColor", true)) {
            SharedPreferences sharedPreferences9 = this.x;
            if (sharedPreferences9 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                this.z = sharedPreferences9.getBoolean("flagTwoButtonColor", false);
                button3.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        if (!this.z) {
            button3.getBackground().setColorFilter(-65536, PorterDuff.Mode.SRC_ATOP);
        }
        SharedPreferences sharedPreferences10 = this.x;
        if (sharedPreferences10 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences10.getBoolean("flagThreeButtonColor", false)) {
            SharedPreferences sharedPreferences11 = this.x;
            if (sharedPreferences11 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                this.A = sharedPreferences11.getBoolean("flagThreeButtonColor", true);
                button4.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        SharedPreferences sharedPreferences12 = this.x;
        if (sharedPreferences12 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences12.getBoolean("flagThreeButtonColor", true)) {
            SharedPreferences sharedPreferences13 = this.x;
            if (sharedPreferences13 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                this.A = sharedPreferences13.getBoolean("flagThreeButtonColor", false);
                button4.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        if (!this.A) {
            button4.getBackground().setColorFilter(-65536, PorterDuff.Mode.SRC_ATOP);
        }
        SharedPreferences sharedPreferences14 = this.x;
        if (sharedPreferences14 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences14.getBoolean("flagFourButtonColor", false)) {
            SharedPreferences sharedPreferences15 = this.x;
            if (sharedPreferences15 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                this.B = sharedPreferences15.getBoolean("flagFourButtonColor", true);
                button5.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        SharedPreferences sharedPreferences16 = this.x;
        if (sharedPreferences16 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences16.getBoolean("flagFourButtonColor", true)) {
            SharedPreferences sharedPreferences17 = this.x;
            if (sharedPreferences17 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                this.B = sharedPreferences17.getBoolean("flagFourButtonColor", false);
                button5.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        if (!this.B) {
            button5.getBackground().setColorFilter(-65536, PorterDuff.Mode.SRC_ATOP);
        }
        SharedPreferences sharedPreferences18 = this.x;
        if (sharedPreferences18 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences18.getBoolean("flagFiveButtonColor", false)) {
            SharedPreferences sharedPreferences19 = this.x;
            if (sharedPreferences19 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                this.C = sharedPreferences19.getBoolean("flagFiveButtonColor", true);
                button6.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        SharedPreferences sharedPreferences20 = this.x;
        if (sharedPreferences20 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences20.getBoolean("flagFiveButtonColor", true)) {
            SharedPreferences sharedPreferences21 = this.x;
            if (sharedPreferences21 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                this.C = sharedPreferences21.getBoolean("flagFiveButtonColor", false);
                button6.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        if (!this.C) {
            button6.getBackground().setColorFilter(-65536, PorterDuff.Mode.SRC_ATOP);
        }
        SharedPreferences sharedPreferences22 = this.x;
        if (sharedPreferences22 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences22.getBoolean("flagSixButtonColor", false)) {
            SharedPreferences sharedPreferences23 = this.x;
            if (sharedPreferences23 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                G = sharedPreferences23.getBoolean("flagSixButtonColor", true);
                button7.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        SharedPreferences sharedPreferences24 = this.x;
        if (sharedPreferences24 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences24.getBoolean("flagSixButtonColor", true)) {
            SharedPreferences sharedPreferences25 = this.x;
            if (sharedPreferences25 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                G = sharedPreferences25.getBoolean("flagSixButtonColor", false);
                button7.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        if (!G) {
            button7.getBackground().setColorFilter(-65536, PorterDuff.Mode.SRC_ATOP);
        }
        SharedPreferences sharedPreferences26 = this.x;
        if (sharedPreferences26 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences26.getBoolean("flagSevenButtonColor", false)) {
            SharedPreferences sharedPreferences27 = this.x;
            if (sharedPreferences27 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                H = sharedPreferences27.getBoolean("flagSevenButtonColor", true);
                button8.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        SharedPreferences sharedPreferences28 = this.x;
        if (sharedPreferences28 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences28.getBoolean("flagSevenButtonColor", true)) {
            SharedPreferences sharedPreferences29 = this.x;
            if (sharedPreferences29 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                H = sharedPreferences29.getBoolean("flagSevenButtonColor", false);
                button8.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        if (!H) {
            button8.getBackground().setColorFilter(-65536, PorterDuff.Mode.SRC_ATOP);
        }
        SharedPreferences sharedPreferences30 = this.x;
        if (sharedPreferences30 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences30.getBoolean("flagEightButtonColor", false)) {
            SharedPreferences sharedPreferences31 = this.x;
            if (sharedPreferences31 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                I = sharedPreferences31.getBoolean("flagEightButtonColor", true);
                button9.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        SharedPreferences sharedPreferences32 = this.x;
        if (sharedPreferences32 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences32.getBoolean("flagEightButtonColor", true)) {
            SharedPreferences sharedPreferences33 = this.x;
            if (sharedPreferences33 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                I = sharedPreferences33.getBoolean("flagEightButtonColor", false);
                button9.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        if (!I) {
            button9.getBackground().setColorFilter(-65536, PorterDuff.Mode.SRC_ATOP);
        }
        SharedPreferences sharedPreferences34 = this.x;
        if (sharedPreferences34 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences34.getBoolean("flagNineButtonColor", false)) {
            SharedPreferences sharedPreferences35 = this.x;
            if (sharedPreferences35 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                this.D = sharedPreferences35.getBoolean("flagNineButtonColor", true);
                button10.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        SharedPreferences sharedPreferences36 = this.x;
        if (sharedPreferences36 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences36.getBoolean("flagNineButtonColor", true)) {
            SharedPreferences sharedPreferences37 = this.x;
            if (sharedPreferences37 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                this.D = sharedPreferences37.getBoolean("flagNineButtonColor", false);
                button10.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        if (!this.D) {
            button10.getBackground().setColorFilter(-65536, PorterDuff.Mode.SRC_ATOP);
        }
        SharedPreferences sharedPreferences38 = this.x;
        if (sharedPreferences38 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences38.getBoolean("flagTenButtonColor", false)) {
            SharedPreferences sharedPreferences39 = this.x;
            if (sharedPreferences39 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                this.E = sharedPreferences39.getBoolean("flagTenButtonColor", true);
                button11.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        SharedPreferences sharedPreferences40 = this.x;
        if (sharedPreferences40 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences40.getBoolean("flagTenButtonColor", true)) {
            SharedPreferences sharedPreferences41 = this.x;
            if (sharedPreferences41 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                this.E = sharedPreferences41.getBoolean("flagTenButtonColor", false);
                button11.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        if (!this.E) {
            button11.getBackground().setColorFilter(-65536, PorterDuff.Mode.SRC_ATOP);
        }
        SharedPreferences sharedPreferences42 = this.x;
        if (sharedPreferences42 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences42.getBoolean("flagElevenButtonColor", false)) {
            SharedPreferences sharedPreferences43 = this.x;
            if (sharedPreferences43 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                this.F = sharedPreferences43.getBoolean("flagElevenButtonColor", true);
                button12.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        SharedPreferences sharedPreferences44 = this.x;
        if (sharedPreferences44 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences44.getBoolean("flagElevenButtonColor", true)) {
            SharedPreferences sharedPreferences45 = this.x;
            if (sharedPreferences45 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                this.F = sharedPreferences45.getBoolean("flagElevenButtonColor", false);
                button12.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        if (!this.F) {
            button12.getBackground().setColorFilter(-65536, PorterDuff.Mode.SRC_ATOP);
        }
        SharedPreferences sharedPreferences46 = this.x;
        if (sharedPreferences46 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences46.getBoolean("flagTwelveButtonColor", false)) {
            SharedPreferences sharedPreferences47 = this.x;
            if (sharedPreferences47 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                K = sharedPreferences47.getBoolean("flagTwelveButtonColor", true);
                button.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        SharedPreferences sharedPreferences48 = this.x;
        if (sharedPreferences48 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences48.getBoolean("flagTwelveButtonColor", true)) {
            SharedPreferences sharedPreferences49 = this.x;
            if (sharedPreferences49 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                K = sharedPreferences49.getBoolean("flagTwelveButtonColor", false);
                button.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        if (!K) {
            button.getBackground().setColorFilter(-65536, PorterDuff.Mode.SRC_ATOP);
        }
        SharedPreferences sharedPreferences50 = this.x;
        if (sharedPreferences50 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences50.getBoolean("flagThirteenButtonColor", false)) {
            SharedPreferences sharedPreferences51 = this.x;
            if (sharedPreferences51 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                L = sharedPreferences51.getBoolean("flagThirteenButtonColor", true);
                button14.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        SharedPreferences sharedPreferences52 = this.x;
        if (sharedPreferences52 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences52.getBoolean("flagThirteenButtonColor", true)) {
            SharedPreferences sharedPreferences53 = this.x;
            if (sharedPreferences53 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                L = sharedPreferences53.getBoolean("flagThirteenButtonColor", false);
                button14.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        if (!L) {
            button14.getBackground().setColorFilter(-65536, PorterDuff.Mode.SRC_ATOP);
        }
        SharedPreferences sharedPreferences54 = getSharedPreferences("FlutterSharedPreferences", 0);
        String string = sharedPreferences54.getString("flutter.flagFourteenButtonColor", "");
        if (d.s.d.g.a(string, "Flag fourteen found!")) {
            z = true;
            sharedPreferences.edit().putBoolean("flagFourteenButtonColor", true).apply();
            button15.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
        } else {
            z = true;
        }
        SharedPreferences sharedPreferences55 = this.x;
        if (sharedPreferences55 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences55.getBoolean("flagFourteenButtonColor", z)) {
            sharedPreferences54.getBoolean("flagFourteenButtonColor", false);
            button15.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
        }
        if (d.s.d.g.a(string, "Flag fourteen found!") ^ z) {
            button15.getBackground().setColorFilter(-65536, PorterDuff.Mode.SRC_ATOP);
        }
        SharedPreferences sharedPreferences56 = this.x;
        if (sharedPreferences56 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences56.getBoolean("flagFifteenButtonColor", false)) {
            SharedPreferences sharedPreferences57 = this.x;
            if (sharedPreferences57 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                M = sharedPreferences57.getBoolean("flagFifteenButtonColor", true);
                button16.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        SharedPreferences sharedPreferences58 = this.x;
        if (sharedPreferences58 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences58.getBoolean("flagFifteenButtonColor", true)) {
            SharedPreferences sharedPreferences59 = this.x;
            if (sharedPreferences59 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                M = sharedPreferences59.getBoolean("flagFifteenButtonColor", false);
                button16.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        if (!M) {
            button16.getBackground().setColorFilter(-65536, PorterDuff.Mode.SRC_ATOP);
        }
        SharedPreferences sharedPreferences60 = this.x;
        if (sharedPreferences60 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences60.getBoolean("flagSixteenButtonColor", false)) {
            SharedPreferences sharedPreferences61 = this.x;
            if (sharedPreferences61 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                N = sharedPreferences61.getBoolean("flagSixteenButtonColor", true);
                button17.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        SharedPreferences sharedPreferences62 = this.x;
        if (sharedPreferences62 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences62.getBoolean("flagSixteenButtonColor", true)) {
            SharedPreferences sharedPreferences63 = this.x;
            if (sharedPreferences63 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                N = sharedPreferences63.getBoolean("flagSixteenButtonColor", false);
                button17.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        if (!N) {
            button17.getBackground().setColorFilter(-65536, PorterDuff.Mode.SRC_ATOP);
        }
        SharedPreferences sharedPreferences64 = this.x;
        if (sharedPreferences64 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences64.getBoolean("flagSeventeenButtonColor", false)) {
            SharedPreferences sharedPreferences65 = this.x;
            if (sharedPreferences65 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                O = sharedPreferences65.getBoolean("flagSeventeenButtonColor", true);
                button18.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        SharedPreferences sharedPreferences66 = this.x;
        if (sharedPreferences66 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences66.getBoolean("flagSeventeenButtonColor", true)) {
            SharedPreferences sharedPreferences67 = this.x;
            if (sharedPreferences67 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                O = sharedPreferences67.getBoolean("flagSeventeenButtonColor", false);
                button18.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        if (!O) {
            button18.getBackground().setColorFilter(-65536, PorterDuff.Mode.SRC_ATOP);
        }
        SharedPreferences sharedPreferences68 = this.x;
        if (sharedPreferences68 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences68.getBoolean("flagEighteenButtonColor", false)) {
            SharedPreferences sharedPreferences69 = this.x;
            if (sharedPreferences69 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                P = sharedPreferences69.getBoolean("flagEighteenButtonColor", true);
                button19.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        SharedPreferences sharedPreferences70 = this.x;
        if (sharedPreferences70 == null) {
            d.s.d.g.n("sharedPreferences");
            throw null;
        }
        if (sharedPreferences70.getBoolean("flagEighteenButtonColor", true)) {
            SharedPreferences sharedPreferences71 = this.x;
            if (sharedPreferences71 == null) {
                d.s.d.g.n("sharedPreferences");
                throw null;
            } else {
                P = sharedPreferences71.getBoolean("flagEighteenButtonColor", false);
                button19.getBackground().setColorFilter(-16711936, PorterDuff.Mode.SRC_ATOP);
            }
        }
        if (P) {
            return;
        }
        button19.getBackground().setColorFilter(-65536, PorterDuff.Mode.SRC_ATOP);
    }
}
