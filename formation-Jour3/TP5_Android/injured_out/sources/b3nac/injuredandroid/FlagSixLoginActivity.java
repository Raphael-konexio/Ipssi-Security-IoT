package b3nac.injuredandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
/* loaded from: classes.dex */
public final class FlagSixLoginActivity extends androidx.appcompat.app.c {
    private int w;

    /* loaded from: classes.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (FlagSixLoginActivity.this.F() == 0) {
                d.s.d.g.c(view);
                Snackbar X = Snackbar.X(view, "Keys.", 0);
                X.Y("Action", null);
                X.N();
                FlagSixLoginActivity flagSixLoginActivity = FlagSixLoginActivity.this;
                flagSixLoginActivity.G(flagSixLoginActivity.F() + 1);
            } else if (FlagSixLoginActivity.this.F() == 1) {
                d.s.d.g.c(view);
                Snackbar X2 = Snackbar.X(view, "Classes.", 0);
                X2.Y("Action", null);
                X2.N();
                FlagSixLoginActivity.this.G(0);
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
        setContentView(R.layout.activity_flag_six_login);
        j.j.a(this);
        C((Toolbar) findViewById(R.id.toolbar));
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new a());
    }

    public final void submitFlag(View view) {
        EditText editText = (EditText) findViewById(R.id.editText3);
        d.s.d.g.d(editText, "editText3");
        if (d.s.d.g.a(editText.getText().toString(), k.a("k3FElEG9lnoWbOateGhj5pX6QsXRNJKh///8Jxi8KXW7iDpk2xRxhQ=="))) {
            Intent intent = new Intent(this, FlagOneSuccess.class);
            FlagsOverview.G = true;
            new j().b(this, "flagSixButtonColor", true);
            startActivity(intent);
        }
    }
}
