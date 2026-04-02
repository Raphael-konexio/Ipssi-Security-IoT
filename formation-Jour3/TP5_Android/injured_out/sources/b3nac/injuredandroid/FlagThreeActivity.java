package b3nac.injuredandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
/* loaded from: classes.dex */
public final class FlagThreeActivity extends androidx.appcompat.app.c {
    private int w;

    /* loaded from: classes.dex */
    static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (FlagThreeActivity.this.F() == 0) {
                Snackbar X = Snackbar.X(view, "R stands for resources.", 0);
                X.Y("Action", null);
                X.N();
                FlagThreeActivity flagThreeActivity = FlagThreeActivity.this;
                flagThreeActivity.G(flagThreeActivity.F() + 1);
            } else if (FlagThreeActivity.this.F() == 1) {
                Snackbar X2 = Snackbar.X(view, "Check .xml files.", 0);
                X2.Y("Action", null);
                X2.N();
                FlagThreeActivity.this.G(0);
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
        setContentView(R.layout.activity_flag_three);
        j.j.a(this);
        C((Toolbar) findViewById(R.id.toolbar));
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new a());
    }

    public final void submitFlag(View view) {
        EditText editText = (EditText) findViewById(R.id.editText2);
        d.s.d.g.d(editText, "editText2");
        if (d.s.d.g.a(editText.getText().toString(), getString(R.string.cmVzb3VyY2VzX3lv))) {
            Intent intent = new Intent(this, FlagOneSuccess.class);
            new FlagsOverview().L(true);
            new j().b(this, "flagThreeButtonColor", true);
            startActivity(intent);
        }
    }
}
