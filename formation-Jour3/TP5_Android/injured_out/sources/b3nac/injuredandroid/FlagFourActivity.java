package b3nac.injuredandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
/* loaded from: classes.dex */
public final class FlagFourActivity extends androidx.appcompat.app.c {
    private int w;

    /* loaded from: classes.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (FlagFourActivity.this.F() == 0) {
                Snackbar X = Snackbar.X(view, "Where is bob.", 0);
                X.Y("Action", null);
                X.N();
                FlagFourActivity flagFourActivity = FlagFourActivity.this;
                flagFourActivity.G(flagFourActivity.F() + 1);
            } else if (FlagFourActivity.this.F() == 1) {
                Snackbar X2 = Snackbar.X(view, "Classes and imports.", 0);
                X2.Y("Action", null);
                X2.N();
                FlagFourActivity.this.G(0);
            }
        }
    }

    public final int F() {
        return this.w;
    }

    public final void G(int i) {
        this.w = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_flag_four);
        j.j.a(this);
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new a());
    }

    public final void submitFlag(View view) {
        EditText editText = (EditText) findViewById(R.id.editText2);
        d.s.d.g.d(editText, "editText2");
        String obj = editText.getText().toString();
        byte[] a2 = new g().a();
        d.s.d.g.d(a2, "decoder.getData()");
        if (d.s.d.g.a(obj, new String(a2, d.w.c.f2418a))) {
            Intent intent = new Intent(this, FlagOneSuccess.class);
            new FlagsOverview().I(true);
            new j().b(this, "flagFourButtonColor", true);
            startActivity(intent);
        }
    }
}
